package com.vnpthaiphong.dichvuvnpt.quanly.repository.get.hopdong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class HopDongBenB {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> getHopDongBenB(){
        String sql = "select * from hopdong_benb";
        return jdbcTemplate.queryForList(sql);
    }
}
