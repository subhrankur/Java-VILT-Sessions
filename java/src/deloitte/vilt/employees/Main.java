/*
 * TODO:
 * Create the application entry point.
 *
 * Demonstrate BOTH implementations:
 * 1. ListEmployeeManager
 * 2. SetEmployeeManager
 *
 * Demonstrate:
 * - Adding employees
 * - Duplicate handling
 * - Finding employees
 * - Missing employee handling
 * - Removing employees
 * - Sorting using every SortField
 * - Exception handling
 *
 * IMPORTANT:
 * Do not use the Java Streams API.
 */

package deloitte.vilt.employees;

import deloitte.vilt.employees.exception.EmployeeAlreadyExistsException;
import deloitte.vilt.employees.exception.EmployeeNotFoundException;
import deloitte.vilt.employees.exception.InvalidSortFieldException;
import deloitte.vilt.employees.list.ListEmployeeManager;
import deloitte.vilt.employees.model.Employee;
import deloitte.vilt.employees.set.SetEmployeeManager;
import deloitte.vilt.employees.sorting.SortField;

public class Main {

    public static void main(String[] args) {

        Employee employee1 = new Employee(
                101,
                "Rahul",
                "IT",
                75000,
                5
        );

        Employee employee2 = new Employee(
                102,
                "Priya",
                "HR",
                65000,
                4
        );

        Employee employee3 = new Employee(
                103,
                "Amit",
                "Finance",
                80000,
                7
        );

        Employee employee4 = new Employee(
                104,
                "Sneha",
                "IT",
                90000,
                6
        );

        Employee duplicateEmployee = new Employee(
                101,
                "Rahul",
                "IT",
                75000,
                5
        );

        demonstrateList(employee1, employee2, employee3, employee4, duplicateEmployee);

        System.out.println();
        System.out.println();
        
        demonstrateSet(employee1, employee2, employee3, employee4, duplicateEmployee);
    }

    private static void demonstrateList(
            Employee employee1,
            Employee employee2,
            Employee employee3,
            Employee employee4,
            Employee duplicateEmployee
    ) {

        System.out.println("========================================");
        System.out.println("LIST IMPLEMENTATION");
        System.out.println("========================================");

        ListEmployeeManager manager = new ListEmployeeManager();

        try {
            System.out.println("\nAdding employees...");

            manager.add(employee1);
            manager.add(employee2);
            manager.add(employee3);
            manager.add(employee4);

            System.out.println("Employees added successfully.");
        } catch (EmployeeAlreadyExistsException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nAttempting duplicate employee...");

        try {
            manager.add(duplicateEmployee);
        } catch (EmployeeAlreadyExistsException e) {
            System.out.println("Duplicate handled: " + e.getMessage());
        }

        System.out.println("\nFinding employee with ID 102...");

        try {
            Employee employee = manager.findById(102);
            System.out.println("Found: " + employee);
        } catch (EmployeeNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nFinding missing employee with ID 999...");

        try {
            manager.findById(999);
        } catch (EmployeeNotFoundException e) {
            System.out.println("Missing employee handled: " + e.getMessage());
        }

        System.out.println("\nRemoving employee with ID 104...");

        try {
            manager.remove(104);
            System.out.println("Employee removed successfully.");
        } catch (EmployeeNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nAttempting to remove missing employee with ID 999...");

        try {
            manager.remove(999);
        } catch (EmployeeNotFoundException e) {
            System.out.println("Missing employee removal handled: " + e.getMessage());
        }

        System.out.println("\nCurrent employees:");

        manager.display();

        System.out.println("\nSorting by every SortField:");

        for (SortField sortField : SortField.values()) {

            System.out.println("\n--- Sort by " + sortField + " ---");

            try {
                manager.sort(sortField);
                manager.display();
            } catch (InvalidSortFieldException e) {
                System.out.println("Sorting error: " + e.getMessage());
            }
        }
    }

    private static void demonstrateSet(
            Employee employee1,
            Employee employee2,
            Employee employee3,
            Employee employee4,
            Employee duplicateEmployee
    ) {

        System.out.println("========================================");
        System.out.println("SET IMPLEMENTATION");
        System.out.println("========================================");

        SetEmployeeManager manager = new SetEmployeeManager();

        try {
            System.out.println("\nAdding employees...");

            manager.add(employee1);
            manager.add(employee2);
            manager.add(employee3);
            manager.add(employee4);

            System.out.println("Employees added successfully.");
        } catch (EmployeeAlreadyExistsException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nAttempting duplicate employee...");

        try {
            manager.add(duplicateEmployee);
        } catch (EmployeeAlreadyExistsException e) {
            System.out.println("Duplicate handled: " + e.getMessage());
        }

        System.out.println("\nFinding employee with ID 102...");

        try {
            Employee employee = manager.findById(102);
            System.out.println("Found: " + employee);
        } catch (EmployeeNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nFinding missing employee with ID 999...");

        try {
            manager.findById(999);
        } catch (EmployeeNotFoundException e) {
            System.out.println("Missing employee handled: " + e.getMessage());
        }

        System.out.println("\nRemoving employee with ID 104...");

        try {
            manager.remove(104);
            System.out.println("Employee removed successfully.");
        } catch (EmployeeNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nAttempting to remove missing employee with ID 999...");

        try {
            manager.remove(999);
        } catch (EmployeeNotFoundException e) {
            System.out.println("Missing employee removal handled: " + e.getMessage());
        }

        System.out.println("\nCurrent employees:");

        manager.display();

        System.out.println("\nSorting by every SortField:");

        for (SortField sortField : SortField.values()) {

            System.out.println("\n--- Sort by " + sortField + " ---");

            try {
                manager.sort(sortField);
            } catch (InvalidSortFieldException e) {
                System.out.println("Sorting error: " + e.getMessage());
            }
        }
    }
}