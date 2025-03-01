package com.example;

import com.example.domain.*;
import java.text.NumberFormat;
import java.util.Locale;

public class EmployeeTest {
    public static void main(String[] args) {
        Engineer eng = new Engineer(101, "Jane Smith", "012-34-5678", 120345.27);
        Manager mgr = new Manager(207, "Barbara Johnson", "054-12-2367", 109501.36, "US Marketing");
        Admin adm = new Admin(304, "Bill Monroe", "108-23-6509", 75002.34);
        Director dir = new Director(12, "Susan Wheeler", "099-45-2340", 120567.36, "Global Marketing", 1000000.00);

        printEmployee(eng);
        printEmployee(mgr);
        printEmployee(adm);
        printEmployee(dir);

        mgr.setName("Barbara Johnson-Smythe");
        mgr.raiseSalary(10000.00);

        printEmployee(mgr);
    }

    public static void printEmployee(Employee emp) {
        NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println();
        System.out.println("Employee ID: " + emp.getEmpId());
        System.out.println("Employee Name: " + emp.getName());
        System.out.println("Employee SSN: " + emp.getSSN());
        System.out.println("Employee Salary: " + currency.format(emp.getSalary()));
    }
}
