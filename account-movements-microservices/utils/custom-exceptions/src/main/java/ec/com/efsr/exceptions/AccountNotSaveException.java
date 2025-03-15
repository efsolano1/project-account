package ec.com.efsr.exceptions;

public class AccountNotSaveException extends RuntimeException {
    public AccountNotSaveException(String info) {
        super(info);
    }
}
