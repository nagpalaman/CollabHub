package com.CollabHub.MyProject.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "niches")
public class Niche {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "niche_id")
    private Long id;
    private String name;
    private String description;

    @ManyToMany
    @JoinTable(name = "influencer_niche",
    joinColumns = @JoinColumn(name = "niche_id"),
    inverseJoinColumns = @JoinColumn(name = "influencer_id"))
    private List<Influencer> influencers;

    public Niche(){}

    public Niche(String name, String description, List<Influencer> influencers) {
        this.name = name;
        this.description = description;
        this.influencers = influencers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Influencer> getInfluencers() {
        return influencers;
    }

    public void setInfluencers(List<Influencer> influencers) {
        this.influencers = influencers;
    }
}
