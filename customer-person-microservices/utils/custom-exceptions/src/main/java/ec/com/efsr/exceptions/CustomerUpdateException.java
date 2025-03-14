package ec.com.efsr.exceptions;

public class CustomerUpdateException  extends RuntimeException {
    public CustomerUpdateException(String info) {
        super(info);
    }
}
