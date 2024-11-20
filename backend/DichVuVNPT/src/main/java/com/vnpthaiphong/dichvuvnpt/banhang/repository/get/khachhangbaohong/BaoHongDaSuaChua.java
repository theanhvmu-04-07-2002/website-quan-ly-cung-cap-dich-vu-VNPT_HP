package com.vnpthaiphong.dichvuvnpt.banhang.repository.get.khachhangbaohong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

@Repository
public class BaoHongDaSuaChua {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> getBaoHongDaSuaRepository(@PathVariable String idKhachHang){
        String sql = "" +
                "select bh.thoigianbaohong, suachua.thoigiansuachua, bh.id_baohong, chung.hoten_khachhang, dh.sdt_khachhang,qh.tenquanhuyen, px.tenphuongxa, dh.chitiet_khachhang,\n" +
                "     gdv.tengdv, hong.noidungbaohong, bh.chitiet_baohong, suachua.loi, suachua.suachua, lapdat.ten_kq_lapdat\n" +
                "from baohong bh\n" +
                "join khachhang kh on bh.idfk_khachhang = kh.id_khachhang\n" +
                "join thongtin_khachhang_chung chung on kh.idfk_thongtin_khachhang_chung = chung.id_thongtin_khachhang_chung\n" +
                "join noidungbaohong hong on bh.idfk_noidungbaohong = hong.id_noidungbaohong\n" +
                "join donhang dh on kh.idfk_donhang = dh.id_donhang\n" +
                "join quanhuyen qh on dh.quanhuyen_khachhang =  qh.id_quanhuyen\n" +
                "join phuongxa px on px.id_phuongxa = dh.phuongxa_khachhang\n" +
                "join goidichvu gdv on dh.goidichvu = gdv.id_gdv\n" +
                "join suachua_baohong suachua on suachua.idfk_baohong = bh.id_baohong\n" +
                "join kq_lapdat lapdat on suachua.ketquasuachua = lapdat.id_kq_lapdat\n" +
                "where kh.id_khachhang = ? \n";
        return jdbcTemplate.queryForList(sql, idKhachHang);
    }
}
