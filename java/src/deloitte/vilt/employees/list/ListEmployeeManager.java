/*
 * TODO:
 * Implement the Employee Management requirements using List.
 *
 * Underlying collection:
 * - List<Employee>
 * - Prefer ArrayList for the initial implementation.
 *
 * Required operations:
 * - add
 * - findById
 * - remove
 * - display
 * - sort
 *
 * IMPORTANT:
 * List permits duplicates.
 * Therefore explicitly validate employee IDs before adding.
 *
 * Sorting:
 * - Accept SortField.
 * - Select the appropriate Comparator.
 * - Support natural ordering where appropriate.
 *
 * IMPORTANT:
 * Do not use Streams.
 *
 * Use traditional loops / enhanced for / collection APIs.
 */

package deloitte.vilt.employees.list;

import deloitte.vilt.employees.exception.EmployeeAlreadyExistsException;
import deloitte.vilt.employees.exception.EmployeeNotFoundException;
import deloitte.vilt.employees.exception.InvalidSortFieldException;
import deloitte.vilt.employees.model.Employee;
import deloitte.vilt.employees.sorting.EmployeeDepartmentComparator;
import deloitte.vilt.employees.sorting.EmployeeExperienceComparator;
import deloitte.vilt.employees.sorting.EmployeeIdComparator;
import deloitte.vilt.employees.sorting.EmployeeNameComparator;
import deloitte.vilt.employees.sorting.EmployeeSalaryComparator;
import deloitte.vilt.employees.sorting.SortField;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListEmployeeManager {

    private final List<Employee> employees;

    public ListEmployeeManager() {
        employees = new ArrayList<>();
    }

    public void add(Employee employee) {

        if (employee == null) {
            throw new IllegalArgumentException("Employee cannot be null.");
        }

        for (Employee existingEmployee : employees) {

            if (existingEmployee.id() == employee.id()) {
                throw new EmployeeAlreadyExistsException(
                        "Employee with ID " + employee.id() + " already exists."
                );
            }
        }

        employees.add(employee);
    }

    public Employee findById(int id) {

        for (Employee employee : employees) {

            if (employee.id() == id) {
                return employee;
            }
        }

        throw new EmployeeNotFoundException(
                "Employee with ID " + id + " was not found."
        );
    }

    public void remove(int id) {

        for (int i = 0; i < employees.size(); i++) {

            Employee employee = employees.get(i);

            if (employee.id() == id) {
                employees.remove(i);
                return;
            }
        }

        throw new EmployeeNotFoundException(
                "Employee with ID " + id + " was not found."
        );
    }

    public void display() {

        if (employees.isEmpty()) {
            System.out.println("No employees available.");
            return;
        }

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public void sort(SortField sortField) {

        if (sortField == null) {
            throw new InvalidSortFieldException(
                    "Sort field cannot be null."
            );
        }

        Comparator<Employee> comparator;

        switch (sortField) {
            case ID:
                comparator = new EmployeeIdComparator();
                break;

            case NAME:
                comparator = new EmployeeNameComparator();
                break;

            case DEPARTMENT:
                comparator = new EmployeeDepartmentComparator();
                break;

            case SALARY:
                comparator = new EmployeeSalaryComparator();
                break;

            case EXPERIENCE:
                comparator = new EmployeeExperienceComparator();
                break;

            default:
                throw new InvalidSortFieldException(
                        "Unsupported sort field: " + sortField
                );
        }

        employees.sort(comparator);
    }
}