package ec.com.efsr.exceptions;

public class CustomerSaveException extends RuntimeException {
    public CustomerSaveException(String info) {
        super(info);
    }
}
