// Authored by: Alex Gonzales
// 11/10/2019

package com.icarus.sapling;

 
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
 
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

public class JSONReader
{
    @SuppressWarnings("unchecked")
    public ArrayList<Plant> parseLibrary(String plantdata) throws JSONException {
        ArrayList<Plant> PlantArr = new ArrayList<Plant>();

        JSONArray JSarr = new JSONArray(plantdata);
        for(int i = 0; i < JSarr.length(); i++) {
            PlantArr.add(i, JSONtoPlant((JSONObject)JSarr.get(i)));
        }
        return PlantArr;
    }

    private Plant JSONtoPlant(JSONObject obj) throws JSONException{
        Plant plnt = new Plant();
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
        return plnt;
    }
}