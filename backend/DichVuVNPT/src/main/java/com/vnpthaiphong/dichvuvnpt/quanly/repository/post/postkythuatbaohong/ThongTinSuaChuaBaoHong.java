package com.vnpthaiphong.dichvuvnpt.quanly.repository.post.postkythuatbaohong;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ThongTinSuaChuaBaoHong {

    @JsonProperty("ThoiGianSuaChua")
    private String thoiGianSuaChua;

    @JsonProperty("IDFK_BaoHong")
    private String idfkBaoHong;

    @JsonProperty("Loi")
    private String loi;

    @JsonProperty("SuaChua")
    private String suaChua;

    @JsonProperty("KetQuaSuaChua")
    private String ketQuaSuaChua;

}
