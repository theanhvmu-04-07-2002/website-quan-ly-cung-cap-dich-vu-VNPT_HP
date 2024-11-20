package com.vnpthaiphong.dichvuvnpt.banhang.repository.post.YeuCauDonHang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class YeuCauDonHang {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ResponseEntity<String> processYeuCau(ThongTinKhachHang thongTinKhachHang) {
//        System.out.println("Du lieu nhan duoc insert:" + thongTinKhachHang);
        String sql = "INSERT INTO DONHANG (THOIGIANTAO, HOTEN_KHACHHANG, SDT_KHACHHANG, EMAIL_KHACHHANG, " +
                "QUANHUYEN_KHACHHANG, PHUONGXA_KHACHHANG, CHITIET_KHACHHANG, " +
                "GHICHU_KHACHHANG, HINHTHUCTRACUOC, GOIDICHVU, IDFK_TRANGTHAI_DONHANG) " +
                "VALUES (TO_TIMESTAMP(?, 'YYYY-MM-DD HH24:MI:SS'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        int result = jdbcTemplate.update(sql,
                thongTinKhachHang.getThoiGianTao(),
                thongTinKhachHang.getHoTenKhachHang(),
                thongTinKhachHang.getSDTKhachhang(),
                thongTinKhachHang.getEmailKhachhang(),
                thongTinKhachHang.getQuanHuyenKhachHang(),
                thongTinKhachHang.getPhuongXaKhachHang(),
                thongTinKhachHang.getChiTietKhachHang(),
                thongTinKhachHang.getGhiChuKhachHang(),
                thongTinKhachHang.getHinhThucTraCuoc(),
                thongTinKhachHang.getGoiDichVu(),
                thongTinKhachHang.getTrangThaiDonHang()
                );

        if (result > 0) {
            return ResponseEntity.ok("ok");
        } else {
            return ResponseEntity.status(500).body("Loi");
        }
    }
}
