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

        TextView placeView = (TextView)listView.findViewById(R.id.place_text_view);
        placeView.setText(currentWord.getPlace());

        Date dateObject = new Date(currentWord.getTime());
        String formattedDate = formatDate(dateObject);
        String formattedTime = formatTime(dateObject);

        TextView dateView = (TextView)listView.findViewById(R.id.date_text_view);
        dateView.setText(formattedDate);

        TextView timeView = (TextView)listView.findViewById(R.id.time_text_view);
        timeView.setText(formattedTime);

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
