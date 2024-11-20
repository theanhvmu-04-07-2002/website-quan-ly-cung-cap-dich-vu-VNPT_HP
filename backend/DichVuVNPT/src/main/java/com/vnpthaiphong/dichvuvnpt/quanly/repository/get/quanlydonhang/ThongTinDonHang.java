package com.vnpthaiphong.dichvuvnpt.quanly.repository.get.quanlydonhang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ThongTinDonHang {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<Map<String, Object>> getThongTinDonHang(){
        String sql = "select * from V_BANHANG_DONHANG ";
        return jdbcTemplate.queryForList(sql);
    }

}
