// Authored by: Alex Gonzales
// 11/10/2019

package com.icarus.sapling;

 
import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
 
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

public class JSONReader
{
    private static Context mContext;
    private static String plantdata;
    private static int count;
    @SuppressWarnings("unchecked")
    public static ArrayList<Plant> parseLibrary(Context context) {
        ArrayList<Plant> PlantArr = new ArrayList<Plant>();
        mContext = context;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(mContext.getAssets().open("plantdata.json")));

            // do reading, usually loop until end of file reading
            plantdata = "";
            String mLine = "";
            while ((mLine = reader.readLine()) != null) {
                plantdata += mLine;
            }
        } catch (FileNotFoundException e) {
            Log.i("404", "plantdata.json not found");
            e.printStackTrace();
        } catch (IOException e) {
            Log.e("IOException", "IOException in parseLibrary");
            e.printStackTrace();
        }
        try {
            JSONArray JSarr = new JSONArray(plantdata);
            count = 0;
            for(int i = 0; i < JSarr.length(); i++) {
                PlantArr.add(i, JSONtoPlant((JSONObject) JSarr.get(i)));
                Log.i("Plant Name", PlantArr.get(i).getName());
            }
        } catch(JSONException e) {
            Log.e("JSONException", "Failed to make JSONArray from plantdata");
        }
        return PlantArr;
    }

    private static Plant JSONtoPlant(JSONObject obj) {
        Log.e("JSONtoPlant", "JSONObject converting to Plant");
        Plant plnt = new Plant();
        try {
            plnt.setName(obj.getString("PLANT_NAME"));
            plnt.setType(obj.getString("PLANT_TYPE"));
            plnt.setWaterF(obj.getDouble("WATERF"));
            plnt.setWaterQ(obj.getDouble("WATERQ"));
            plnt.setMaturation(obj.getInt("MATURATION"));
            plnt.setSoilWetness(obj.getString("SOIL_WETNESS"));
            plnt.setSpace(obj.getDouble("SPACE"));
            plnt.setSun(obj.getString("SUN"));
            plnt.setVulnerabilities(obj.getString("VULNERABILITIES"));
            plnt.setYield(obj.getDouble("YIELD"));
            plnt.removeFromGarden();
            if(count % 2 == 0) plnt.putInGarden();
            count++;
        } catch (JSONException e) {
            Log.e("JSONtoPlant", e.toString());
        }

        return plnt;
    }
}