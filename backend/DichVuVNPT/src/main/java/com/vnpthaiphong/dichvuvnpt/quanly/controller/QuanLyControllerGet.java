package com.vnpthaiphong.dichvuvnpt.quanly.controller;

import com.vnpthaiphong.dichvuvnpt.quanly.repository.get.hopdong.HopDongBenB;
import com.vnpthaiphong.dichvuvnpt.quanly.repository.get.khaosat.KetQuaKhaoSat;
import com.vnpthaiphong.dichvuvnpt.quanly.repository.get.lapdat.KetQuaLapDat;
import com.vnpthaiphong.dichvuvnpt.quanly.repository.get.quanlydonhang.ThongTinDonHang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/quanly")
public class QuanLyControllerGet {
    @Autowired private ThongTinDonHang thongTinDonHang;
    @GetMapping("/thongtindonhang")
    public List<Map<String, Object>> getThongTinDonHang(){
        return thongTinDonHang.getThongTinDonHang();
    }

    @Autowired private KetQuaLapDat ketQuaLapDat;
    @GetMapping("/ketqualapdat")
    public List<Map<String,Object>> getKetQuaLapDat(){
        return ketQuaLapDat.getKetQuaLapDat();
    }

    @Autowired private KetQuaKhaoSat ketQuaKhaoSat;
    @GetMapping("/ketquakhaosat")
    public List<Map<String, Object>> getKetQuaKhaoSat(){
        return  ketQuaKhaoSat.getKetQuaKhaoSat();
    }

    @Autowired
    private HopDongBenB hopDongBenB;
    @GetMapping("hopdongbenb")
    public List<Map<String, Object>> getHopDongBenB(){
        return  hopDongBenB.getHopDongBenB();
    }
}
