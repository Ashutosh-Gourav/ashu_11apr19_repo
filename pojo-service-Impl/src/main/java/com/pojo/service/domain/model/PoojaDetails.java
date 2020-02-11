package com.pojo.service.domain.model;

import java.util.List;

/**
 * Created by virmanv on 26/09/2016 October.
 */
public class PoojaDetails {
    private int id;
    private String name;
    private String procedure;
    private String importance;
    private float cost;
    private String avgDuration;
    private List<PoojaItems> poojaItems;


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

    public List<PoojaItems> getPoojaItems() {
        return poojaItems;
    }

    public void setPoojaItems(List<PoojaItems> poojaItems) {
        this.poojaItems = poojaItems;
    }
}
