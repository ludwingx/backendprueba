package posCarRental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import posCarRental.dto.BookACarDto;
import posCarRental.dto.SearchCarDto;
import posCarRental.service.IBookACarService;

import java.util.List;
import static posCarRental.constants.GeneralConstants.*;

@RestController
@RequestMapping(API)
public class BookACarController {

    @Autowired
    private IBookACarService bookACarService;

    @PostMapping(CAR + BOOK_A_CAR)
    public ResponseEntity<?> bookACar(@RequestBody BookACarDto bookACarDto){
        boolean success = bookACarService.bookACar(bookACarDto);
        if (success) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping(CAR + GET_CAR_BOOKINGS_BY_USER_ID)
    public ResponseEntity<List<BookACarDto>> getBookingsByUserId(@PathVariable Long userId){
        try {
            return ResponseEntity.ok(bookACarService.getBookingsByUserId(userId));
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(CAR + GET_ALL_BOOKINGS_CAR)
    public ResponseEntity<List<BookACarDto>> findAllBookings(){
        return ResponseEntity.ok(bookACarService.findAllBookings());
    }

    //APROBAR LA RESERVA: CAMBIAR ESTADO DE RESERVA
    @GetMapping(CAR + CHANGE_BY_BOOKING_ID_AND_STATUS)
    public ResponseEntity<?> changeBookingStatus(@PathVariable Long bookingId, @PathVariable String status){
        boolean success = bookACarService.changeBookingStatus(bookingId, status);
        if (success) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }


}
