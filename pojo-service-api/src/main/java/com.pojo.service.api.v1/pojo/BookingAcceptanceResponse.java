package com.pojo.service.api.v1.pojo;

/**
 * Created by gourava on 1/29/17.
 */
public class BookingAcceptanceResponse {

    private String poojaBookingRequestId;
    private String userId;
    private String userName;
    private String poojaAddress;
    private int poojaId;
    private String poojaStartTime;
    private String poojaLanguage;
    private String prepBy;
    private float poojaAddressLongitude;
    private float poojaAddressLatitude;
    private int bookingId;
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

    public String getPoojaStartTime() {
        return poojaStartTime;
    }

    public void setPoojaStartTime(String poojaStartTime) {
        this.poojaStartTime = poojaStartTime;
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

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getOfferedPrice() {
        return offeredPrice;
    }

    public void setOfferedPrice(int offeredPrice) {
        this.offeredPrice = offeredPrice;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
