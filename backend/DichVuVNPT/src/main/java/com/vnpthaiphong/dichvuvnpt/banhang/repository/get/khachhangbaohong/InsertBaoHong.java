package com.vnpthaiphong.dichvuvnpt.banhang.repository.get.khachhangbaohong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class InsertBaoHong {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ResponseEntity<String> postInsertBaoHong(DuLieuBaoHong duLieuBaoHong){
        String sql = "insert into BAOHONG(THOIGIANBAOHONG , IDFK_KHACHHANG, IDFK_NOIDUNGBAOHONG,CHITIET_BAOHONG, TRANGTHAI_BAOHONG)" +
                " values(TO_TIMESTAMP(?, 'YYYY-MM-DD HH24:MI:SS'),?,?,?,?)";
        int ketqua = jdbcTemplate.update(sql,
            duLieuBaoHong.getThoiGianBaoHong(),
            duLieuBaoHong.getIdKhachHang(),
                duLieuBaoHong.getIdfkNoiDungBaoHong(),
                duLieuBaoHong.getChiTietBaoHong(),
                duLieuBaoHong.getTrangThaiBaoHong()
                );
        if(ketqua > 0){
            return ResponseEntity.status(200).body("OK");
        }
        else {
            return ResponseEntity.status(401).body("error");
        }
    }
}
