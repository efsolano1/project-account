package ec.com.efsr.exceptions;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(String info) {
        super(info);
    }
}
