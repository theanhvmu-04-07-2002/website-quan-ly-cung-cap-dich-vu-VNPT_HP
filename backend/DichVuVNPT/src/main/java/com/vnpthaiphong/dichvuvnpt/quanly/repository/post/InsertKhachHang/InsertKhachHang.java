package com.vnpthaiphong.dichvuvnpt.quanly.repository.post.InsertKhachHang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class InsertKhachHang {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public ResponseEntity<String> getInsertKhachHang(ThongTinKhachHangInsert thongTinKhachHang){
        String sql = "insert into khachhang(idfk_donhang, idfk_thongtin_khachhang_chung, idfk_tk_kh) " +
                "values(?,?,?)";
        int result = jdbcTemplate.update(sql,
                thongTinKhachHang.getIdfk_donhang(),
                thongTinKhachHang.getIdfk_thongtinkhachhangchung(),
                thongTinKhachHang.getIdfk_taikhoankhachhang()
                );
        if(result>0){
            return ResponseEntity.status(200).body("OK");
        }
        else {
            return ResponseEntity.status(401).body("Error insert khach hang");
        }
    }
}
