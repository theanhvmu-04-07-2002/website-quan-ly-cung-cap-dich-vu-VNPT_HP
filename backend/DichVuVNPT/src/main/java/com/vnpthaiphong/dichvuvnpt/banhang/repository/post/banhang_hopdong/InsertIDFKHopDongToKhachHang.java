package com.vnpthaiphong.dichvuvnpt.banhang.repository.post.banhang_hopdong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
@Service
public class InsertIDFKHopDongToKhachHang {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ResponseEntity<String> getInsertHopDongToKhachHang(ThongTinInsertHopDongToKhachHang thongTinInsertKhachHang){
        // In dữ liệu ra console để kiểm tra
//        System.out.println("IDFK_HOPDONG insert: " + thongTinInsertKhachHang.getIdfkHopDong());
//        System.out.println("ID_KhachHang : " + thongTinInsertKhachHang.getIdKhachHang());

        String sql = "UPDATE khachhang SET IDFK_HOPDONG = ? WHERE id_khachhang = ?";
        int result = jdbcTemplate.update(sql,
                thongTinInsertKhachHang.getIdfkHopDong(),
                thongTinInsertKhachHang.getIdKhachHang()
        );

        if(result > 0) {
            return ResponseEntity.status(200).body("Ok");
        } else {
            return ResponseEntity.status(401).body("Error");
        }
    }
}
