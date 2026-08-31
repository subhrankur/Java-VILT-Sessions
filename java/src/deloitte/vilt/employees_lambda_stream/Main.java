package deloitte.vilt.employees_lambda_stream;

import deloitte.vilt.employees_lambda_stream.exception.EmployeeAlreadyExistsException;
import deloitte.vilt.employees_lambda_stream.exception.EmployeeNotFoundException;
import deloitte.vilt.employees_lambda_stream.exception.InvalidSortFieldException;
import deloitte.vilt.employees_lambda_stream.list.ListEmployeeManager;
import deloitte.vilt.employees_lambda_stream.model.Employee;
import deloitte.vilt.employees_lambda_stream.set.SetEmployeeManager;
import deloitte.vilt.employees_lambda_stream.sorting.SortField;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Employee employee1 = new Employee(
                103,
                "Rahul",
                "IT",
                75000,
                5
        );

        Employee employee2 = new Employee(
                101,
                "priya",
                "HR",
                65000,
                4
        );

        Employee employee3 = new Employee(
                104,
                "Amit",
                "Finance",
                80000,
                7
        );

        Employee employee4 = new Employee(
                102,
                "Sneha",
                "IT",
                90000,
                6
        );

        Employee duplicateEmployee = new Employee(
                103,
                "Rahul",
                "IT",
                75000,
                5
        );

        demonstrateList(
                employee1,
                employee2,
                employee3,
                employee4,
                duplicateEmployee
        );

        System.out.println("\n\n");

        demonstrateSet(
                employee1,
                employee2,
                employee3,
                employee4,
                duplicateEmployee
        );
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

        System.out.println("\nAdding employees:");

        List.of(
                employee1,
                employee2,
                employee3,
                employee4
        ).forEach(employee -> {

            try {
                manager.add(employee);
                System.out.println("Added: " + employee);
            } catch (EmployeeAlreadyExistsException e) {
                System.out.println("Add error: " + e.getMessage());
            }
        });

        System.out.println("\nAttempting duplicate:");

        try {
            manager.add(duplicateEmployee);
        } catch (EmployeeAlreadyExistsException e) {
            System.out.println("Duplicate handled: " + e.getMessage());
        }

        System.out.println("\nFinding employee with ID 101:");

        try {
            System.out.println("Found: " + manager.findById(101));
        } catch (EmployeeNotFoundException e) {
            System.out.println("Find error: " + e.getMessage());
        }

        System.out.println("\nFinding employee with ID 999:");

        try {
            System.out.println("Found: " + manager.findById(999));
        } catch (EmployeeNotFoundException e) {
            System.out.println("Find error: " + e.getMessage());
        }

        System.out.println("\nRemoving employee with ID 102:");

        try {
            manager.remove(102);
            System.out.println("Employee removed successfully.");
        } catch (EmployeeNotFoundException e) {
            System.out.println("Remove error: " + e.getMessage());
        }

        System.out.println("\nRemoving employee with ID 999:");

        try {
            manager.remove(999);
            System.out.println("Employee removed successfully.");
        } catch (EmployeeNotFoundException e) {
            System.out.println("Remove error: " + e.getMessage());
        }

        System.out.println("\nCurrent employees:");

        manager.display();

        System.out.println("\nNatural ordering using Comparable:");

        manager.sortNaturally()
                .forEach(System.out::println);

        System.out.println("\nSorting using every SortField:");

        Arrays.stream(SortField.values())
                .forEach(sortField -> {

                    System.out.println(
                            "\n--- Sort by " + sortField + " ---"
                    );

                    try {

                        List<Employee> sortedEmployees =
                                manager.sort(sortField);

                        sortedEmployees.forEach(
                                System.out::println
                        );

                    } catch (InvalidSortFieldException e) {
                        System.out.println(
                                "Sort error: " + e.getMessage()
                        );
                    }
                });

        System.out.println("\nTesting invalid sort request:");

        try {
            manager.sort(null);
        } catch (InvalidSortFieldException e) {
            System.out.println(
                    "Invalid sort handled: " + e.getMessage()
            );
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

        System.out.println("\nAdding employees:");

        List.of(
                employee1,
                employee2,
                employee3,
                employee4
        ).forEach(employee -> {

            try {
                manager.add(employee);
                System.out.println("Added: " + employee);
            } catch (EmployeeAlreadyExistsException e) {
                System.out.println("Add error: " + e.getMessage());
            }
        });

        System.out.println("\nAttempting duplicate:");

        try {
            manager.add(duplicateEmployee);
        } catch (EmployeeAlreadyExistsException e) {
            System.out.println("Duplicate handled: " + e.getMessage());
        }

        System.out.println("\nFinding employee with ID 101:");

        try {
            System.out.println("Found: " + manager.findById(101));
        } catch (EmployeeNotFoundException e) {
            System.out.println("Find error: " + e.getMessage());
        }

        System.out.println("\nFinding employee with ID 999:");

        try {
            System.out.println("Found: " + manager.findById(999));
        } catch (EmployeeNotFoundException e) {
            System.out.println("Find error: " + e.getMessage());
        }

        System.out.println("\nRemoving employee with ID 102:");

        try {
            manager.remove(102);
            System.out.println("Employee removed successfully.");
        } catch (EmployeeNotFoundException e) {
            System.out.println("Remove error: " + e.getMessage());
        }

        System.out.println("\nRemoving employee with ID 999:");

        try {
            manager.remove(999);
            System.out.println("Employee removed successfully.");
        } catch (EmployeeNotFoundException e) {
            System.out.println("Remove error: " + e.getMessage());
        }

        System.out.println("\nCurrent employees:");

        manager.display();

        System.out.println("\nNatural ordering using Comparable:");

        manager.sortNaturally()
                .forEach(System.out::println);

        System.out.println("\nSorting using every SortField:");

        Arrays.stream(SortField.values())
                .forEach(sortField -> {

                    System.out.println(
                            "\n--- Sort by " + sortField + " ---"
                    );

                    try {

                        List<Employee> sortedEmployees =
                                manager.sort(sortField);

                        sortedEmployees.forEach(
                                System.out::println
                        );

                    } catch (InvalidSortFieldException e) {
                        System.out.println(
                                "Sort error: " + e.getMessage()
                        );
                    }
                });

        System.out.println("\nTesting invalid sort request:");

        try {
            manager.sort(null);
        } catch (InvalidSortFieldException e) {
            System.out.println(
                    "Invalid sort handled: " + e.getMessage()
            );
        }
    }
}