package com.vnpthaiphong.dichvuvnpt.banhang.repository.post.post_hopdong;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class Post_HopDong_DichVu {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @JsonProperty("ID_KhachHang")
    private String idKhachHang;

    public void setIdKhachHang(String idKhachHang) {
        this.idKhachHang = idKhachHang;
    }
    public List<Map<String, Object>> getHopDongDichVu() {
        String sql = "SELECT danhmucgdv.tendanhmucgdv, " +
                "quanhuyen.tenquanhuyen, " +
                "phuongxa.tenphuongxa, " +
                "thongtin_khachhang_chung.sdt_khachhang, " +
                "goidichvu.tengdv " +
                "FROM thongtin_khachhang_chung " +
                "JOIN khachhang ON thongtin_khachhang_chung.id_thongtin_khachhang_chung = khachhang.idfk_thongtin_khachhang_chung " +
                "JOIN donhang ON khachhang.idfk_donhang = donhang.id_donhang " +
                "JOIN goidichvu ON donhang.goidichvu = goidichvu.id_gdv " +
                "JOIN danhmucgdv ON goidichvu.idfk_danhmucgdv = danhmucgdv.id_danhmucgdv " +
                "JOIN phuongxa ON thongtin_khachhang_chung.phuongxa_khachhang = phuongxa.id_phuongxa " +
                "JOIN quanhuyen ON thongtin_khachhang_chung.quanhuyen_khachhang = quanhuyen.id_quanhuyen " +
                "WHERE khachhang.id_khachhang = ?";

        return jdbcTemplate.queryForList(sql, idKhachHang);
    }
}
