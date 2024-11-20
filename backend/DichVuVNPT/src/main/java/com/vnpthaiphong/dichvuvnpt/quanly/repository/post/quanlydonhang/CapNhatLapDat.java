package com.vnpthaiphong.dichvuvnpt.quanly.repository.post.quanlydonhang;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class CapNhatLapDat {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public ResponseEntity<String> getCapNhatLapDat(ThongTinLapDat thongTinLapDat){
//        System.out.println("Don hang cap nhat: "
//        + thongTinLapDat.getDonHangCapNhat()
//        + " " + thongTinLapDat.getKetQuaKhaoSat()
//        + " " + thongTinLapDat.getKetQuaLapDat()
//        + " " + thongTinLapDat.getTrangThaiLapDat()
//        + " " + thongTinLapDat.getGhiChuKhaoSatDonHang()
//        + " " + thongTinLapDat.getThoiGianHoanTat());
        String sql = " update donhang set " +
                "thoigianhoantat = (TO_TIMESTAMP(?, 'YYYY-MM-DD HH24:MI:SS'))," +
                "idfk_kq_khaosat = ?," +
                "idfk_kq_lapdat = ?," +
                "idfk_trangthai_lapdat = ?," +
                "ghichu_donhang = ? " +
                "where id_donhang = ? ";
        int soluong = jdbcTemplate.update(sql,
                thongTinLapDat.getThoiGianHoanTat(),
                thongTinLapDat.getKetQuaKhaoSat(),
                thongTinLapDat.getKetQuaLapDat(),
                thongTinLapDat.getTrangThaiLapDat(),
                thongTinLapDat.getGhiChuKhaoSatDonHang(),
                thongTinLapDat.getDonHangCapNhat()
                );
        if(soluong > 0) {
            return ResponseEntity.ok("Da cap nhat");
        }
        else {
            return  ResponseEntity.status(500).body("Loi cap nhat lap dat");
        }
    }
}
