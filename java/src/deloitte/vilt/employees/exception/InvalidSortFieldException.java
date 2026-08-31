/*
 * TODO:
 * Create a custom runtime exception for invalid sorting requests.
 *
 * The enum should normally prevent invalid values,
 * but this exception can be used for defensive validation.
 */

package deloitte.vilt.employees.exception;

public class InvalidSortFieldException extends RuntimeException {

    public InvalidSortFieldException(String message) {
        super(message);
    }
}