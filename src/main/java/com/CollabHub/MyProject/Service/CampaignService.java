package com.CollabHub.MyProject.Service;

import com.CollabHub.MyProject.Repository.CampaignRepository;
import com.CollabHub.MyProject.model.Campaign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CampaignService {

    @Autowired
    private CampaignRepository campaignRepository;

    List<Campaign> getAllCampaigns(){
        return campaignRepository.findAll();
    }

    public Optional<Campaign> getCampaignById(Long id) {
        return campaignRepository.findById(id);
    }

    public Campaign saveCampaign(Campaign campaign) {
        return campaignRepository.save(campaign);
    }

    public List<Campaign> getActiveCampaigns() {
        return campaignRepository.findActiveCampaigns();
    }

    public List<Campaign> getCampaignsByBrand(Long brandId) {
        return campaignRepository.findByBrandProfileId(brandId);
    }

    public List<Campaign> searchCampaigns(String keyword) {
        return campaignRepository.findByTitleContaining(keyword);
    }

    public List<Campaign> getCampaignsByBudgetRange(Double minBudget, Double maxBudget) {
        return campaignRepository.findByBudgetBetween(minBudget, maxBudget);
    }

    public void deleteCampaign(Long id) {
        campaignRepository.deleteById(id);
    }
}
