package ec.com.efsr.exceptions;

public class MovementNotFoundException extends RuntimeException {
    public MovementNotFoundException(String info) {
        super(info);
    }
}
