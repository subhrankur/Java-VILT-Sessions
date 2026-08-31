package deloitte.vilt.employees_lambda_stream.exception;

public class InvalidSortFieldException extends RuntimeException {

    public InvalidSortFieldException(String message) {
        super(message);
    }
}