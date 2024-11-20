package com.vnpthaiphong.dichvuvnpt.quanly.repository.post.quanlydonhang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class CapNhatDonHang {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ResponseEntity<String> getCapNhatDonHang(ThongTinCapNhat thongTinCapNhat){
        try {
            String sql = "UPDATE DONHANG SET "
                    +" HOTEN_KHACHHANG = ?,"
                    +" SDT_KHACHHANG = ?,"
                    +" EMAIL_KHACHHANG = ?,"
                    +" QUANHUYEN_KHACHHANG = ?," +
                    " PHUONGXA_KHACHHANG = ?," +
                    " HINHTHUCTRACUOC = ?," +
                    " GOIDICHVU =?," +
                    " CHITIET_KHACHHANG=?," +
                    " GHICHU_KHACHHANG=?, " +
                    " IDFK_TRANGTHAI_DONHANG=? " +

                    " WHERE ID_DONHANG = ?"

                    ;
            int result = jdbcTemplate.update(sql,
                    thongTinCapNhat.getHoTenKhachHang(),
                    thongTinCapNhat.getSDTKhachHang(),
                    thongTinCapNhat.getEmailKhachHang(),
                    thongTinCapNhat.getQuanHuyenKhachHang(),
                    thongTinCapNhat.getPhuongXaKhachHang(),
                    thongTinCapNhat.getHinhThucTraCuoc(),
                    thongTinCapNhat.getGoiDichVu(),
                    thongTinCapNhat.getChiTietKhachHang(),
                    thongTinCapNhat.getGhiChuKhachHang(),
                    thongTinCapNhat.getTrangThaiDonHang(),
                    thongTinCapNhat.getDonHang()

            );
            if(result>0){
                return  ResponseEntity.ok("cap nhat thanh cong");
            }
            else {
                return ResponseEntity.status(500).body("Cap nhat that bai");
            }
        }
        catch (Exception error) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("loi cap nhat don hang: " + error.getMessage());
        }
    }

}
