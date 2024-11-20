package com.vnpthaiphong.dichvuvnpt.banhang.repository.get.diachi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class DiaChi_PhuongXa {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> getChiTietPhuongXa() {
        String sql = "SELECT * FROM SYSTEM.PhuongXa";
        return jdbcTemplate.queryForList(sql);

    }
}
