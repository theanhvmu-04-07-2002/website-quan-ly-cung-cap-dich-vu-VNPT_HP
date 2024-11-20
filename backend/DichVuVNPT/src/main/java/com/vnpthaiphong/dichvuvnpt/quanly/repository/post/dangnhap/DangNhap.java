package com.vnpthaiphong.dichvuvnpt.quanly.repository.post.dangnhap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class DangNhap {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean kiemTraDangNhap(ThongTinDangNhap thongTin) {
        String sql = "SELECT COUNT(*) FROM tk_nv WHERE taikhoan = ? AND matkhau = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, thongTin.getTenDangNhap(), thongTin.getMatKhau());
        return count != null && count > 0;
    }

    public List<Map<String, Object>> getThongTinTaiKhoan(ThongTinDangNhap thongTin) {
        if (kiemTraDangNhap(thongTin)) {
            String sql = "SELECT * FROM TK_NV WHERE taikhoan = ? AND matkhau = ?";
            List<Map<String, Object>> result = jdbcTemplate.queryForList(sql, thongTin.getTenDangNhap(), thongTin.getMatKhau());
//            System.out.println("Thong tin tai khoan - getThongTinTaiKhoan: " + result);
            return result;
        } else {
            System.out.print("NULL");
            return Collections.emptyList();
        }
    }

}
