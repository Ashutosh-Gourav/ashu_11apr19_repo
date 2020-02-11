package com.pojo.service.api.v1.pojo;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created by virmanv on 26/09/2016 October.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserMobileNumber {
    private String mobileNumber;
    private Boolean isUser;
    private String email;

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Boolean getIsUser() {
        return isUser;
    }

    public void setIsUser(Boolean isUser) {
        this.isUser = isUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
