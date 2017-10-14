package com.example.jl.lilprinter.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jav on 10/13/2017.
 */

public class Printer implements Parcelable {
    private int id;
    private String location;
    private String type;

    private boolean status;
    private boolean computerStatus;

    //private boolean paperStatus;
    //private boolean jamStatus;
    //private boolean inkStatus;

    private double lat;
    private double lng;

    public Printer() {
        this(-1, "unknown", "unknown", true, 0, 0);
    }

    public Printer(int id, String location, String type, boolean status, double lat, double lng) {
        this.id = id;
        this.location = location;
        this.type = type;
        this.status = status;
        //this.paperStatus = paperStatus;
        //this.jamStatus = jamStatus;
        //this.inkStatus = inkStatus;
        this.lat = lat;
        this.lng = lng;
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

    /*public String getColorType() {
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
    }*/

    public double getLat() {
        return this.lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return this.lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(location);
        dest.writeString(type);
        dest.writeBooleanArray(new boolean[] {status});
        dest.writeDouble(lat);
        dest.writeDouble(lng);
    }

    public static final Parcelable.Creator<Printer> CREATOR = new Parcelable.Creator<Printer>() {
        public Printer createFromParcel(Parcel in) {
            return new Printer(in);
        }

        public Printer[] newArray(int size) {
            return new Printer[size];
        }
    };

    private Printer(Parcel in) {
        id = in.readInt();
        location = in.readString();
        type = in.readString();
        boolean[] boolArr = new boolean[1];
        in.readBooleanArray(boolArr);
        status = boolArr[0];
        lat = in.readDouble();
        lng = in.readDouble();
    }
}
