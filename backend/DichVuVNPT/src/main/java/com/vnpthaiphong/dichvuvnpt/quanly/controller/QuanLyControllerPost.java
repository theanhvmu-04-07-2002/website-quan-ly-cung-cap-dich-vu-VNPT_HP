    package com.vnpthaiphong.dichvuvnpt.quanly.controller;

    import com.vnpthaiphong.dichvuvnpt.quanly.repository.post.InsertKhachHang.InsertKhachHang;
    import com.vnpthaiphong.dichvuvnpt.quanly.repository.post.InsertKhachHang.ThongTinKhachHangInsert;
    import com.vnpthaiphong.dichvuvnpt.quanly.repository.post.insert_taikhoankhachhang.InsertTaiKhoanKhachHang;
    import com.vnpthaiphong.dichvuvnpt.quanly.repository.post.insert_taikhoankhachhang.ThongTinTaiKhoanKhachHangInsert;
    import com.vnpthaiphong.dichvuvnpt.quanly.repository.post.insert_thongtinkhachhangchung.InsertThongTinKhachHangChung;
    import com.vnpthaiphong.dichvuvnpt.quanly.repository.post.insert_thongtinkhachhangchung.ThongTinKhachHangChung;
    import com.vnpthaiphong.dichvuvnpt.quanly.repository.post.dangnhap.DangNhap;
    import com.vnpthaiphong.dichvuvnpt.quanly.repository.post.dangnhap.ThongTinDangNhap;
    import com.vnpthaiphong.dichvuvnpt.quanly.repository.post.postkythuatbaohong.InsertSuaChuaBaoHong;
    import com.vnpthaiphong.dichvuvnpt.quanly.repository.post.postkythuatbaohong.ThongTinSuaChuaBaoHong;
    import com.vnpthaiphong.dichvuvnpt.quanly.repository.post.quanlydonhang.CapNhatDonHang;
    import com.vnpthaiphong.dichvuvnpt.quanly.repository.post.quanlydonhang.CapNhatLapDat;
    import com.vnpthaiphong.dichvuvnpt.quanly.repository.post.quanlydonhang.ThongTinCapNhat;
    import com.vnpthaiphong.dichvuvnpt.quanly.repository.post.quanlydonhang.ThongTinLapDat;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;

    import java.util.List;
    import java.util.Map;

    @RestController
    @RequestMapping("/api/quanly")
    public class QuanLyControllerPost {

        @Autowired
        private DangNhap dangNhap;

        @PostMapping("/thongtintaikhoan")
        public ResponseEntity<?> getThongTinTaiKhoan(@RequestBody ThongTinDangNhap thongTin) {
    //        System.out.println("Nhận dữ liệu đăng nhập: " + thongTin);
            boolean isLoginSuccessful = dangNhap.kiemTraDangNhap(thongTin);
            if (!isLoginSuccessful) {
                return ResponseEntity.status(401).body("Đăng nhập thất bại");
            }
            List<Map<String, Object>> thongTinTaiKhoan = dangNhap.getThongTinTaiKhoan(thongTin);
    //        System.out.println("Thông tin tài khoản: " + thongTinTaiKhoan);
            return thongTinTaiKhoan.isEmpty() ? ResponseEntity.ok(null) : ResponseEntity.ok(thongTinTaiKhoan);
        }

        @PostMapping("/dangnhap")
        public ResponseEntity<?> getDangNhap(@RequestBody ThongTinDangNhap thongTin) {
            return getThongTinTaiKhoan(thongTin);
        }

        @Autowired
        private CapNhatDonHang capNhatDonHang;

        @PostMapping("quanlybanhang/capnhatdonhang")
        public ResponseEntity<String> getCapNhatDonHang(@RequestBody ThongTinCapNhat thongTinCapNhat) {
            return capNhatDonHang.getCapNhatDonHang(thongTinCapNhat);
        }

        @Autowired
        private CapNhatLapDat capNhatLapDat;

        @PostMapping("quanlykythuat/capnhatlapdat")
        public ResponseEntity<String> getCapNhatLapDat(@RequestBody ThongTinLapDat thongTinLapDat) {
            return capNhatLapDat.getCapNhatLapDat(thongTinLapDat);
        }

//    @Autowired
//    private InsertTaiKhoanKhachHang insertTaiKhoanKhachHang;
//
//    @PostMapping("quanlykythuat/inserttaikhoankhachhang")
//    public ResponseEntity<Map<String, Object>> getInsertTaiKhoanKhachHang(@RequestBody ThongTinTaiKhoanKhachHang thongTinTaiKhoanKhachHang) {
//        return insertTaiKhoanKhachHang.getInsertTaiKhoanKhachHang(thongTinTaiKhoanKhachHang);
//    }

    @Autowired
    private InsertThongTinKhachHangChung insertThongTinKhachHangChung;
    @PostMapping("quanlykythuat/insertthongtinkhachhangchung")
    public ResponseEntity<Map<String, Object>> getInsertThongTinKhachHangChung(@RequestBody ThongTinKhachHangChung thongTinKhachHangChung){
        return  insertThongTinKhachHangChung.getInsertThongTinKhachHangChung(thongTinKhachHangChung);
    }

    @Autowired
    private InsertKhachHang insertKhachHang;
    @PostMapping ("/quanlykythuat/insertkhachhang")
    public ResponseEntity<String> getInsertKhachHang(@RequestBody ThongTinKhachHangInsert thongTinKhachHangInsert){
        return insertKhachHang.getInsertKhachHang(thongTinKhachHangInsert);
    }

    @Autowired
    private InsertTaiKhoanKhachHang insertTaiKhoanKhachHang;
    @PostMapping("/quanlykythuat/inserttaikhoankhachhang")
    public ResponseEntity<Map<String, Object>> postInserttaikhoankhachhang(@RequestBody ThongTinTaiKhoanKhachHangInsert thongTinTaiKhoanKhachHangInsert){
        return insertTaiKhoanKhachHang.postInsertTaiKhoanKhachHang(thongTinTaiKhoanKhachHangInsert);
    }

    @Autowired
    private InsertSuaChuaBaoHong insertSuaChuaBaoHong;
    @PostMapping("/insertsuachuabaohong")
    public ResponseEntity<String> postInsertChiTietBaoHong(@RequestBody ThongTinSuaChuaBaoHong thongTinSuaChuaBaoHong) {
        return insertSuaChuaBaoHong.postInsertSuaChuaBaoHongService(thongTinSuaChuaBaoHong);
    }
}
