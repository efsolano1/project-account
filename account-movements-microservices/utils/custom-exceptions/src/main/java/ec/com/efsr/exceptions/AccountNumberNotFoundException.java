package ec.com.efsr.exceptions;

public class AccountNumberNotFoundException extends RuntimeException {
    public AccountNumberNotFoundException(String info) {
        super(info);
    }
}
