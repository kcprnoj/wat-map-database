package com.watmap.server.entity.exception;

import java.text.MessageFormat;

public class FacultyNotFoundException extends RuntimeException{
    public FacultyNotFoundException(Integer id) {
        super(MessageFormat.format(" Could not find faculty with id {0}", id));
    }
}