package com.vnpthaiphong.dichvuvnpt.quanly.repository.post.insert_thongtinkhachhangchung;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ThongTinKhachHangChung {
    @JsonProperty("HoTen_KhachHang")
    private String hoTenKhachHang;

    @JsonProperty("SDT_KhachHang")
    private String sdtKhachHang;

    @JsonProperty("Email_KhachHang")
    private String emailKhachHang;

    @JsonProperty("QuanHuyen_KhachHang")
    private String quanHuyenKhachHang;

    @JsonProperty("PhuongXa_KhachHang")
    private String phuongXaKhachHang;

    @JsonProperty("ChiTiet_KhachHang")
    private String chiTietKhachHang;

}
