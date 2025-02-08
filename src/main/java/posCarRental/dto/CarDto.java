package posCarRental.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;
import java.sql.Timestamp;

@Data
public class CarDto {

    private Long id;

    private String color;

    private String name;

    private String description;

    private Long price;

    private Timestamp year;

    private MultipartFile  image;

    private byte[] returnedImage;

    private Long brandId;

    private Long fuelId;

    private Long transmissionId;
}
