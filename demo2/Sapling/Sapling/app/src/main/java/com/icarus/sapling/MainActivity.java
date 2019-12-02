package com.icarus.sapling;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    public static ArrayList<Plant> library;
    public static ArrayList<Plant> gardenPlants;
    public static ArrayList<Plant> recommendedPlants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            library = JSONReader.parseLibrary(MainActivity.this);
        } catch (JSONException e) {
            Log.e("jsonexception", e.toString());
        }
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_library, R.id.navigation_recommendations)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }
    public static View loadList(Context context, ArrayList<Plant> mList, LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ArrayList<String> plantNameArray = new ArrayList<String>();
        ArrayList<String> plantTypeArray = new ArrayList<String>();
        ArrayAdapter<String> listViewAdapter;
        ListView plantlist;
        try {
            for (int i = 0; i < mList.size(); i++) {
                plantNameArray.add(i, mList.get(i).getName());
                plantNameArray.set(i, plantNameArray.get(i) + ": "+ mList.get(i).getType());
            }
        } catch (NullPointerException e) {
            Log.e("NullPointerE", e.toString());
            e.printStackTrace();
        } catch (IndexOutOfBoundsException e) {
            Log.e("IndexOutOfBounds", e.toString());
            e.printStackTrace();
        }

        View root = inflater.inflate(R.layout.fragment_library, container, false);

        // find by id plantlist view
        plantlist = (ListView) root.findViewById(R.id.plantList);

        listViewAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1,plantNameArray);
        // Set adapter for plantlist
        plantlist.setAdapter(listViewAdapter);
        return root;
    }
}
