package com.example.jl.lilprinter.model;

/**
 * Created by jav on 10/13/2017.
 */

public class Printer {
    private int id;
    private String location;
    private String colorType;
    private boolean paperStatus;
    private boolean jamStatus;
    private boolean inkStatus;

    public Printer() {}

    public Printer(int id, String location, String colorType, boolean paperStatus, boolean jamStatus, boolean inkStatus) {
        this.id = id;
        this.location = location;
        this.colorType = colorType;
        this.paperStatus = paperStatus;
        this.jamStatus = jamStatus;
        this.inkStatus = inkStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getColorType() {
        return colorType;
    }

    public void setColorType(String colorType) {
        this.colorType = colorType;
    }

    public boolean getPaperStatus() {
        return paperStatus;
    }

    public void setPaperStatus(boolean paperStatus) {
        this.paperStatus = paperStatus;
    }

    public boolean getJamStatus() {
        return jamStatus;
    }

    public void setJamStatus(boolean jamStatus) {
        this.jamStatus = jamStatus;
    }

    public boolean getInkStatus() {
        return inkStatus;
    }

    public void setInkStatus(boolean inkStatus) {
        this.inkStatus = inkStatus;
    }
}
