package com.pojo.service.api.v1.pojo;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created by virmanv on 26/09/2016 October.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class StatusConfirmationRequest {
    private String mobileNumber;
    private String email;
    private String event;
    private Boolean isUser;

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getIsUser() {
        return isUser;
    }

    public void setIsUser(Boolean isUser) {
        this.isUser = isUser;
    }
}
