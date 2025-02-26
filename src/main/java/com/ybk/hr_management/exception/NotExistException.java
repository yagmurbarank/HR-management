package com.ybk.hr_management.exception;

import java.io.Serial;

public class NotExistException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -436261361729769744L;

    public NotExistException(final String message) {
        super(message);
    }
}
