package com.example.duan1_vinh.model;

import androidx.annotation.NonNull;

public class LoaiThu {
    private String tenloaithu;
    private int vitrihinhanh;

    public LoaiThu(String tenloaithu, int vitrihinhanh) {
        this.tenloaithu = tenloaithu;
        this.vitrihinhanh = vitrihinhanh;
    }

    public String getTenloaithu() {
        return tenloaithu;
    }

    public void setTenloaithu(String tenloaithu) {
        this.tenloaithu = tenloaithu;
    }

    public int getVitrihinhanh() {
        return vitrihinhanh;
    }

    public void setVitrihinhanh(int vitrihinhanh) {
        this.vitrihinhanh = vitrihinhanh;
    }

    @NonNull
    @Override
    public String toString() {
        return tenloaithu;

    }
}
