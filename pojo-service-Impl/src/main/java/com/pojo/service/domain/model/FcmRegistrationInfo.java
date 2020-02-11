package com.pojo.service.domain.model;

/**
 * Created by gourava on 1/20/17.
 */
public class FcmRegistrationInfo {

    private String fcmRegistrationToken;
    private String deviceId;
    private boolean isUser;
    private int personId;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFcmRegistrationToken() {
        return fcmRegistrationToken;
    }

    public void setFcmRegistrationToken(String fcmRegistrationToken) {
        this.fcmRegistrationToken = fcmRegistrationToken;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public boolean isUser() {
        return isUser;
    }

    public void setUser(boolean isUser) {
        this.isUser = isUser;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }
}
