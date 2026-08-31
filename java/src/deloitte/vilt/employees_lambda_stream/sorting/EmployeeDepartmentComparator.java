package deloitte.vilt.employees_lambda_stream.sorting;

import deloitte.vilt.employees_lambda_stream.model.Employee;

import java.util.Comparator;

public class EmployeeDepartmentComparator implements Comparator<Employee> {

    private static final Comparator<Employee> COMPARATOR =
            Comparator.comparing(Employee::department);

    @Override
    public int compare(Employee first, Employee second) {
        return COMPARATOR.compare(first, second);
    }
}