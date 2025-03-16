package ec.com.efsr.exceptions;

public class BalanceNotAvailableException  extends RuntimeException {
    public BalanceNotAvailableException(String info) {
        super(info);
    }
}
