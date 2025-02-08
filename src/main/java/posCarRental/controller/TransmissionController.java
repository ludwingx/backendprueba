package posCarRental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import posCarRental.entity.Brand;
import posCarRental.entity.Transmission;
import posCarRental.service.IBrandService;
import posCarRental.service.ITransmissionService;

import java.util.List;

import static posCarRental.constants.GeneralConstants.*;

@RestController
@RequestMapping(API)
public class TransmissionController {

    @Autowired
    private ITransmissionService transmissionService;

    @PostMapping(TRANSMISSION)
    public ResponseEntity<?> create(@RequestBody Transmission transmission){
        try {
            return ResponseEntity.ok(transmissionService.createTransmission(transmission));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping(TRANSMISSIONS)
    public ResponseEntity<?> findAllTransmissions(){
        try {
            return ResponseEntity.ok(transmissionService.findAllTransmissions());
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(GET_BY_TRANSMISSION_ID)
    public ResponseEntity<?> getByTransmissionId(@PathVariable Long id){
        try {
            return ResponseEntity.ok(transmissionService.getByTransmissionId(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
