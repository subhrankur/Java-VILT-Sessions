package deloitte.vilt.employees_lambda_stream.model;

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