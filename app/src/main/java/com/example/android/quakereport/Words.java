package com.example.android.quakereport;

/**
 * Created by Lenovo on 15-02-2017.
 */

public class Words {

    private String magnitude;
    private String place;
    private String time;

    public Words(String magnitude, String place, String time){
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
    public  String getTime(){
        return  time;
    }
}
