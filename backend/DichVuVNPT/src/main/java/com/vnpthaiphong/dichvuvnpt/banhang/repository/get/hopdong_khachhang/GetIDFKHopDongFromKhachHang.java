package com.vnpthaiphong.dichvuvnpt.banhang.repository.get.hopdong_khachhang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GetIDFKHopDongFromKhachHang {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> getIDFKHopDongFromKhachHang(String idKhachHang) {

        String sql = "SELECT idfk_hopdong FROM khachhang WHERE id_khachhang = ?";
        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql, idKhachHang);

        return result;
    }
}
