/*
 * TODO:
 * Implement Comparator<Employee>.
 *
 * Compare employees using department.
 */

package deloitte.vilt.employees.sorting;

import deloitte.vilt.employees.model.Employee;

import java.util.Comparator;

public class EmployeeDepartmentComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee first, Employee second) {
        return first.department().compareToIgnoreCase(second.department());
    }
}