<template>
  <div class="content">
    <div class="header">
        <BanHang_Header />
    </div>
    <div class="maincontent">
        <div class="dieuhuong">
            <ul>
                <li>
                    <button @click="HienThiShowHopDong">Hợp đồng</button>
                </li>
                <li>
                    <button @click="HienThiShowThanhToan">Thanh toán trực tuyến</button>
                </li>
                <li>
                    <button @click="HienThiShowTraCuu">Tra cứu hóa đơn</button>
                </li>
                <li>
                    <button @click="HienThiShowBaoHong">Báo hỏng</button>
                </li>
                <li>
                    <button @click="HienThiShowDoiDichVu">Đổi dịch vụ</button>
                </li>
                <li>
                    <button @click="HienThiShowThongTinThueBao">Thông tin thuê bao</button>
                </li>
                
            </ul>

        </div>
        <!-- 
        <div class="dieuhuong">
            <ul>
                <li>
                    <button @click="HienThiShowHopDong">Hợp đồng</button>
                </li>
                <li>
                    <button @click="HienThiShowThanhToan">Thanh toán</button>
                </li>
                <li>
                    <button @click="HienThiShowTraCuu">Tra cứu</button>
                </li>
                <li>
                    <button @click="HienThiShowBaoHong">Báo hỏng</button>
                </li>
                <li>
                    <button @click="HienThiShowDoiDichVu">Đổi dịch vụ</button>
                </li>
                <li>
                    <button @click="HienThiShowThongTinThueBao">Thông tin thuê bao</button>
                </li>
                
            </ul>

        </div> -->
        <div class="quanly">
            <div class="khachhang-content">
                <div class="khachhang-hopdong" v-if="ShowHopDong">
                    <KhachHangHopDong />
                </div>
                <div class="khachhang-thanhtoan" v-if="ShowThanhToan">
                    <KhachHangThanhToan />
                </div>
                <div class="khachhang-tracuu" v-if="ShowTraCuu">
                    <KhachHangTraCuu />
                </div>
                <div class="khachhang-baohong" v-if="ShowBaoHong">
                    <KhachHangBaoHong />
                </div>
                <div class="khachhang-doidichvu" v-if="ShowDoiDichVu">
                    <KhachHangDoiDichVu />
                </div>
                <div class="khachhang-ThongTinThueBao" v-if="ShowThongTinThueBao">
                    <KhachHangTaiKhoan />
                </div>
            </div>
            
        </div>
    </div>
    <div class="footer">
        <BanHang_Footer />
    </div>
  </div>
</template>

<script>
import BanHang_Header from '../components/BanHang_Header.vue'
import BanHang_Footer from '../components/BanHang_Footer.vue'
import KhachHangHopDong from './KhachHangHopDong.vue'
import KhachHangThanhToan from './KhachHangThanhToan.vue'
import KhachHangTraCuu from './KhachHangTraCuu.vue'
import KhachHangBaoHong from './KhachHangBaoHong.vue'
import KhachHangDoiDichVu from './KhachHangDoiDichVu.vue'
import KhachHangTaiKhoan from './KhachHangThueBao.vue'

export default {
  name: "KhachHang",
  components:{
    BanHang_Header,
    BanHang_Footer,
    KhachHangHopDong,
    KhachHangThanhToan,
    KhachHangTraCuu,
    KhachHangBaoHong,
    KhachHangDoiDichVu,
    KhachHangTaiKhoan
  },
  beforeCreate(){
        this.ID_KhachHang = localStorage.getItem("ID_KhachHang");
        if(this.ID_KhachHang == null) {
            this.$router.push({name: 'dangnhap'});
        }
    },
  data(){
    return {
        ShowHopDong: false,
        ShowThanhToan: false,
        ShowTraCuu: false,
        ShowBaoHong: false,
        ShowDoiDichVu: false,
        ShowThongTinThueBao: false
    }
  },
  methods:{
    HienThiShowHopDong(){
        this.ShowHopDong = true;
        this.ShowThanhToan = false;
        this.ShowTraCuu = false;
        this.ShowBaoHong = false;
        this.ShowDoiDichVu = false;
        this.ShowThongTinThueBao = false;
    },

    HienThiShowThanhToan(){
        this.ShowThanhToan = true;
        this.ShowHopDong = false;
        this.ShowTraCuu = false;
        this.ShowBaoHong = false;
        this.ShowDoiDichVu = false;
        this.ShowThongTinThueBao = false;
    },

    HienThiShowTraCuu(){
        this.ShowTraCuu = true;
        this.ShowHopDong = false;
        this.ShowThanhToan = false;
        this.ShowBaoHong = false;
        this.ShowDoiDichVu = false;
        this.ShowThongTinThueBao = false;
    },

    HienThiShowBaoHong(){
        this.ShowBaoHong = true;
        this.ShowHopDong = false;
        this.ShowThanhToan = false;
        this.ShowTraCuu = false;
        this.ShowDoiDichVu = false;
        this.ShowThongTinThueBao = false;
    },

    HienThiShowDoiDichVu(){
        this.ShowDoiDichVu = true;
        this.ShowHopDong = false;
        this.ShowThanhToan = false;
        this.ShowTraCuu = false;
        this.ShowBaoHong = false;
        this.ShowThongTinThueBao = false;
    },  

    HienThiShowThongTinThueBao() {
        this.ShowThongTinThueBao = true;
        this.ShowHopDong = false;
        this.ShowThanhToan = false;
        this.ShowTraCuu = false;
        this.ShowBaoHong = false;
        this.ShowDoiDichVu = false;
    }
  }
};
</script>


<style scoped>
.content {
    display: flex;
    flex-direction: column;
    height: 100vh;
}

.header {
    width: 100%;
    height: 130px; 
}

.maincontent {
    display: flex;
    flex-grow: 1; 
    height: calc(100vh - 130px);
}

.dieuhuong {
    width: 20%;
    background-color: #cff4fc;
    display: flex;
    flex-direction: column;
    justify-content: flex-start; 
    position: sticky; 
    top: 0; 
    height: auto; 
    max-height: 100%; 
}

.quanly {
    width: 80%;
    background-color: #f5f4f0;
    padding: 20px; 
    overflow-y: auto; 
}
ul {
    list-style-type: none;
}
ul li button {
    width: 100%;
    border: none;
    background-color: #006ecf;
    color: white;
    padding: 10px;
    /* border-radius: 10px; */
    border-top-left-radius: 10px;
    border-bottom-left-radius: 10px;
    font-weight: 500;
}
ul{
    display: flex;
    flex-direction: column;
    gap: 20px;
}
ul li button:hover {
    /* background-color: #cff4fc;
    color: black; */
    background-color: white;
    color: #006ecf;
    border: 2px solid #006ecf;
}
.bold {
    font-weight: 500;
    color: white;
    background-color: #212120;
    width: 100%;
}

li {
    margin-top: 20px;
}

.khachhang-content {
    border: 1px solid #0064b5;
    flex-grow: 1;
}


.white {
    color: white;
}

.h2 {
    font-weight: 500;
    font-size: 20px;
    padding: 5px;
}


</style>

