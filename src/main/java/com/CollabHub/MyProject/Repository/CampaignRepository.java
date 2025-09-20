package com.CollabHub.MyProject.Repository;

import com.CollabHub.MyProject.model.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign,Long> {
    List<Campaign> findByBrandProfileId(Long brandId);
    List<Campaign> findByApplicationDeadlineAfter(Date date);
    List<Campaign> findByBudgetBetween(Double minBudget,Double maxBudget);
    List<Campaign> findByTitleContaining(String title);//like %?%

    @Query("Select c from Campaign c where c.applicationDeadline >= CURRENT_DATE ORDER BY c.applicationDeadline ASC")
    List<Campaign> findActiveCampaigns();
}
