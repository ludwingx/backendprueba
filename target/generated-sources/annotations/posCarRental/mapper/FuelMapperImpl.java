package posCarRental.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import posCarRental.dto.FuelDto;
import posCarRental.entity.Fuel;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-01T06:37:35-0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class FuelMapperImpl implements FuelMapper {

    @Override
    public FuelDto toDto(Fuel fuel) {
        if ( fuel == null ) {
            return null;
        }

        FuelDto fuelDto = new FuelDto();

        return fuelDto;
    }

    @Override
    public Fuel toFuel(FuelDto fuelDto) {
        if ( fuelDto == null ) {
            return null;
        }

        Fuel fuel = new Fuel();

        return fuel;
    }
}
