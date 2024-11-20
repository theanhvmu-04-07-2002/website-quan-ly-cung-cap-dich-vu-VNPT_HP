package com.vnpthaiphong.dichvuvnpt.banhang.repository.post.banhang_hopdong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

@Service
public class InsertHopDong {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ResponseEntity<Map<String, Object>> getInsertHopDong(ThongTinHopDong thongTinHopDong){
        String sql  = "insert  into HOPDONG(THOIGIANKYHOPDONG, IDFK_THONGTIN_KHACHHANG_CHUNG, IDFK_KHACHHANG_HOPDONG, IDFK_HOPDONG_BENB, CHUKY_KHACHHANG, TRANGTHAI_HOPDONG) " +
                "values (TO_TIMESTAMP(?, 'YYYY-MM-DD HH24:MI:SS'), ?, ?, ?, ?, ?)";
//        System.out.println("Thong tin hopdong: " + thongTinHopDong);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int truyvan = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[] {"id_hopdong"});
            ps.setString(1, thongTinHopDong.getThoiGianKyHopDong());
            ps.setString(2, thongTinHopDong.getIdfkThongTinKhachHangChung());
            ps.setString(3, thongTinHopDong.getIdfkKhachHangHopDong());
            ps.setString(4, thongTinHopDong.getIdfkHopDongBenB());
            ps.setString(5, thongTinHopDong.getChuKyKhachHang());
            ps.setString(6, thongTinHopDong.getTrangThaiHopDong());
            return ps;
        }, keyHolder);
        if(truyvan > 0) {
            Number IDFK_HopDong = keyHolder.getKey();
//            System.out.println("IDFK_HopDong: " + IDFK_HopDong);
            Map<String, Object> response = new HashMap<>();
            response.put("IDFK_HopDong", IDFK_HopDong);
            return ResponseEntity.status(200).body(response);
        }
        else {
            return ResponseEntity.status(401).body(Map.of("error","Loi inser hop dong"));
        }
    }
}
