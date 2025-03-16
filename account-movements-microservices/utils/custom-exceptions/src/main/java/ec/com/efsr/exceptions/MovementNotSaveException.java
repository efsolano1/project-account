package ec.com.efsr.exceptions;

public class MovementNotSaveException extends RuntimeException {
    public MovementNotSaveException(String info) {
        super(info);
    }
}
