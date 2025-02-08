package posCarRental.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "fuels")
public class Fuel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;
}
