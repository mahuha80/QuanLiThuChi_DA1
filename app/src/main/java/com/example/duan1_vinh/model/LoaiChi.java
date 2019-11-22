package com.example.duan1_vinh.model;

public class LoaiChi {
    private String tenloaichi;
    private int vitrihinhanh;

    public LoaiChi(String tenloaichi, int vitrihinhanh) {
        this.tenloaichi = tenloaichi;
        this.vitrihinhanh = vitrihinhanh;
    }

    public String getTenloaichi() {
        return tenloaichi;
    }

    public void setTenloaichi(String tenloaichi) {
        this.tenloaichi = tenloaichi;
    }

    public int getVitrihinhanh() {
        return vitrihinhanh;
    }

    public void setVitrihinhanh(int vitrihinhanh) {
        this.vitrihinhanh = vitrihinhanh;
    }
}
