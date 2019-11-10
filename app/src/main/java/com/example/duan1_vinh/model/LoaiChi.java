package com.example.duan1_vinh.model;

public class LoaiChi {
    private String tenloaichi;
    private byte[] anh;

    public LoaiChi(String tenLoaiChi, byte[] anh) {
        this.tenloaichi = tenLoaiChi;
        this.anh = anh;
    }

    public String getTenloaichi() {
        return tenloaichi;
    }

    public void setTenloaichi(String tenloaichi) {
        this.tenloaichi = tenloaichi;
    }

    public byte[] getAnh() {
        return anh;
    }

    public void setAnh(byte[] anh) {
        this.anh = anh;
    }
}
