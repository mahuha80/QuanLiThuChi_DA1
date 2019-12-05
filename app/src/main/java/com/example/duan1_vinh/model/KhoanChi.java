package com.example.duan1_vinh.model;

import java.util.Date;

public class KhoanChi {
    private int id;
    private double sotien;
    private String ghichu;
    private LoaiChi loaiChi;
    private Date ngaygio;

    public KhoanChi(int id, double sotien, String ghichu, LoaiChi loaiChi, Date ngaygio) {
        this.id = id;
        this.sotien = sotien;
        this.ghichu = ghichu;
        this.loaiChi = loaiChi;
        this.ngaygio = ngaygio;
    }

    public KhoanChi(double sotien, String ghichu, LoaiChi loaiChi, Date ngaygio) {
        this.sotien = sotien;
        this.ghichu = ghichu;
        this.loaiChi = loaiChi;
        this.ngaygio = ngaygio;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
