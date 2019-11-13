package com.example.duan1_vinh.model;

public class LoaiChi {
    private String tenloaichi;
    private String vitrihinhanh;

    public LoaiChi(String tenloaichi, String vitrihinhanh) {
        this.tenloaichi = tenloaichi;
        this.vitrihinhanh = vitrihinhanh;
    }

    public String getTenloaichi() {
        return tenloaichi;
    }

    public void setTenloaichi(String tenloaichi) {
        this.tenloaichi = tenloaichi;
    }

    public String getVitrihinhanh() {
        return vitrihinhanh;
    }

    public void setVitrihinhanh(String vitrihinhanh) {
        this.vitrihinhanh = vitrihinhanh;
    }
}
