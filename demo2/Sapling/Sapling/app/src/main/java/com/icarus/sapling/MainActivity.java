package com.icarus.sapling;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import org.json.JSONException;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    public ArrayList<Plant> library;
    public ArrayList<Plant> gardenPlants;
    public ArrayList<Plant> recommendedPlants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            library = JSONReader.parseLibrary("plantdata.json");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
<<<<<<< HEAD
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_recommendations)
=======
                R.id.navigation_home, R.id.navigation_library, R.id.navigation_notifications)
>>>>>>> a856afa7567453db63bd9f045cbdaad1832f8d85
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }
}
