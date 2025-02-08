package posCarRental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import posCarRental.dto.BrandDto;
import posCarRental.entity.Brand;
import posCarRental.service.IBrandService;

import java.util.List;

import static posCarRental.constants.GeneralConstants.*;


@RestController
@RequestMapping(API)
public class BrandController {

    @Autowired
    private IBrandService brandService;

    @PostMapping(BRAND)
    public ResponseEntity<?> create(@RequestBody BrandDto brandDto){
        try {
            return ResponseEntity.ok(brandService.createBrand(brandDto));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping(BRANDS)
    public ResponseEntity<?> findAllsBrands(
            @RequestParam(defaultValue = DEFAULT_PAGE_NUMBER) int page,
            @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int size,
            @RequestParam(required = false) String name){
        try {
            return ResponseEntity.ok(brandService.findAllsBrands(name, page, size));
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(GET_ALL_BRANDS)
    public ResponseEntity<?> findAllBrands(){
        try {
            return ResponseEntity.ok(brandService.findAllBrands());
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(GET_BY_BRAND_ID)
    public ResponseEntity<?> getByBrandId(@PathVariable Long id){
        try {
            return ResponseEntity.ok(brandService.getByBrandId(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping(GET_BY_BRAND_ID)
    public ResponseEntity<?> updateBrand(@PathVariable Long id, @RequestBody BrandDto brandDto){
        try {
            return ResponseEntity.ok(brandService.updateBrand(id, brandDto));
        }catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping(GET_BY_BRAND_ID)
    public ResponseEntity<?> delete(@PathVariable Long id){
        brandService.deleteByBrandId(id);
        return ResponseEntity.noContent().build();
    }
}
