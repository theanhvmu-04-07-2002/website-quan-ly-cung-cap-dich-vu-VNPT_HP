package com.vnpthaiphong.dichvuvnpt.banhang.repository.post.InsertHoaDon;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ThongTinHoaDon {

    @JsonProperty("ThoiGianThanhToan")
    private String thoiGianThanhToan;

    @JsonProperty("ID_KhachHang")
    private String idKhachHang;

    @JsonProperty("SoLuong")
    private String soLuong;

    @JsonProperty("ThanhTien")
    private String thanhTien;

    @JsonProperty("TienThueGTGT")
    private String tienThueGTGT;

    @JsonProperty("TongCongTienThanhToan")
    private String tongCongTienThanhToan;

    @JsonProperty("TenTaiKhoanThanhToan")
    private String tenTaiKhoanThanhToan;

    @JsonProperty("SoTaiKhoanThanhToan")
    private String soTaiKhoanThanhToan;

    @JsonProperty("NganHangThanhToan")
    private String nganHangThanhToan;

}
