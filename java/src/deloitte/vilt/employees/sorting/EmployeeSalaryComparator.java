/*
 * TODO:
 * Implement Comparator<Employee>.
 *
 * Compare employees using salary.
 */

package deloitte.vilt.employees.sorting;

import deloitte.vilt.employees.model.Employee;

import java.util.Comparator;

public class EmployeeSalaryComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee first, Employee second) {
        return Double.compare(first.salary(), second.salary());
    }
}