package com.pojo.service.api.v1.pojo;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created by virmanv on 26/09/2016 October.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class PriestRegistrationRequest {

    private String name;
    private String phNumber;
    private String address;
    private String email;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhNumber() {
        return phNumber;
    }

    public void setPhNumber(String phNumber) {
        this.phNumber = phNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
