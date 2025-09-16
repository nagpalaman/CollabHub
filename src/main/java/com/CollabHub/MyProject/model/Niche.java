package com.CollabHub.MyProject.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "niches")
public class Niche {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "niche_id")
    private long id;
    private String name;
    private String description;

    @ManyToMany
    @JoinTable(name = "influencer_niche",
    joinColumns = @JoinColumn(name = "niche_id"),
    inverseJoinColumns = @JoinColumn(name = "influencer_id"))
    private List<Influencer> influencers;

    public long id() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String description() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Influencer> influencers() {
        return influencers;
    }

    public void setInfluencers(List<Influencer> influencers) {
        this.influencers = influencers;
    }
}
