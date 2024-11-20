package com.vnpthaiphong.dichvuvnpt.banhang.repository.get.goidichvu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class HinhThucTraCuoc {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> getChiTietHinhThuc() {
        String sql = "SELECT * FROM SYSTEM.HINHTHUCTRACUOC";
        return jdbcTemplate.queryForList(sql);
    }
}
