package posCarRental.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import posCarRental.dto.BrandDto;
import posCarRental.entity.Brand;
import posCarRental.mapper.IBrandMapper;
import posCarRental.repository.IBrandRepository;
import posCarRental.service.IBrandService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements IBrandService {

    @Autowired
    private IBrandRepository brandRepository;

    @Autowired
    private IBrandMapper brandMapper;

    @Override
    public BrandDto createBrand(BrandDto brandDto) {
        Brand brand = brandMapper.toBrand(brandDto);
        return brandMapper.toDto(brandRepository.save(brand));
    }


    @Override
    public List<BrandDto> findAllsBrands(String name, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Brand> brandPage;
        if (name != null && !name.isEmpty()) {
            brandPage = brandRepository.findByNameContainingIgnoreCase(name, pageable);
        } else {
            brandPage = brandRepository.findAll(pageable);
        }
        //return brandPage.stream().toList();
        return brandPage.stream().map(brandMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public BrandDto getByBrandId(Long id) {
        return brandRepository.findById(id)
                .map(brandMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Error not found : " + id));
    }

    @Override
    public List<BrandDto> findAllBrands() {
        return brandRepository.findAll().stream().map(brand -> brandMapper.toDto(brand)).collect(Collectors.toList());
    }

    @Override
    public BrandDto updateBrand(Long id, BrandDto brandDto) {
        return brandRepository.findById(id)
                .map(existingBrand -> {
                    Brand brand = brandMapper.toBrand(brandDto);
                    brand.setId(existingBrand.getId());
                    return brandMapper.toDto(brandRepository.save(brand));
                })
                .orElseThrow(() -> new RuntimeException("Error update brand : " + id));
    }

    @Override
    public void deleteByBrandId(Long id) {
        brandRepository.deleteById(id);
    }


}
