package com.vnpthaiphong.dichvuvnpt.banhang.repository.post.banhang_hopdong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LayDuLieuKhachHangChungHopDong {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> getLayDuLieuKhachHangChung(String idKhachHang){
        String sql = "select * from khachhang_hopdong " +
                "join hopdong on hopdong.idfk_khachhang_hopdong = khachhang_hopdong.id_khachhang_hopdong " +
                "join khachhang on khachhang.idfk_hopdong = hopdong.id_hopdong " +
                "where khachhang.id_khachhang = ?";
        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql,idKhachHang );
        return  result;
    }
}
