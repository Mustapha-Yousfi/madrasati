package com.madrasati.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Establishment {

    @Id
    private  Long id;

    private String name;
    private String address;
    private String slug;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

}
