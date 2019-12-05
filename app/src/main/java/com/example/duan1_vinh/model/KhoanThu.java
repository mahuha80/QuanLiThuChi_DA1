package com.example.duan1_vinh.model;

import java.util.Date;

public class KhoanThu {
    private int id;
    private double sotien;
    private String ghichu;
    private LoaiThu loaiThu;
    private Date ngaygio;

    public KhoanThu(int id, double sotien, String ghichu, LoaiThu loaiThu, Date ngaygio) {
        this.id = id;
        this.sotien = sotien;
        this.ghichu = ghichu;
        this.loaiThu = loaiThu;
        this.ngaygio = ngaygio;
    }

    public KhoanThu(double sotien, String ghichu, LoaiThu loaiThu, Date ngaygio) {
        this.sotien = sotien;
        this.ghichu = ghichu;
        this.loaiThu = loaiThu;
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
