/*
 * TODO:
 * Implement Comparator<Employee>.
 *
 * Compare employees using employee ID.
 */

package deloitte.vilt.employees.sorting;

import deloitte.vilt.employees.model.Employee;

import java.util.Comparator;

public class EmployeeIdComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee first, Employee second) {
        return Integer.compare(first.id(), second.id());
    }
}