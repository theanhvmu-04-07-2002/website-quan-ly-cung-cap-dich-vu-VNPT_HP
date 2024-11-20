package com.vnpthaiphong.dichvuvnpt.banhang.repository.post.banhang_hopdong;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ThongTinHopDongThanhToan {
    @JsonProperty("IDFKHopDong")
    private String idfkHopDong;

    @JsonProperty("IDFKHinhThucThanhToan")
    private List<Integer> idfkHinhThucThanhToan;
}
