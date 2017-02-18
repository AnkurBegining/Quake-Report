package com.example.android.quakereport;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String URL_DOMAIN =
            "http://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=2016-01-01&endtime=2016-01-31&minmag=6&limit=10";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EarthQuakeAsynTask task =new EarthQuakeAsynTask();
        task.execute(URL_DOMAIN);





    }

    private class EarthQuakeAsynTask extends AsyncTask<String, Void, ArrayList>{

        @Override
        protected ArrayList doInBackground(String... urls) {
            for(int i=0;i<urls.length;i++) {
                ArrayList<Words> words = QueryUtils.extractEarthQuake(urls[i]);
                return words;
            }
            return null;
        }

        @Override
        protected void onPostExecute(ArrayList words) {
            WordAdapter adapter = new WordAdapter(MainActivity.this,words);
            ListView listview=(ListView)findViewById(R.id.list);
            listview.setAdapter(adapter);

        }
    }
}
