package com.pojo.service.domain.model;

public class User {


    private String email;
    private String name;
    private String password;
    private String mobileNumber;
    private String registeredAddress;
    private boolean isUser;
    private String deviceId;
    private float registeredLatitude;
    private float registeredLongitude;
    private String fcmRegistrationToken;

    public String getFcmRegistrationToken() {
        return fcmRegistrationToken;
    }

    public void setFcmRegistrationToken(String fcmRegistrationToken) {
        this.fcmRegistrationToken = fcmRegistrationToken;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getRegisteredAddress() {
        return registeredAddress;
    }

    public void setRegisteredAddress(String registeredAddress) {
        this.registeredAddress = registeredAddress;
    }

    public boolean isUser() {
        return isUser;
    }

    public void setUser(boolean isUser) {
        this.isUser = isUser;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public float getRegisteredLatitude() {
        return registeredLatitude;
    }

    public void setRegisteredLatitude(float registeredLatitude) {
        this.registeredLatitude = registeredLatitude;
    }

    public float getRegisteredLongitude() {
        return registeredLongitude;
    }

    public void setRegisteredLongitude(float registeredLongitude) {
        this.registeredLongitude = registeredLongitude;
    }
}
