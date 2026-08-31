/*
 * TODO:
 * Implement Comparator<Employee>.
 *
 * Compare employees using years of experience.
 */

package deloitte.vilt.employees.sorting;

import deloitte.vilt.employees.model.Employee;

import java.util.Comparator;

public class EmployeeExperienceComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee first, Employee second) {
        return Integer.compare(first.experience(), second.experience());
    }
}