package com.vnpthaiphong.dichvuvnpt.banhang.repository.get.banhangthanhtoan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GetKhachHangThanhToan {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> getKhachHangThanhToan(String idKhachHang){
        String sql = "select chung.hoten_khachhang,khhd.DIACHI_THUONGTRU, chung.sdt_khachhang, " +
                "    khhd.taikhoanso, khhd.tainganhang, khhd.masothue, " +
                "    gdv.tengdv, gdv.GiaNiemYet1 " +
                " from thongtin_khachhang_chung chung " +
                " join hopdong hd on hd.idfk_thongtin_khachhang_chung = chung.id_thongtin_khachhang_chung" +
                " join khachhang_hopdong khhd on hd.idfk_khachhang_hopdong = khhd.id_khachhang_hopdong" +
                " join khachhang kh on kh.idfk_hopdong = hd.id_hopdong" +
                " join donhang dh on kh.idfk_donhang = dh.id_donhang" +
                " join goidichvu gdv on dh.goidichvu = gdv.id_gdv" +
                " where kh.id_khachhang = ? ";
        return  jdbcTemplate.queryForList(sql, idKhachHang);
    }
}
