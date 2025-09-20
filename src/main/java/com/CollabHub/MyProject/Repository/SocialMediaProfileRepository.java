package com.CollabHub.MyProject.Repository;

import com.CollabHub.MyProject.model.SocialMediaProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SocialMediaProfileRepository extends JpaRepository<SocialMediaProfile,Long> {
    List<SocialMediaProfile> findByInfluencerId(Long influencerId);
    List<SocialMediaProfile> findByPlatform(String platform);
    List<SocialMediaProfile> findByFollowersCountGreaterThan(Integer minFollowers);
}
