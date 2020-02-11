package com.pojo.service.domain.model;

/**
 * Created by virmanv on 26/09/2016 October.
 */
public class SmsSendingException extends RuntimeException {
    public SmsSendingException() {
        super();
    }

    public SmsSendingException(String message) {
        super(message);
    }

    public SmsSendingException(String message, Throwable cause) {
        super(message, cause);
    }
}
