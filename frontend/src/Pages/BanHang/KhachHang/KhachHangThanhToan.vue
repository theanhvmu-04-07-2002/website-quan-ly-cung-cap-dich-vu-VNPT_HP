<template>
    <div class="main-container">
        <p class="bold blue inhoa gachchan center" id="tieude">thanh toán dịch vụ trực tuyến</p>
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
                                <p class="bold red inhoa gachchan center " >hóa đơn giá trị gia tăng</p>
                                <p class="bold red inhoa gachchan center innghieng"> vat invoice</p>
                            </div>
                            <div class="col-sm-3 justify-align">
                                <p>Ký hiệu: </p>
                                <p>Số: </p>
                            </div>
                        </div>
                    </div>
                    <!-- het ten hoa don -->
                    <!-- ben nguoi ban -->
                    <div class="element bennguoiban">
                        <p>Tên người bán: 
                            <span class="inhoa blue" >trung tâm kinh doanh vnpt - hải phòng, chi nhánh tổng công ty dịch vụ viễn thông</span>
                    
                        </p>
                        <p>Mã số thuế: <span class="blue">0106869738-056</span></p>
                        <p>Địa chỉ: 
                            <span class="blue">Tòa nhà VNPT Hải Phòng, Lô C6 Trung tâm Hành chính quận Hải An, Đường Lê Hồng Phong, <br> Phường Đằng Hải, Quận Hải An, Thành phố Hải Phòng, Việt Nam</span>
                        </p>
                        <p>Tên đơn vị hưởng thụ: <span class="blue">TTKD VNPT TP. Hải Phòng – CN Tổng Công ty Dịch vụ Viễn thông</span></p>
                        <p>Số tài khoản: <span class="blue">375109001114</span></p>
                        <p>Ngân hàng: <span class="blue">KHO BẠC TP Hải Phòng</span></p>
                    </div>
                    <!-- het ben ben ban -->
                    
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
                        <p class="inhoa gachchan">tài khoản thanh toán</p>
                        <div class="tentaikhoan iinput-group">
                            <p>Tên tài khoản: </p>
                            <input type="text" v-model="TenTaiKhoanThanhToan">
                        </div>
                        <div class="sotaikhoan iinput-group">
                            <p>Số tài khoản</p>
                            <input type="text" v-model="SoTaiKhoanThanhToan">
                        </div>
                        <div class="nganhang iinput-group">
                            <p>Ngân hàng</p>
                            <VueSelect2 
                            v-model="NganHangThanhToan"
                            :options="DanhSachNganHang"
                            class="form-control"
                            placeholder="---------- Chọn ngân hàng ---------- "
                            >

                            </VueSelect2>
                        </div>
                    </div>
                    <!-- thong bao -->
                    
                    <!-- het thong bao  -->
                    <div class="noidungthanhtoan">
                        <table class="table-bordered">
                            <thead>
                                <tr>
                                    <th id="sothutu">STT</th>
                                    <th id="tendichvu">Tên hàng hóa/ dịch vụ</th>
                                    <th id="donvitinh">Đơn vị tính</th>
                                    <th id="soluong">Số lượng</th>
                                    <th id="dongia">Đơn giá</th>
                                    <th id="thanhtien">Thành tiền</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>1</td>
                                    <td class="blue">{{GoiDichVu}}</td>
                                    <td class="blue">Tháng</td>
                                    <td><input @change="ThayDoiSoLuong" v-model="SoLuong" class="form-control blue" type="text" ></td>
                                    <td class="blue">{{DonGia}}</td>
                                    <td class="blue">{{ThanhTienGoiDichVu}}</td>
                                </tr>
                                <tr  class="chieucao">
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <tr  class="chieucao">
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <tr  class="chieucao">
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <tr  class="chieucao">
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <tr class="congtienhang">
                                    <td colspan="5" class="text-right">Cộng tiền hàng: </td>
                                    <td class="blue">{{ThanhTienGoiDichVu}}
                                    </td>
                                </tr>
                                <tr class="thue">
                                    <td colspan="2" class="text-left">Thuế suất GTGT: 10%</td>
                                    <td colspan="3" class="text-right">Tiền thuế GTGT: </td>
                                    <td class="blue"> {{TienThueGTGT}}</td>
                                </tr>
                                <tr class="tongtienthanhtoan">
                                    <td colspan="5" class="text-right">Tổng cộng tiền thanh toán: </td>
                                    <td class="blue">{{TongCongTienThanhToan}}</td>
                                </tr>
                                
                            </tbody>
                        </table>
                    </div>
                    <P class="img-logo" hidden="true">VNPT</P>
                    <p class="innghieng">Khách hàng nhấn vào nút <span clas="blue">Tạo mã QR</span> để tạo mã sau đó quét mã để thực hiện thành toán.</p>
                    
                    <div class="taoma">
                        <button type="button" class="taomaqr" @click="TaoMaQR">Tạo mã QR</button>
                    </div>
                    <!--  -->
                    
                    <!--  -->
                    <div class="qrcode" v-show="HienThiQRCode">
                        <img id="qrcode" src="/assets/HinhAnh/khachhang/img-qrcode.png" alt="">
                        <div class="button">
                            <button @click="HoanTatThanhToan" type="button" id="hoantat">HOÀN TẤT</button>
                            <button type="button" id="huy" @click="HuyThanhToan">Hủy</button>
                        </div>
                    </div>
                    <div class="thongbaothatbai" v-show="hienthithongbaothatbai">
                        <div class="noidungthongbaothatbai">
                            <div class="button-close-thongbaothatbai">
                                <button type="button" @click="dongthongbaothatbai" class="inhoa">
                                    <Icon icon="zondicons:close-outline" width="30" height="30"  style="color: white" />
                                </button>
                            </div>
                            <p class="inhoa white">quý khách chưa nhập hết thông tin</p>
                        </div>
                    </div>
                    <div class="thongbao" v-show="HienThiThongBaoThanhCong">
                        <div class="thongbaothanhcong">
                            <Icon icon="line-md:uploading-loop" width="30" height="30"  style="color: white;" />
                            <p class="inhoa">đang gửi yêu cầu</p>
                        </div>
                    </div>
                </form>
                
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
            ThoiGianThanhToan: null, // format time

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
        
            hienthithongbaothatbai: false,
            HienThiThongBaoThanhCong: false,
            


        }
    },
    mounted(){
        console.log("ID_KhachHang-mounted: ", this.ID_KhachHang);
    },
    created(){
        this.ID_KhachHang = localStorage.getItem('ID_KhachHang');
        this.AxiosAPI_GetKhachHangThanhToan();
        this.FetchAPI_getNganHang();
        this.ThoiGianThanhToan =  this.FormatTime();
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
        ThayDoiSoLuong(){
            this.ThanhTienGoiDichVu = this.DonGia * this.SoLuong;
            this.TienThueGTGT = this.ThanhTienGoiDichVu * 0.1;
            this.TongCongTienThanhToan = this.ThanhTienGoiDichVu + this.TienThueGTGT;
    
        },
        TaoMaQR(){
            if(this.TenTaiKhoanThanhToan == null 
                || this.SoTaiKhoanThanhToan == null
                || this.NganHangThanhToan == null
                || this.SoLuong === 0 || this.SoLuong == null
            ) 
            {
                this.hienthithongbaothatbai = true;
            }

            else {
                this.HienThiQRCode = true;
            }
        },
        async FetchAPI_getNganHang(){
            try {
                const KetNoi = await fetch('http://localhost:8081/api/banhang/getnganhang');
                if(KetNoi.ok) {
                    const Data = await KetNoi.json();
                    console.log("Thong tin ngan hang: ", Data);
                    this.DanhSachNganHang = Data.map(
                        (item) => {
                            return {
                                id: item.ID_NGANHANG,
                                text: item.TENNGANHANG
                            }
                        }
                    );
                }
            }
            catch(error){
                console.log("Loi lay data ngan hang: ", error);
            }
        },
        HuyThanhToan(){
            this.HienThiQRCode = false;
        },
        async HoanTatThanhToan(){
            const DuLieuThanhToan = {
                ID_KhachHang: this.ID_KhachHang,
                SoLuong: this.SoLuong,
                ThanhTien: this.ThanhTienGoiDichVu,
                TienThueGTGT: this.TienThueGTGT,
                TongCongTienThanhToan: this.TongCongTienThanhToan,
                TenTaiKhoanThanhToan: this.TenTaiKhoanThanhToan,
                SoTaiKhoanThanhToan: this.SoTaiKhoanThanhToan,
                NganHangThanhToan: this.NganHangThanhToan,
                ThoiGianThanhToan: this.ThoiGianThanhToan
    
            };
            console.log("Du lieu thanh toan: ", DuLieuThanhToan);
            try {
                const YeuCau = await axios.post(
                    'http://localhost:8081/api/banhang/inserhoadon',
                    DuLieuThanhToan,
                    {
                        headers: {
                            'Content-Type':'application/json'
                        }
                    }
                );
                if(YeuCau.status === 200) {
                    console.log("Gui du lieu thanh toan thanh cong");
                    this.TenTaiKhoanThanhToan = '';
                    this.SoTaiKhoanThanhToan = '';
                    this.NganHangThanhToan = '';
                    this.SoLuong = 0;
                    this.ThanhTienGoiDichVu = 0;
                    this.TienThueGTGT = 0;
                    this.TongCongTienThanhToan = 0;
                    this.HienThiQRCode = false;
                    this.HienThiThongBaoThanhCong = true;
                    setTimeout(()=>{
                        this.HienThiThongBaoThanhCong = false;
                    }, 2000);
                }
            }
            catch(error) {
                console.log("Loi insert thanh toan: ", error);
            }
        },
        dongthongbaothatbai(){
            this.hienthithongbaothatbai = false;
        },

        
    },
    // computed(){
    //     this.ThanhTienGoiDichVu = this.DonGia * this.SoLuong;
    //     this.TienThueGTGT = this.ThanhTienGoiDichVu * 0.1;
    //     this.TongCongTienThanhToan = this.ThanhTienGoiDichVu + this.TienThueGTGT;
    // }

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
    background: url("http://localhost:8080/assets/HinhAnh/khachhang/img-logo-remove.png");
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
    margin-bottom: 20px;
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

</style>
