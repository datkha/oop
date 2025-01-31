package com.example;

import com.example.domain.Employee;

public class EmployeeTest {
    public EmployeeTest() {}

    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setId(101);
        employee.setName("Jane Smith");
        employee.setSSN("012-34-4567");
        employee.setSalary(120345.27);

        System.out.println("Employee ID: " + employee.getId());
        System.out.println("Employee name: " +employee.getName());
        System.out.println("Employee SSN: " +employee.getSSN());
        System.out.println("Employee salary: " +employee.getSalary());
    }
}
