package com.vnpthaiphong.dichvuvnpt.banhang.repository.get.khachhangbaohong;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DuLieuBaoHong {

    @JsonProperty("ThoiGianBaoHong")
    private String thoiGianBaoHong;

    @JsonProperty("ID_KhachHang")
    private String idKhachHang;

    @JsonProperty("IDFK_NoiDungBaoHong")
    private String idfkNoiDungBaoHong;

    @JsonProperty("ChiTiet_BaoHong")
    private String chiTietBaoHong;

    @JsonProperty("TrangThaiBaoHong")
    private String trangThaiBaoHong;
}
