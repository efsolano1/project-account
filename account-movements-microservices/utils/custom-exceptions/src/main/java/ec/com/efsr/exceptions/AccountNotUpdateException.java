package ec.com.efsr.exceptions;

public class AccountNotUpdateException extends RuntimeException {
    public AccountNotUpdateException(String info) {
        super(info);
    }
}
