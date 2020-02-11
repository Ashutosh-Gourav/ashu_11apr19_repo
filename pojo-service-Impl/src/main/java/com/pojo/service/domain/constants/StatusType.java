package com.pojo.service.domain.constants;

/**
 * Created by virmanv on 26/09/2016 October.
 */
public enum StatusType {
    INACTIVE("inactive"), ACTIVE("active"), BLOCKED("blocked"),CANCELLED("cancelled"),EXPIRED("expired"),ACCEPTED("accepted");
    private String statusType;

    StatusType(String statusType) {
        this.statusType = statusType;
    }

    public static StatusType get(String statusType) {
        StatusType[] allStatusTypes = StatusType.values();

        for (StatusType status : allStatusTypes) {
            if (status.statusType.equalsIgnoreCase(statusType)) {
                return status;
            }
        }
        throw new IllegalArgumentException("No status found for input string :" + statusType);
    }

    public String get() {
        return statusType;
    }

}
