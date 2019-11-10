package com.example.duan1_vinh.ui.QuanLyNhom;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class QuanLyNhomViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public QuanLyNhomViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is tools fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
