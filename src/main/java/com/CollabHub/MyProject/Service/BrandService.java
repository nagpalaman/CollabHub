package com.CollabHub.MyProject.Service;

import com.CollabHub.MyProject.Repository.BrandRepository;
import com.CollabHub.MyProject.model.BrandProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandService {
    @Autowired
    private BrandRepository brandRepository;

    public List<BrandProfile> getAllBrands() {
        return brandRepository.findAll();
    }

    public Optional<BrandProfile> getBrandById(Long id) {
        return brandRepository.findById(id);
    }

    public Optional<BrandProfile> getBrandByUserId(Long userId) {
        return brandRepository.findByUserId(userId);
    }

    public BrandProfile saveBrand(BrandProfile brand) {
        return brandRepository.save(brand);
    }

    public List<BrandProfile> getBrandsByIndustry(String industry) {
        return brandRepository.findByIndustry(industry);
    }

    public List<BrandProfile> searchBrands(String companyName) {
        return brandRepository.findByCompanyNameContaining(companyName);
    }

    public void deleteBrand(Long id) {
        brandRepository.deleteById(id);
    }
}
