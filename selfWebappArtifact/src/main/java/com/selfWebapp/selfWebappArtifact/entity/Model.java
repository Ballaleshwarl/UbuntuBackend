package com.selfWebapp.selfWebappArtifact.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "models")
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true)
    private String modelName;

    private String modelType;

    private String resource;

    private int riskScore;

    private String resourceAttribute;

    private String eventDesc;

    public Model() {
    }

    public Model(long id, String modelName, String modelType, String resource, int riskScore, String resourceAttribute, String eventDesc) {
        this.id = id;
        this.modelName = modelName;
        this.modelType = modelType;
        this.resource = resource;
        this.riskScore = riskScore;
        this.resourceAttribute = resourceAttribute;
        this.eventDesc = eventDesc;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModelType() {
        return modelType;
    }

    public void setModelType(String modelType) {
        this.modelType = modelType;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public int getRiskScore() {
        return riskScore;
    }

    public void setRiskScore(int riskScore) {
        this.riskScore = riskScore;
    }

    public String getResourceAttribute() {
        return resourceAttribute;
    }

    public void setResourceAttribute(String resourceAttribute) {
        this.resourceAttribute = resourceAttribute;
    }

    public String getEventDesc() {
        return eventDesc;
    }

    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }
}
