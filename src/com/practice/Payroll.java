package com.practice;

import java.util.ArrayList;
import java.util.Scanner;

public class Payroll {

    public static void main(String[] args) {

        System.out.println("Please, enter five data for employees: name, surname and salary.");
        ArrayList<Employee> employees = new ArrayList<>();
        //adding five employees entered by user to ArrayList
        for (int i = 0; i < 5; i++) {
            System.out.println((i + 1) + " employee");
            employees.add(Payroll.getDataForEmployee());
        }

        boolean flag = true;
        while (flag) {
            switch (Payroll.getMenu()) {
                case 1:
                    System.out.println("Sum of all employees salary is: " + Employee.getEmployeesSum(employees));
                    break;
                case 2:
                    Employee.getDataForAllEmployees(employees);
                    break;
                case 3:
                    Employee empl = Payroll.getDataForEmployee();
                    employees.add(empl);
                    System.out.println("Data of new employee: ");
                    employees.get(employees.size() - 1).getAllData();
                    break;
                case 4:
                    System.out.println("You've left payroll program.");
                    flag = false;
                    break;
            }
        }
    }

    //method to create new employee
    private static Employee getDataForEmployee() {

        Scanner sc = new Scanner(System.in);
        System.out.println("name of employee:");
        String name = sc.next();

        System.out.println("surname of employee:");
        String surname = sc.next();

        System.out.println("salary of employee: ");
        int salary;

        do {
            while (!sc.hasNextInt()) {
                sc.next();
                System.out.println("You entered string, please enter integer value > 0");
            }
            salary = sc.nextInt();
            if (salary <= 0) {
                System.out.println("You entered wrong salary,  please enter integer value > 0");
            }
        } while (salary <= 0);

        return new Employee(name, surname, salary);
    }

    //method showing menu and getting action from user
    private static int getMenu() {
        Scanner sc = new Scanner(System.in);

        //print MENU
        System.out.println("*************************************************" + '\n'
                + "MENU" + '\n'
                + "1 – Print sum of all employees salary" + '\n'
                + "2 – Display all user employees data" + '\n'
                + "3 – Add new employee" + '\n'
                + "4 – End program" +'\n'
                + "*************************************************");

        //getting action from user
        System.out.println("What would you like to do? Choose appropriate number:");

        int action;
        do {
            while (!sc.hasNextInt()) {
                sc.next();
                System.out.println("You entered string, please enter integer from 1 to 4:");
            }
            action = sc.nextInt();
            if (action != 1 && action != 2 && action != 3 && action != 4) {
                System.out.println("You entered wrong integer, please enter integer from 1 to 4:");
            }
        } while (action != 1 && action != 2 && action != 3 && action != 4);
        return action;
    }
}
