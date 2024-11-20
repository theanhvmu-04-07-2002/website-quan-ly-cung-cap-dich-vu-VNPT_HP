package com.vnpthaiphong.dichvuvnpt.banhang.controller;

import com.vnpthaiphong.dichvuvnpt.banhang.repository.get.hopdong_khachhang.GetIDFKHopDongFromKhachHang;
import com.vnpthaiphong.dichvuvnpt.banhang.repository.get.hopdong_khachhang.Get_BanHang_ThongTin_KhachHang_Chung;
import com.vnpthaiphong.dichvuvnpt.banhang.repository.get.khachhangbaohong.DuLieuBaoHong;
import com.vnpthaiphong.dichvuvnpt.banhang.repository.get.khachhangbaohong.InsertBaoHong;
import com.vnpthaiphong.dichvuvnpt.banhang.repository.post.DangNhap.DangNhapKhachHang;
import com.vnpthaiphong.dichvuvnpt.banhang.repository.post.DangNhap.TaoVaXacMinhJWT;
import com.vnpthaiphong.dichvuvnpt.banhang.repository.post.DangNhap.ThongTinDangNhapKhachHang;
import com.vnpthaiphong.dichvuvnpt.banhang.repository.post.InsertHoaDon.InsertHoaDon;
import com.vnpthaiphong.dichvuvnpt.banhang.repository.post.InsertHoaDon.ThongTinHoaDon;
import com.vnpthaiphong.dichvuvnpt.banhang.repository.post.YeuCauDonHang.ThongTinKhachHang;
import com.vnpthaiphong.dichvuvnpt.banhang.repository.post.YeuCauDonHang.YeuCauDonHang;
import com.vnpthaiphong.dichvuvnpt.banhang.repository.post.banhang_hopdong.*;
import com.vnpthaiphong.dichvuvnpt.banhang.repository.post.khachhangdoimatkhau.DoiMatKhau;
import com.vnpthaiphong.dichvuvnpt.banhang.repository.post.khachhangdoimatkhau.ThongTinDoiMatKhau;
import com.vnpthaiphong.dichvuvnpt.banhang.repository.post.post_hopdong.GetKhachHangHopDong;
import com.vnpthaiphong.dichvuvnpt.banhang.repository.post.post_hopdong.Post_HopDong_DichVu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/banhang")
public class BanHangControllerPost {

    @Autowired
    private YeuCauDonHang yeuCauDonHang;

    @PostMapping("/yeucaudonhang")
    public ResponseEntity<String> yeucaudonhang(@RequestBody ThongTinKhachHang thongTinKhachHang) {
//        System.out.println("controller post - don hang: "+thongTinKhachHang);
        return yeuCauDonHang.processYeuCau(thongTinKhachHang);
        }


    @Autowired
    private Post_HopDong_DichVu postHopDongDichVu;

    @PostMapping("/getHopDong/{idKhachHang}")
    public ResponseEntity<List<Map<String, Object>>> getHopDong(@PathVariable String idKhachHang) {
        postHopDongDichVu.setIdKhachHang(idKhachHang);
        List<Map<String, Object>> hopDong = postHopDongDichVu.getHopDongDichVu();
        return ResponseEntity.ok(hopDong);
    }

    @Autowired
    private GetIDFKHopDongFromKhachHang getIDFKHopDongFromKhachHang;
    @PostMapping("/idfkhopdongfromkhachhang/{idKhachHang}")
    public ResponseEntity<List<Map<String, Object>>> getIDFKHopDong(
            @PathVariable String idKhachHang) {
        List<Map<String, Object>> idfkHopDong = getIDFKHopDongFromKhachHang.getIDFKHopDongFromKhachHang(idKhachHang);
        return ResponseEntity.ok(idfkHopDong);
    }

    @Autowired
    private LayDuLieuKhachHangChungHopDong layDuLieuKhachHangChungHopDong;
    @PostMapping("/laydulieukhachhanghopdong/{idKhachHang}")
    public ResponseEntity<List<Map<String, Object>>> getLayDuLieuKhachHangChungHopDong(
            @PathVariable String idKhachHang) {
        List<Map<String, Object>> DuLieuKhachHangHopDong = layDuLieuKhachHangChungHopDong.getLayDuLieuKhachHangChung(idKhachHang);
        return  ResponseEntity.ok(DuLieuKhachHangHopDong);
    }


    @Autowired
    private Get_BanHang_ThongTin_KhachHang_Chung get_banHang_thongTin_khachHang_chung;
    @PostMapping("/getthongtinkhachhangchung/{idKhachHang}")
    public ResponseEntity<List<Map<String, Object>>> getThongTinKhachHangChung(@PathVariable String idKhachHang) {
        get_banHang_thongTin_khachHang_chung.setIdKhachHang(idKhachHang);
        List<Map<String, Object>> hopDong = get_banHang_thongTin_khachHang_chung.getThongTinKhachHangChung();
        return ResponseEntity.ok(hopDong);
    }
    @Autowired
    private GetKhachHangHopDong getKhachHangHopDong;

    @PostMapping("/getkhachhanghopdong/{idKhachHang}")
    public ResponseEntity<List<Map<String, Object>>> getKhachHangHopDong(@PathVariable String idKhachHang) {
        getKhachHangHopDong.setIdKhachHang(idKhachHang);
        List<Map<String, Object>> khachHangHopDong = getKhachHangHopDong.getKhachHangHopDongById();
        return ResponseEntity.ok(khachHangHopDong);
    }



    @Autowired
    private InsertKhachHangHopDong insertKhachHangHopDong;
    @PostMapping("/insertkhachhanghopdong")
    public ResponseEntity<Map<String, Object>> getInsertKhachHangHopDong(@RequestBody ThongTinKhachHangHopDong thongTinKhachHangHopDong){
        return insertKhachHangHopDong.getInsertKhachHangHopDong(thongTinKhachHangHopDong);
    }

    @Autowired
    private InsertHopDong insertHopDong;
    @PostMapping("/inserthopdong")
    public ResponseEntity<Map<String, Object>> getInsertHopDong(@RequestBody ThongTinHopDong thongTinHopDong){
        return insertHopDong.getInsertHopDong((thongTinHopDong));
    }

    @Autowired
    private InsertHopDongThanhToan insertHopDongThanhToan;
    @PostMapping("inserthopdongthanhtoan")
    public ResponseEntity<String> getInsertHopDongThanhToan( @RequestBody ThongTinHopDongThanhToan thongTinHopDongThanhToan){
        return insertHopDongThanhToan.getInsertHopDongThanhToan(thongTinHopDongThanhToan);
    }

    @Autowired
    private InsertHopDongThongBao insertHopDongThongBao;
    @PostMapping("inserthopdongthongbao")
    public ResponseEntity<String> getInsertHopDongThongBao( @RequestBody ThongTinHopDongThongBao thongTinHopDongThongBao){
        return insertHopDongThongBao.getInsertHopDongThongBao(thongTinHopDongThongBao);
    }

    @Autowired
    private InsertIDFKHopDongToKhachHang insertHopDongToKhachHang;
    @PostMapping("/inserthopdongkhachhang")
    public ResponseEntity<String> getInsertHopDongToKhachHang(@RequestBody ThongTinInsertHopDongToKhachHang thongTinInsertHopDongToKhachHang){
//        System.out.println("du lieu controller Be nhan: " +thongTinInsertHopDongToKhachHang);
        return insertHopDongToKhachHang.getInsertHopDongToKhachHang(thongTinInsertHopDongToKhachHang);
    }

    @Autowired
    private InsertHoaDon insertHoaDon;
    @PostMapping("/inserhoadon")
    public ResponseEntity<String> postInsertHopDong(@RequestBody ThongTinHoaDon thongTinHoaDon){
        return insertHoaDon.postInsertHoaDon(thongTinHoaDon);
    }



    @Autowired
    private DangNhapKhachHang dangNhapKhachHang;

    @Autowired
    private TaoVaXacMinhJWT taoVaXacMinhJWT;

    @PostMapping("dangnhapkhachhang")
    public ResponseEntity<Map<String, Object>> login(@RequestBody ThongTinDangNhapKhachHang thongTinDangNhapKhachHang) {
        try {
            Map<String, Object> response = dangNhapKhachHang.dangNhap(thongTinDangNhapKhachHang);
            return ResponseEntity.ok(response); // Trả về mã 200 OK khi đăng nhập thành công
        } catch (RuntimeException e) {
            // Trả về mã 400 Bad Request nếu tài khoản hoặc mật khẩu sai
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message", e.getMessage()));
        }
    }

    @PostMapping("dangnhapkhachhang/refreshJWT")
    public ResponseEntity<Map<String, Object>> refreshToken(@RequestBody Map<String, String> refreshTokenRequest) {
        String refreshToken = refreshTokenRequest.get("refreshToken");

        try {
            // Kiểm tra và xác minh Refresh Token, lấy thông tin người dùng
            String userId = taoVaXacMinhJWT.validateToken(refreshToken);

            // Tạo Access Token mới với thông tin người dùng
            // Cần đảm bảo phương thức validateToken trả về thông tin người dùng, hoặc có thể thêm bước lấy thông tin người dùng từ DB nếu cần
//            String username = "user_example"; // Giả sử lấy từ DB nếu không có trong token
            String customerId = "customer_example"; // Giả sử lấy từ DB nếu không có trong token

            String newAccessToken = taoVaXacMinhJWT.generateAccessToken(userId, customerId);

            // Chuẩn bị phản hồi
            Map<String, Object> response = new HashMap<>();
            response.put("accessToken", newAccessToken);
            response.put("refreshToken", refreshToken); // Optionally return refreshToken for client

            return ResponseEntity.ok(response); // Trả về mã 200 OK khi tạo Access Token mới
        } catch (Exception e) {
            // Trả về mã 403 Forbidden nếu Refresh Token không hợp lệ
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(Map.of("message", "Refresh Token không hợp lệ hoặc đã hết hạn"));
        }
    }

    @Autowired
    private InsertBaoHong insertBaoHong;
    @PostMapping("/insertbaohong")
    public ResponseEntity<String> postInsertChiTietBaoHong(@RequestBody DuLieuBaoHong duLieuBaoHong){
        return insertBaoHong.postInsertBaoHong(duLieuBaoHong);
    }

    @Autowired
    private DoiMatKhau doiMatKhau;
    @PostMapping("/khachhangdoimatkhau")
    public ResponseEntity<Map<String, Integer>> postKhachHangDoiMatKhau(@RequestBody ThongTinDoiMatKhau thongTinDoiMatKhau){
        return doiMatKhau.postDoiMatKhauService(thongTinDoiMatKhau);
    }



}


