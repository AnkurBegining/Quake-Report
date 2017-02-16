package com.example.android.quakereport;

/**
 * Created by Lenovo on 15-02-2017.
 */

public class Words {

    private String magnitude;
    private String Location;
    private long time;

    public Words(String magnitude, String Location, long time){
        this.magnitude=magnitude;
        this.Location=Location;
        this.time=time;

    }

    public String getMagnitude(){
        return magnitude;
    }

    public long getTime(){
        return  time;
    }

    public String getLocation() {
        return Location;
    }
}
