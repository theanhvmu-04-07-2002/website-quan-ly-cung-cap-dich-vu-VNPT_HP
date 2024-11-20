package com.vnpthaiphong.dichvuvnpt.banhang.repository.get.goidichvu;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ChiTietGoiDichVu {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> getChiTietGoiDichVu() {
        String sql = "SELECT * FROM SYSTEM.V_GDV_CHITIET";
        return jdbcTemplate.queryForList(sql);
    }
}
