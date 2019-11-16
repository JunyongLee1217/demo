package com.icarus.sapling.ui.plantLibrary;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.icarus.sapling.R;

import java.util.ArrayList;

public class PlantLibraryFragment extends Fragment
{
    private PlantLibraryViewModel libraryViewModel;
    //public static TextView data;
    public static ListView plantlist;
    public static ArrayList<String> plantarray = new ArrayList<String>();
    Button click;
    public static ArrayAdapter<String> listViewAdapter;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        libraryViewModel = ViewModelProviders.of(this).get(PlantLibraryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_library, container, false);

        //data = (TextView) root.findViewById(R.id.fetcheddata);


        // find by id plantlist view
        plantlist = (ListView) root.findViewById(R.id.plantList);

        // Adapter part

        //ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,plantarray);
        listViewAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,plantarray);
        // Set adapter for plantlist
        plantlist.setAdapter(listViewAdapter);

        // Click find by id
        click = (Button) root.findViewById(R.id.button);

        // Button click Listener
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fetchData process = new fetchData();
                process.execute();

            }

        });

        return root;
    }
}