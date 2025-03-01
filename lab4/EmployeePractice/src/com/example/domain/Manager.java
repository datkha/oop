package com.example.domain;

import java.util.Locale;
import java.text.NumberFormat;

public class Manager extends Employee {
    private String deptName;
    private Employee[] staff;
    private int employeeCount;

    public Manager(int empId, String name, String ssn, double salary, String deptName) {
        super(empId, name, ssn, salary);
        this.deptName = deptName;
        this.staff = new Employee[20];
        this.employeeCount = 0;
    }

    public String getDeptName() {
        return deptName;
    }

    public int findEmployee(Employee emp) {
        for (int i = 0; i < employeeCount; i++) {
            if (staff[i].getEmpId() == emp.getEmpId()) {
                return i;
            }
        }
        return -1;
    }

    public boolean addEmployee(Employee emp) {
        if (employeeCount >= 20) {
            return false;
        }
        if (findEmployee(emp) != -1) {
            return false;
        }
        staff[employeeCount] = emp;
        employeeCount++;
        return true;
    }

    public boolean removeEmployee(Employee emp) {
        boolean found = false;
        Employee[] tempStaff = new Employee[20];
        int tempCount = 0;

        for (int i = 0; i < employeeCount; i++) {
            if (staff[i].getEmpId() == emp.getEmpId()) {
                found = true;
                continue;
            }
            tempStaff[tempCount] = staff[i];
            tempCount++;
        }

        if (found) {
            staff = tempStaff;
            employeeCount = tempCount;
        }

        return found;
    }

    public void printStaffDetails() {
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);

        System.out.println("Manager: " + getName());
        System.out.println("Department: " + getDeptName());
        System.out.println("Salary: " + currencyFormat.format(getSalary()));
        System.out.println("Staff Members:");

        for (int i = 0; i < employeeCount; i++) {
            System.out.println("ID: " + staff[i].getEmpId() +
                    ", Name: " + staff[i].getName() +
                    ", Salary: " + currencyFormat.format(staff[i].getSalary()));
        }
    }
}
