package com.example.domain;

public class Employee {
    private int empId;
    private String name;
    private String ssn;
    private double salary;

    public Employee(int empId, String name, String ssn, double salary) {
        this.empId = empId;
        this.name = validateName(name);
        this.ssn = ssn;
        this.salary = salary;
    }

    public int getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = validateName(name);
    }

    public String getSSN() {
        return ssn;
    }

    public double getSalary() {
        return salary;
    }

    public void raiseSalary(double increase) {
        if (increase < 0) {
            throw new IllegalArgumentException("Salary increase cannot be negative");
        }
        this.salary += increase;
    }

    private String validateName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        return name;
    }
}
