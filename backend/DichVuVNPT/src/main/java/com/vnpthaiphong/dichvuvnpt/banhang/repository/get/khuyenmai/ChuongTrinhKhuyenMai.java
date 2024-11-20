package com.vnpthaiphong.dichvuvnpt.banhang.repository.get.khuyenmai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ChuongTrinhKhuyenMai {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> getChuongTrinhKhuyenMai() {
        String sql = "SELECT * FROM SYSTEM.CHUONGTRINHKHUYENMAI";
        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql);
//        System.out.println("Data chuong trinh: " + result);
        return result;

    }
}
