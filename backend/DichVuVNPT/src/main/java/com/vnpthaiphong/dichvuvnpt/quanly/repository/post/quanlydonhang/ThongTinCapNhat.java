package com.vnpthaiphong.dichvuvnpt.quanly.repository.post.quanlydonhang;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ThongTinCapNhat {

    @JsonProperty("DonHang")
    private  String donHang;

    @JsonProperty("HoTenKhachHang")
    private  String hoTenKhachHang;

    @JsonProperty("SDTKhachHang")
    private String sDTKhachHang;

    @JsonProperty("EmailKhachHang")
    private String emailKhachHang;

    @JsonProperty("QuanHuyenKhachHang")
    private String quanHuyenKhachHang;

    @JsonProperty("PhuongXaKhachHang")
    private  String phuongXaKhachHang;

    @JsonProperty("HinhThucTraCuoc")
    private String hinhThucTraCuoc;

    @JsonProperty("GoiDichVu")
    private  String goiDichVu;

    @JsonProperty("ChiTietKhachHang")
    private  String chiTietKhachHang;

    @JsonProperty("GhiChuKhachHang")
    private  String ghiChuKhachHang;

    @JsonProperty("TrangThaiDonHang")
    private  String trangThaiDonHang;
}
