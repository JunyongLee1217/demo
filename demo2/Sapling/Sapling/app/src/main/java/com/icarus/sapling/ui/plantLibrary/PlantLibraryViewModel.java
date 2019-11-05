package com.icarus.sapling.ui.plantLibrary;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PlantLibraryViewModel extends ViewModel
{

    private MutableLiveData<String> mText;

    public PlantLibraryViewModel()
    {
        mText = new MutableLiveData<>();
        mText.setValue("This is plantLibrary fragment");
    }

    public LiveData<String> getText()
    {
        return mText;
    }
}