package com.vnpthaiphong.dichvuvnpt.quanly.repository.get.lapdat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class KetQuaLapDat {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<Map<String, Object>> getKetQuaLapDat(){
        String sql = "select * from kq_lapdat";
        return jdbcTemplate.queryForList(sql);
    }

}
