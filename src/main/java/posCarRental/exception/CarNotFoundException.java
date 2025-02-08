package posCarRental.exception;

public class CarNotFoundException extends   RuntimeException{

    public CarNotFoundException(String message) {
        super(message);
    }

    public CarNotFoundException(Long id) {
        this(String.format("No se pudo encontrar el car con id: %d", id));
    }
}
