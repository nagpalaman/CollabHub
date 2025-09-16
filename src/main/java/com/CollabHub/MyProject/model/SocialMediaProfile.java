package com.CollabHub.MyProject.model;

import jakarta.persistence.*;

@Entity
@Table(name = "social_media_profiles")
public class SocialMediaProfile {
    @Id
    @Column(name = "social_media_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "influencer_id")
    private Influencer influencer;

    private String platform;
    private String handle;
    private int folowersCount;
    private String profileUrl;

    public long id() {
        return id;
    }

    public void setId(long id) {
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

    public int folowersCount() {
        return folowersCount;
    }

    public void setFolowersCount(int folowersCount) {
        this.folowersCount = folowersCount;
    }

    public String profileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }
}
