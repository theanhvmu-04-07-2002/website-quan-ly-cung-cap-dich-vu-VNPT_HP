package com.vnpthaiphong.dichvuvnpt.banhang.repository.get.khachhangbaohong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class TrangThaiBaoHong {
    @Autowired

    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> getTrangThaiBaoHong (){
        String sql = "select * from NOIDUNGBAOHONG ";
        return  jdbcTemplate.queryForList(sql);
    }
}
