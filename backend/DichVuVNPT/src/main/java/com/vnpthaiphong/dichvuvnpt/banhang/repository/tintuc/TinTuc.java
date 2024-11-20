package com.vnpthaiphong.dichvuvnpt.banhang.repository.tintuc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class TinTuc {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> getTinTuc() {
        String sql = "SELECT * FROM SYSTEM.TRANGCHU_TINTUC";
        return jdbcTemplate.queryForList(sql);
    }
}
