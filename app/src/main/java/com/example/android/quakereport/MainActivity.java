package com.example.android.quakereport;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Words> words= new ArrayList<Words>();

        words.add(new Words("2.1","Delhi","11111"));
        words.add(new Words("2.1","Delhi","11111"));
        words.add(new Words("2.1","Delhi","11111"));
        words.add(new Words("2.1","Delhi","11111"));
        words.add(new Words("2.1","Delhi","11111"));
        words.add(new Words("2.1","Delhi","11111"));
        words.add(new Words("2.1","Delhi","11111"));
        words.add(new Words("2.1","Delhi","11111"));
        words.add(new Words("2.1","Delhi","11111"));
        words.add(new Words("2.1","Delhi","11111"));
        words.add(new Words("2.1","Delhi","11111"));

        WordAdapter adapter =new WordAdapter(this,words);
        ListView listView=(ListView)findViewById(R.id.list);
        listView.setAdapter(adapter );



    }
}
