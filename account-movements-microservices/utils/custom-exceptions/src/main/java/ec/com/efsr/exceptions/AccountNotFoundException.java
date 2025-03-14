package ec.com.efsr.exceptions;

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(String info) {
        super(info);
    }
}
