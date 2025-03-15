package ec.com.efsr.exceptions;

public class AccountNumberExistException extends RuntimeException {
    public AccountNumberExistException(String info) {
        super(info);
    }
}
