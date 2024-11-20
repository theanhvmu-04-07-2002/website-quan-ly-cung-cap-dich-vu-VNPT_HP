package com.vnpthaiphong.dichvuvnpt.banhang.repository.post.updateTaikhoanKhachhang;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ThongTinTaiKhoan {
    @JsonProperty("ID_KhachHang")
    private String idKhachHang;

    @JsonProperty("MatKhauMoi")
    private String matKhauMoi;

}
