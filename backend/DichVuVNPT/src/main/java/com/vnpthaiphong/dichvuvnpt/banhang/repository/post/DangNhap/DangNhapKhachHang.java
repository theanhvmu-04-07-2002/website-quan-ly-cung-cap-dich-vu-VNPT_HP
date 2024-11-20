package com.vnpthaiphong.dichvuvnpt.banhang.repository.post.DangNhap;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DangNhapKhachHang {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private TaoVaXacMinhJWT taoVaXacMinhJWT;

    public Map<String, Object> dangNhap(ThongTinDangNhapKhachHang thongTinDangNhapKhachHang) {

        System.out.println("TK BE nhan: {" + thongTinDangNhapKhachHang.getTenDangNhap() + "}");
        System.out.println("MK BE nhan: {" + thongTinDangNhapKhachHang.getMatKhau() + "}");
        String sql = "SELECT TK_KH.ID_TK_KH,  tk_kh.tk_kh, tk_kh.mk_kh, khachhang.id_khachhang " +
                "FROM tk_kh " +
                "JOIN khachhang ON khachhang.idfk_tk_kh = tk_kh.id_tk_kh " +
                "WHERE tk_kh.tk_kh = ?";


        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql, thongTinDangNhapKhachHang.getTenDangNhap());


        if (result.isEmpty()) {
            System.out.println("Khong tim thay tai khoan");
            throw new RuntimeException("Sai tai khoan");
        }
        System.out.println("Co tim thay tai khoan");

        Map<String, Object> user = result.get(0);
        String hash_pass = (String) user.get("mk_kh");
        System.out.println("MK ma hoa trong DB: " + hash_pass);

        // Kiểm tra mật khẩu
        if (!BCrypt.checkpw(thongTinDangNhapKhachHang.getMatKhau(), hash_pass)) {
            System.out.println("Mat khau sai ");
            throw new RuntimeException("Sai mat khau");
        }

        System.out.println("Mat khau dung ");

        // lay thong tin
        try {
            String id_taikhoan_khachhang = user.get("id_tk_kh").toString();
//        String taikhoan_khachhang = user.get("tk_kh").toString();
            String id_khachhang = user.get("id_khachhang").toString();

            // Tao cac token
            String accessToken = taoVaXacMinhJWT.generateAccessToken(id_taikhoan_khachhang, id_khachhang);
            String refreshToken = taoVaXacMinhJWT.generateRefreshToken(id_khachhang);

            // Kiểm tra thông tin token
            System.out.println("Access Token: " + accessToken);
            System.out.println("Refresh Token: " + refreshToken);

            // data
            Map<String, Object> response = new HashMap<>();
            response.put("accessToken", accessToken);
            response.put("refreshToken", refreshToken);


            System.out.println("Response gui ve FE: " + response);
            return response;
        }
        catch (Exception e){
            System.out.println("Loi token: " + e.getMessage());
            throw  new RuntimeException("Loi token");
        }
    }
}
