package com.vnpthaiphong.dichvuvnpt.banhang.repository.post.banhang_hopdong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsertHopDongThanhToan {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public ResponseEntity<String> getInsertHopDongThanhToan(ThongTinHopDongThanhToan thongTinHopDongThanhToan) {
        String sql = "insert into hopdong_thanhtoan_bena(idfk_hopdong, idfk_hinhthuc_thanhtoan_bena) values (?, ?)";
        try {
            List<Integer> hinhthucthanhtoan = thongTinHopDongThanhToan.getIdfkHinhThucThanhToan();
            for(Integer hinhthuc : hinhthucthanhtoan) {
                jdbcTemplate.update(sql, thongTinHopDongThanhToan.getIdfkHopDong(), hinhthuc);
            }
            return ResponseEntity.status(200).body("OK");
        }
        catch (Exception error) {
            return  ResponseEntity.status(401).body("Loi");
        }
    }
}
