package com.example.duan1_vinh.ui.ThongKeChiTiet;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CaiDatViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CaiDatViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is share fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}