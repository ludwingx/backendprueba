package posCarRental.mapper;

import org.mapstruct.Mapper;
import posCarRental.dto.TransmissionDto;
import posCarRental.entity.Transmission;

@Mapper(componentModel = "spring")
public interface TransmissionMapper {

    TransmissionDto toDto(Transmission transmission);
    Transmission toTransmission(TransmissionDto transmissionDto);
}
