/*
 * TODO:
 * Create Employee as a Java record.
 *
 * Fields:
 * - int id
 * - String name
 * - String department
 * - double salary
 * - int experience
 *
 * Implement Comparable<Employee>.
 *
 * Natural ordering:
 * - Employee ID
 *
 * Use the record-generated equals() and hashCode().
 */

package deloitte.vilt.employees.model;

public record Employee(
        int id,
        String name,
        String department,
        double salary,
        int experience
) implements Comparable<Employee> {

    @Override
    public int compareTo(Employee other) {
        return Integer.compare(this.id, other.id);
    }
}