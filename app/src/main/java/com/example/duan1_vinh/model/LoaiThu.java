package com.example.duan1_vinh.model;

public class LoaiThu {
    private String tenloaithu;
    private byte[] hinhanh;

    public LoaiThu(String tenloaithu, byte[] hinhanh) {
        this.tenloaithu = tenloaithu;
        this.hinhanh = hinhanh;
    }

    public String getTenloaithu() {
        return tenloaithu;
    }

    public void setTenloaithu(String tenloaithu) {
        this.tenloaithu = tenloaithu;
    }

    public byte[] getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(byte[] hinhanh) {
        this.hinhanh = hinhanh;
    }
}
