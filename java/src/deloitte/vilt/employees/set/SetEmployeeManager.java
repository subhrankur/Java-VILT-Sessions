/*
 * TODO:
 * Implement the SAME Employee Management requirements using Set.
 *
 * Start with:
 * - Set<Employee>
 * - HashSet
 *
 * Then experiment with:
 * - LinkedHashSet
 * - TreeSet
 *
 * Required operations:
 * - add
 * - findById
 * - remove
 * - display
 * - sort
 *
 * IMPORTANT:
 * Observe how Set handles duplicates differently from List.
 *
 * Use Employee's record-generated equals() and hashCode()
 * when reasoning about HashSet uniqueness.
 *
 * Sorting:
 * - Accept SortField.
 * - Select the appropriate Comparator.
 * - Experiment with TreeSet and natural ordering.
 *
 * IMPORTANT:
 * Do not use Streams.
 */

package deloitte.vilt.employees.set;

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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetEmployeeManager {

    private final Set<Employee> employees;

    public SetEmployeeManager() {
        employees = new HashSet<>();
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

        boolean added = employees.add(employee);

        if (!added) {
            throw new EmployeeAlreadyExistsException(
                    "Employee already exists: " + employee
            );
        }
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

        for (Employee employee : employees) {

            if (employee.id() == id) {
                employees.remove(employee);
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

        List<Employee> sortedEmployees = new ArrayList<>(employees);

        sortedEmployees.sort(comparator);

        for (Employee employee : sortedEmployees) {
            System.out.println(employee);
        }
    }
}