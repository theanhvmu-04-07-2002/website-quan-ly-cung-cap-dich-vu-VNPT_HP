package com.vnpthaiphong.dichvuvnpt.banhang.repository.post.banhang_hopdong;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ThongTinHopDongThongBao {
    @JsonProperty("IDFKHopDong")
    private String idfkHopDong;

    @JsonProperty("IDFKHinhThucThongBao")
    private List<Integer> idfkHinhThucThongBao;
}
