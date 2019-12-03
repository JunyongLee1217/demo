package com.icarus.sapling.ui.myGarden;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;

import com.icarus.sapling.MainActivity;
import com.icarus.sapling.Plant;
import com.icarus.sapling.R;

import java.util.ArrayList;
import java.util.Date;

public class MyGardenFragment extends Fragment
{
    public static final String CHANNEL_1_ID = "channel1";
    private MyGardenViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        MainActivity.gardenPlants = new ArrayList<Plant>();
        int j = 0;
        for(int i = 0; i < MainActivity.library.size(); i++) {
            try {
                if (MainActivity.library.get(i).isInGarden()) {
                    MainActivity.gardenPlants.add(j, MainActivity.library.get(i));
                    Log.i("Added Plant", MainActivity.gardenPlants.get(j).getName());
                    j++;
                }
            } catch (NullPointerException e) {
                Log.e("Failed Plant", "");
            }
        }
        createNotificationChannels();
        View root = MainActivity.loadList(this.getActivity(), MainActivity.gardenPlants, 1, inflater, container, savedInstanceState);
        /*
        View root = inflater.inflate(R.layout.fragment_mygarden, container, false);
        TextView dateView = (TextView) root.findViewById(R.id.dateTextView);
        setDate(dateView);

        TextView plantText = (TextView) root.findViewById(R.id.plantOneTextView);
        setText(plantText, "This is where I get the name of the plant from the database");
        */
        return root;
    }

    public void setDate (TextView view)
    {
        String str = String.format("%tc", new Date());
        view.setText(str);
    }

    public void setText (TextView view, String str)
    {
        view.setText(str);
    }

    public void createNotificationChannels()
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            // Channel 1 stuff
            NotificationChannel channel1 = new NotificationChannel(CHANNEL_1_ID, "Channel 1", NotificationManager.IMPORTANCE_HIGH);
            channel1.setDescription("This is channel 1");


            NotificationManager manager = (NotificationManager) getContext().getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);
        }
    }


}