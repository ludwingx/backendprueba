package posCarRental.service;

import posCarRental.dto.BrandDto;
import posCarRental.entity.Brand;

import java.util.List;

public interface IBrandService {

    BrandDto createBrand(BrandDto brandDto);

    BrandDto getByBrandId(Long Id);

    List<BrandDto> findAllBrands();

    List<BrandDto> findAllsBrands(String name, Integer page, Integer size);

    BrandDto updateBrand(Long id, BrandDto brandDto);

    void deleteByBrandId(Long id);
}
