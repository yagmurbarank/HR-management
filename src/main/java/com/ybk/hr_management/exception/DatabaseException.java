package com.ybk.hr_management.exception;

import lombok.extern.slf4j.Slf4j;

import java.io.Serial;

import static com.ybk.hr_management.exception.util.ExceptionConstants.DATABASE_ERROR;

@Slf4j
public class DatabaseException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -4092737528643939521L;

    public DatabaseException(final Exception exception) {
        super(DATABASE_ERROR, exception);
        log.error(exception.getMessage());
    }}