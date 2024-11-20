package com.vnpthaiphong.dichvuvnpt.banhang.repository.post.post_hopdong;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class GetKhachHangHopDong {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @JsonProperty("ID_KhachHang")
    private String idKhachHang;

    public void setIdKhachHang(String idKhachHang) {
        this.idKhachHang = idKhachHang;
    }


    public List<Map<String, Object>> getKhachHangHopDongById() {
//        System.out.println("ID khachhang: " + idKhachHang);
        String sql = "SELECT * FROM khachhang_hopdong " +
                "JOIN hopdong ON hopdong.idfk_khachhang_hopdong = khachhang_hopdong.id_khachhang_hopdong " +
                "JOIN khachhang ON khachhang.idfk_hopdong = hopdong.id_hopdong " +
                "WHERE khachhang.id_khachhang = ?";

        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql, idKhachHang);


//        System.out.println("Ket qua ");
//        for (Map<String, Object> row : result) {
//            System.out.println(row);
//        }

        return result;
    }

}
