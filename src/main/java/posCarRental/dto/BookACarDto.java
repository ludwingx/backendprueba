package posCarRental.dto;

import lombok.Data;
import posCarRental.entity.enums.BookCarStatus;

import java.sql.Date;
import java.sql.Timestamp;

@Data
public class BookACarDto {

    private Long id;

    private Date fromDate;

    private Date toDate;

    private Long days;

    private Long price;

    private BookCarStatus bookCarStatus;

    private Long carId;

    private Long userId;

    private String username;

    private String email;
}
