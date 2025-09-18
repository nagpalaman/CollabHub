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

    @OneToMany(mappedBy = "influencer")
    private List<SocialMediaProfile> socialMediaProfiles = new ArrayList<>();

    @ManyToMany(mappedBy = "followingInfluencers")
    private List<BrandProfile> followerBrands = new ArrayList<>();

    @ManyToMany(mappedBy = "interestedInfluencers")
    private List<Campaign> interestedCampaigns = new ArrayList<>();

    public Influencer(){
    }

    public Influencer(User user, List<CampaignApplication> applications, List<Niche> niches,
                      List<SocialMediaProfile> socialMediaProfiles, List<BrandProfile> followerBrands,
                      List<Campaign> interestedCampaigns) {
        this.user = user;
        this.applications = applications;
        this.niches = niches;
        this.socialMediaProfiles = socialMediaProfiles;
        this.followerBrands = followerBrands;
        this.interestedCampaigns = interestedCampaigns;
    }

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

    public List<SocialMediaProfile> getSocialMediaProfile() {
        return socialMediaProfiles;
    }

    public void setSocialMediaProfile(List<SocialMediaProfile> socialMediaProfiles) {
        this.socialMediaProfiles = socialMediaProfiles;
    }

    public List<BrandProfile> getFollowerBrands() {
        return followerBrands;
    }

    public void setFollowerBrands(List<BrandProfile> followerBrands) {
        this.followerBrands = followerBrands;
    }

    public List<Campaign> getCampaignList() {
        return interestedCampaigns;
    }

    public void setCampaignList(List<Campaign> interestedCampaigns) {
        this.interestedCampaigns = interestedCampaigns;
    }


}
