package com.example.javabasic_finalpractice;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class DepartmentManager {
public List<Department> departments=new ArrayList<>();
    public void addDepartment(Department department) {
        try {
            departments.add(department);
            FileOutputStream writeData = new FileOutputStream("department.dat");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
            writeStream.writeObject(departments);
            writeStream.flush();
            writeStream.close();
            System.out.println("ADDED SUCCESS");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<Department> search() throws IOException, ClassNotFoundException {
        System.out.println("Searching (enter the name) ");
        List<Department> departments = readFromFile();
        List<Department> results = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        try {
            String name = scanner.nextLine();

            for (int i = 0; i < departments.size(); i++) {
                if (departments.get(i).getName().toLowerCase().contains(name.toLowerCase())) {
                    results.add(departments.get(i));
                }
            }

        } catch (InputMismatchException ex) {
            System.out.println("please enter the string");
            scanner.next();
        }
        return results;


    }

    public void display(List<Department> departments) {
        if (departments.size() > 0) {
            System.out.println("result");
            for (Department d : departments) {
                System.out.println(d.toString());
            }
        } else {
            System.out.println("No result!!!");
        }
    }

    public List<Department> readFromFile() throws IOException, ClassNotFoundException {

        List<Department> departments = new ArrayList<>();


        FileInputStream fis = new FileInputStream("department.dat");
        ObjectInputStream input = new ObjectInputStream(fis);
        List<Object> inputs = (List<Object>) input.readObject();
        for (Object o : inputs) {
            if (o instanceof Department) {
                departments.add((Department) o);
            }
        }


        fis.close();
        return departments;
    }

    public Department input() {
        Department department = new Department();
        System.out.println("Enter the name of department");
        department.setName(new Scanner(System.in).nextLine());
        System.out.println("Enter the domain of department");
        department.setDomain(new Scanner(System.in).nextLine());
        return department;
    }
    public Department findById(String id) throws IOException, ClassNotFoundException {
        List<Department> departmentList=readFromFile();
       Department rsDepartment=new Department();
       for (int i=0;i<departmentList.size();i++){
           if (departmentList.get(i).getID().equalsIgnoreCase(id)){
               rsDepartment=departmentList.get(i);
           }
       }
       return rsDepartment;
    }
}
