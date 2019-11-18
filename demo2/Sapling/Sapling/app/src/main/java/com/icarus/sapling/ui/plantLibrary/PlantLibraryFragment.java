package com.icarus.sapling.ui.plantLibrary;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
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

import com.icarus.sapling.MainActivity;
import com.icarus.sapling.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class PlantLibraryFragment extends Fragment
{

    private PlantLibraryViewModel libraryViewModel;
    //public static TextView data;
    public static ListView plantlist;
    public static ArrayList<String> plantNameArray = new ArrayList<String>();
    public static ArrayList<String> plantTypeArray = new ArrayList<String>();
    public static ArrayAdapter<String> listViewAdapter;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        try {
            for (int i = 0; i < MainActivity.library.size(); i++) {
                plantNameArray.add(i, MainActivity.library.get(i).getName());
                plantNameArray.set(i, plantNameArray.get(i) + ": "+ MainActivity.library.get(i).getType());
                //plantTypeArray.add(i, MainActivity.library.get(i).getType());
            }
        } catch (NullPointerException e) {
            Log.e("NullPointerE", e.toString());
            e.printStackTrace();
        } catch (IndexOutOfBoundsException e) {
            Log.e("IndexOutOfBounds", e.toString());
            e.printStackTrace();
        }

        libraryViewModel = ViewModelProviders.of(this).get(PlantLibraryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_library, container, false);


        // find by id plantlist view
        plantlist = (ListView) root.findViewById(R.id.plantList);

        //ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,plantarray);
        listViewAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,plantNameArray);
        // Set adapter for plantlist
        plantlist.setAdapter(listViewAdapter);


        return root;
    }
}