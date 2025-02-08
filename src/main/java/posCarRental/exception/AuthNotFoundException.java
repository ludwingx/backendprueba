package posCarRental.exception;

public class AuthNotFoundException extends RuntimeException{

    public AuthNotFoundException(String message) {
        super(message);
    }

    public AuthNotFoundException(Long id) {
        this(String.format("No se pudo encontrar el usuario con id: %d", id));
    }
}
