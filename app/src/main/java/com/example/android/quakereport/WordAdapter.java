package com.example.android.quakereport;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

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

        TextView timeView = (TextView)listView.findViewById(R.id.time_text_view);
        timeView.setText(currentWord.getTime());

        return  listView;


    }
}
