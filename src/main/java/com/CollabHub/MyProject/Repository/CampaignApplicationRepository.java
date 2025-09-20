package com.CollabHub.MyProject.Repository;

import com.CollabHub.MyProject.model.ApplicationStatus;
import com.CollabHub.MyProject.model.CampaignApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampaignApplicationRepository extends JpaRepository<CampaignApplication,Long> {
    List<CampaignApplication> findByCampaignId(Long campaignId);
    List<CampaignApplication> findByInfluencerId(Long influencerId);
    List<CampaignApplication> findByApplicationStatus(ApplicationStatus status);
    List<CampaignApplication> findByCampaignIdAndInfluencerId(Long campaignId,Long InfluencerId);
}
