package com.vnpthaiphong.dichvuvnpt.banhang.repository.post.banhang_hopdong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsertHopDongThongBao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public ResponseEntity<String> getInsertHopDongThongBao(ThongTinHopDongThongBao thongTinHopDongThongBao) {
        String sql = "insert into HOPDONG_THONGBAO_BENA(idfk_hopdong, IDFK_HINHTHUC_THONGBAO_BENA) values (?, ?)";
        try {
            List<Integer> hinhthucthongbao = thongTinHopDongThongBao.getIdfkHinhThucThongBao();
            for(Integer hinhthuc : hinhthucthongbao) {
                jdbcTemplate.update(sql, thongTinHopDongThongBao.getIdfkHopDong(), hinhthuc);
            }
            return ResponseEntity.status(200).body("OK");
        }
        catch (Exception error) {
            return  ResponseEntity.status(401).body("Loi");
        }
    }
}
