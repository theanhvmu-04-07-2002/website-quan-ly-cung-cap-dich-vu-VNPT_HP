package com.vnpthaiphong.dichvuvnpt.quanly.repository.post.dangnhap;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ThongTinDangNhap {
    @JsonProperty("TenDangNhap")
    private String tenDangNhap;

    @JsonProperty("MatKhau")
    private String matKhau;

    // Getter và Setter
    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    @Override
    public String toString() {
        return "ThongTinDangNhap{" +
                "tenDangNhap='" + tenDangNhap + '\'' +
                ", matKhau='" + matKhau + '\'' +
                '}';
    }
}
