package com.RentBikApp.RentBik.Service;

import com.RentBikApp.RentBik.Model.Brand;
import com.RentBikApp.RentBik.Repository.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BrandService {
    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }
    public List<Brand> findAllBrands(){
        return brandRepository.findAll();
    }

    public Brand addBrand(Brand brand){
        return brandRepository.save(brand);
    }

    public List<Brand> findBrandByName(String name){
        return brandRepository.findAllByNameContaining(name);
    }
}
