package deloitte.vilt.employees_lambda_stream.set;

import deloitte.vilt.employees_lambda_stream.exception.EmployeeAlreadyExistsException;
import deloitte.vilt.employees_lambda_stream.exception.EmployeeNotFoundException;
import deloitte.vilt.employees_lambda_stream.exception.InvalidSortFieldException;
import deloitte.vilt.employees_lambda_stream.model.Employee;
import deloitte.vilt.employees_lambda_stream.sorting.EmployeeDepartmentComparator;
import deloitte.vilt.employees_lambda_stream.sorting.EmployeeExperienceComparator;
import deloitte.vilt.employees_lambda_stream.sorting.EmployeeIdComparator;
import deloitte.vilt.employees_lambda_stream.sorting.EmployeeNameComparator;
import deloitte.vilt.employees_lambda_stream.sorting.EmployeeSalaryComparator;
import deloitte.vilt.employees_lambda_stream.sorting.SortField;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetEmployeeManager {

    private final Set<Employee> employees = new HashSet<>();

    public void add(Employee employee) {

        if (employee == null) {
            throw new IllegalArgumentException("Employee cannot be null.");
        }

        /*
         * HashSet uses the record-generated equals() and hashCode().
         *
         * But the business rule is stronger:
         * employee ID itself must be unique.
         *
         * Therefore we explicitly check the ID as well.
         */
        boolean sameIdExists = employees.stream()
                .anyMatch(existing -> existing.id() == employee.id());

        if (sameIdExists) {
            throw new EmployeeAlreadyExistsException(
                    "Employee with ID " + employee.id() + " already exists."
            );
        }

        boolean added = employees.add(employee);

        if (!added) {
            throw new EmployeeAlreadyExistsException(
                    "Employee already exists: " + employee
            );
        }
    }

    public Employee findById(int id) {

        return employees.stream()
                .filter(employee -> employee.id() == id)
                .findFirst()
                .orElseThrow(() ->
                        new EmployeeNotFoundException(
                                "Employee with ID " + id + " was not found."
                        )
                );
    }

    public void remove(int id) {

        Employee employee = findById(id);

        employees.remove(employee);
    }

    public void display() {

        if (employees.isEmpty()) {
            System.out.println("No employees available.");
            return;
        }

        employees.forEach(System.out::println);
    }

    public List<Employee> sort(SortField sortField) {

        Comparator<Employee> comparator = getComparator(sortField);

        /*
         * A Set has no positional order.
         *
         * Therefore, sort the Set's elements into a List and return
         * the sorted result.
         */
        return employees.stream()
                .sorted(comparator)
                .toList();
    }

    public List<Employee> sortNaturally() {

        return employees.stream()
                .sorted()
                .toList();
    }

    private Comparator<Employee> getComparator(SortField sortField) {

        if (sortField == null) {
            throw new InvalidSortFieldException(
                    "Sort field cannot be null."
            );
        }

        return switch (sortField) {
            case ID -> new EmployeeIdComparator();
            case NAME -> new EmployeeNameComparator();
            case DEPARTMENT -> new EmployeeDepartmentComparator();
            case SALARY -> new EmployeeSalaryComparator();
            case EXPERIENCE -> new EmployeeExperienceComparator();
        };
    }
}