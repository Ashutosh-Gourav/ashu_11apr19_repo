package com.pojo.service.domain.model;

/**
 * Created by virmanv on 26/09/2016 October.
 */
public class BookingAlreadyExistException extends RuntimeException {
    public BookingAlreadyExistException() {
        super();
    }

    public BookingAlreadyExistException(String message) {
        super(message);
    }

    public BookingAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

}
