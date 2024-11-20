package com.vnpthaiphong.dichvuvnpt.banhang.repository.post.khachhangdoimatkhau;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ThongTinDoiMatKhau {

    @JsonProperty("ID_KhachHang")
    private String idKhachHang;

    @JsonProperty("TaiKhoan")
    private String taiKhoan;

    @JsonProperty("MatKhauCu")
    private String matKhauCu;

    @JsonProperty("MatKhauMoi")
    private String matKhauMoi;
}
