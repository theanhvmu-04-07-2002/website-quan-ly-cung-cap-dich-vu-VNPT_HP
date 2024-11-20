package com.vnpthaiphong.dichvuvnpt.banhang.repository.get.nganhhang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class GetNganHang {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<Map<String, Object>> getChiTietNganHang(){
        String sql = "select * from nganhang";
        return  jdbcTemplate.queryForList(sql);
    }
}
