package posCarRental.dto;

import lombok.Data;

@Data
public class AuthResponseDto {

    private Long userId;

    private String rol;

    private String token;
}
