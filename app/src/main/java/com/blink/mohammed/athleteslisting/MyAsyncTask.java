package com.blink.mohammed.athleteslisting;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by mohammed on 20/08/17.
 * Create HTTP connection to use JSON data into URL
 * getting parameters send through execute method
 * adding data to Atheletes List
 * and show it into Listview
 * and send Data to MainActivity
 */


public class MyAsyncTask extends AsyncTask<String, String, String> {
    Context context;
    ArrayList<Athletes> athletesList;
    AsyncResponse response ;



    public MyAsyncTask(Context context,AsyncResponse response) {
        this.context=context;
        athletesList = new ArrayList<>();
        this.response=response;
    }

    @Override
    protected void onPreExecute() {

    }

    @Override
    protected String  doInBackground(String... params) {

        try {
            String weather;

            URL url = new URL(params[0]);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setConnectTimeout(5000);

            try {
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());

                weather = StreamFormat.convert2String(in);

                publishProgress(weather);
            } catch (Exception e) {
                Toast.makeText(context,e.getMessage(),Toast.LENGTH_LONG).show();
            } finally {
                urlConnection.disconnect();
            }

        }catch (Exception ex) {
            Toast.makeText(context,ex.getMessage(),Toast.LENGTH_LONG).show();
        }
        return null;
    }



    protected void onProgressUpdate(String... progress) {

        try {
            JSONObject query= new JSONObject(progress[0]);
            JSONArray athletes=query.getJSONArray("athletes");

            for (int index=0;index<athletes.length();index++) {
                JSONObject data = athletes.getJSONObject(index);
                String name = data.getString("name");
                String image = data.getString("image");
                String desc = data.getString("brief");

                athletesList.add(new Athletes(name,image,desc));

            }

            response.processFinish(athletesList);


        } catch (Exception ex) {
            Toast.makeText(context,ex.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}
