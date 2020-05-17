package com.kusak.dariusz.simplejwtauthorizationproject.exception;

import javax.naming.AuthenticationException;

public class InvalidJwtAuthenticationException extends AuthenticationException {

    private static final long serialVersionUID = 3L;

    public InvalidJwtAuthenticationException(String explanation) {
        super(explanation);
    }
}
