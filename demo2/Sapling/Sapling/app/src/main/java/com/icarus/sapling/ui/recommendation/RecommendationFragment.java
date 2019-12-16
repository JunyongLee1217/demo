package com.icarus.sapling.ui.recommendation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.icarus.sapling.MainActivity;
import com.icarus.sapling.Plant;
import com.icarus.sapling.R;

import java.util.ArrayList;

public class RecommendationFragment extends Fragment {

    private RecommendationViewModel recommendationViewModel;
    ArrayList<Plant> recommendedPlants;
    ArrayList<Plant> recommendedPlants2;
    RadioGroup radioGroup1, radioGroup2, radioGroup3;
    Button button;
    RadioButton radioButton1, radioButton2, radioButton3;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        //recommendationViewModel = ViewModelProviders.of(this).get(RecommendationViewModel.class);



        View root = inflater.inflate(R.layout.fragment_recommendation, container, false);
        //View root = MainActivity.loadList(this.getActivity(), MainActivity.gardenPlants, 1, inflater, container, savedInstanceState);

        button = (Button) root.findViewById(R.id.button);
        radioGroup1 = root.findViewById(R.id.radiogr1);
        radioGroup2 = root.findViewById(R.id.radiogr2);
        radioGroup3 = root.findViewById(R.id.radiogr3);


        // Onclick = search the correspoding radio data from the arraylist
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                // get radio group ids
//                int radioid1 = radioGroup1.getCheckedRadioButtonId();
//                int radioid2 = radioGroup2.getCheckedRadioButtonId();
//                int radioid3 = radioGroup3.getCheckedRadioButtonId();
                // define radioButtons
                radioButton1 = getActivity().findViewById(radioGroup1.getCheckedRadioButtonId());
                radioButton2 = getActivity().findViewById(radioGroup2.getCheckedRadioButtonId());
                radioButton3 = getActivity().findViewById(radioGroup3.getCheckedRadioButtonId());

                String str1 = radioButton1.getText().toString(); //tree
                String str2 = radioButton2.getText().toString(); //>3
                String str3 = radioButton3.getText().toString(); //>14
                //Toast.makeText(getActivity(), "Selected Radio Button is:" + str1+str2+str3 , Toast.LENGTH_LONG).show();



                recommendedPlants = new ArrayList<>();

                // Plant Type
                for(int i = 0; i < MainActivity.library.size(); i++) {
                    try {
                        if (MainActivity.library.get(i).getType().equals(str1)) {
                            recommendedPlants.add( MainActivity.library.get(i) );
                        }
                    } catch (NullPointerException e) {
                        Log.e("Failed Plant", "");
                    }
                }
                // Plant space
                recommendedPlants2 = new ArrayList<>();
                int space = 0;
                switch (str2){
                    case "3":space = 3; break;
                    case "3-7": space = 7; break;
                    case "8-11": space = 11; break;
                    case "12-15": space = 15; break;
                    case "15+": space = 16; break;




                    default: space = 16; break;
                }


                for(int i = 0; i < recommendedPlants.size(); i++)
                {
                    if(recommendedPlants.get(i).getSpace() < space)
                    {
                        recommendedPlants2.add(recommendedPlants.get(i));
                    }
                }
                //Toast.makeText(getActivity(), "Selected Radio Button is:" + recommendedPlants2.get(1), Toast.LENGTH_LONG).show();



                //Toast.makeText(getActivity(), "Selected Radio Button is:" + recommendedPlants.get(1)+recommendedPlants.get(2)+recommendedPlants1.get(3) , Toast.LENGTH_LONG).show();
                ArrayList<String> ar = new ArrayList<>();
                for(int i = 0; i < recommendedPlants.size(); i++)
                {
                    ar.add(i, recommendedPlants.get(i).getName());
                }

                Intent intent = new Intent(getActivity(), SubActivity.class);
                intent.putExtra("PLANTARR", ar);

                startActivity((intent));





            }

        });

        return root;
    }
}