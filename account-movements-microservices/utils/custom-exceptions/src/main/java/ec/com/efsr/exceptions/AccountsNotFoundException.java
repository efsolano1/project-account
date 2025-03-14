package ec.com.efsr.exceptions;

public class AccountsNotFoundException extends RuntimeException {
    public AccountsNotFoundException(String info) {
        super(info);
    }
}
