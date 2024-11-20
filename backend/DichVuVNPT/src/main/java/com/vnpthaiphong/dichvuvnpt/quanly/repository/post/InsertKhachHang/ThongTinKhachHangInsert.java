package com.vnpthaiphong.dichvuvnpt.quanly.repository.post.InsertKhachHang;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ThongTinKhachHangInsert {
    @JsonProperty("IDFK_TaiKhoanKhachHang")
    private  String idfk_taikhoankhachhang;

    @JsonProperty("IDFK_ThongTinKhachHangChung")
    private String idfk_thongtinkhachhangchung;

    @JsonProperty("IDFK_DonHang")
    private  String idfk_donhang;
}
