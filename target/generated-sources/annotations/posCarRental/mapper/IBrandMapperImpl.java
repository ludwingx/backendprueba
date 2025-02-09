package posCarRental.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import posCarRental.dto.BrandDto;
import posCarRental.entity.Brand;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-08T21:57:11-0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class IBrandMapperImpl implements IBrandMapper {

    @Override
    public BrandDto toDto(Brand brand) {
        if ( brand == null ) {
            return null;
        }

        BrandDto brandDto = new BrandDto();

        brandDto.setId( brand.getId() );
        brandDto.setName( brand.getName() );
        brandDto.setDescription( brand.getDescription() );

        return brandDto;
    }

    @Override
    public Brand toBrand(BrandDto brandDto) {
        if ( brandDto == null ) {
            return null;
        }

        Brand brand = new Brand();

        brand.setId( brandDto.getId() );
        brand.setName( brandDto.getName() );
        brand.setDescription( brandDto.getDescription() );

        return brand;
    }
}
