package com.vnpthaiphong.dichvuvnpt.banhang.repository.post.banhang_hopdong;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ThongTinKhachHangHopDong {

    @JsonProperty("ChucVu")
    private String chucVu;

    @JsonProperty("NgaySinh")
    private String ngaySinh;

    @JsonProperty("GioiTinh")
    private String gioiTinh;

    @JsonProperty("SoCCCD")
    private String soCCCD;

    @JsonProperty("NgayCapCCCD")
    private String ngayCapCCCD;

    @JsonProperty("NoiCapCCCD")
    private String noiCapCCCD;

    @JsonProperty("SoGiayChungNhan")
    private String soGiayChungNhan;

    @JsonProperty("NgayCapGCN")
    private String ngayCapGCN;

    @JsonProperty("NoiCapGCN")
    private String noiCapGCN;

    @JsonProperty("DiaChiThuongTru")
    private String diaChiThuongTru;

    @JsonProperty("DiaChiThanhToan")
    private String diaChiThanhToan;

    @JsonProperty("TruSoGiaoDich")
    private String truSoGiaoDich;

    @JsonProperty("TaiKhoanSo")
    private String taiKhoanSo;

    @JsonProperty("NganHang")
    private String taiNganHang;

    @JsonProperty("MaSoThue")
    private String maSoThue;

    @JsonProperty("LienHeKhac")
    private String lienHeKhac;

}
