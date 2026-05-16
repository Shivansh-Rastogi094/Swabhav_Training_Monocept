package com.project.app.exception;

public class DuplicateRegistrationException extends Exception {

    public DuplicateRegistrationException(int studentId, String courseName) {
        super("Student ID " + studentId + " is already registered for course '" + courseName + "'.");
    }

    public DuplicateRegistrationException(String message) {
        super(message);
    }
}
