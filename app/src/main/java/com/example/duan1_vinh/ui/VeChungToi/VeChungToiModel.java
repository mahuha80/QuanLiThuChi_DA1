package com.example.duan1_vinh.ui.VeChungToi;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class VeChungToiModel extends ViewModel {

    private MutableLiveData<String> mText;

    public VeChungToiModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is send fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}