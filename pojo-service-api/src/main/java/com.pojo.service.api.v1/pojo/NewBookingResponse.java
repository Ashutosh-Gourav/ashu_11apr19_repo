package com.pojo.service.api.v1.pojo;

/**
 * Created by virmanv on 26/09/2016 October.
 */
public class NewBookingResponse {
    private String userFullName;
    private String userMobileNumber;
    private String poojaAddress;
    private int poojaid;
    private String poojaStartTime;
    private String poojalanguage;
    private String prepBy;
    private float poojaAddressLongitude;
    private float poojaAddressLatitude;
    private String status;

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

    public String getPoojaStartTime() {
        return poojaStartTime;
    }

    public void setPoojaStartTime(String poojaStartTime) {
        this.poojaStartTime = poojaStartTime;
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
}
