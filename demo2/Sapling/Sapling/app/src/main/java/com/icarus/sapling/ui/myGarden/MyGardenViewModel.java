package com.icarus.sapling.ui.myGarden;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyGardenViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MyGardenViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is myGarden fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}