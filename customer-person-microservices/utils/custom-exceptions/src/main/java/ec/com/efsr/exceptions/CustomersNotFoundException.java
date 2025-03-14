package ec.com.efsr.exceptions;

public class CustomersNotFoundException  extends RuntimeException {
    public CustomersNotFoundException(String info) {
        super(info);
    }
}
