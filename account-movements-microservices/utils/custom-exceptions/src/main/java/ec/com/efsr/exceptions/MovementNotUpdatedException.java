package ec.com.efsr.exceptions;

public class MovementNotUpdatedException extends RuntimeException {
    public MovementNotUpdatedException(String info) {
        super(info);
    }
}
