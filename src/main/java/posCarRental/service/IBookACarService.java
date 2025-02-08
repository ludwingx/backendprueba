package posCarRental.service;

import posCarRental.dto.BookACarDto;
import posCarRental.dto.CarDtoListDto;
import posCarRental.dto.SearchCarDto;

import java.util.List;

public interface IBookACarService {

    boolean bookACar(BookACarDto bookACarDto);

    List<BookACarDto> getBookingsByUserId(Long userId);

    List<BookACarDto> findAllBookings();

    boolean changeBookingStatus(Long bookingId, String status);

}
