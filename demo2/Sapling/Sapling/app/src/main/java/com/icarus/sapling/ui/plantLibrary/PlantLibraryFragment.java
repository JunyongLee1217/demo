package com.icarus.sapling.ui.plantLibrary;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.icarus.sapling.MainActivity;

public class PlantLibraryFragment extends Fragment
{

    private PlantLibraryViewModel libraryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        libraryViewModel = ViewModelProviders.of(this).get(PlantLibraryViewModel.class);
        return MainActivity.loadList(this.getActivity(), MainActivity.library, inflater, container, savedInstanceState);
    }
}