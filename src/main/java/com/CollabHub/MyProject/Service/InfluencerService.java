package com.CollabHub.MyProject.Service;

import com.CollabHub.MyProject.Repository.InfluencerRepository;
import com.CollabHub.MyProject.model.Influencer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InfluencerService {
    @Autowired
    private InfluencerRepository influencerRepository;

    public List<Influencer> getAllInfluencers() {
        return influencerRepository.findAll();
    }

    public Optional<Influencer> getInfluencerById(Long id) {
        return influencerRepository.findById(id);
    }

    public Optional<Influencer> getInfluencerByUserId(Long userId) {
        return influencerRepository.findByUserId(userId);
    }

    public Influencer saveInfluencer(Influencer influencer) {
        return influencerRepository.save(influencer);
    }

    public List<Influencer> getInfluencersByMinFollowers(Integer minFollowers) {
        return influencerRepository.findByMinFollowers(minFollowers);
    }

    public List<Influencer> getInfluencersByNiche(String niche) {
        return influencerRepository.findByNiche(niche);
    }

    public void deleteInfluencer(Long id) {
        influencerRepository.deleteById(id);
    }
}
