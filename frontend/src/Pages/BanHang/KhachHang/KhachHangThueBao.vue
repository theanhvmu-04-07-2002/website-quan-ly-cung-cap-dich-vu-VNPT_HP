<template>
    <div class="main">
        <div class="main-container">
            <p class="bold blue inhoa center" id="tieude">thông tin thuê bao</p>
            <div class="row">
                <!-- thong tin dang ky thue bao -->
                <div class="col-sm-6 ">
                    <h5><p class="blue center bold">Thông tin đăng ký thuê bao</p></h5>
                    <div class="thongtinthuebao">
                        <p>Người đại diện: <span class="bold blue">{{SuDung_DaiDien}}</span></p>
                        <p>Điện thoại: <span class="bold blue">{{SuDung_SDT}}</span></p>
                        <p>E-mail: <span class="bold blue">{{SuDung_Email}}</span></p>
                        <p>Thông tin liên hệ khác: <span class="bold blue">{{SuDung_LienHeKhac}}</span> <span v-if="this.SuDung_LienHeKhac == null" style="color: red;">Không</span></p>
                        <p>Chức vụ: <span class="bold blue">{{SuDung_ChucVu}}</span>  <span v-if="this.SuDung_ChucVu == null" style="color: red;">Không</span></p>
                        <p>Ngày sinh: <span class="bold blue">{{SuDung_NgaySinh}}</span> </p>
                        <p>Giới tính: <span class="bold blue">{{SuDung_GoiTinh}}</span> </p>
                        <p>Số CCCD/CMND/Hộ chiếu: <span class="bold blue">{{SuDung_SoCCCD}}</span> </p>
                        <p>Ngày cấp: <span class="bold blue">{{SuDung_NgayCapCCCD}}</span> </p>
                        <p>Nơi cấp: <span class="bold blue">{{SuDung_NoiCapCCCD}}</span> </p>
                        <p>Số Giấy chứng nhận ĐKDN/QĐTL/GPTL: <span class="bold blue">{{SuDung_GiayChungNhan}}</span> <span v-if="this.SuDung_GiayChungNhan == null" style="color: red;">Không</span> </p>
                        <p>Ngày cấp Giấy chứng nhận: <span class="bold blue">{{SuDung_NgayCapGCN}}</span>  <span v-if="this.SuDung_NgayCapGCN == null" style="color: red;">Không</span> </p>
                        <p>Nơi cấp Giấy chứng nhận: <span class="bold blue">{{SuDung_NoiCap_GDN}}</span>  <span v-if="this.SuDung_NoiCap_GDN == null" style="color: red;">Không</span></p>
                        <p>Địa chỉ thường trú: <span class="bold blue">{{SuDung_DiaChiThuongTru}}</span> </p>
                        <p>Địa chỉ thanh toán: <span class="bold blue">{{SuDung_DiaChiThanhToan}}</span> </p>
                        <p>Địa chỉ trụ sở giao dịch: <span class="bold blue">{{SuDung_TruSoGiaoDich}}</span>  <span v-if="this.SuDung_TruSoGiaoDich == null" style="color: red;">Không</span></p>
                        <p>Tài khoản số: <span class="bold blue">{{SuDung_TaiKhoanSo}}</span>  <span v-if="this.SuDung_TaiKhoanSo == null" style="color: red;">Không</span></p>
                        <p>Tại ngân hàng: <span class="bold blue">{{SuDung_NganHang}}</span>  <span v-if="this.SuDung_NganHang == null" style="color: red;">Không</span></p>
                        <p>MST/Mã NNS: <span class="bold blue">{{SuDung_MST}}</span>  <span v-if="this.SuDung_MST == null" style="color: red;">Không</span></p>
                    </div>
                </div>
                <!-- het thong tin dang ky thue bao -->
                <div class="col-sm-1"></div>
                <!-- thong tin tai khoan -->
                <div class="col-sm-5">
                    <div>
                        <h5><p class="blue center bold">Thông tin tài khoản</p></h5>
                    </div>
                    <div>
                        <div class="bandau">
                            <div class="row taikhoanbandau">
                                <div class="col-sm-6 right">
                                    <p>Mã khách hàng: </p>
                                    <p>Tên đăng nhập: </p>
                                    <p>Mật khẩu: </p>
                                </div>
                                <div class="col-sm-5 left">
                                    <p>{{ID_KhachHang}}</p>
                                    <input v-model="TaiKhoan" type="text" readonly="true" class="readonly">
                                    <p></p>
                                    <input v-model="MatKhauCu" type="password" readonly="true" class="readonly">
                                </div>
                            </div>
                        </div>
                        <div class="suadoi">
                            <div>
                                <p class="blue center bold">Đổi mật khẩu</p>
                            </div>
                            <div v-show="thanhcong" class="thongbao thanhcong">
                                <p>Đã đổi mật khẩu thành công</p>
                            </div>
                            <div v-show="matkhaucusai" class="thongbao error">
                                <p> Mật khẩu sai</p>
                            </div>
                            <div v-show="nhaplaimatkhaumoisai" class="thongbao error">
                                <p>Sai xác nhận mật khẩu mới </p>
                            </div>
                            <div v-show="matkhaumoikhacmatkhaucu" class="thongbao error">
                                <p>Mật khẩu mới phải khác mật khẩu cũ</p>
                            </div>
                            <div class="row ">
                                <div class="col-sm-6 right">
                                    <p>Tên đăng nhập: </p>
                                    <p>Mật khẩu cũ: </p>
                                    <p>Mật khẩu mới: </p>
                                    <p>Xác nhận mật khẩu mới: </p>
                                </div>
                                <div class="col-sm-5 left">
                                    <input required v-model="TaiKhoan" type="text" readonly="true" class="readonly">
                                    <p></p>
                                    <input required v-model="MatKhauCu2" type="password"  class="doimatkhau">
                                    <p></p>
                                    <input required v-model="MatKhauMoi" type="password"  class="doimatkhau">
                                    <p></p>
                                    <input required v-model="NhapLaiMatKhauMoi" type="password"  class="doimatkhau">
                                </div>
                            </div>
                            <div class="button">
                                <button class="btn-luuthaydoi" @click="DoiMatKhau">Lưu thay đổi</button>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- het thong tin tai khoan -->
            </div>
        </div>
    </div>
</template>

<script>
import axios from 'axios'
export default {
    name: 'KhachHangThueBao',
    data(){
        return {
            ID_KhachHang: null,
            TaiKhoan: null,
            MatKhauMoi: null,
            NhapLaiMatKhauMoi: null,
            MatKhauCu2: null,
            MatKhauCu: null,
            thanhcong: false,
            matkhaucusai: false,
            nhaplaimatkhaumoisai: false,
            matkhaumoikhacmatkhaucu: false,

            // thong tin dang ky thue bao
            SuDung_DaiDien: null,
            SuDung_ChucVu: null,
            SuDung_NgaySinh: null,
            SuDung_GoiTinh: null,
            SuDung_SoCCCD: null,
            SuDung_NgayCapCCCD: null,
            SuDung_NoiCapCCCD: null,
            SuDung_GiayChungNhan: null,
            SuDung_NgayCapGCN: null,
            SuDung_NoiCap_GDN: null,
            SuDung_DiaChiThuongTru: null,
            SuDung_DiaChiThanhToan: null,
            SuDung_TruSoGiaoDich: null,
            SuDung_TaiKhoanSo: null,
            SuDung_NganHang: null,
            SuDung_MST: null,
            SuDung_SDT: null,
            SuDung_Email: null,
            SuDung_LienHeKhac: null,
        }
    },
    created(){
        this.ID_KhachHang = localStorage.getItem('ID_KhachHang');
        console.log("IDget khachhang ", this.ID_KhachHang);
        this.AxiosAPI_ChiTietTaiKhoan();
        this.fetchAPI_thongtin_khachhang_chung();
        this.fetchAPI_LayDuLieuKhachHangChungHopDong();
    },
    methods:{
        async AxiosAPI_ChiTietTaiKhoan(){
            const DuLieu = await axios.get(
                `http://localhost:8081/api/banhang/chitiettaikhoan/${this.ID_KhachHang}`,
            );
            if(DuLieu.status === 200) {
                console.log("Dulieu tai khoan: ", DuLieu.data);
                this.TaiKhoan = DuLieu.data[0].TK_KH;
                this.MatKhauCu = DuLieu.data[0].MK_KH;
            }
        },
        async DoiMatKhau(){
            // neu bi rong -> loi
            if(this.MatKhauMoi == null || this.NhapLaiMatKhauMoi != this.MatKhauMoi ){
                console.log("(loi this.MatKhauMoi == null || this.NhapLaiMatKhauMoi != this.MatKhauMoi");
                this.nhaplaimatkhaumoisai = true;
                setTimeout( () => {
                    this.nhaplaimatkhaumoisai = false;
                }, 3000);
                return;
            }
            // neu nhap lai mk lan 2 != lan 1
            if(this.MatKhauMoi != this.NhapLaiMatKhauMoi) {
                console.log("this.MatKhauMoi != this.NhapLaiMatKhauMoi");
                this.nhaplaimatkhaumoisai = true;
                setTimeout(() => {
                    this.nhaplaimatkhaumoisai = false;
                }, 3000);
                return;
            }
            else {
                console.log("OK");
                const DuLieu = {
                    ID_KhachHang: this.ID_KhachHang,
                    TaiKhoan: this.TaiKhoan,
                    MatKhauCu: this.MatKhauCu2,
                    MatKhauMoi: this.MatKhauMoi
                };
                console.log("Thong tin gui ve BE: ", DuLieu);
                const YeuCau = await axios.post(
                    'http://localhost:8081/api/banhang/khachhangdoimatkhau',
                    DuLieu,
                    {
                        headers: {
                            'Content-Type':'application/json'
                        }
                    }
                );
                console.log("Du lieu tra ve: ", YeuCau);
                if(YeuCau.status === 200) { 
                    
                    // console.log("Doi mat khau thanh cong");
                    // this.thanhcong = true;
                    // setTimeout( () => {
                    //     this.thanhcong = false;
                    // }, 3000);
                }
                else {
                    // if sai mk -> bao loi
                    // if mk moi === mk cu -> bao loi
                    console.log("Loi doi mat khau");
                }
            }
        },
        //  het doi mat khau 
        
        async fetchAPI_thongtin_khachhang_chung(){
            try {
                const YeuCau = await axios.post(
                    `http://localhost:8081/api/banhang/getthongtinkhachhangchung/${this.ID_KhachHang}`,
                );
                if(YeuCau.status === 200) {
                    console.log("Thong tin khach hang chung: ", YeuCau.data);
                    this.SuDung_DaiDien = YeuCau.data[0].HOTEN_KHACHHANG;
                    this.SuDung_SDT = YeuCau.data[0].SDT_KHACHHANG;
                    this.SuDung_Email = YeuCau.data[0].EMAIL_KHACHHANG;
                    this.IDFK_ThongTinKhachHangChung = YeuCau.data[0].ID_THONGTIN_KHACHHANG_CHUNG;
                    
                }
                else {
                    console.log("loi thong tin khachhang chung");
                }
            }
            catch(error){
                console.log("loi lay thong tin khach hang chung: ", error);
            }
        },
        async fetchAPI_LayDuLieuKhachHangChungHopDong(){
                try {
                    const LayDuLieuKhachHangChungHopDong = await axios.post(`http://localhost:8081/api/banhang/laydulieukhachhanghopdong/${this.ID_KhachHang}`, {}, {
                        
                    });
                    if(LayDuLieuKhachHangChungHopDong.status === 200) {
                        // const DuLieu = LayDuLieuKhachHangChungHopDong.json();
                        console.log("da lay duoc fetchAPI_LayDuLieuKhachHangChungHopDong");
                        console.log("laydulieukhachhanghopdong: ", LayDuLieuKhachHangChungHopDong );
                        const DuLieu = LayDuLieuKhachHangChungHopDong.data[0];
                        this.SuDung_ChucVu = DuLieu.CHUCVU;
                        console.log("SuDung_ChucVu: ", this.SuDung_ChucVu);
                        this.SuDung_NgaySinh = DuLieu.NGAYSINH  ;
                        this.SuDung_GoiTinh = DuLieu.GIOITINH  ; 
                        this.SuDung_SoCCCD = DuLieu.SO_CCCD  ;
                        this.SuDung_NgayCapCCCD = DuLieu.NGAYCAP_CCCD  ;
                        this.SuDung_NoiCapCCCD = DuLieu.NOICAP_CCCD  ;
                        this.SuDung_GiayChungNhan = DuLieu.SO_GIAYCHUNGNHAN  ;
                        this.SuDung_NgayCapGCN = DuLieu.NGAYCAP_GIAYCHUNGNHAN  ;
                        this.SuDung_NoiCap_GDN = DuLieu.NOICAP_GIAYCHUNGNHAN  ;
                        this.SuDung_DiaChiThuongTru = DuLieu.DIACHI_THUONGTRU  ;
                        this.SuDung_DiaChiThanhToan = DuLieu.DIACHI_THANHTOAN  ;
                        this.SuDung_TruSoGiaoDich = DuLieu.DIACHI_TRUSOGIAODICH  ; 
                        this.SuDung_TaiKhoanSo = DuLieu.TAIKHOANSO  ;
                        this.SuDung_NganHang = DuLieu.TAINGANHANG  ;
                        this.SuDung_MST = DuLieu.MASOTHUE  ;
                        this.SuDung_LienHeKhac = DuLieu.LIENHEKHAC  ;
                        // this.SuDung_DiaChiThuongTru = 
                        this.ChuKyURL = DuLieu.CHUKY_KHACHHANG;
                        // console.log("URL: ", this.ChuKyURL);
                        const canvas = this.$refs.signatureCanvas;

                        if (canvas && this.ChuKyURL) {
                            const ctx = canvas.getContext('2d');
                            const image = new Image();

                            image.onload = () => {
                                console.log("Ảnh đã tải xong, bắt đầu vẽ...");
                                ctx.clearRect(0, 0, canvas.width, canvas.height);
                                ctx.drawImage(image, 0, 0, canvas.width, canvas.height);
                                console.log("Đã vẽ ảnh lên canvas.");
                            };

                            image.onerror = () => {
                                console.error("Không thể tải ảnh từ URL:", this.ChuKyURL);
                            };

                            image.src = this.ChuKyURL;
                        } else {
                            console.error("Canvas hoặc URL chữ ký không tồn tại.");
                        }


                    }
                    else {
                        console.log("Loi laydulieukhachhanghopdong");
                    }
                }
                catch(error) {
                    console.log("Loi laydulieukhachhanghopdong", error);
                }
            },
            // het lay du lieu thong tin dang ky thue bao
            

    }
}
</script>

<style scoped>
.main{
    width: 100%;
    background-color: white;
    display: flex;
    justify-content: center;
}
.main-container{
    background-color: white;
    width: 95%;
    
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
.right {
    text-align: right;
}
.left {
    text-align: left;
}
.readonly {
    border: none;
    background-color: #f5f4f0;
}
.bandau, .suadoi, .thongtinthuebao {
    border: 1px solid #31649e;
    border-radius: 10px;
    padding-top: 10px;
}
.thongtinthuebao p {
    margin-left: 10px;
}
.suadoi {
    margin-top: 20px;
    padding-bottom: 20px;
}
input {
    width: 100%;
}
.button {
    display: flex;
    justify-content: center;
    margin-top: 20px;
}
.btn-luuthaydoi {
    background-color: #1f7ed1;
    color: white;
    padding-left: 10px;
    padding-right: 10px;
    font-weight: 500;
    border: 2px solid #1f7ed1;
    font-size: 18px;
}
.btn-luuthaydoi:hover {
    background-color: white;
    color: #1f7ed1;
}
.doimatkhau:focus{
    outline:none;
}
.thongbao {
    text-align: center;
    display: flex;
    justify-content: center;
    align-items: center;
    color: white;
    padding-top: 5px;
    padding-bottom: 2px;
    margin-bottom: 5px;
    font-weight: 500;
}
.thanhcong {
    background-color: #34a853;
    
}
.error{
    background-color: #ff0808;
}
</style>