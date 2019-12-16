package com.icarus.sapling.ui.recommendation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.icarus.sapling.MainActivity;
import com.icarus.sapling.Plant;
import com.icarus.sapling.R;

import java.util.ArrayList;

import static android.R.layout.simple_list_item_1;

public class SubActivity extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Bundle bundle = getIntent().getExtras();
        ArrayList<String> arrayList = bundle.getStringArrayList("PLANTARR");
        ListView listview = findViewById(R.id.listview);
        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<>(this, simple_list_item_1, arrayList);
        listview.setAdapter(adapter);

        //View root = MainActivity.loadList(getApplicationContext(), RecommendationFragment.recommendedPlants, 2, inflater, container, savedInstanceState);
        //return root;
    }
}
