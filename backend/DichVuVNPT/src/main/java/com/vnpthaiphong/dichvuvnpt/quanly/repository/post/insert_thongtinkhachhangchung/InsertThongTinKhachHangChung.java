package com.vnpthaiphong.dichvuvnpt.quanly.repository.post.insert_thongtinkhachhangchung;

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
public class InsertThongTinKhachHangChung {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ResponseEntity<Map<String, Object>> getInsertThongTinKhachHangChung(ThongTinKhachHangChung thongTinKhachHangChung) {
//        System.out.println("Thong tin tai khoan chung "
//        + thongTinKhachHangChung.getHoTenKhachHang()
//        +" " + thongTinKhachHangChung.getSdtKhachHang()
//        +" " + thongTinKhachHangChung.getEmailKhachHang()
//        +" " + thongTinKhachHangChung.getQuanHuyenKhachHang()
//        +" " + thongTinKhachHangChung.getPhuongXaKhachHang()
//        +" " + thongTinKhachHangChung.getChiTietKhachHang());
        String sql = "insert into thongtin_khachhang_chung(hoten_khachhang, sdt_khachhang, email_khachhang, quanhuyen_khachhang, phuongxa_khachhang, chitiet_khachhang) " +
                " values (?,?,?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int truyvan = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[] {"id_thongtin_khachhang_chung"});
            ps.setString(1, thongTinKhachHangChung.getHoTenKhachHang());
            ps.setString(2, thongTinKhachHangChung.getSdtKhachHang());
            ps.setString(3, thongTinKhachHangChung.getEmailKhachHang());
            ps.setString(4, thongTinKhachHangChung.getQuanHuyenKhachHang());
            ps.setString(5, thongTinKhachHangChung.getPhuongXaKhachHang());
            ps.setString(6, thongTinKhachHangChung.getChiTietKhachHang());
            return ps;
        }, keyHolder);
        if(truyvan > 0){
            Number IDFK_ThongTinKhachHangChung = keyHolder.getKey();
//            System.out.println("IDFK_ThongTinKhachHangChung: " + IDFK_ThongTinKhachHangChung);
            Map<String, Object> response = new HashMap<>();
            response.put("IDFK_ThongTinKhachHangChung", IDFK_ThongTinKhachHangChung);
            return ResponseEntity.status(200).body(response);
        }
        else {
            return ResponseEntity.status(401).body(Map.of("Error","sai insert thong tin khach hang chung"));
        }

    }
}
