package com.example.duan1_vinh.model;

import java.util.Date;

public class KhoanThu {
    private int sotien;
    private String ghichu;
    private LoaiThu loaiThu;
    private Date ngaygio;

    public KhoanThu(int sotien, String ghichu, LoaiThu loaiThu, Date ngaygio) {
        this.sotien = sotien;
        this.ghichu = ghichu;
        this.loaiThu = loaiThu;
        this.ngaygio = ngaygio;
    }

    public int getSotien() {
        return sotien;
    }

    public void setSotien(int sotien) {
        this.sotien = sotien;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public LoaiThu getLoaiThu() {
        return loaiThu;
    }

    public void setLoaiThu(LoaiThu loaiThu) {
        this.loaiThu = loaiThu;
    }

    public Date getNgaygio() {
        return ngaygio;
    }

    public void setNgaygio(Date ngaygio) {
        this.ngaygio = ngaygio;
    }
}
