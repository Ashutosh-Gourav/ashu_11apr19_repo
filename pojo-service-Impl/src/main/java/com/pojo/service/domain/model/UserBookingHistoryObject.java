package com.pojo.service.domain.model;

import java.sql.Timestamp;

/**
 * Created by virmanv on 26/09/2016 October.
 */
public class UserBookingHistoryObject {
    private int id;
    private String poojaBookingRequestId;
    private String userId;
    private String poojaAddress;
    private int poojaId;
    private Timestamp bookingRequestTime;
    private Timestamp poojaStartTime;
    private String poojaLanguage;
    private String prepBy;
    private float poojaAddressLongitude;
    private float poojaAddressLatitude;
    private String poojaBookingStatus;
    private String panditName;
    private String assignedPanditId;
    private String panditPhone;
    private int offeredPrice;


    public String getPoojaBookingRequestId() {
        return poojaBookingRequestId;
    }

    public void setPoojaBookingRequestId(String poojaBookingRequestId) {
        this.poojaBookingRequestId = poojaBookingRequestId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPoojaAddress() {
        return poojaAddress;
    }

    public void setPoojaAddress(String poojaAddress) {
        this.poojaAddress = poojaAddress;
    }

    public int getPoojaId() {
        return poojaId;
    }

    public void setPoojaId(int poojaId) {
        this.poojaId = poojaId;
    }

    public String getPoojaLanguage() {
        return poojaLanguage;
    }

    public void setPoojaLanguage(String poojaLanguage) {
        this.poojaLanguage = poojaLanguage;
    }

    public String getPrepBy() {
        return prepBy;
    }

    public void setPrepBy(String prepBy) {
        this.prepBy = prepBy;
    }

    public float getPoojaAddressLongitude() {
        return poojaAddressLongitude;
    }

    public void setPoojaAddressLongitude(float poojaAddressLongitude) {
        this.poojaAddressLongitude = poojaAddressLongitude;
    }

    public float getPoojaAddressLatitude() {
        return poojaAddressLatitude;
    }

    public void setPoojaAddressLatitude(float poojaAddressLatitude) {
        this.poojaAddressLatitude = poojaAddressLatitude;
    }

    public String getPoojaBookingStatus() {
        return poojaBookingStatus;
    }

    public void setPoojaBookingStatus(String poojaBookingStatus) {
        this.poojaBookingStatus = poojaBookingStatus;
    }

    public String getPanditName() {
        return panditName;
    }

    public void setPanditName(String panditName) {
        this.panditName = panditName;
    }

    public String getPanditPhone() {
        return panditPhone;
    }

    public void setPanditPhone(String panditPhone) {
        this.panditPhone = panditPhone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getBookingRequestTime() {
        return bookingRequestTime;
    }

    public void setBookingRequestTime(Timestamp bookingRequestTime) {
        this.bookingRequestTime = bookingRequestTime;
    }

    public Timestamp getPoojaStartTime() {
        return poojaStartTime;
    }

    public void setPoojaStartTime(Timestamp poojaStartTime) {
        this.poojaStartTime = poojaStartTime;
    }

    public String getAssignedPanditId() {
        return assignedPanditId;
    }

    public void setAssignedPanditId(String assignedPanditId) {
        this.assignedPanditId = assignedPanditId;
    }

    public int getOfferedPrice() {
        return offeredPrice;
    }

    public void setOfferedPrice(int offeredPrice) {
        this.offeredPrice = offeredPrice;
    }
}
