package com.CollabHub.MyProject.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Influencer_Profile")
public class Influencer{
    @Id
    @Column(name = "influencer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "influencer", cascade = CascadeType.ALL)
    private List<CampaignApplication> applications = new ArrayList<>();

    @ManyToMany(mappedBy = "influencers")
    private List<Niche> niches = new ArrayList<>();

    @OneToOne(mappedBy = "influencer")
    private SocialMediaProfile socialMediaProfile;

    @ManyToMany(mappedBy = "followingInfluencers")
    private List<Campaign> campaigns = new ArrayList<>();

    public Influencer() {}

    public Influencer(User user) {
        this.user = user;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<CampaignApplication> getApplications() {
        return applications;
    }

    public void setApplications(List<CampaignApplication> applications) {
        this.applications = applications;
    }

    public List<Niche> getNiches() {
        return niches;
    }

    public void setNiches(List<Niche> niches) {
        this.niches = niches;
    }

    public SocialMediaProfile getSocialMediaProfile() {
        return socialMediaProfile;
    }

    public void setSocialMediaProfile(SocialMediaProfile socialMediaProfile) {
        this.socialMediaProfile = socialMediaProfile;
    }

    public List<Campaign> getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(List<Campaign> campaigns) {
        this.campaigns = campaigns;
    }

    // Helper methods for bidirectional relationships
    public void addApplication(CampaignApplication application) {
        applications.add(application);
        application.setInfluencer(this);
    }

    public void removeApplication(CampaignApplication application) {
        applications.remove(application);
        application.setInfluencer(null);
    }

    public void addNiche(Niche niche) {
        if (!niches.contains(niche)) {
            niches.add(niche);
            niche.getFollowingInfluencers().add(this);
        }
    }

    public void removeNiche(Niche niche) {
        if (niches.contains(niche)) {
            niches.remove(niche);
            niche.getFollowingInfluencers().remove(this);
        }
    }

    public void addCampaign(Campaign campaign) {
        if (!campaigns.contains(campaign)) {
            campaigns.add(campaign);
            campaign.getInfluencers().add(this);
        }
    }

    public void removeCampaign(Campaign campaign) {
        if (campaigns.contains(campaign)) {
            campaigns.remove(campaign);
            campaign.getInfluencers().remove(this);
        }
    }

}
