package com.project.app.exception;

/**
 * Wraps unexpected SQL/database failures so the UI layer
 * never needs to import java.sql directly for error handling.
 */
public class DatabaseException extends Exception {

    public DatabaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public DatabaseException(String message) {
        super(message);
    }
}
