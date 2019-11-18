package com.icarus.sapling.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.icarus.sapling.Plant;
import com.icarus.sapling.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PlantCareFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PlantCareFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlantCareFragment extends Fragment {

    private static TextView name_header;
    private static TextView type_header;
    private static TextView water_frequency_header;
    private static TextView sun_requirement_header;
    private static TextView water_q_text;
    private static TextView sun_requirement_text;
    private static TextView maturation_text;
    private static TextView maturation_header;
    private static TextView vulnerabilities_header;
    private static TextView vulnerabilities_text;
    private Plant mPlant;

    public PlantCareFragment(Plant plant) {
        mPlant = plant;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.plant_care, container, false);

        name_header = root.findViewById(R.id.name_header);
        type_header = root.findViewById(R.id.type_header);
        water_frequency_header = root.findViewById(R.id.water_frequency_header);
        sun_requirement_header = root.findViewById(R.id.sun_requirement_header);
        water_q_text = root.findViewById(R.id.water_q_text);
        sun_requirement_text = root.findViewById(R.id.sun_requirement_text);
        maturation_text = root.findViewById(R.id.maturation_text);
        maturation_header = root.findViewById(R.id.maturation_header);
        vulnerabilities_header = root.findViewById(R.id.vulnerabilities_header);
        vulnerabilities_text = root.findViewById(R.id.vulnerabilities_text);

        name_header.setText(mPlant.getName());
        type_header.setText(mPlant.getType());
        water_frequency_header.setText("Waterings per week");
        sun_requirement_header.setText("Sunlight Needed");
        water_q_text.setText(Double.toString(mPlant.getWaterQ()));
        sun_requirement_text.setText(mPlant.getSun());
        maturation_text.setText("" + mPlant.getMaturation() + " weeks");
        maturation_header.setText("Maturation");
        vulnerabilities_header.setText("Vulnerabilities");
        vulnerabilities_text.setText(mPlant.getVulnerabilities());

        return null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
