package com.pojo.service.domain.model;

import java.sql.Timestamp;

/**
 * Created by gourava on 1/29/17.
 */
public class RegisteredUserBookingDetails {
    private String userName;
    private Timestamp poojaStartTime;
    private String Lang;
    private String prepBy;
    private float poojaLatitude;
    private float poojaLongitude;
    private int poojaId;
    private int offeredPrice;
    private String poojaAddress;

    public String getPoojaAddress() {
        return poojaAddress;
    }

    public void setPoojaAddress(String poojaAddress) {
        this.poojaAddress = poojaAddress;
    }

    public int getOfferedPrice() {
        return offeredPrice;
    }

    public void setOfferedPrice(int offeredPrice) {
        this.offeredPrice = offeredPrice;
    }

    public Timestamp getPoojaStartTime() {
        return poojaStartTime;
    }

    public void setPoojaStartTime(Timestamp poojaStartTime) {
        this.poojaStartTime = poojaStartTime;
    }

    public String getLang() {
        return Lang;
    }

    public void setLang(String lang) {
        Lang = lang;
    }

    public String getPrepBy() {
        return prepBy;
    }

    public void setPrepBy(String prepBy) {
        this.prepBy = prepBy;
    }

    public float getPoojaLatitude() {
        return poojaLatitude;
    }

    public void setPoojaLatitude(float poojaLatitude) {
        this.poojaLatitude = poojaLatitude;
    }

    public float getPoojaLongitude() {
        return poojaLongitude;
    }

    public void setPoojaLongitude(float poojaLongitude) {
        this.poojaLongitude = poojaLongitude;
    }

    public int getPoojaId() {
        return poojaId;
    }

    public void setPoojaId(int poojaId) {
        this.poojaId = poojaId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
