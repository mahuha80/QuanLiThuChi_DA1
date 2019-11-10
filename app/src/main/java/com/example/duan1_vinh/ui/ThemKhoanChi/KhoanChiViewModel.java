package com.example.duan1_vinh.ui.ThemKhoanChi;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class KhoanChiViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public KhoanChiViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}