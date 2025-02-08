package posCarRental.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import posCarRental.entity.Transmission;
import posCarRental.repository.ITransmissionRepository;
import posCarRental.service.ITransmissionService;

import java.util.List;

@Service
public class TransmissionServiceImpl  implements ITransmissionService {

    @Autowired
    private ITransmissionRepository transmissionRepository;

    @Override
    public Transmission createTransmission(Transmission transmission) {
        return transmissionRepository.save(transmission);
    }

    @Override
    public List<Transmission> findAllTransmissions() {
        return transmissionRepository.findAll();
    }

    @Override
    public Transmission getByTransmissionId(Long id) {
        return transmissionRepository.findById(id).orElseThrow();
    }
}
