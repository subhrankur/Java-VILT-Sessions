/*
 * TODO:
 * Create a custom runtime exception.
 *
 * Use this exception when an employee with the same
 * employee ID already exists.
 */

package deloitte.vilt.employees.exception;

public class EmployeeAlreadyExistsException extends RuntimeException {

    public EmployeeAlreadyExistsException(String message) {
        super(message);
    }
}