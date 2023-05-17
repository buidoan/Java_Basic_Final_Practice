package com.example.javabasic_finalpractice;

import java.io.Serializable;

public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private String ID;
    private String title;
    private String fullName;
    private String domain;
    private String position;
    private double monthlySalary;
    private Department department;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "ID='" + ID + '\'' +
                ", title='" + title + '\'' +
                ", fullName='" + fullName + '\'' +
                ", domain='" + domain + '\'' +
                ", position='" + position + '\'' +
                ", monthlySalary=" + monthlySalary +
                ", departmentID=" + department.getID() +
                '}';
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
