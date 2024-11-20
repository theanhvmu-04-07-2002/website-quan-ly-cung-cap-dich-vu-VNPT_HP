package com.vnpthaiphong.dichvuvnpt.banhang.repository.post.DangNhap;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class TaoVaXacMinhJWT {

    private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256); // Tạo SecretKey

    // Hàm xác minh Refresh Token và lấy thông tin người dùng
    public String validateToken(String token) {
        try {
            Claims claims = Jwts.parserBuilder() // Cập nhật parser thành parserBuilder
                    .setSigningKey(SECRET_KEY) // Sử dụng Key thay vì String
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            // Lấy thông tin userId từ token
            return claims.getSubject(); // Lấy userId từ phần subject của token

        } catch (Exception e) {
            throw new RuntimeException("Token không hợp lệ");
        }
    }

    // Hàm tạo Access Token với thông tin người dùng
    public String generateAccessToken(String id_taikhoan_khachhang, String id_khachhang) {
        String token =  Jwts.builder()
                .setSubject(id_taikhoan_khachhang)
//                .claim("taikhoan_khachhang", taikhoan_khachhang)  Thêm thông tin username vào claim
                .claim("id_khachhang", id_khachhang) // Thêm thông tin customerId vào claim
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 giờ
                .signWith(SECRET_KEY) // Sử dụng Key thay vì String
                .compact();
        System.out.println("Da tao token: " + token);
        return token;
    }

    // Hàm tạo Refresh Token với thông tin người dùng (Refresh Token có thời gian hết hạn dài hơn)
    public String generateRefreshToken(String userId) {
        return Jwts.builder()
                .setSubject(userId) // Thêm thông tin userId vào subject
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 3)) // 30 ngày
                .signWith(SECRET_KEY) // Sử dụng Key thay vì String
                .compact();
    }
}
