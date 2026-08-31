/*
 * TODO:
 * Implement Comparator<Employee>.
 *
 * Compare employees using employee name.
 *
 * Consider whether comparison should be case-sensitive.
 */

package deloitte.vilt.employees.sorting;

import deloitte.vilt.employees.model.Employee;

import java.util.Comparator;

public class EmployeeNameComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee first, Employee second) {
        return first.name().compareToIgnoreCase(second.name());
    }
}