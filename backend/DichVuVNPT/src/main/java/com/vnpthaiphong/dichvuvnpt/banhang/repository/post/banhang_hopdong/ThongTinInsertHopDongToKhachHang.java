package com.vnpthaiphong.dichvuvnpt.banhang.repository.post.banhang_hopdong;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ThongTinInsertHopDongToKhachHang {
    @JsonProperty("IDFK_HopDong")
    private String idfkHopDong;

    @JsonProperty("ID_KhachHang")
    private String idKhachHang;
}
