package com.ahd.api.exception;

import org.springframework.http.HttpStatus;

public class BadRequest extends ApiBaseException{

    public BadRequest(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.BAD_REQUEST;
    }
}
