package deloitte.vilt.employees_lambda_stream.sorting;

import deloitte.vilt.employees_lambda_stream.model.Employee;

import java.util.Comparator;

public class EmployeeIdComparator implements Comparator<Employee> {

    private static final Comparator<Employee> COMPARATOR =
            Comparator.comparingInt(Employee::id);

    @Override
    public int compare(Employee first, Employee second) {
        return COMPARATOR.compare(first, second);
    }
}