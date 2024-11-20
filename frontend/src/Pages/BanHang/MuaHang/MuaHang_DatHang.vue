<template>
  <div class="content">
    <div class="header">
        <BanHang_Header />
    </div>
    <div class="main-content">
        <div class="thongtinkhachhang">
            <form @submit.prevent="YeuCauDonHang" action="" class="form-group">
                <div class="khachhang">
                    <p class="inhoa" id="thongtinkhachhang">
                        Thông tin khách hàng
                    </p>
                </div>
                <div class="thongtincannhan">
                    <p class="blue inhoa">Thông tin cá nhân</p>
                    <input v-model="HoTenKhachHang" class="form-control" type="text" placeholder="Họ và tên">
                    <input v-model="SDTKhachhang" class="form-control" type="text" placeholder="Số điện thoại">
                    <input v-model="EmailKhachhang" class="form-control" type="text" placeholder="Email">
                </div>
                <div class="diachilapdat">
                    <p class="blue inhoa">Địa chỉ lắp đặt</p>
                    <VueSelect2
                    v-model="QuanHuyenKhachHang"
                    :options="DanhSachQuanHuyen"
                    class="form-control"
                    placeholder="Chọn quận huyện"
                    @change="ChonQuanHuyen"
                    >
                    </VueSelect2>   

                    <VueSelect2
                    v-model="PhuongXaKhachHang"
                    :options="DanhSachPhuongXaChonLoc"
                    class="form-control"
                    placeholder="Chọn phường xã"
                    >
                    </VueSelect2>    
                    <input v-model="ChiTietKhachHang" class="form-control" type="text" placeholder="Chi tiết">
                    <input v-model="GhiChuKhachHang" class="form-control" type="text" placeholder="Ghi chú">
                </div>
                <div class="hinhthuctracuoc">
                    <p class="blue inhoa">Hình thức trả cước</p>
                    <VueSelect2
                    v-model="HinhThucTraCuoc"
                    :options="DanhSachHinhThucTraCuoc"
                    class="form-control"
                    placeholder="Chọn hình thức trả cước"
                    >
                    </VueSelect2>

                </div>
                <div class="dieukhoansudung">
                    <p class="blue inhoa">Điều khoản sử dụng</p>
                    <div class="dieukhoan">
                        <input type="checkbox" name="" id="" checked="true">Tôi đồng ý với <a href="">Điều khoản sử dụng</a> và   <a href="">Chính sách bảo vệ dữ liệu cá nhân</a> của VNPT/Công ty con của VNPT.
                        <br>
                        <input type="checkbox" name="" id="" checked="true">Tôi đồng ý nhận các thông tin từ VNPT/Công ty con của VNPT bao gồm các thông tin với mục đích quảng cáo tiếp thị. Trường hợp cần thiết tôi sẽ từ chối nhận thông tin quảng cáo tiếp thị qua các phương thức do VNPT/Công ty con của VNPT cung cấp (soạn tin TC gửi 18001091)
                    </div>
                </div>
                <div class="guiyeucau">
                    <input type="submit" id="btnsubmit" class="inhoa" value="Gửi yêu cầu">
                </div>
                <input type="hidden" v-model="gdv.ID_GDV">
                <p>id gdv: {{gdv.ID_GDV}}</p>
            </form>
        </div>
       <div class="thongtindonhang">
            <div class="donhang">
                <p class="inhoa" id="thongtindonhang">
                    Thông tin đơn hàng
                </p>
            </div>
            <!-- <ChiTietGoiDichVu @datmua="DatMua" /> -->
            <div class="chitietdon">
                <div class="thongtindon">
                    <img id="img-gdv" :src="gdv.HINHANH" v-if="gdv.HINHANH != null" alt="">
                    <p v-if="gdv.HINHANH == null">Chưa chọn dịch vụ</p>
                </div>
                <div class="thongtindon thongtindondichvu">
                    <p>DV cố định:</p>
                    <p><strong>{{gdv.TENGDV}}</strong></p>
                </div>
                <div class="thongtindon">
                    <p>Giá sản phẩm:</p>
                    <p><strong>{{gdv.GIANIEMYET1}} VNĐ/Tháng</strong></p>
                </div>
            </div>
       </div>
      
    </div>
    <div class="thongbao" v-show="thongbao">
         <div class="thongbaothanhcong" v-show="thongbaothanhcong">
            <div class="button-close">
               <button @click="dongthongbaothanhcong">
                 <Icon  class="icon" icon="zondicons:close-solid" width="30" height="30"  style="color: white" />
               </button>
            </div>
            <p>CẢM ƠN QUÝ KHÁCH ĐÃ TIN CHỌN VNPT</p>
            <p>THÔNG TIN ĐƠN ĐẶT HÀNG ĐÃ ĐƯỢC GỬI ĐI</p>
            <p>VNPT SẼ LIÊN HỆ VỚI BẠN SỚM NHẤT CÓ THỂ</p>
            <p>(Tối đa 15 tiếng)</p>
            
        </div>
        <div class="thongbaothatbai" v-show="thongbaothatbai">
            <div class="button-close">
               <button @click="dongthongbaothatbai">
                 <Icon class="icon" icon="zondicons:close-solid" width="30" height="30"  style="color: white" />
               </button>
            </div>
            <p>CHƯA NHẬP HẾT THÔNG TIN</p>
            <p>QUÝ KHÁCH VUI LÒNG KIỂM TRA LẠI THÔNG TIN</p>
            <p></p>
        </div>
    </div>
    <div class="footer">
        <BanHang_Footer />
    </div>
  </div>
</template>
<script>
    import {Icon} from '@iconify/vue2'
    import axios from 'axios'
    import BanHang_Footer from "../components/BanHang_Footer.vue";
    import BanHang_Header from "../components/BanHang_Header.vue";
    // import {EventBus} from '../../../main.js'
    export default {
        data(){
            return{
                DanhSachQuanHuyen:[],
                DanhSachPhuongXa:[],
                DanhSachPhuongXaChonLoc:[],
                DanhSachHinhThucTraCuoc:[],
                
                HoTenKhachHang:null,
                SDTKhachhang: null,
                EmailKhachhang:null,
                QuanHuyenKhachHang: null,
                PhuongXaKhachHang: null,
                ChiTietKhachHang:null,
                GhiChuKhachHang:null,
                HinhThucTraCuoc: null,
                // TenGDV: gdv.TENGDV,
                ThoiGianTao:null,
                gdv: {
                    HINHANH:null,
                    TENGDV: null,
                    GIANIEMYET1:null,
                    ID_GDV:null,
                },

                thongbao: false,
                thongbaothanhcong: false,
                thongbaothatbai: false, 
            }
        },
        components:{
            BanHang_Footer,
            BanHang_Header,
            Icon,
        },
        created(){
            const gdvData = sessionStorage.getItem('gdvData');
            if (gdvData) {
                this.gdv = JSON.parse(gdvData);
                console.log("Nhan du lieu: ", this.gdv);
                // sessionStorage.removeItem('gdvData');
            }

            this.fetchAPI_quanhuyen();
            this.fetchAPI_phuongxa();
            this.fetchAPI_hinhthuc();
            this.ThoiGianTao =  this.FormatTime();
        },
        mounted() {
            
        },
        methods:{
            FormatTime(){
                const now = new Date();
                const year = now.getFullYear();
                const month = String(now.getMonth() + 1).padStart(2, '0');
                const day = String(now.getDate()).padStart(2, '0');
                const hours = String(now.getHours()).padStart(2, '0');
                const minutes = String(now.getMinutes()).padStart(2, '0');
                const seconds = String(now.getSeconds()).padStart(2, '0');
                return `${year}-${month}-${day} ${hours}:${minutes}:${seconds}`;
            },
            async fetchAPI_quanhuyen(){
                try{
                    const ketnoi = await fetch('http://localhost:8081/api/banhang/diachi/quanhuyen');
                    if(ketnoi.ok) {
                        const data = await ketnoi.json();
                        this.DanhSachQuanHuyen = data.map(
                            (item) => {
                                return {
                                    id: item.ID_QUANHUYEN,
                                    text: item.TENQUANHUYEN,
                                    // IDFK_QUANHUYEN: item.ID_QUANHUYEN,
                                }
                            }
                        );
                    }
                }
                catch(error) {
                    console.log("Loi ket noi" + error);
                }
            },
            
            async fetchAPI_phuongxa(){
                try{
                    const ketnoi = await fetch('http://localhost:8081/api/banhang/diachi/phuongxa');
                    if(ketnoi.ok) {
                        const data = await ketnoi.json();
                        this.DanhSachPhuongXa = data.map(
                            (item) => {
                                return {
                                    id: item.ID_PHUONGXA,
                                    text: item.TENPHUONGXA,
                                    IDFK_QUANHUYEN: item.IDFK_QUANHUYEN,
                                }
                            }
                        );
                        console.log(this.DanhSachPhuongXa);
                    }
                }
                catch(error) {
                    console.log("Loi ket noi" + error);
                }
            },
            ChonQuanHuyen(){
                
                const selectedID = Number(this.QuanHuyenKhachHang);
                console.log('idfk: '+this.QuanHuyenKhachHang);
                this.DanhSachPhuongXaChonLoc = this.DanhSachPhuongXa.filter(
                    (item) => {
                        return (item.IDFK_QUANHUYEN === selectedID);
                    }
                );
                
                console.log("length: "+this.DanhSachPhuongXaChonLoc.length);
                
            },
            async fetchAPI_hinhthuc(){
                try{
                    const ketnoi = await fetch('http://localhost:8081/api/banhang/goidichvu/hinhthuctracuoc');
                    if(ketnoi.ok) {
                        const data = await ketnoi.json();
                        this.DanhSachHinhThucTraCuoc = data.map(
                            (item) => {
                                return {
                                    id: item.ID_HINHTHUC,
                                    text: item.TENHINHTHUC,
                                }
                            }
                        );
                    }
                }
                catch(error){
                    console.log("error: ", error);
                }
            },
            async YeuCauDonHang(){
                if(this.gdv.TENGDV == null
                    || this.HoTenKhachHang == null
                    || this.SDTKhachhang == null
                    || this.EmailKhachhang == null
                    || this.QuanHuyenKhachHang == null
                    || this.PhuongXaKhachHang == null
                    || this.ChiTietKhachHang == null
                    || this.HinhThucTraCuoc == null

                ) {
                    console.log("chua chon");
                    this.thongbao = true;
                    this.thongbaothatbai = true;
                }
                else {
                    console.log("GDV da chon: "+this.gdv.TENGDV);
                    const ThongTinKhachHang = {
                        ThoiGianTao: this.ThoiGianTao,
                        HoTenKhachHang:this.HoTenKhachHang,
                        SDTKhachHang: this.SDTKhachhang,
                        EmailKhachHang:this.EmailKhachhang,
                        QuanHuyenKhachHang: this.QuanHuyenKhachHang,
                        PhuongXaKhachHang: this.PhuongXaKhachHang,
                        ChiTietKhachHang:this.ChiTietKhachHang,
                        GhiChuKhachHang:this.GhiChuKhachHang,
                        HinhThucTraCuoc: this.HinhThucTraCuoc,
                        GoiDichVu: this.gdv.ID_GDV,
                        TrangThaiDonHang: 1
                    };
                    console.log("thong tin khach hang: ", ThongTinKhachHang)
                    try {
                        const YeuCau = await axios.post('http://localhost:8081/api/banhang/yeucaudonhang', ThongTinKhachHang, {
                            headers: {
                                'Content-Type': 'application/json'
                            }
                        });
                        if(YeuCau.status === 200) {
                            console.log("gui du lieu thanh cong", ThongTinKhachHang );
                            this.thongbao = true;
                            this.thongbaothanhcong = true;
                        }
                    }
                    catch(error) {
                        console.log("loi: ", error);
                    }
                }
                
                
            },
            dongthongbaothanhcong(){
                this.thongbao = false;
                this.thongbaothanhcong = false;
                this.thongbaothatbai = false;
            },
            dongthongbaothatbai() {
                console.log("Dong thong bao that bai");
                this.thongbaothatbai = false;
                this.thongbao = false;
            }
        }
        ,
        

        
    }
</script>
<style scoped>
.main-content{
    margin: 40px auto 60px auto;
    width: 90%;
    display: flex;
    justify-content: space-around;
}
.inhoa {
    text-transform:uppercase;
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    font-size: 20px;
    font-weight: 400;
}
.thongtinkhachhang {
    width: 55%;
}
.thongtindonhang {
    width: 40%;
}
.form-control {
    margin-top: 10px;
    width: 60%;
}
.khachhang, .donhang {
    background-color: #2cd1b0;
    padding-top: 5px;
    /* padding-bottom: 1px; */
    border-radius:10px ;
}
#thongtinkhachhang, #thongtindonhang {
    margin-left: 30px;
    color: white;
    padding-bottom: 5px;
    font-weight: 500;
}

.thongtinkhachhang, .thongtindonhang {
   border: 1px solid #dedede;
   border-radius: 10px;
   color:#5a86d1;
}
.thongtincannhan, .diachilapdat, .hinhthuctracuoc,.dieukhoansudung {
    margin-left: 20px;
    margin-bottom: 20px;

}
.thongtindon {
    display: flex;
    color: #db0b49;
    display: flex;
    justify-content: space-around;
}
.chitietdon {
    margin-top: 20px;
}
.thongtindondichvu {
    border-bottom: 1px solid #dedede;
    margin-top: 20px;
}
.dieukhoan {
    line-height: 30px;
    color: black;
}
.guiyeucau{
    justify-content: center;
    display: flex;
}
#btnsubmit {
    border: none;
    color: white;
    background-color: #17abe6;
    margin-bottom: 20px;
    border-radius: 5px;
    font-size: 18px;
    padding: 5px 50px;
    font-weight: 500;
}
#img-gdv {
    max-width: 100%;
}

p {
    line-height: 1.5;
}

.thongbao {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.5);
    display: flex;
    justify-content: center;
    align-items: center;
    z-index: 1000;
}
.thongbaothanhcong,
.thongbaothatbai
{
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    text-align: center;
    width: 40% ;
    min-height: 25%;
    background-color: #1f7ed1;
    color: white;
    padding: 0 20 20px;
    text-align: center;
    font-weight: 500;
    border: 3px solid white;
    border-radius: 10px;
}
.thongbaothatbai{
    background-color: brown;
}
.button-close {
    display: flex;
    justify-content: flex-end;
    /* border: 1px solid black; */
    width: 100%;
    
}
.button-close button {
    width: auto;
    height: auto;
    display: inline-block;
    margin-right: 20px;
    background:transparent;
    border: none;
    cursor: pointer;
}

</style>