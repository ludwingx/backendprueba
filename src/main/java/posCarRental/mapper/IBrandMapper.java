package posCarRental.mapper;

import org.mapstruct.Mapper;
import posCarRental.dto.BrandDto;
import posCarRental.entity.Brand;

@Mapper(componentModel = "spring")
public interface IBrandMapper {

    // Mapeo de entidad a DTO
    BrandDto toDto(Brand brand);
    // Mapeo de DTO a entidad
    Brand toBrand(BrandDto brandDto);
}
