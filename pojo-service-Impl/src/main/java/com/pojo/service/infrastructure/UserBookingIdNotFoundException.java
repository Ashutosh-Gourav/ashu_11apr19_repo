package com.pojo.service.infrastructure;

/**
 * Created by virmanv on 26/09/2016 October.
 */
public class UserBookingIdNotFoundException extends RuntimeException {

    public UserBookingIdNotFoundException() {
        super();
    }

    public UserBookingIdNotFoundException(String message) {
        super(message);
    }
}
