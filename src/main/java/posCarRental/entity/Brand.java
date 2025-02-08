package posCarRental.entity;

import jakarta.persistence.*;
import lombok.Data;
import posCarRental.dto.BrandDto;
import posCarRental.dto.CarDto;

@Entity
@Data
@Table(name = "brands")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    /*crear su el mapeo de BRAND para crear el service de Lista
    public BrandDto brandDto(){
        BrandDto dto = new BrandDto();
        dto.setId(id);
        dto.setName(name);
        dto.setDescription(description);
        return dto;
    }
    */
}
