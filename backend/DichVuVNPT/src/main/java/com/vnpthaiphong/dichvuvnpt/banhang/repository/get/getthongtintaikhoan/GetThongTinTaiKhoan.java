package com.vnpthaiphong.dichvuvnpt.banhang.repository.get.getthongtintaikhoan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GetThongTinTaiKhoan {
    @Autowired
    private JdbcTemplate   jdbcTemplate;

    public List<Map<String, Object>> getChiTietTaiKhoanKhachHang(String idKhachHang){
        String sql = "select * from tk_kh " +
                " join khachhang on khachhang.IDFK_TK_KH = TK_KH.ID_TK_KH " +
                " where KHACHHANG.ID_KHACHHANG = ?";
        return jdbcTemplate.queryForList(sql, idKhachHang);
    }
}
