package com.project.app.exception;

public class RegistrationNotFoundException extends Exception {

    public RegistrationNotFoundException(int studentId, String courseName) {
        super("No registration found for Student ID " + studentId + " in course '" + courseName + "'.");
    }

    public RegistrationNotFoundException(String message) {
        super(message);
    }
}
