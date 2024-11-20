package com.vnpthaiphong.dichvuvnpt.quanly.repository.post.postkythuatbaohong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class InsertSuaChuaBaoHong {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ResponseEntity<String> postInsertSuaChuaBaoHongService(@RequestBody ThongTinSuaChuaBaoHong thongTinSuaChuaBaoHong) {
        String sql = "insert into SUACHUA_BAOHONG(thoigiansuachua, idfk_baohong, loi, suachua, ketquasuachua) " +
                " values(TO_TIMESTAMP(?, 'YYYY-MM-DD HH24:MI:SS'), ?, ?,?, ?) ";
        int ketqua = jdbcTemplate.update(sql,
                thongTinSuaChuaBaoHong.getThoiGianSuaChua(),
                thongTinSuaChuaBaoHong.getIdfkBaoHong(),
                thongTinSuaChuaBaoHong.getLoi(),
                thongTinSuaChuaBaoHong.getSuaChua(),
                thongTinSuaChuaBaoHong.getKetQuaSuaChua()
                );
        if(ketqua > 0) {
            return ResponseEntity.status(200).body("OK");
        }
        else {
            return ResponseEntity.badRequest().body("Error");
        }
    }
}
