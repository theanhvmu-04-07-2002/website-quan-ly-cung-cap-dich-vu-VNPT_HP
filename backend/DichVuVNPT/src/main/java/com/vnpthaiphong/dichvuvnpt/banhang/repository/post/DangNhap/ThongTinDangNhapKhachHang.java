package com.vnpthaiphong.dichvuvnpt.banhang.repository.post.DangNhap;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ThongTinDangNhapKhachHang {
    @JsonProperty("TaiKhoan")
    private String taiKhoan;

    @JsonProperty("MatKhau")
    private  String matKhau;

    public String getTenDangNhap(){
        return taiKhoan;
    }

    public String getMatKhau(){
        return  matKhau;
    }
}
