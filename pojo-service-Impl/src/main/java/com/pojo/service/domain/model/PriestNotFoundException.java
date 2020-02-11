package com.pojo.service.domain.model;

/**
 * Created by virmanv on 26/09/2016 October.
 */
public class PriestNotFoundException extends  RuntimeException {
    public PriestNotFoundException() {
        super();
    }

    public PriestNotFoundException(String message) {
        super(message);
    }
}
