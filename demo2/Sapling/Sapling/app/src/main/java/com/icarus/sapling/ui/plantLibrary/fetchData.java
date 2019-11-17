package com.icarus.sapling.ui.plantLibrary;

import android.os.AsyncTask;
import android.widget.ArrayAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class fetchData extends AsyncTask<Void, Void, Void> {

    String data = "";
    String dataParsed = "";
    String singleParsed = "";

    @Override
    protected Void doInBackground(Void... voids) {

        try {
            URL url = new URL("https://api.myjson.com/bins/oggv2");
            HttpURLConnection httpsURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpsURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while(line != null){
                line = bufferedReader.readLine();
                data = data + line;
            }

            // Parsing json and put it into the Arraylist
            JSONArray JA = new JSONArray(data);
            for(int i = 0; i < JA.length(); i++){
                JSONObject JO = (JSONObject) JA.get(i);
                singleParsed = "PlantName:" + JO.get("PLANT_NAME") + "\n"+
                               "PlantType:" + JO.get("PLANT_TYPE") + "\n";

                PlantLibraryFragment.plantarray.add(singleParsed);
                //dataParsed = dataParsed + singleParsed + "\n";
            }

        } catch(MalformedURLException e){
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        } catch(JSONException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        PlantLibraryFragment.listViewAdapter.notifyDataSetChanged();
        //PlantLibraryFragment.data.setText(this.dataParsed);
        //PlantLibraryFragment.plantlist.setText(this.dataParsed);

    }
}
