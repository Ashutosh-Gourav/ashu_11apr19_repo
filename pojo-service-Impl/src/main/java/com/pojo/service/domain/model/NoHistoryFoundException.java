package com.pojo.service.domain.model;

/**
 * Created by virmanv on 26/09/2016 October.
 */
public class NoHistoryFoundException extends RuntimeException {

    public NoHistoryFoundException() {
        super();
    }

    public NoHistoryFoundException(String message) {
        super(message);
    }
}
