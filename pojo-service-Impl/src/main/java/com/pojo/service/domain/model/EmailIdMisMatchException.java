package com.pojo.service.domain.model;

/**
 * Created by virmanv on 26/09/2016 October.
 */
public class EmailIdMisMatchException extends RuntimeException {

    public EmailIdMisMatchException() {
        super();
    }

    public EmailIdMisMatchException(String message) {
        super(message);
    }

    public EmailIdMisMatchException(String message, Throwable cause) {
        super(message, cause);
    }
}
