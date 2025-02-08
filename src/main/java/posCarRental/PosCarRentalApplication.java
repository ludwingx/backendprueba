package posCarRental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class PosCarRentalApplication {

    public static void main(String[] args) {
        // Obtener el puerto de la variable de entorno de Render
        String port = Optional.ofNullable(System.getenv("PORT")).orElse("8080");

        // Establecer la dirección IP a 0.0.0.0 (permitir conexiones externas)
        System.setProperty("server.address", "0.0.0.0");
        System.setProperty("server.port", port);

        SpringApplication.run(PosCarRentalApplication.class, args);
    }
}
