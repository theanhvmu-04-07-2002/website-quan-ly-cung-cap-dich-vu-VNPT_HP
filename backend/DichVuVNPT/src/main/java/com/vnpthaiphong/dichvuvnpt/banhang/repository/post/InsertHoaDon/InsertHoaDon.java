package com.vnpthaiphong.dichvuvnpt.banhang.repository.post.InsertHoaDon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class InsertHoaDon {
    @Autowired

    private JdbcTemplate jdbcTemplate;

    public ResponseEntity<String> postInsertHoaDon(ThongTinHoaDon thongTinHoaDon){
        String sql = "insert into hoadongtgt(thoigianthanhtoan, " +
                "id_khachhang, soluong, " +
                "thanhtiengdv, tienthuegtgt, tongcongtienthanhtoan, " +
                "TENTAIKHOANTHANHTOAN, SOTAIKHOANTHANHTOAN, IDFK_NGANHANG) " +
                "values (TO_TIMESTAMP(?, 'YYYY-MM-DD HH24:MI:SS'),?,?,?,?,?,?, ?,?)";
        int result = jdbcTemplate.update(sql,
                thongTinHoaDon.getThoiGianThanhToan(),
                thongTinHoaDon.getIdKhachHang(),
                thongTinHoaDon.getSoLuong(),
                thongTinHoaDon.getThanhTien(),
                thongTinHoaDon.getTienThueGTGT(),
                thongTinHoaDon.getTongCongTienThanhToan(),
                thongTinHoaDon.getTenTaiKhoanThanhToan(),
                thongTinHoaDon.getSoTaiKhoanThanhToan(),
                thongTinHoaDon.getNganHangThanhToan()
        );
        if(result > 0) {
            return ResponseEntity.ok("ok");
        }
        else {
            return ResponseEntity.status(500).body("Loi");
        }
    }
}
