package posCarRental.service;

import posCarRental.entity.Transmission;

import java.util.List;

public interface ITransmissionService {

    Transmission createTransmission(Transmission transmission);

    List<Transmission> findAllTransmissions();

    Transmission getByTransmissionId(Long id);
}
