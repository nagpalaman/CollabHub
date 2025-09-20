package com.CollabHub.MyProject.Repository;

import com.CollabHub.MyProject.model.Influencer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InfluencerRepository extends JpaRepository<Influencer,Long> {
    Optional<Influencer> findByUserId(Long userId);
    @Query("Select i from Influencer i join i.socialMediaProfiles s where s.followersCount >= :minFollowers")
    List<Influencer> findByMinFollowers(Integer minFollowers);
    @Query("Select i from Influencer i join i.niches n where  n.name = :nicheName")
    List<Influencer> findByNiche(String nicheName);
}
