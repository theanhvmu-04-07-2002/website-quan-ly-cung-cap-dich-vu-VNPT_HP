package com.vnpthaiphong.dichvuvnpt.quanly.repository.post.insert_taikhoankhachhang;

import com.vnpthaiphong.dichvuvnpt.quanly.repository.post.insert_taikhoankhachhang.ThongTinTaiKhoanKhachHangInsert;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.security.SecureRandom;
import java.sql.PreparedStatement;
import java.util.*;

@Repository
public class InsertTaiKhoanKhachHang {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final char[] MangMatKhau = {'a','b','c','d','e','f','k','A', 'B','C','D','E','F','K','1','2','3','4','5','6','7','8','9','0'};
    private static final int DoDaiMK = 5;

    public static String RamdomMatKhau() {
        Random random = new SecureRandom();
        StringBuilder matkhau = new StringBuilder(DoDaiMK);
        for (int i = 0; i < DoDaiMK; i++) {
            int index = random.nextInt(MangMatKhau.length);
            matkhau.append(MangMatKhau[index]);
        }
        String MatKhauBanDau = matkhau.toString();
        System.out.println("MatKhauBanDau 1: " + MatKhauBanDau);
        return MatKhauBanDau;
    }

    public static String MaHoaMatKhau(String matkhau, int factor) {
        String salt = BCrypt.gensalt(factor);
        String MatKhauMaHoa = BCrypt.hashpw(matkhau, salt);

        return MatKhauMaHoa;
    }

    public ResponseEntity<Map<String, Object>> postInsertTaiKhoanKhachHang(ThongTinTaiKhoanKhachHangInsert thongTinTaiKhoanKhachHangInsert) {
//        tao mat khau ban dau + ma hoa
        String matKhauBanDau = RamdomMatKhau();
        String matKhauMaHoa = MaHoaMatKhau(matKhauBanDau, 12);
        System.out.println("MatKhauBanDau 1: " + matKhauBanDau);
        System.out.println("TaiKhoanBanDau 1: " + thongTinTaiKhoanKhachHangInsert.getTaiKhoan());
        String sql = "insert into tk_kh(tk_kh, MK_KH, IDFK_PHANQUYEN) values (?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int truyvan = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[]{"ID_TK_KH"});
            ps.setString(1, thongTinTaiKhoanKhachHangInsert.getTaiKhoan());
            ps.setString(2, matKhauMaHoa);
            ps.setString(3, thongTinTaiKhoanKhachHangInsert.getPhanQuyen());
            return ps;
        }, keyHolder);

        if (truyvan > 0) {
            Number IDFK_TK_KH = keyHolder.getKey();
            Map<String, Object> response = new HashMap<>();
            response.put("IDFK_TaiKhoan_KhachHang", IDFK_TK_KH);
            return ResponseEntity.status(200).body(response);
        } else {
            return ResponseEntity.status(401).body(Map.of("Loi", "Loi server"));
        }
    }
}
