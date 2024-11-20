package com.vnpthaiphong.dichvuvnpt.banhang.repository.get.khachhangbaohong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class BaoHongDaGui {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> getBaoHongDaGui(String idKhachHang){
        String sql = "select bh.id_baohong,bh.THOIGIANBAOHONG,  chung.hoten_khachhang, hong.noidungbaohong, bh.chitiet_baohong,bh.TRANGTHAI_BAOHONG \n" +
                "from baohong bh\n" +
                "join khachhang kh on bh.idfk_khachhang = kh.id_khachhang\n" +
                "join thongtin_khachhang_chung chung on kh.idfk_thongtin_khachhang_chung = chung.id_thongtin_khachhang_chung\n" +
                "join noidungbaohong hong on bh.idfk_noidungbaohong = hong.id_noidungbaohong\n" +
                " where kh.ID_KHACHHANG = ?";
        return jdbcTemplate.queryForList(sql, idKhachHang);
    }
}
