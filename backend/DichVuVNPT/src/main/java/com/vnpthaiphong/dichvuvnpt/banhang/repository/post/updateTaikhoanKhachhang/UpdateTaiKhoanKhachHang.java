package com.vnpthaiphong.dichvuvnpt.banhang.repository.post.updateTaikhoanKhachhang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UpdateTaiKhoanKhachHang {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ResponseEntity<String> postUpdateTaiKhoanKhachHang(ThongTinTaiKhoan thongTinTaiKhoan) {
        String sql = "UPDATE tk_kh " +
                "SET tk_kh.MK_KH = ? " +
                "WHERE EXISTS ( " +
                "    SELECT 1 " +
                "    FROM khachhang " +
                "    WHERE khachhang.idfk_tk_kh = tk_kh.id_tk_kh " +
                "      AND khachhang.id_khachhang = ? " +
                ")";
        int ketqua = jdbcTemplate.update(sql,
                thongTinTaiKhoan.getMatKhauMoi(),
                thongTinTaiKhoan.getIdKhachHang());
        if(ketqua > 0) {
            return ResponseEntity.ok("OK");
        }
        else {
            return ResponseEntity.status(500).body("Loi");
        }
    }
}
