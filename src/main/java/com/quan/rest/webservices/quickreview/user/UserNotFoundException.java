package com.quan.rest.webservices.quickreview.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException{
    /**
     *
     */
    private static final long serialVersionUID = 360082401847319097L;

    public UserNotFoundException(String message) {
        super(message);
    }
}
