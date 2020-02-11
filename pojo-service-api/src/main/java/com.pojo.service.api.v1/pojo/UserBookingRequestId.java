package com.pojo.service.api.v1.pojo;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created by virmanv on 26/09/2016 October.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserBookingRequestId  {
    private String userBookingRequestId;
    private String priestEmail;
    private String priestMobile;

    public String getUserBookingRequestId() {
        return userBookingRequestId;
    }

    public void setUserBookingRequestId(String userBookingRequestId) {
        this.userBookingRequestId = userBookingRequestId;
    }

    public String getPriestEmail() {
        return priestEmail;
    }

    public void setPriestEmail(String priestEmail) {
        this.priestEmail = priestEmail;
    }

    public String getPriestMobile() {
        return priestMobile;
    }

    public void setPriestMobile(String priestMobile) {
        this.priestMobile = priestMobile;
    }
}

