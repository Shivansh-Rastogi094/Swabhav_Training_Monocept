package com.project.app.exception;

public class DuplicateStudentException extends Exception {

    public DuplicateStudentException(int studentId) {
        super("Student with ID " + studentId + " already exists. Duplicate IDs are not allowed.");
    }

    public DuplicateStudentException(String message) {
        super(message);
    }
}
