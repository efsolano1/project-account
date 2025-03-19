package ec.com.efsr.exceptions;

public class CustomerIdentificationException extends RuntimeException{
    public CustomerIdentificationException(String info) {
        super(info);
    }
}
