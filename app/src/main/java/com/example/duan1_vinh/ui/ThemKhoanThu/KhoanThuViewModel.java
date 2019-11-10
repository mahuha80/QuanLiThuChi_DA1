package com.example.duan1_vinh.ui.ThemKhoanThu;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class KhoanThuViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public KhoanThuViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}