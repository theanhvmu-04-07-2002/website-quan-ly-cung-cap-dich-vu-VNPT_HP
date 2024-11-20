package com.vnpthaiphong.dichvuvnpt.quanly.repository.get.khaosat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class KetQuaKhaoSat {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<Map<String, Object>> getKetQuaKhaoSat(){
        String sql = "select * from kq_khaosat";
        return jdbcTemplate.queryForList(sql);
    }
}
