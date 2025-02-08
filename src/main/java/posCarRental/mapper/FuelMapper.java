package posCarRental.mapper;

import org.mapstruct.Mapper;
import posCarRental.dto.BrandDto;
import posCarRental.dto.FuelDto;
import posCarRental.entity.Brand;
import posCarRental.entity.Fuel;

@Mapper(componentModel = "spring")
public interface FuelMapper {

    FuelDto toDto(Fuel fuel);
    Fuel toFuel(FuelDto fuelDto);
}
