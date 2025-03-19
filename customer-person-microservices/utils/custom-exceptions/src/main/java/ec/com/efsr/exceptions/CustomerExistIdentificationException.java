package ec.com.efsr.exceptions;

public class CustomerExistIdentificationException extends RuntimeException{
    public CustomerExistIdentificationException(String info) {
        super(info);
    }
}
