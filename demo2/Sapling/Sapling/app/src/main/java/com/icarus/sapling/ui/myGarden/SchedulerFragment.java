package com.icarus.sapling.ui.myGarden;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;

import com.icarus.sapling.Plant;
import com.icarus.sapling.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SchedulerFragment extends Fragment
{
    private TextView plantName;
    private CalendarView calendar;
    private TextView date;
    private Plant mPlant;

    public SchedulerFragment(Plant plant)
    {
        mPlant = plant;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View root = inflater.inflate(R.layout.fragment_scheduler, container, false);

        plantName = (TextView) root.findViewById(R.id.scheduler_plantName);
        calendar = (CalendarView) root.findViewById(R.id.scheduler_calendarView);
        date = (TextView) root.findViewById(R.id.scheduler_date);


        plantName.setText(mPlant.getName());
        calendar.setDate(calendar.getDate() + (long) (1/(mPlant.getWaterF())*7*86400000));

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        String selectedDate = sdf.format(new Date(calendar.getDate()));
        date.setText(selectedDate);

        return root;
    }
}
