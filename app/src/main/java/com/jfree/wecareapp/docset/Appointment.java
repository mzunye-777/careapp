package com.jfree.wecareapp.docset;

public class Appointment {
    private String date;
    private String time;
    private String patientName;
    private String disease;
    private String tests;

    public Appointment(String date, String time, String patientName, String disease, String tests) {
        this.date = date;
        this.time = time;
        this.patientName = patientName;
        this.disease = disease;
        this.tests = tests;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getDisease() {
        return disease;
    }

    public String getTests() {
        return tests;
    }
}