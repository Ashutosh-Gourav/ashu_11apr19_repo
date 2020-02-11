package com.pojo.service.api.v1.pojo;

/**
 * Created by virmanv on 26/09/2016 October.
 */
public class BookingDetailsResponse {
    private String poojaBookingRequestId;
    private String userId;
    private String poojaAddress;
    private int poojaId;
    private String poojaStartTime;
    private String poojaLanguage;
    private String prepBy;
    private float poojaAddressLongitude;
    private float poojaAddressLatitude;
    private String poojaBookingStatus;
    private String panditName;
    private String panditPhone;
    private int bookingId;
    private int offeredPrice;
    private String bookingRequestTime;

    public String getBookingRequestTime() {
        return bookingRequestTime;
    }

    public void setBookingRequestTime(String bookingRequestTime) {
        this.bookingRequestTime = bookingRequestTime;
    }

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
}
