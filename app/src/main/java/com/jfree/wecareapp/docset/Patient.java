package com.jfree.wecareapp.docset;

public class Patient {


    private String name;
    private String description;
    private int imageResId;
    private String zoomLink;
    private boolean onMedication;
    private boolean cured;

    public Patient(String name, String description, int imageResId, String zoomLink) {
        this.name = name;
        this.description = description;
        this.imageResId = imageResId;
        this.zoomLink = zoomLink;
        this.onMedication = onMedication;
        this.cured = cured;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getZoomLink() {
        return zoomLink;
    }

    public boolean isOnMedication() {
        return onMedication;
    }

    public boolean isCured() {
        return cured;
    }
}
