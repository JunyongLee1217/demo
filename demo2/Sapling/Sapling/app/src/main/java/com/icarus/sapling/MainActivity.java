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
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    public static ArrayList<Plant> library;
    public static ArrayList<Plant> gardenPlants;
    public static ArrayList<Plant> recommendedPlants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        library = new ArrayList<Plant>();
        library = JSONReader.parseLibrary(MainActivity.this);
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
// Int destination: 1 for myGarden (scheduler xml), 2 for Library and Recommendation (Plant care xml)

    public static View loadList(Context context, ArrayList<Plant> mList, int destination, LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
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
        /*
        * Implement an onClickListener here, and through that listener and using 'findPlant(___)'
        * Specify the plant whose properties (as specified in Plant.java) will be communicated to the PlantCareFragment and Scheduler Fragment
         */

        // Plant thisplant = whatever's clicked
        plantlist.setAdapter(listViewAdapter);
        return root;
    }

    public static Plant findPlant(String name) {
        for(int i = 0; i < MainActivity.library.size(); i++) {
            if(MainActivity.library.get(i).getName().contentEquals(name)) return MainActivity.library.get(i);
        }
        return null;
    }
}
