package com.project.app.exception;

public class StudentNotFoundException extends Exception {

    public StudentNotFoundException(int studentId) {
        super("Student with ID " + studentId + " does not exist in the system.");
    }

    public StudentNotFoundException(String message) {
        super(message);
    }
}
