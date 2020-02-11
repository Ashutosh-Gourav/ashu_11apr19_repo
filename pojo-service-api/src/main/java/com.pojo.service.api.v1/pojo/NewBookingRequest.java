package com.pojo.service.api.v1.pojo;

/**
 * Created by virmanv on 26/09/2016 October.
 */
public class NewBookingRequest {

    private  int priestId;
    private float lastSeenLatitude;
    private float lastSeenLongitude;

    public int getPriestId() {
        return priestId;
    }

    public void setPriestId(int priestId) {
        this.priestId = priestId;
    }

    public float getLastSeenLatitude() {
        return lastSeenLatitude;
    }

    public void setLastSeenLatitude(float lastSeenLatitude) {
        this.lastSeenLatitude = lastSeenLatitude;
    }

    public float getLastSeenLongitude() {
        return lastSeenLongitude;
    }

    public void setLastSeenLongitude(float lastSeenLongitude) {
        this.lastSeenLongitude = lastSeenLongitude;
    }
}
