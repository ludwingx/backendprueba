package posCarRental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import posCarRental.dto.CarDto;
import posCarRental.dto.SearchCarDto;
import posCarRental.exception.CarNotFoundException;
import posCarRental.service.ICarService;

import java.io.IOException;

import static posCarRental.constants.GeneralConstants.*;

@RestController
@RequestMapping(API)
public class CarController {

    @Autowired
    private ICarService carService;

    @PostMapping(CAR)
    public ResponseEntity<?> posCar(@ModelAttribute CarDto requestDto) throws Exception {
        boolean success = carService.posCar(requestDto);
        if (success) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(GET_ALL_CARS)
    public ResponseEntity<?> findAllCars(){
        return ResponseEntity.ok(carService.findAllCars());
    }

    @GetMapping(GET_BY_CAR_ID)
    public ResponseEntity<?> getByCarId(@PathVariable Long id){
        CarDto carDtoId = carService.getByCarId(id);
        if (carDtoId != null) {
            return ResponseEntity.ok(carDtoId);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping(GET_BY_CAR_ID)
    public ResponseEntity<?> updateCar(@PathVariable Long id, @ModelAttribute CarDto requestDto) throws Exception {
        try {
            boolean upate = carService.updateByCarId(id, requestDto);
            if (upate) {
                return ResponseEntity.status(HttpStatus.OK).build();
            }
            return ResponseEntity.notFound().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping(GET_BY_CAR_ID)
    public  ResponseEntity<Void> delete(@PathVariable Long id) throws CarNotFoundException {
        boolean success = carService.deleteByCarId(id);
        if(success) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping(SEARCH_BY_CAR)
    public ResponseEntity<?> searchCar(@RequestBody SearchCarDto searchCarDto){
        try {
            return ResponseEntity.ok(carService.searchCar(searchCarDto));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
