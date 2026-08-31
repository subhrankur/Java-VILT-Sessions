package deloitte.vilt.employees_lambda_stream.sorting;

import deloitte.vilt.employees_lambda_stream.model.Employee;

import java.util.Comparator;

public class EmployeeNameComparator implements Comparator<Employee> {

    private static final Comparator<Employee> COMPARATOR =
            Comparator.comparing(
                    Employee::name,
                    String.CASE_INSENSITIVE_ORDER
            );

    @Override
    public int compare(Employee first, Employee second) {
        return COMPARATOR.compare(first, second);
    }
}