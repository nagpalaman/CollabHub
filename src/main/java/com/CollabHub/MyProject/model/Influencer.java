package com.CollabHub.MyProject.model;

import jakarta.persistence.*;

@Entity
@Table(name="Influencer_Profile")
public class Influencer extends User{
    @Id
    @Column(name = "id")
    private long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private User user;

    private String niche;
    private int followerCount;
    private double engagementRate;

    @Override
    public long id() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public User user() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String niche() {
        return niche;
    }

    public void setNiche(String niche) {
        this.niche = niche;
    }

    public int followerCount() {
        return followerCount;
    }

    public void setFollowerCount(int followerCount) {
        this.followerCount = followerCount;
    }

    public double engagementRate() {
        return engagementRate;
    }

    public void setEngagementRate(double engagementRate) {
        this.engagementRate = engagementRate;
    }
}
