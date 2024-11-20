package com.vnpthaiphong.dichvuvnpt.banhang.repository.post.YeuCauDonHang;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ThongTinKhachHang {
    @JsonProperty("ThoiGianTao")
    private String thoiGianTao;

    @JsonProperty("HoTenKhachHang")
    private String hoTenKhachHang;

    @JsonProperty("SDTKhachHang")
    private String sDTKhachhang;

    @JsonProperty("EmailKhachHang")
    private String emailKhachhang;

    @JsonProperty("QuanHuyenKhachHang")
    private Integer quanHuyenKhachHang;

    @JsonProperty("PhuongXaKhachHang")
    private Integer phuongXaKhachHang;

    @JsonProperty("ChiTietKhachHang")
    private String chiTietKhachHang;

    @JsonProperty("GhiChuKhachHang")
    private String ghiChuKhachHang;

    @JsonProperty("HinhThucTraCuoc")
    private Integer hinhThucTraCuoc;

    @JsonProperty("GoiDichVu")
    private Integer goiDichVu;

    @JsonProperty("TrangThaiDonHang")
    private Integer trangThaiDonHang;
}
