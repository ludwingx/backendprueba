package posCarRental.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "transmissions")
public class Transmission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;
}
