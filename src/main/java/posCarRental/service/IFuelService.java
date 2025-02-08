package posCarRental.service;

import posCarRental.entity.Fuel;

import java.util.List;

public interface IFuelService {

    Fuel createFuel(Fuel fuel);

    List<Fuel> findAllFuel();

    Fuel getByFuelId(Long id);
}
