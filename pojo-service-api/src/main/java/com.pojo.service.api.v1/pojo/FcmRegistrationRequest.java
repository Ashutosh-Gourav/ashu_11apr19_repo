package com.pojo.service.api.v1.pojo;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created by gourava on 1/20/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FcmRegistrationRequest {

    private String fcmRegistrationToken;
    private String deviceId;
    private int personId;
    private Boolean isUser;


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

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public Boolean getIsUser() {
        return isUser;
    }

    public void setIsUser(Boolean isUser) {
        this.isUser = isUser;
    }
}
