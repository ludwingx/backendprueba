package posCarRental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import posCarRental.entity.Fuel;
import posCarRental.service.IFuelService;

import java.util.List;
import static posCarRental.constants.GeneralConstants.*;

@RestController
@RequestMapping(API)
public class FuelController {

    @Autowired
    private IFuelService fuelService;

    @PostMapping(FUEL)
    public ResponseEntity<?> create(@RequestBody Fuel fuel){
        try {
            return ResponseEntity.ok(fuelService.createFuel(fuel));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping(FUELS)
    public ResponseEntity<?> findAllFuels(){
        try {
            return ResponseEntity.ok(fuelService.findAllFuel());
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(GET_BY_FUEL_ID)
    public ResponseEntity<?> getByFuelId(@PathVariable Long id){
        try {
            return ResponseEntity.ok(fuelService.getByFuelId(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
