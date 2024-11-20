package com.vnpthaiphong.dichvuvnpt.banhang.repository.get.hopdong_khachhang;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class Get_BanHang_ThongTin_KhachHang_Chung {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @JsonProperty("ID_KhachHang")
    private String idKhachHang;

    public void setIdKhachHang(String idKhachHang) {
        this.idKhachHang = idKhachHang;
    }
    public List<Map<String, Object>> getThongTinKhachHangChung() {
        String sql = "SELECT * from THONGTIN_KHACHHANG_CHUNG " +
                " join KHACHHANG on khachhang.IDFK_THONGTIN_KHACHHANG_CHUNG =THONGTIN_KHACHHANG_CHUNG.ID_THONGTIN_KHACHHANG_CHUNG" +
                " where khachhang.id_khachhang = ?";

        return jdbcTemplate.queryForList(sql, idKhachHang);
    }
}
