package com.CollabHub.MyProject.model;

import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="campaigns")
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "campaign_id")
    private Long id;

    private String title;
    private String description;
    private double budget;

    @Column(name = "application_deadline")
    private LocalDateTime applicationDeadline;

    private String preferredNiche;
    private String preferredSocialMediaPlatform;

    @ManyToOne(fetch=FetchType.LAZY)//unless i want to access brandprofile explicitly it wont load this data
    @JoinColumn(name = "brand_id",nullable = false)
    private BrandProfile brandProfile;

    @ManyToMany
    @JoinTable(name = "influencer_campaign"
    ,joinColumns = @JoinColumn(name = "campaign_id")
    ,inverseJoinColumns = @JoinColumn(name = "influencer_id"))
    private List<Influencer> interestedInfluencers = new ArrayList<>();

    @OneToMany(mappedBy = "campaign", cascade = CascadeType.ALL)
    private List<CampaignApplication> applications = new ArrayList<>();

    public Campaign(){}


    public Campaign(String title, String description, double budget, LocalDateTime applicationDeadline, String preferredNiche, String preferredSocialMediaPlatform, BrandProfile brandProfile, List<Influencer> interestedInfluencers, List<CampaignApplication> applications) {
        this.title = title;
        this.description = description;
        this.budget = budget;
        this.applicationDeadline = applicationDeadline;
        this.preferredNiche = preferredNiche;
        this.preferredSocialMediaPlatform = preferredSocialMediaPlatform;
        this.brandProfile = brandProfile;
        this.interestedInfluencers = interestedInfluencers;
        this.applications = applications;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public LocalDateTime getApplicationDeadline() {
        return applicationDeadline;
    }

    public void setApplicationDeadline(LocalDateTime applicationDeadline) {
        this.applicationDeadline = applicationDeadline;
    }

    public BrandProfile getBrandProfile() {
        return brandProfile;
    }

    public void setBrandProfile(BrandProfile brandProfile) {
        this.brandProfile = brandProfile;
    }

    public String getPreferredNiche() {
        return preferredNiche;
    }

    public void setPreferredNiche(String preferredNiche) {
        this.preferredNiche = preferredNiche;
    }

    public String getPreferredSocialMediaPlatform() {
        return preferredSocialMediaPlatform;
    }

    public void setPreferredSocialMediaPlatform(String preferredSocialMediaPlatform) {
        this.preferredSocialMediaPlatform = preferredSocialMediaPlatform;
    }

    public List<Influencer> getInterestedInfluencers() {
        return interestedInfluencers;
    }

    public void setInterestedInfluencers(List<Influencer> interestedInfluencers) {
        this.interestedInfluencers = interestedInfluencers;
    }

    public List<CampaignApplication> getApplications() {
        return applications;
    }

    public void setApplications(List<CampaignApplication> applications) {
        this.applications = applications;
    }
}
