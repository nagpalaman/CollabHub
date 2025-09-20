package com.CollabHub.MyProject.Repository;

import com.CollabHub.MyProject.model.BrandProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BrandRepository extends JpaRepository<BrandProfile,Long> {
    List<BrandProfile> findByIndustry(String industry);
    List<BrandProfile> findByCompanyNameContaining(String companyName);
    Optional<BrandProfile> findByUserId(Long userId);
}
