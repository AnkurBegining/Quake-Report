package com.example.android.quakereport;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Lenovo on 15-02-2017.
 */


public class WordAdapter extends ArrayAdapter {
    private static final String LOCATION_SEPARATOR = "of";
    public WordAdapter(Activity context, ArrayList<Words> arrayFlavor) {
        super(context,0, arrayFlavor);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listView =convertView;
        if(listView ==null){
            listView = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake_list_item, parent, false);

        }
        Words currentWord= (Words) getItem(position);

        TextView magitudeView =(TextView)listView.findViewById(R.id.magnitude_text_view);
        magitudeView.setText(currentWord.getMagnitude());

        Date dateObject = new Date(currentWord.getTime());
        String formattedDate = formatDate(dateObject);

        TextView dateView = (TextView)listView.findViewById(R.id.date_text_view);
        dateView.setText(formattedDate);

        String formattedTime = formatTime(dateObject);
        TextView timeView = (TextView)listView.findViewById(R.id.time_text_view);
        timeView.setText(formattedTime);

        //Get the original location String from earthquake object and store that in variable

        String originalLocation = currentWord.getLocation();
        String primaryLocation;
        String locationOffset;

        if(originalLocation.contains(LOCATION_SEPARATOR)){
            String[] parts = originalLocation.split(LOCATION_SEPARATOR);//Spilt before and after 'of'
            locationOffset = parts[0] + LOCATION_SEPARATOR; //add 'of' after the spiliting;
            primaryLocation = parts[1];
        }
        else{
            locationOffset = getContext().getString(R.string.near_the); //set the default location offset to say "Near_the'
            primaryLocation = originalLocation;
        }

        TextView primaryLocationView = (TextView)listView.findViewById(R.id.primaryLocation_text_view);
        primaryLocationView.setText(primaryLocation);

        TextView locationOffsetView = (TextView)listView.findViewById(R.id.locationOffset_text_view);
        locationOffsetView.setText(locationOffset);


        return  listView;


    }

    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }
}
