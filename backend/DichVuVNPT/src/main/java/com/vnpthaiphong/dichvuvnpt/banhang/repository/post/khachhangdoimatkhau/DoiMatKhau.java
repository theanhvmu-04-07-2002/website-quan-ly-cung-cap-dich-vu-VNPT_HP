package com.vnpthaiphong.dichvuvnpt.banhang.repository.post.khachhangdoimatkhau;


import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DoiMatKhau {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int KiemTraMatKhauCu(ThongTinDoiMatKhau thongTinDoiMatKhau) {
        System.out.println("TaiKhoan: "+ thongTinDoiMatKhau.getTaiKhoan());
        System.out.println("MatKhauCu: "+ thongTinDoiMatKhau.getMatKhauCu());
        System.out.println("MatKhauMoi: "+ thongTinDoiMatKhau.getMatKhauMoi());
        String sql = "select * from TK_KH where TK_KH = ? " ;
        List<Map<String, Object>> check = jdbcTemplate.queryForList(sql, thongTinDoiMatKhau.getTaiKhoan());
        if(!check.isEmpty()) {
            System.out.println("Co tim thay tai khoan");
            Map<String, Object> user = check.get(0);
            String hash_pass = (String) user.get("mk_kh");
            if(BCrypt.checkpw(thongTinDoiMatKhau.getMatKhauCu(), hash_pass)){
                return 1; // mat khau cu dung
            }
            else {
                return 2; // mat khau cu sai
            }
        }
        else {
            System.out.println("Khong tim thay tai khoan");
            return 3; // khong tim thay tai khoan
        }
    }

    public int KiemTraMatKhauMoi(ThongTinDoiMatKhau thongTinDoiMatKhau){

        if(KiemTraMatKhauCu(thongTinDoiMatKhau) == 1){
            // so sanh mat khau moi voi mat khau cu
            String sql = "select * from TK_KH where TK_KH = ? " ;
            List<Map<String, Object>> check = jdbcTemplate.queryForList(sql, thongTinDoiMatKhau.getTaiKhoan());
            if(check.isEmpty()) {
                System.out.println("Khong tim thay tai khoan");
                return 3; // khong tim thay tai khoan
            }
            else {

                System.out.println("Co tim thay tai khoan");
                Map<String, Object> user = check.get(0);
                String hash_pass = (String) user.get("mk_kh");
                if(!BCrypt.checkpw(thongTinDoiMatKhau.getMatKhauMoi(), hash_pass)){
                    System.out.println("MK moi khac MK cu");
                    return 4; // mk moi khac mk cu
                }
                else {
                    System.out.println("MK moi giong MK cu");
                    return 5; // mk moi giong mk cu
                }
            }
        }
        else {
            return 3; // khong tim thay tai khoan
        }
    }

    public ResponseEntity<Map<String, Integer>> postDoiMatKhauService(ThongTinDoiMatKhau thongTinDoiMatKhau){
        int maLoiKiemTraMKCu = KiemTraMatKhauCu(thongTinDoiMatKhau);
        if(maLoiKiemTraMKCu != 1 ){
            return ResponseEntity.badRequest().body(Map.of("data",maLoiKiemTraMKCu));
        }
        else  {
            int MaLoiKiemTraMKMoi = KiemTraMatKhauMoi(thongTinDoiMatKhau);
            if(MaLoiKiemTraMKMoi == 4){
                String salt = BCrypt.gensalt(12);
                String MatKhauMaHoa = BCrypt.hashpw(thongTinDoiMatKhau.getMatKhauMoi(), salt);
                System.out.println("Mat khau moi ma hoa: "+ MatKhauMaHoa);
                String sql = "update TK_KH set MK_KH = ? where TK_KH = ?";
                jdbcTemplate.update(sql,
                        MatKhauMaHoa,
                        thongTinDoiMatKhau.getTaiKhoan()
                        );
                return ResponseEntity.ok().body(Map.of("data",7)); // thanh cong
            }
            else {
                return ResponseEntity.badRequest().body(Map.of("data",MaLoiKiemTraMKMoi));
            }
        }
    }
//response.put(
}
