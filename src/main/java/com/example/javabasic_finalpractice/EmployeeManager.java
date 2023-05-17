package com.example.javabasic_finalpractice;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeManager {
    public List<Employee> employees = new ArrayList<>();
    public DepartmentManager departmentManager;

    public Employee input() {
        Employee employee = new Employee();
        System.out.println("Enter the  title");
        employee.setTitle(new Scanner(System.in).nextLine());
        System.out.println("Enter the full name");
        employee.setFullName(new Scanner(System.in).nextLine());
        System.out.println("Enter the domain");
        employee.setDomain(new Scanner(System.in).nextLine());
        System.out.println("Enter the position");
        employee.setPosition(new Scanner(System.in).nextLine());
        System.out.println("Enter the monthly salary ");
        employee.setMonthlySalary(new Scanner(System.in).nextDouble());

        return employee;
    }

    public void addEmployee(Employee employee) {
        try {
            employees.add(employee);
            FileOutputStream writeData = new FileOutputStream("employee1.dat");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
            writeStream.writeObject(employees);
            writeStream.flush();
            writeStream.close();
            System.out.println("ADDED SUCCESS");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<Employee> readFromFile() throws IOException, ClassNotFoundException {

        List<Employee> employees1 = new ArrayList<>();


        FileInputStream fis = new FileInputStream("employee.dat");
        ObjectInputStream input = new ObjectInputStream(fis);
        List<Object> inputs = (List<Object>) input.readObject();
        for (Object o : inputs) {
            if (o instanceof Department) {
                employees1.add((Employee) o);
            }
        }


        fis.close();
        return employees1;
    }

    public void display(List<Employee> employees) {
        for (Employee e : employees) {
            System.out.println(e.toString());
        }
    }

    public Employee findById(String id) throws IOException, ClassNotFoundException {
        List<Employee> employeeList = readFromFile();
        Employee rsEmployee = new Employee();
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getID().equalsIgnoreCase(id)) {
                rsEmployee = employeeList.get(i);
            }
        }
        return rsEmployee;
    }

    public void addEmployeeTODepartment() throws IOException, ClassNotFoundException {
        System.out.println("Enter the id of department");
        Scanner sc= new Scanner(System.in);
        String departmentId = sc.nextLine();
        Department department = departmentManager.findById(departmentId);
        System.out.println("Enter the number of employee you want to add");
        int n = new Scanner(System.in).nextInt();
        Employee employee = new Employee();
        for (int i = 0; i < n; i++) {
            System.out.println(" Enter the id of the " + i + " department");

            employee = findById(sc.nextLine());
            if (employee != null) {
                employee.setDepartment(department);
            } else {
                System.out.println("the employee not found");
            }
        }
    }
}
