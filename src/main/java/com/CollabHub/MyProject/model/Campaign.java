package com.CollabHub.MyProject.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="campaigns")
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "campaign_id")
    private long id;

    private String title;
    private String description;
    private double budget;

    @Temporal(TemporalType.DATE)
    private Date applicationDeadline;


    @ManyToOne(fetch=FetchType.LAZY)//unless i want to access brandprofile explicitly it wont load this data
    @JoinColumn(name = "brand_id",nullable = false)
    private BrandProfile brandProfile;

    @ManyToMany
    @JoinTable(name = "influencer_campaign"
    ,joinColumns = @JoinColumn(name = "campaign_id")
    ,inverseJoinColumns = @JoinColumn(name = "influencer_id"))
    private List<Influencer> influencers;

    @OneToMany(mappedBy = "campaign", cascade = CascadeType.ALL)
    private List<CampaignApplication> applications;


    public long id() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String title() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String description() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double budget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public Date applicationDeadline() {
        return applicationDeadline;
    }

    public void setApplicationDeadline(Date applicationDeadline) {
        this.applicationDeadline = applicationDeadline;
    }

    public BrandProfile brandProfile() {
        return brandProfile;
    }

    public void setBrandProfile(BrandProfile brandProfile) {
        this.brandProfile = brandProfile;
    }

}
