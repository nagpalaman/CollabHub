package com.CollabHub.MyProject.model;

import jakarta.persistence.*;

@Entity
@Table(name="brand_profile")
public class BrandProfile {
    @Id
    @Column(name = "id")
    private int id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private User user;

    private String companyName;
    private String industry;
    private String contactPerson;
    private String companyWebsite;
    private String Description;

    public int id() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User user() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String companyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String contactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String industry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String companyWebsite() {
        return companyWebsite;
    }

    public void setCompanyWebsite(String companyWebsite) {
        this.companyWebsite = companyWebsite;
    }

    public String Description() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
