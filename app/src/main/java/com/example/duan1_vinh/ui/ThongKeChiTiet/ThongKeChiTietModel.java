package com.example.duan1_vinh.ui.ThongKeChiTiet;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ThongKeChiTietModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ThongKeChiTietModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is tools fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}