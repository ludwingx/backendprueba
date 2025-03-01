package posCarRental.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import posCarRental.dto.TransmissionDto;
import posCarRental.entity.Transmission;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-01T06:37:34-0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class TransmissionMapperImpl implements TransmissionMapper {

    @Override
    public TransmissionDto toDto(Transmission transmission) {
        if ( transmission == null ) {
            return null;
        }

        TransmissionDto transmissionDto = new TransmissionDto();

        return transmissionDto;
    }

    @Override
    public Transmission toTransmission(TransmissionDto transmissionDto) {
        if ( transmissionDto == null ) {
            return null;
        }

        Transmission transmission = new Transmission();

        return transmission;
    }
}
