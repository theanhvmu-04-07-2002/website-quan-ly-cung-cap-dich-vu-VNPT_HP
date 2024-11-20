package com.vnpthaiphong.dichvuvnpt.banhang.repository.post.banhang_hopdong;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ThongTinHopDong {
    @JsonProperty("ThoiGianKyHopDong")
    private String thoiGianKyHopDong;

    @JsonProperty("IDFKThongTinKhachHangChung")
    private String idfkThongTinKhachHangChung ;

    @JsonProperty("IDFKKhachHangHopDong")
    private String idfkKhachHangHopDong ;

    @JsonProperty("IDFKHopDongBenB")
    private String idfkHopDongBenB ;

    @JsonProperty("ChuKyKhachHang")
    private String chuKyKhachHang ;

    @JsonProperty("TrangThaiHopDong")
    private String trangThaiHopDong ;




}
