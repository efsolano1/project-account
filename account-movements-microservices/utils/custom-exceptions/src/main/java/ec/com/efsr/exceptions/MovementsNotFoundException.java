package ec.com.efsr.exceptions;

public class MovementsNotFoundException  extends RuntimeException {
    public MovementsNotFoundException(String info) {
        super(info);
    }
}
