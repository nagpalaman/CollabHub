package com.CollabHub.MyProject.Repository;

import com.CollabHub.MyProject.model.Influencer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfluencerRepository extends JpaRepository<Influencer,Integer> {
}
