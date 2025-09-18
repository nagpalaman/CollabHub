package com.CollabHub.MyProject.model;

import jakarta.persistence.*;

@Entity
@Table(name = "social_media_profiles")
public class SocialMediaProfile {
    @Id
    @Column(name = "social_media_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "influencer_id")
    private Influencer influencer;

    private String platform;
    private String handle;
    private int followersCount;
    private String profileUrl;
    private double engagementRate;

    public SocialMediaProfile(){}

    public SocialMediaProfile(Influencer influencer, String platform, String handle, int followersCount, String profileUrl, double engagementRate) {
        this.influencer = influencer;
        this.platform = platform;
        this.handle = handle;
        this.followersCount = followersCount;
        this.profileUrl = profileUrl;
        this.engagementRate = engagementRate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Influencer influencer() {
        return influencer;
    }

    public void setInfluencer(Influencer influencer) {
        this.influencer = influencer;
    }

    public String platform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String handle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public int followersCount() {
        return followersCount;
    }

    public void setFollowersCount(int folowersCount) {
        this.followersCount = folowersCount;
    }

    public String profileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public double engagementRate() {
        return engagementRate;
    }

    public void setEngagementRate(double engagementRate) {
        this.engagementRate = engagementRate;
    }
}
