package com.selfWebapp.selfWebappArtifact.dto;

public class ModelDto {

    private String entity;
    private String resource;
    private String modelName;
    private String resourceAttribute;
    private String eventDesc;
    private int riskScore;

    public ModelDto() {
    }

    public ModelDto(String entity, String resource, String modelName, String resourceAttribute, String eventDesc, int riskScore) {
        this.entity = entity;
        this.resource = resource;
        this.modelName = modelName;
        this.resourceAttribute = resourceAttribute;
        this.eventDesc = eventDesc;
        this.riskScore = riskScore;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
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

    public int getRiskScore() {
        return riskScore;
    }

    public void setRiskScore(int riskScore) {
        this.riskScore = riskScore;
    }
}
