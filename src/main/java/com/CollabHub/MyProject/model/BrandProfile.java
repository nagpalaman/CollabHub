package com.CollabHub.MyProject.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="brand_profile")
public class BrandProfile {
    @Id
    @Column(name = "brand_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;

    private String companyName;
    private String industry;
    private String contactPerson;
    private String companyWebsite;
    private String description;


    @OneToMany(mappedBy = "brandProfile", cascade = CascadeType.ALL)
    private List<Campaign> campaigns;

    @ManyToMany
    @JoinTable(name = "brand_influencer"
            ,joinColumns = @JoinColumn(name="brand_id")
            ,inverseJoinColumns = @JoinColumn(name="influencer_id"))
    private List<Influencer> followingInfluencers;

    public BrandProfile(){
    }

    public BrandProfile(User user, String companyName, String industry, String contactPerson, String companyWebsite, String description, List<Campaign> campaigns) {
        this.user = user;
        this.companyName = companyName;
        this.industry = industry;
        this.contactPerson = contactPerson;
        this.companyWebsite = companyWebsite;
        this.description = description;
        this.campaigns = campaigns;
    }

    public List<Campaign> getCampaigns() { return campaigns; }
    public void setCampaigns(List<Campaign> campaigns) { this.campaigns = campaigns; }

    public List<Influencer> getFollowingInfluencers() {
        return followingInfluencers;
    }

    public void setFollowingInfluencers(List<Influencer> followingInfluencers) {
        this.followingInfluencers = followingInfluencers;
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getCompanyWebsite() {
        return companyWebsite;
    }

    public void setCompanyWebsite(String companyWebsite) {
        this.companyWebsite = companyWebsite;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
