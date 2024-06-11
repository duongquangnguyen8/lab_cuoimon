package com.example.lab_cuoimon_ph50030.models;

public class SinhVien {
    private String msv;
    private String ten;
    private int id;

    public SinhVien(String msv, String ten, int id) {
        this.msv = msv;
        this.ten = ten;
        this.id = id;
    }
    public SinhVien(String msv, String ten) {
        this.msv = msv;
        this.ten = ten;
    }

    public String getMsv() {
        return msv;
    }

    public void setMsv(String msv) {
        this.msv = msv;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
