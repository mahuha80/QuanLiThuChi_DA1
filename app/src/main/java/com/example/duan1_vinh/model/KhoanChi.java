package com.example.duan1_vinh.model;

import java.util.Date;

public class KhoanChi {
    private double sotien;
    private String ghichu;
    private LoaiChi loaiChi;
    private Date ngaygio;

    public KhoanChi(double sotien, String ghichu, LoaiChi loaiChi, Date ngaygio) {
        this.sotien = sotien;
        this.ghichu = ghichu;
        this.loaiChi = loaiChi;
        this.ngaygio = ngaygio;

    }

    public double getSotien() {
        return sotien;
    }

    public void setSotien(double sotien) {
        this.sotien = sotien;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public LoaiChi getLoaiChi() {
        return loaiChi;
    }

    public void setLoaiChi(LoaiChi loaiChi) {
        this.loaiChi = loaiChi;
    }

    public Date getNgaygio() {
        return ngaygio;
    }

    public void setNgaygio(Date ngaygio) {
        this.ngaygio = ngaygio;
    }
}
