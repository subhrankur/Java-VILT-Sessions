package deloitte.vilt.employees_lambda_stream.sorting;

import deloitte.vilt.employees_lambda_stream.model.Employee;

import java.util.Comparator;

public class EmployeeSalaryComparator implements Comparator<Employee> {

    private static final Comparator<Employee> COMPARATOR =
            Comparator.comparingDouble(Employee::salary);

    @Override
    public int compare(Employee first, Employee second) {
        return COMPARATOR.compare(first, second);
    }
}