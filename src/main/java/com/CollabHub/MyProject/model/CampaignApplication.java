package com.CollabHub.MyProject.model;

import jakarta.persistence.*;

@Entity
@Table(name = "campaign_applications")
public class CampaignApplication {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "application_id")
    private Long id;

    private String pitch;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "campaign_id",nullable = false)
    private Campaign campaign;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "influencer_id",nullable = false)
    private Influencer influencer;

    @Enumerated(EnumType.STRING)
    private ApplicationStatus applicationStatus;

    public CampaignApplication(){}

    public CampaignApplication(String pitch, Campaign campaign, Influencer influencer, ApplicationStatus applicationStatus) {
        this.pitch = pitch;
        this.campaign = campaign;
        this.influencer = influencer;
        this.applicationStatus = applicationStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPitch() {
        return pitch;
    }

    public void setPitch(String pitch) {
        this.pitch = pitch;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public Influencer getInfluencer() {
        return influencer;
    }

    public void setInfluencer(Influencer influencer) {
        this.influencer = influencer;
    }

    public ApplicationStatus getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(ApplicationStatus applicationStatus) {
        this.applicationStatus = applicationStatus;
    }
}
