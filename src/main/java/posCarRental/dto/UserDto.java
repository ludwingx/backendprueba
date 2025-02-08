package posCarRental.dto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;
import posCarRental.entity.Rol;
import posCarRental.entity.enums.UserStatus;

@Data
public class UserDto {

    private Long id;

    private String name;

    private String email;

    private UserStatus status;

    private Long rolId;
}
