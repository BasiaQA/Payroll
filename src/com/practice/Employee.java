package com.practice;

import java.util.ArrayList;

public class Employee {

    private String firstName;
    private String lastName;
    private int salary;


    public Employee(String firstName, String lastName, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void getAllData() {
        System.out.println("Salary for " + firstName + " " + lastName + " is " + salary);
    }

    public static int getEmployeesSum(ArrayList<Employee> employees) {
        int sum = 0;
        for (int i = 0; i < employees.size(); i++) {
            sum += employees.get(i).getSalary();
        }
        return sum;
    }

    public static void getDataForAllEmployees(ArrayList<Employee> employees){
        for (int i = 0; i < employees.size(); i++) {
           employees.get(i).getAllData();
        }
    }
}
