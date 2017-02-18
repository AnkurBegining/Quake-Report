package com.example.android.quakereport;

import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * Created by Lenovo on 15-02-2017.
 */

public class QueryUtils  {


    private QueryUtils(){

    }

    public static ArrayList<Words> extractEarthQuake(String urls){

        URL url =createUrl(urls);
        String jsonResponse="";
        try {
            jsonResponse = makeHttpconnection(url);

        }catch (Exception e){

        }

        ArrayList<Words> earthQuakeData = new ArrayList<Words>();
        try {

            JSONObject root=new JSONObject(jsonResponse);
            JSONArray jsonArray=root.getJSONArray("features");
            for(int i=0;i<jsonArray.length();i++){
                JSONObject currentEarthQuake= (JSONObject) jsonArray.get(i);
                JSONObject properties=currentEarthQuake.getJSONObject("properties");

                String mag=properties.getString("mag");
                String place=properties.getString("place");
                long time=properties.getLong("time");
                earthQuakeData.add(new Words(mag,place,time));
            }

        }catch (Exception e){


        }
        return  earthQuakeData;

    }

    private static String makeHttpconnection(URL url) throws IOException {
        String jsonResponse="";
        HttpURLConnection urlConnection=(HttpURLConnection) url.openConnection();
        try{
            InputStream inputStream = new BufferedInputStream(urlConnection.getInputStream());
            jsonResponse=readFromStream(inputStream);

            return jsonResponse;


        }catch (Exception e){

        }
        return null;
    }

    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output =new StringBuilder();
        if(inputStream != null){
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
        BufferedReader reader=new BufferedReader(inputStreamReader);
        String line =reader.readLine();
            while(line!=null){
                output.append(line);
                line = reader.readLine();
            }
        }

        return output.toString();

    }


    private static URL createUrl(String urls) {
        URL url=null;
        try {
            url=new URL(urls);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }

}
