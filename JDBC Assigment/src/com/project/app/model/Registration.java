package com.project.app.model;

public class Registration {

    private int    regId;
    private int    studentId;
    private String courseName;
    private double feesPaid;

    public Registration() {}

    public Registration(int regId, int studentId, String courseName, double feesPaid) {
        this.regId      = regId;
        this.studentId  = studentId;
        this.courseName = courseName;
        this.feesPaid   = feesPaid;
    }

    public int    getRegId()      { return regId; }
    public int    getStudentId()  { return studentId; }
    public String getCourseName() { return courseName; }
    public double getFeesPaid()   { return feesPaid; }

    public void setRegId(int regId)           { this.regId = regId; }
    public void setStudentId(int studentId)   { this.studentId = studentId; }
    public void setCourseName(String c)       { this.courseName = c; }
    public void setFeesPaid(double feesPaid)  { this.feesPaid = feesPaid; }

    @Override
    public String toString() {
        return String.format("Registration [RegID=%-4d | Course=%-25s | Fees Paid=%.2f]",
                regId, courseName, feesPaid);
    }
}
