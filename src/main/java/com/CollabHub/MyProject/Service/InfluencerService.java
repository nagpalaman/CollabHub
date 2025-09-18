package com.CollabHub.MyProject.Service;

import com.CollabHub.MyProject.model.Influencer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfluencerService {
    @Autowired
    private InfluencerRepository influencerRepository;
    public Influencer getMyProfile(int userId){
        
    }
}
