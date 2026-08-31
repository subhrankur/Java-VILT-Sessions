package deloitte.vilt.employees_lambda_stream.list;

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

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListEmployeeManager {

    private final List<Employee> employees = new ArrayList<>();

    public void add(Employee employee) {

        if (employee == null) {
            throw new IllegalArgumentException("Employee cannot be null.");
        }

        boolean employeeExists = employees.stream()
                .anyMatch(existing -> existing.id() == employee.id());

        if (employeeExists) {
            throw new EmployeeAlreadyExistsException(
                    "Employee with ID " + employee.id() + " already exists."
            );
        }

        employees.add(employee);
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

        List<Employee> sortedEmployees = employees.stream()
                .sorted(comparator)
                .toList();

        // Keep the actual List sorted as well.
        employees.clear();
        employees.addAll(sortedEmployees);

        return List.copyOf(employees);
    }

    public List<Employee> sortNaturally() {

        List<Employee> sortedEmployees = employees.stream()
                .sorted()
                .toList();

        employees.clear();
        employees.addAll(sortedEmployees);

        return List.copyOf(employees);
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