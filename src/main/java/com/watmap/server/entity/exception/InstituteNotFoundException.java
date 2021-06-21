package com.watmap.server.entity.exception;

import java.text.MessageFormat;

public class InstituteNotFoundException extends RuntimeException{
    public InstituteNotFoundException(Integer id) {
        super(MessageFormat.format(" Could not find institute with id {0}", id));
    }
}
