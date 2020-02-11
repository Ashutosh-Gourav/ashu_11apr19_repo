package com.pojo.service.domain.model;

/**
 * Created by virmanv on 26/09/2016 October.
 */
public class PojoException extends RuntimeException {
    public PojoException() {
        super();
    }

    public PojoException(String message) {
        super(message);
    }

    public PojoException(String message, Throwable cause) {
        super(message, cause);
    }
}
