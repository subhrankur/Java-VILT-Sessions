/*
 * TODO:
 * Create a custom runtime exception.
 *
 * Use this exception when an employee cannot be found.
 */

package deloitte.vilt.employees.exception;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(String message) {
        super(message);
    }
}