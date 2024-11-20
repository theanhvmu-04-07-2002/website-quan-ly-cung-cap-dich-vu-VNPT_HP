package com.vnpthaiphong.dichvuvnpt.banhang.controller;

import com.vnpthaiphong.dichvuvnpt.banhang.repository.get.banhangthanhtoan.GetKhachHangThanhToan;
import com.vnpthaiphong.dichvuvnpt.banhang.repository.get.banhangthanhtoan.GetLichSuThanhToan;
import com.vnpthaiphong.dichvuvnpt.banhang.repository.get.diachi.DiaChi_PhuongXa;
import com.vnpthaiphong.dichvuvnpt.banhang.repository.get.diachi.DiaChi_QuanHuyen;
import com.vnpthaiphong.dichvuvnpt.banhang.repository.get.getthongtintaikhoan.GetThongTinTaiKhoan;
import com.vnpthaiphong.dichvuvnpt.banhang.repository.get.goidichvu.ChiTietGoiDichVu;
import com.vnpthaiphong.dichvuvnpt.banhang.repository.get.goidichvu.HinhThucTraCuoc;
import com.vnpthaiphong.dichvuvnpt.banhang.repository.get.khachhangbaohong.BaoHongDaGui;
import com.vnpthaiphong.dichvuvnpt.banhang.repository.get.khachhangbaohong.BaoHongDaSuaChua;
import com.vnpthaiphong.dichvuvnpt.banhang.repository.get.khachhangbaohong.BaoHongKyThuatTiepNhan;
import com.vnpthaiphong.dichvuvnpt.banhang.repository.get.khachhangbaohong.TrangThaiBaoHong;
import com.vnpthaiphong.dichvuvnpt.banhang.repository.get.khuyenmai.ChuongTrinhKhuyenMai;
import com.vnpthaiphong.dichvuvnpt.banhang.repository.get.nganhhang.GetNganHang;
import com.vnpthaiphong.dichvuvnpt.banhang.repository.tintuc.TinTuc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/banhang")
public class BanHangControllerGet {
    private static final Logger logger = LoggerFactory.getLogger(BanHangControllerGet.class);
    @Autowired private ChiTietGoiDichVu chiTietGoiDichVu;
    @GetMapping("/chitietgiodichvu")
    public List<Map<String, Object>> getChiTietGoiDichVu() {
//        logger.info("GDV: run");
        return chiTietGoiDichVu.getChiTietGoiDichVu();
    }
    @Autowired private TinTuc tinTuc;
    @GetMapping("/tintuc")
    public List<Map<String, Object>> getTinTuc(){
        return tinTuc.getTinTuc();
    }
    @Autowired private DiaChi_PhuongXa diaChi_PhuongXa;
    @GetMapping("/diachi/phuongxa")
    public List<Map<String, Object>> getChiTietPhuongXa() {
        return diaChi_PhuongXa.getChiTietPhuongXa();
    }
    @Autowired private DiaChi_QuanHuyen diaChi_QuanHuyen;
    @GetMapping("/diachi/quanhuyen")
    public List<Map<String, Object>> getChiTietQuanHuyen() {
        return diaChi_QuanHuyen.getChiTietQuanHuyen();
    }

    @Autowired private HinhThucTraCuoc hinhThucTraCuoc;
    @GetMapping("/goidichvu/hinhthuctracuoc")
    public  List<Map<String, Object>> getChiTietHinhThuc(){
        return hinhThucTraCuoc.getChiTietHinhThuc();

    }
    @Autowired
    private ChuongTrinhKhuyenMai chuongTrinhKhuyenMai;
    @GetMapping("/chuongtrinhkhuyenmai")
    public  List<Map<String, Object>> getChuongTrinhKhuyenMai(){
        return chuongTrinhKhuyenMai.getChuongTrinhKhuyenMai();

    }

    @Autowired private GetKhachHangThanhToan getKhachHangThanhToan;
    @GetMapping("/getkhachhangthanhtoan/{idKhachHang}")
    public ResponseEntity<?> getKhachHangThanhToanController(@PathVariable String idKhachHang) {
        List<Map<String, Object>> result = getKhachHangThanhToan.getKhachHangThanhToan(idKhachHang);
        if(result != null) {
            return ResponseEntity.status(200).body(result);
        }
        else {
            return ResponseEntity.status(401).body(Map.of("Error", "sai"));
        }
    }

    @Autowired
    private GetLichSuThanhToan getLichSuThanhToan;
    @GetMapping("/getlichsuthanhtoan/{idKhachHang}")
    public ResponseEntity<?> getChiTietLichSuThanhToan(@PathVariable String idKhachHang){
//        System.out.println("ID khach hang" + idKhachHang);
        List<Map<String, Object>> resutl = getLichSuThanhToan.getTraCuuLichSuThanhToan(idKhachHang);
        if(resutl != null) {
            return ResponseEntity.status(200).body(resutl);
        }
        else {
            return ResponseEntity.status(401).body(Map.of("Loi","loi lay du lieu lich su thanh toan"));
        }
    }


    @Autowired
    private GetThongTinTaiKhoan getThongTinTaiKhoan;
    @GetMapping("/chitiettaikhoan/{idKhachHang}")
    public ResponseEntity<?> getChiTietTaiKhoanKhachHang( @PathVariable  String idKhachHang){
        List<Map<String, Object>> thongtin = getThongTinTaiKhoan.getChiTietTaiKhoanKhachHang(idKhachHang);
        if(thongtin != null) {
            return ResponseEntity.status(200).body(thongtin);
        }
        else {
            return ResponseEntity.status(500).body(Map.of("Loi","Loi"));
        }
    }

    @Autowired
    private BaoHongDaSuaChua baoHongDaSuaChua;
    @GetMapping("/baohongdasuachua/{idKhachHang}")
    public List<Map<String , Object>> getBaoHongDaSuaChua(@PathVariable String idKhachHang){
        return baoHongDaSuaChua.getBaoHongDaSuaRepository(idKhachHang);
    }



    @Autowired
    private GetNganHang getNganHang;
    @GetMapping("/getnganhang")
    public List<Map<String, Object>> getNganHang(){
        return getNganHang.getChiTietNganHang();
    }

    @Autowired
    private TrangThaiBaoHong trangThaiBaoHong;
    @GetMapping("/gettrangthaibaohong")
    public List<Map<String, Object>> getChiTietTrangThaiBaoHong(){
        return trangThaiBaoHong.getTrangThaiBaoHong();
    }

    @Autowired
    private BaoHongDaGui baoHongDaGui;
    @GetMapping("/baohongdagui/{idKhachHang}")
    public List<Map<String, Object>> getChiTietBaoHongDaGui(@PathVariable String idKhachHang){
        return baoHongDaGui.getBaoHongDaGui(idKhachHang);
    }

    @Autowired
    private BaoHongKyThuatTiepNhan baoHongKyThuatTiepNhan;
    @GetMapping("/baohongkythuattiepnhan")
    public List<Map<String, Object>> getChiTietBaoHongKyThuatTiepNhan(){
        return baoHongKyThuatTiepNhan.getBaoHongKyThuatTiepNhan();
    }
}
