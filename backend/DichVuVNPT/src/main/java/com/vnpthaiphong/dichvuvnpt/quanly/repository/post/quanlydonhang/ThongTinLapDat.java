package com.vnpthaiphong.dichvuvnpt.quanly.repository.post.quanlydonhang;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ThongTinLapDat {

    @JsonProperty("DonHangCapNhat")
    private String donHangCapNhat;

    @JsonProperty("ThoiGianHoanTat")
    private String thoiGianHoanTat;

    @JsonProperty ("KetQuaKhaoSat")
    private String ketQuaKhaoSat;

    @JsonProperty("KetQuaLapDat")
    private  String ketQuaLapDat;

    @JsonProperty("TrangThaiLapDat")
    private String trangThaiLapDat;

    @JsonProperty("GhiChuKhaoSat")
    private String ghiChuKhaoSatDonHang;
}
