package com.pojo.service.domain.model;

import java.sql.Timestamp;

/**
 * Created by virmanv on 26/09/2016 October.
 */
public class NewBookingResponseObject {
    private String userFullName;
    private String userMobileNumber;
    private String poojaAddress;
    private int poojaid;
    private Timestamp poojaStartTime;
    private String poojalanguage;
    private String prepBy;
    private float poojaAddressLongitude;
    private float poojaAddressLatitude;
    private String status;
    private String deviceId;
    private String poojabookingrequestId;

    public String getPoojabookingrequestId() {
        return poojabookingrequestId;
    }

    public void setPoojabookingrequestId(String poojabookingrequestId) {
        this.poojabookingrequestId = poojabookingrequestId;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getUserMobileNumber() {
        return userMobileNumber;
    }

    public void setUserMobileNumber(String userMobileNumber) {
        this.userMobileNumber = userMobileNumber;
    }

    public String getPoojaAddress() {
        return poojaAddress;
    }

    public void setPoojaAddress(String poojaAddress) {
        this.poojaAddress = poojaAddress;
    }

    public int getPoojaid() {
        return poojaid;
    }

    public void setPoojaid(int poojaid) {
        this.poojaid = poojaid;
    }

    public String getPoojalanguage() {
        return poojalanguage;
    }

    public void setPoojalanguage(String poojalanguage) {
        this.poojalanguage = poojalanguage;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getPoojaStartTime() {
        return poojaStartTime;
    }

    public void setPoojaStartTime(Timestamp poojaStartTime) {
        this.poojaStartTime = poojaStartTime;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
