<template>
    <div class="main-container">
        <p class="bold blue inhoa gachchan center" id="tieude">hỗ trợ khách hàng</p>
        <div class="thanhtoan">
            <div class="thanh">
                <form action="" class="formthanhtoan">
                    <!-- ten hoa don -->
                    <div class="element">
                        <div class="row">
                            <div class="col-sm-3 justify-align">
                                <img id="logo" src="/assets/HinhAnh/khachhang/logovnpt.png" alt="">
                            </div>
                            <div class=" col-sm-6 justify-align " id="tenhoadon">
                                <p class="bold red inhoa gachchan center " >báo hỏng dịch vụ</p>
                                <!-- <p class="bold red inhoa gachchan center innghieng"> vat invoice</p> -->
                            </div>
                            <div class="col-sm-3 justify-align">
                                <p>Ký hiệu: </p>
                                <p>Số: </p>
                            </div>
                        </div>
                    </div>
                    <!-- het ten hoa don -->
                    
                    <!-- ben mua -->
                    <div class="element bennguoimua">
                        <p class="inhoa gachchan">thông tin thuê bao</p>
                        <p>Tên khách hàng: <span class="blue">{{TenNguoiMua}}</span></p>
                        <p>Mã số thuế: <span class="blue">{{MaSoThue}}</span> </p>
                        <p>Địa chỉ: <span class="blue">{{DiaChi}}</span> </p>
                        <p>Hình thức thanh toán: <span class="blue">Thanh toán điện tử</span></p>
                        <p>Số tài khoản: <span class="blue">{{SoTaiKhoan}}</span> </p>
                        <p>Ngân hàng: <span class="blue">{{NganHang}}</span> </p>
                        <p>Số điện thoại: <span class="blue">{{SoDienThoai}}</span> </p>
                        <p>Mã khách hàng: <span class="blue">{{ ID_KhachHang}}</span> </p>
                    </div>
                    <!-- het ben mua -->
                    
                    <!-- tai khoan thanh toan -->
                    <div class="element">
                        <p class="inhoa gachchan">thông tin báo hỏng</p>
                        
                        <div class="row">
                            <div class="flex-column col-sm-6 nganhang iinput-group">
                                <p>Loại lỗi / hỏng</p>
                                <VueSelect2 
                                v-model="NoiDungBaoHong"
                                :options="DanhSachTrangThaiBaoHong"
                                class="form-control"
                                placeholder="---------- Chọn ---------- "
                                ref="trangthaibaohong"
                                >

                                </VueSelect2>
                            </div>
                            <div class="flex-column col-sm-6">
                                <p>Chi tiết báo hỏng</p>
                                <textarea v-model="ChiTietBaoHong" ref="chitietbaohong" required class="form-control" name="" id="" cols="" rows="10"></textarea>
                            </div>
                        </div>
                    </div>
                    <!-- thong bao -->
                    
                    <!-- het thong bao  -->
                    
                    <P class="img-logo" hidden="true">VNPT</P>
                    <!-- <p class="innghieng">Khách hàng nhấn vào nút <span clas="blue">Tạo mã QR</span> để tạo mã sau đó quét mã để thực hiện thành toán.</p> -->
                    
                    <div class="taoma">
                        <!-- <button type="button" class="taomaqr" >gửi yêu cầu</button> -->
                        <button type="button" class="taomaqr" @click="GuiYeuCauBaoHong">gửi yêu cầu</button>
                    </div>
                    <!--  -->
                    
                    <!--  -->
                    
                </form>
                
            </div>
        </div>
        <div class="thongbao" v-show="HienThiThongBaoThanhCong">
            <div class="thongbaothanhcong">
                <Icon icon="line-md:uploading-loop" width="30" height="30"  style="color: white;" />
                <p class="inhoa">đang gửi yêu cầu</p>
            </div>
        </div>
        <div class="lichsubaohon">
            <div>
                <div class="tieude">
                    <p class="bold center blue inhoa size-20">báo hỏng đã gửi</p>
                </div>
                <table class="table-bordered xanh">
                    <thead>
                        <tr>
                            <th>STT</th>
                            <th>Tên khách hàng</th>
                            <th>Nội dung báo hỏng</th>
                            <th>Chi tiết báo hỏng</th>
                            <th>Trạng thái báo hỏng</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr
                        v-for="(BaoHong, index) in DanhSachBaoHongDaGui"
                        :key="index"
                        >
                            <td>{{index}}</td>
                            <td>{{BaoHong.HOTEN_KHACHHANG}}</td>
                            <td>{{BaoHong.NOIDUNGBAOHONG}}</td>
                            <td>{{BaoHong.CHITIET_BAOHONG}}</td>
                            <td>
                                <span v-if="BaoHong.TRANGTHAI_BAOHONG === 0">Đã gửi</span>
                                <span v-if="BaoHong.TRANGTHAI_BAOHONG != 0">Lỗi</span>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <!-- het bao hong da gui -->
        <!-- bao hong da sua -->
        <div class="baohongdasua">
            <div>
                <div class="tieude cam">
                    <p class="bold center blue inhoa size-20">báo hỏng đã sửa</p>
                </div>
                <table class="table-bordered cam">
                    <thead>
                        <tr>
                            <th>STT</th>
                            <th>Tên khách hàng</th>
                            <th>Dịch vụ</th>
                            <th>Nội dung báo hỏng</th>
                            <th>Chi tiết báo hỏng</th>
                            <th>Lỗi gây hỏng</th>
                            <th>Cách sửa chữa</th>
                            <th>Kết quả sửa chữachữa</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr
                        v-for="(BaoHong, index) in DanhSachBaoHongDaSua"
                        :key="index"
                        >
                            <td>{{index + 1}}</td>
                            <td>{{BaoHong.HOTEN_KHACHHANG}}</td>
                            <td>{{BaoHong.TENGDV}}</td>
                            <td>{{BaoHong.NOIDUNGBAOHONG}}</td>
                            <td>{{BaoHong.CHITIET_BAOHONG}}</td>
                            <td>{{BaoHong.LOI}}</td>
                            <td>{{BaoHong.SUACHUA}}</td>
                            <td>{{BaoHong.TEN_KQ_LAPDAT}}</td>

                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
        
    </div>
</template>
<script>
import {Icon} from '@iconify/vue2'
import axios from 'axios'
export default {
    name : 'KhachHangThanhToan',
    components:{
        Icon,
    },
    data(){
        return {

            ID_KhachHang: null,
            TenNguoiMua: null, //api
            MaSoThue: null, // api
            DiaChi: null, // api
            SoTaiKhoan: null, // api
            NganHang: null, // api
            SoDienThoai: null, // api
            MaKhachHang: null, // api
            //
            GoiDichVu: null, // api
            SoLuong: 0, // input
            DonGia: null, // api
            ThanhTienGoiDichVu: null, // api
            TienThueGTGT: null, // thanhtiengoidichvu * 10%
            TongCongTienThanhToan: null,// thanhtiengoidichvu + tienthuegtgt
            ThoiGianBaoHong: null, // format time

            HienThiQRCode: false,
            DanhSachNganHang: [],
            // sbumit
            // ID_KhachHang
            // SoLuong
            // DonGia
            // ThanhTienGoiDichVu
            // TienThueGTGT
            // TongCongTienThanhToan
            // ThoiGianThanhToan
            TenTaiKhoanThanhToan: null,
            SoTaiKhoanThanhToan: null,
            NganHangThanhToan: null,
        
            HienThiThongBaoThanhCong: false,
            //
            NoiDungBaoHong: null,
            DanhSachTrangThaiBaoHong: [],
            ChiTietBaoHong: null,
            DanhSachBaoHongDaGui: [],
            DanhSachBaoHongDaSua: [],

        }
    },
    mounted(){
        // console.log("ID_KhachHang-mounted: ", this.ID_KhachHang);
    },
    created(){
        this.ID_KhachHang = localStorage.getItem('ID_KhachHang');
        // console.log("AxiosAPI_GetKhachHangThanhToan");
        this.AxiosAPI_GetKhachHangThanhToan();
        // this.FetchAPI_getNganHang();
        this.ThoiGianBaoHong =  this.FormatTime();
        // console.log("fetchAPI_TrangThaiBaoHong");
        this.fetchAPI_TrangThaiBaoHong();
        this.AxiosAPI_GetBaoHongDaGui();
        this.AxiosAPI_GetBaoHongDaSua();

        
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
        async AxiosAPI_GetKhachHangThanhToan(){
            try {
                console.log("ID_KhachHang: ", this.ID_KhachHang);
                const DuLieu = await axios.get(
                    `http://localhost:8081/api/banhang/getkhachhangthanhtoan/${this.ID_KhachHang}`,
                );
                if(DuLieu.status === 200) {
                    console.log('AxiosAPI_GetKhachHangThanhToan: OK');
                    console.log("AxiosAPI_GetKhachHangThanhToan DuLieu: ", DuLieu);
                    this.TenNguoiMua = DuLieu.data[0].HOTEN_KHACHHANG;
                    console.log("Ten Nguoi Mua:",this.TenNguoiMua);
                    this.MaSoThue = DuLieu.data[0].MASOTHUE;
                    this.DiaChi = DuLieu.data[0].DIACHI_THUONGTRU;
                    this.SoDienThoai = DuLieu.data[0].SDT_KHACHHANG;
                    this.SoTaiKhoan = DuLieu.data[0].TAIKHOANSO;
                    this.NganHang = DuLieu.data[0].TAINGANHANG;
                    this.GoiDichVu = DuLieu.data[0].TENGDV;
                    this.DonGia = DuLieu.data[0].GIANIEMYET1;
                    this.ThanhTienGoiDichVu = DuLieu.data[0].GIANIEMYET1 * this.SoLuong;
                    this.TienThueGTGT = DuLieu.data[0].ThanhTienGoiDichVu * 0.1;
                    this.TongCongTienThanhToan = this.ThanhTienGoiDichVu + this.TienThueGTGT;
                    
                }
            }
            catch(error) {
                console.log("Loi AxiosAPI_GetKhachHangThanhToan: ", error);
            }
        },
        // lay thong tin trang thai bao hong
        async fetchAPI_TrangThaiBaoHong(){
            console.log("Lay fetchAPI_TrangThaiBaoHong");
            try {
                const YeuCau = await fetch('http://localhost:8081/api/banhang/gettrangthaibaohong');
                if(YeuCau.ok) {
                    const DuLieu = await YeuCau.json();
                    console.log("data fetchAPI_TrangThaiBaoHong: ", DuLieu);
                    this.DanhSachTrangThaiBaoHong = DuLieu.map(
                        (TrangThai) => {
                            return {
                                id: TrangThai.ID_NOIDUNGBAOHONG,
                                text: TrangThai.NOIDUNGBAOHONG
                            }
                        }
                    );
                }
                else {
                    console.log("Loi fetchAPI_TrangThaiBaoHong");
                }
            }
            catch(error) {
                console.log("Loi fetchAPI_TrangThaiBaoHong:", error);
            }
        },
        // het lay thong tin noi dung bao hong
        async GuiYeuCauBaoHong(){
            try {
                if(this.NoiDungBaoHong == null) {
                    this.$refs.chitietbaohong.focus();
                }
                else {
                    const DuLieu = {
                        ThoiGianBaoHong: this.ThoiGianBaoHong,
                        ID_KhachHang: this.ID_KhachHang,
                        IDFK_NoiDungBaoHong: this.NoiDungBaoHong,
                        ChiTiet_BaoHong: this.ChiTietBaoHong,
                        TrangThaiBaoHong: 0
                    };
                    const YeuCau = await axios.post(
                        'http://localhost:8081/api/banhang/insertbaohong',
                        DuLieu,
                        {
                            headers: {
                                'Content-Type' : 'application/json'
                            }
                        }
                    );
                    if(YeuCau.status === 200) {
                        console.log("Insert bao hong thanh cong");
                        this.HienThiThongBaoThanhCong = true;
                        setTimeout(()=>{
                            this.HienThiThongBaoThanhCong = false;
                            window.location.reload();
                        }, 2000);
                        
                    }
                    else {
                        console.log("Loi insert bao hong");
                    }
                    
                }
            }
            catch (error) {
                console.log("Loi GuiYeuCauBaoHong: ", error);
            }
        },
        // het insert bao hong
        async AxiosAPI_GetBaoHongDaGui(){
            try {
                const YeuCau = await axios.get(
                    `http://localhost:8081/api/banhang/baohongdagui/${this.ID_KhachHang}`
                );
                if(YeuCau.status === 200) {
                    const Data = YeuCau.data;
                    console.log("Data AxiosAPI_GetBaoHongDaGui: ", Data);
                    this.DanhSachBaoHongDaGui = Data;
                    console.log("DanhSachBaoHongDaGui: ", Data);
                }
            }
            catch(error) {
                console.log("Loi AxiosAPI_GetBaoHongDaGui: ", error);
            }
        },

        async AxiosAPI_GetBaoHongDaSua(){
            try {
                const YeuCau = await axios.get(
                    `http://localhost:8081/api/banhang/baohongdasuachua/${this.ID_KhachHang}`
                );
                if(YeuCau.status === 200) {
                    console.log("Data AxiosAPI_GetBaoHongDaSua: ", YeuCau);
                    const DuLieu = YeuCau.data;
                    this.DanhSachBaoHongDaSua = DuLieu;
                }
            }
            catch(error){
                console.log("Loi AxiosAPI_GetBaoHongDaSua: ", error);
            }
        }


    },
}
</script>

<style scoped>
.main-container{
    background-color: white;
    width: 100%;
}
.thanhtoan{
    display: flex;
    width: 100%;
    justify-content: center;
}
.thanh {
    width: 95%;
    display: flex;
    border: 2px solid #006db5;
    justify-content: center;
}
.formthanhtoan {
    width: 95%;
    border-radius: 3px;
}
.bold {
    font-weight: 500;
}
.blue {
    color :#31649e;
}
.red {
    color: #ff0808;
}
.inhoa {
    text-transform: uppercase;
}
.center {
    text-align: center;
}
#tieude {
    font-size: 22px;
    font-weight: bold;
}
.innghieng {
    font-style: italic;
}
#logo {
    width: 60px;
    height: auto;
    /* display: inline-block; */
}
#tenhoadon{
    font-size: 22px;
    font-weight: 800;
    display: flex;
    align-items: center;
}
.justify-align {
    display: flex;
    justify-content: center;
    align-items: center;
    text-align: center;
    flex-direction: column;
    height: 100%;
}
.element {
    border-bottom: 2px solid #006db5;
    padding-top: 10px;
    padding-bottom: 10px;
}
table {
    width: 100%;
    text-align: center;
}
#sothutu {
    width: 5%;
}
#tendichvu{
    width: 40%;
}
#donvitinh{
    width: 10% ;
}
#soluong {
    width: 10%;
}
#dongia {
    widows: 15%;
}
#thanhtien {
    width: auto;
}
input {
    width: 100%;
    font-weight: bold;
}

.img-logo {
    font-size: 180px;
    font-weight: bold;
    color:#ebf3fa;
    margin-bottom: 100px;
    margin-left: 150px;
    letter-spacing: 40px;
}
table {
    margin-top: 20px;
    position: relative;
    /* background: url("http://localhost:8080/assets/HinhAnh/khachhang/img-logo-remove.png"); */
    margin-bottom: 20px;
}
.chieucao {
    height: 30px;
}
.text-left {
    text-align: left;
} 
.text-right {
    text-align: right;
}
form {
    font-weight: bold;
}
.form-control {
    position: relative;
    z-index: 1;
    background-color: transparent;
}
.taoma {
    display: flex;
    justify-content: center;
    margin-top: 1em;
    margin-bottom: 1em;
}
.taomaqr {
    border: none;
    padding: 10px 30px;
    background-color: #1f7ed1;
    color: #ffffff;
    font-weight: 500;
    font-size: 17px;
    border: 2px solid #1f7ed1;
}
.taomaqr:hover,
#hoantat:hover
{
    background-color: white;
    border: 2px solid #1f7ed1;
    color: #1f7ed1;
}
/* .qrcode {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    border: 1px solid #0f0fa6;
    background-color: #0f0fa8;
    width: 300px;
    height: 300px;  
    transform: translate(100%, -130%);
    z-index: 9999;
    
} */
.qrcode {
    display: flex;
    flex-direction: column;
    position: fixed;
    top: 50%;
    bottom: 50%;
    transform: translate(50%, -50%);
    align-items: center;
    justify-content: center;
    border: 5px solid white;
    background-color: #0f0fa8;
    width: 300px;
    height: 300px;
    z-index: 1000;
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);

}
/* Lớp phủ nền tối */
.overlay {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background: rgba(0, 0, 0, 0.7);
    z-index: 999; /* Đảm bảo lớp phủ dưới qrcode */
}

#qrcode{
    width: 200px;
    height: 200px;
    border-radius: 5px;
    display: inline-block;
    border: 1px solid white;
    
}
.button {
    margin-top: 20px;
}
#hoantat {
    padding: 5px 20px;

    background-color: #278cd9;
    color: white;
    font-weight: 500;
    border: none;
    border: 2px solid #278cd9;
}
#huy {
    padding: 5px 30px;
    margin-left: 30px;
    background-color: #db3545;
    color: white;
    font-weight: 500;
    border: none;
    border: 2px solid #db3545;
}
#huy:hover
{
    background-color: white;
    border: 2px solid #db3545;
    color: #db3545;
}
.inhoa {
    text-transform: uppercase;
    
}
.gachchan {
    text-decoration: underline;
}
.iinput-group{
    display: flex;
}
.iinput-group p {
    margin: 0;
    margin-right: 10px;
    white-space: nowrap;
    line-height: 35px;
}
input {
    flex-grow: 1;
    width: 100%;
    height: 30px;
    border: none;
    outline: none;
    background-color: #f5f4f0;
}
input:hover {
    border: none;
}
.chonnganhang {
    width: 300px;
}
/*  */
.thongbaothatbai {
    position: fixed;
    z-index: 1000;
    top: 0;
    left: 0;
    background: rgba(0, 0, 0, 0.5);
    width: 100%;
    height: 100%;
    display: flex;
    align-items: center;
    justify-content: center;
}
.noidungthongbaothatbai {
    color: white;
    width: 20%;
    height: 20%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    text-align: center;
    border: 2px solid white;
    background-color: brown;
    border-radius: 10px;
}
.button-close-thongbaothatbai {
    width: 100%;
    display: flex;
    justify-content: flex-end;
    margin-top: 0;
    padding-top: 0;
    
}
.button-close-thongbaothatbai button {
    background: transparent;
    border: none;
}
textarea {
    width: 100%;
}
.flex-column {
    display: flex;
    flex-direction: column;
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
.thongbaothanhcong {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    text-align: center;
    width: 20% ;
    min-height: 20%;
    background-color: #1f7ed1;
    color: white;
    padding: 0 20 20px;
    text-align: center;
    font-weight: 500;
    border: 3px solid white;
    border-radius: 10px;
}
.lichsubaohon {
    margin-top: 2em;
}
.tieude {
    width: 100%;
    padding-top: 1em;
    padding-bottom: 1em;
    background-color: #cff4fc;
    border-top: 1px solid black;
}
.bold{
    font-weight: 500;
}
.white {
    color:white;
}
.inhoa {
    text-transform: uppercase;
}
.xanh {
    background-color:#cff4fc;
}
.size-20 {
    font-size: 1.5em;
}
.blue {
    color:#1f7ed1;
}
VueSelect2 {
    max-width: 100%;
}
.cam {
    background-color: #fff3cc;
}
</style>
