package com.example.javabasic_finalpractice;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static DepartmentManager departmentManager = new DepartmentManager();
    public static EmployeeManager employeeManager = new EmployeeManager();

    public static void main(String[] args) {
        String[] options = {"1- Department manager",
                "2- Employee manager ",
                "3- Close program"

        };
        Scanner scanner = new Scanner(System.in);
        int option = 1;
        while (option != 3) {
            printMenu(options);
            try {
                option = scanner.nextInt();
                if (option == 1) {
                    departmentManager();
                } else if (option==2){
                    employeeManager();
                }
            } catch (InputMismatchException ex) {
                System.out.println("Please enter an integer value between 1 and " + options.length);
                scanner.next();
            } catch (Exception ex) {
                System.out.println("An unexpected error happened. Please try again");
                scanner.next();
            }
        }

    }

    public static void printMenu(String[] options) {
        for (String option : options) {
            System.out.println(option);
        }
        System.out.print("Choose your option : ");
    }

    public static void departmentManager() {


        String[] options = {"1- add new department",
                "2- search departments ",
                "3- back to main screen"

        };
        Scanner scanner = new Scanner(System.in);
        int option = 1;
        while (option != 3) {
            System.out.println("---Department manager----");
            printMenu(options);
            try {
                option = scanner.nextInt();
                if (option == 1) {
                    departmentManager.addDepartment(departmentManager.input());
                } else if (option == 2) {
                    departmentManager.display(departmentManager.search());
                }
            } catch (InputMismatchException ex) {
                System.out.println("Please enter an integer value between 1 and " + options.length);
                scanner.next();
            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("An unexpected error happened. Please try again");
                scanner.next();
            }
        }
    }

    public static void employeeManager() {


        String[] options = {"1- Add new employee",
                "2- Add one or more employees to a department ",
                "3- List employee ",
                "4- back to main screen"

        };
        Scanner scanner = new Scanner(System.in);
        int option = 1;
        while (option != 4) {
            System.out.println("---Employee manager----");
            printMenu(options);
            try {
                option = scanner.nextInt();
                if (option == 1) {
                    employeeManager.addEmployee(employeeManager.input());
                } else if (option == 2) {
                    employeeManager.display(employeeManager.readFromFile());
                } else if (option == 3) {
                    employeeManager.addEmployeeTODepartment();
                }
            } catch (InputMismatchException ex) {
                System.out.println("Please enter an integer value between 1 and " + options.length);
                scanner.next();
            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("An unexpected error happened. Please try again");
                scanner.next();
            }
        }
    }
}
