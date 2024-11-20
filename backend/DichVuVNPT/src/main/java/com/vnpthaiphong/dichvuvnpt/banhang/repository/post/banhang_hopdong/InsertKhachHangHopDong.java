package com.vnpthaiphong.dichvuvnpt.banhang.repository.post.banhang_hopdong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

@Service
public class InsertKhachHangHopDong {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ResponseEntity<Map<String, Object>> getInsertKhachHangHopDong(ThongTinKhachHangHopDong thongTinKhachHangHopDong){
        String sql = "insert into KHACHHANG_HOPDONG(CHUCVU, NGAYSINH, GIOITINH, SO_CCCD, NGAYCAP_CCCD, NOICAP_CCCD, SO_GIAYCHUNGNHAN, NGAYCAP_GIAYCHUNGNHAN, NOICAP_GIAYCHUNGNHAN, DIACHI_THANHTOAN, DIACHI_TRUSOGIAODICH, TAIKHOANSO, TAINGANHANG, MASOTHUE, LIENHEKHAC, DIACHI_THUONGTRU) " +
                " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int truyvan =jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id_khachhang_hopdong"});
            ps.setString(1, thongTinKhachHangHopDong.getChucVu());
            ps.setString(2, thongTinKhachHangHopDong.getNgaySinh());
            ps.setString(3, thongTinKhachHangHopDong.getGioiTinh());
            ps.setString(4, thongTinKhachHangHopDong.getSoCCCD());
            ps.setString(5, thongTinKhachHangHopDong.getNgayCapCCCD());
            ps.setString(6, thongTinKhachHangHopDong.getNoiCapCCCD());
            ps.setString(7, thongTinKhachHangHopDong.getSoGiayChungNhan());
            ps.setString(8, thongTinKhachHangHopDong.getNgayCapGCN());
            ps.setString(9, thongTinKhachHangHopDong.getNoiCapGCN());
            ps.setString(10, thongTinKhachHangHopDong.getDiaChiThanhToan());
            ps.setString(11, thongTinKhachHangHopDong.getTruSoGiaoDich());
            ps.setString(12, thongTinKhachHangHopDong.getTaiKhoanSo());
            ps.setString(13, thongTinKhachHangHopDong.getTaiNganHang());
            ps.setString(14, thongTinKhachHangHopDong.getMaSoThue());
            ps.setString(15, thongTinKhachHangHopDong.getLienHeKhac());
            ps.setString(16, thongTinKhachHangHopDong.getDiaChiThuongTru());
            return ps;
        }, keyHolder);
        if (truyvan > 0) {
            Number IDFK_KhachHangHopDong = keyHolder.getKey();
//            System.out.println("IDFK_KhachHangHopDong: " + IDFK_KhachHangHopDong);

            Map<String, Object> response = new HashMap<>();
            response.put("IDFK_KhachHangHopDong", IDFK_KhachHangHopDong);
            return ResponseEntity.status(200).body(response);
        } else {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "sai thong tin");
            return ResponseEntity.status(400).body(errorResponse);
        }
    }
}
