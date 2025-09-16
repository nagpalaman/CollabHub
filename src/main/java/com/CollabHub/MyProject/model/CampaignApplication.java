package com.CollabHub.MyProject.model;

import jakarta.persistence.*;

@Entity
@Table(name = "campaign_applications")
public class CampaignApplication {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "campaign_id",nullable = false)
    private Campaign campaign;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "influencer_id",nullable = false)
    private Influencer influencer;

    @Enumerated(EnumType.STRING)
    private ApplicationStatus applicationStatus;


    public long id() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Campaign campaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public Influencer influencer() {
        return influencer;
    }

    public void setInfluencer(Influencer influencer) {
        this.influencer = influencer;
    }

    public ApplicationStatus applicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(ApplicationStatus applicationStatus) {
        this.applicationStatus = applicationStatus;
    }
}
