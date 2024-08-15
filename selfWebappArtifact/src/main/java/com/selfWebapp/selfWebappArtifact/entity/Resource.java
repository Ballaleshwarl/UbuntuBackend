package com.selfWebapp.selfWebappArtifact.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "resources")
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String resourceName;

    public Resource() {
    }

    public Resource(Long id, String resourceName) {
        this.id = id;
        this.resourceName = resourceName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }
}
