package com.pojo.service.api.v1.pojo;



import java.util.List;

/**
 * Created by virmanv on 26/09/2016 October.
 */
public class PoojaDetailsResponse {
    private int id;
    private String name;
    private String procedure;
    private String importance;
    private float cost;
    private String avgDuration;
    private List<com.pojo.service.api.v1.pojo.PoojaItemInResponse> poojaItems;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProcedure() {
        return procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    public String getImportance() {
        return importance;
    }

    public void setImportance(String importance) {
        this.importance = importance;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getAvgDuration() {
        return avgDuration;
    }

    public void setAvgDuration(String avgDuration) {
        this.avgDuration = avgDuration;
    }

    public List<com.pojo.service.api.v1.pojo.PoojaItemInResponse> getPoojaItems() {
        return poojaItems;
    }

    public void setPoojaItems(List<com.pojo.service.api.v1.pojo.PoojaItemInResponse> poojaItems) {
        this.poojaItems = poojaItems;
    }
}
