package com.example.duan1_vinh.ui.BieuDoThongKe;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ThongKeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ThongKeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}