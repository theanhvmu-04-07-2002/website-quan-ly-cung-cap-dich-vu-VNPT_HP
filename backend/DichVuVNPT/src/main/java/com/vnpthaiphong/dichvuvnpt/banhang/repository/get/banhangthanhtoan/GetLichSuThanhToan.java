package com.vnpthaiphong.dichvuvnpt.banhang.repository.get.banhangthanhtoan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GetLichSuThanhToan {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> getTraCuuLichSuThanhToan(String idKhachHang) {
        String sql = "select hoadon.ID_HOADONGTGT, to_char(hoadon.THOIGIANTHANHTOAN,'hh24:mi:ss dd/mm/yyyy') as THOIGIANTHANHTOAN ,  " +
                "chung.HOTEN_KHACHHANG," +
                " hoadon.TENTAIKHOANTHANHTOAN, hoadon.SOTAIKHOANTHANHTOAN, nganhang.TENNGANHANG," +
                " gdv.TENGDV, hoadon.SOLUONG, hoadon.THANHTIENGDV, hoadon.TIENTHUEGTGT, hoadon.TONGCONGTIENTHANHTOAN " +
                " from HOADONGTGT hoadon" +
                " join KHACHHANG kh on hoadon.ID_KHACHHANG = kh.ID_KHACHHANG" +
                " join THONGTIN_KHACHHANG_CHUNG chung on kh.IDFK_THONGTIN_KHACHHANG_CHUNG = chung.ID_THONGTIN_KHACHHANG_CHUNG" +
                " join NGANHANG on hoadon.IDFK_NGANHANG = NGANHANG.ID_NGANHANG " +
                " join DONHANG on kh.IDFK_DONHANG = DONHANG.ID_DONHANG" +
                " join GOIDICHVU gdv on donhang.GOIDICHVU = gdv.ID_GDV" +
                " where kh.ID_KHACHHANG = ? ";
        return jdbcTemplate.queryForList(sql, idKhachHang);
    }
}
