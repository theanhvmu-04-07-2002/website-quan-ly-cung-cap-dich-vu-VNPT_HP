package com.vnpthaiphong.dichvuvnpt.quanly.repository.post.insert_taikhoankhachhang;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ThongTinTaiKhoanKhachHangInsert {
    @JsonProperty("TaiKhoan")
    private String taiKhoan;

    @JsonProperty("PhanQuyen")
    private String phanQuyen;
}
