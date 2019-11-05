package com.icarus.sapling.ui.myGarden;

import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.icarus.sapling.R;

import java.util.Date;

public class MyGardenFragment extends Fragment
{

    private MyGardenViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        TextView dateView = (TextView) root.findViewById(R.id.dateTextView);
        setDate(dateView);

        TextView plantText = (TextView) root.findViewById(R.id.plantOneTextView);
        setText(plantText, "This is where I get the name of the plant from the database");

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
}