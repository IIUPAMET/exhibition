package exceptions;


public class AccessDeniesException extends RuntimeException {
    public AccessDeniesException(){super();}
    public AccessDeniesException(String message){ super(message); }
}
