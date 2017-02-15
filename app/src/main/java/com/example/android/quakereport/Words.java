package com.example.android.quakereport;

/**
 * Created by Lenovo on 15-02-2017.
 */

public class Words {

    private String magnitude;
    private String place;
    private long time;

    public Words(String magnitude, String place, long time){
        this.magnitude=magnitude;
        this.place=place;
        this.time=time;

    }

    public String getMagnitude(){
        return magnitude;
    }
    public String getPlace(){
        return  place;
    }
    public long getTime(){
        return  time;
    }

}
