package posCarRental.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import posCarRental.entity.Fuel;
import posCarRental.repository.IFuelRepository;
import posCarRental.service.IFuelService;

import java.util.List;

@Service
public class FuelServiceImp implements IFuelService {

    @Autowired
    private IFuelRepository fuelRepository;

    @Override
    public Fuel createFuel(Fuel fuel) {
        return fuelRepository.save(fuel);
    }

    @Override
    public List<Fuel> findAllFuel() {
        return fuelRepository.findAll();
    }

    @Override
    public Fuel getByFuelId(Long id) {
        return fuelRepository.findById(id).orElseThrow();
    }
}