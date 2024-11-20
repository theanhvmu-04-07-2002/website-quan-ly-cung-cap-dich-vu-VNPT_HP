<template>
    <div class="quanly-donhang">
        <div class="header blue">
            <p class="bold white center inhoa h2">quản lý khảo sát và lắp đặt</p>
        </div>
        
        <div class="content-donhang">
            <!-- don hang cho khao sat va lap dat -->
            <div class="thongtindonhang back-blue bang">
                <div class="blue tenbang">
                    <p class="bold white center inhoa">thông tin đơn hàng chờ khảo sát và lắp đặt</p>
                </div>
                <table class="table-bordered">
                    <thead>
                        <tr>
                            <th>STT</th>
                            <th>Thời gian</th>
                            <th>ID đơn hàng</th>
                            <th>Tên KH</th>
                            <th>SDT KH</th>
                            <th>Email KH</th>
                            <th>Quận huyện</th>
                            <th>Phường xã</th>
                            <th>Chi tiết</th>
                            <th>Ghi chú</th>
                            <!-- <th>Hình thức trả cước</th> -->
                            <th>Dịch vụ</th>
                            <th>Thao tác</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr
                        v-for="(DonHang, index) in DanhSachDonHangChoKhaoSat"
                        
                        :key="index"
                        >   <td>{{index + 1}}</td>
                            <td>{{DonHang.THOIGIANTAO}}</td>
                            <td>{{DonHang.ID_DONHANG}}</td>
                            <td>{{DonHang.HOTEN_KHACHHANG}}</td>
                            <td>{{DonHang.SDT_KHACHHANG}}</td>
                            <td>{{DonHang.EMAIL_KHACHHANG}}</td>
                            <td>{{DonHang.TENQUANHUYEN}}</td>
                            <td>{{DonHang.TENPHUONGXA}}</td>
                            <td>{{DonHang.CHITIET_KHACHHANG}}</td>
                            <td>{{DonHang.GHICHU_KHACHHANG}}</td>
                            <!-- <td>{{DonHang.TENHINHTHUC}}</td> -->
                            <td>{{DonHang.TENGDV}}</td>
                            <td>
                                <button class="btn btn-primary" @click="CapNhatKhaoSat(DonHang)">cập nhật</button>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <!-- het thong tin don hang cho khao sat va lap dat-->
            
            <!-- cap nhat ket qua khao sat va lap dat -->
            <div class="capnhatdonhang back-white bang" v-show="HienThiFormCapNhatKetQuaKhaoSat">
                
                <div class="thongtindonhang">
                    <div class="blue tenbang">
                        <p class="bold white center inhoa">cập nhật kết quả khảo sát và lắp đặt</p>
                    </div>
                    <div v-show="CapNhat_ThongBao_ChuaNhapHetThongTin" class="thongbao_chuanhaphetthongtin">
                        <div class="alert alert-danger">
                            <strong>Lỗi !</strong> Chưa nhập hết thông tin.
                        </div>
                    </div>
                    <div v-show="CapNhat_ThongBao_ThanhCong" class="thongbao_chuanhaphetthongtin">
                        <div class="alert alert-info">
                            <strong>Thông báo !</strong> Đã cập nhật thông tin.
                        </div>
                    </div>
                    <form  action="" class="form-group">
                        
                        <div class="row">
                            <div class="col-sm-4">
                                <div class="input-group">
                                    <span>Thời gian tạo:</span>
                                    <input type="text" class="form-controll" disabled="true" v-model="DonHangCapNhat.THOIGIANTAO">
                                </div>
                                <div class="input-group">
                                    <span>ID đơn hàng</span>
                                    <input type="text" class="form-controll" disabled="true" v-model="DonHangCapNhat.ID_DONHANG">
                                </div>
                                <div class="input-group">
                                    <span>Tên khách hàng</span>
                                    <input type="text" class="form-controll" disabled="true" v-model="DonHangCapNhat.HOTEN_KHACHHANG">
                                </div>
                                <div class="input-group">
                                    <span>SDT khách hàng</span>
                                    <input type="text" class="form-controll" disabled="true" v-model="DonHangCapNhat.SDT_KHACHHANG">
                                </div>
                                <div class="input-group">
                                    <span>Email khách hàng</span>
                                    <input type="text" class="form-controll" disabled="true" v-model="DonHangCapNhat.EMAIL_KHACHHANG">
                                </div>
                                
                            </div>
                            <!-- end -->
                            <div class="col-sm-4">
                                <div class="input-group">
                                    <span>Quận huyện:</span>
                                    <input disabled="true" type="text" class="form-controll" v-model="DonHangCapNhat.TENQUANHUYEN">
                                    
                                </div>
                                <div class="input-group">
                                    <span>Phường xã</span>
                                    <input disabled="true" type="text" class="form-controll" v-model="DonHangCapNhat.TENPHUONGXA">
                                    
                                </div>
                                <div class="input-group">
                                    <span>Hình thức trả cước</span>
                                    <input disabled="true" type="text" class="form-controll" v-model="DonHangCapNhat.TENHINHTHUC">
                                    
                                </div>
                                <div class="input-group">
                                    <span>Dịch vụ</span>
                                    <input disabled="true" type="text" class="form-controll" v-model="DonHangCapNhat.TENGDV">
                                    
                                    
                                </div>
                                
                                
                            </div>
                            <!--  -->
                            <div class="col-sm-4">
                                <div class="input-group">
                                    <span>Chi tiết địa chỉ:</span>
                                    <textarea disabled="true" class="form-controll" v-model="DonHangCapNhat.CHITIET_KHACHHANG" name="" id="" cols="30" rows="2" ></textarea>
                                    <!-- <input type="text" class="form-controll" v-model="DonHangCapNhat.CHITIET_KHACHHANG"> -->
                                </div>
                                <div class="input-group">
                                    <span>Ghi chú khách hàng</span>
                                    <textarea disabled="true" class="form-controll" name="" id="" cols="30" rows="2" v-model="DonHangCapNhat.GHICHU_KHACHHANG"></textarea>
                                    <!-- <input type="text" class="form-controll" v-model="DonHangCapNhat.GHICHU_KHACHHANG"> -->
                                </div>

                                <div class="input-group">
                                    <span>Kết quả khảo sát</span>
                                    <!-- <input type="text" class="form-controll" v-model="DonHangCapNhat.TENHINHTHUC"> -->
                                    <VueSelect2
                                        v-model="KetQuaKhaoSat"
                                        :options="DanhSachKetQuaKhaoSat"
                                        class="form-controll"
                                        placeholder="-----------------"
                                        @change="LuaChonKQKhaoSat"
                                        >
                                    </VueSelect2>
                                </div>
                                <div class="input-group">
                                    <span>Kết quả lắp đặt</span>
                                    <!-- <input type="text" class="form-controll" v-model="DonHangCapNhat.TENGDV"> -->
                                    <VueSelect2
                                    v-model="KetQuaLapDat"
                                    :options="DanhSachKetQuaLapDat"
                                    class="form-controll"
                                    placeholder="-----------------"
                                    :disabled="LuaChonKQLapDat"
                                    >
                                    </VueSelect2>
                                    
                                </div>
                                <div class="input-group">
                                    <span>Ghi chú khảo sát & lắp đặt</span>
                                    <textarea class="form-controll" name="" id="" cols="30" rows="2" v-model="GhiChuKhaoSat"></textarea>
                                    <!-- <input type="text" class="form-controll" v-model="DonHangCapNhat.GHICHU_KHACHHANG"> -->
                                </div>
                                
                            </div>
                        </div>
                        <div class="button-group">
                            <!-- <input type="submit" value="Lưu" class="btn btn-success" id="button"> -->
                            <button class="btn btn-success" @click="LuuCapNhatKetQuaKhaoSat" type="button" id="button">Lưu</button>
                            <button class="btn btn-danger" @click="DongFormCapNhatKhaoSat" type="button" id="button">Hủy</button>
                        </div>
                        <!-- <div class="alert alert-success" v-show="DaLuuDuLieuCapNhat">
                            <strong>Thông báo: </strong>Đã lưu dữ liệu cập nhật
                        </div> -->
                        <input type="hidden" v-model="DonHangCapNhat.ID_DONHANG" >
                    </form>
                </div>
                
            </div>
            <!-- het cap nhat khao sat -->
            <!-- danh sach don hang da khao sat va lap dat -->
            <div class="thongtindonhang back-orange bang">
                <div class="blue tenbang">
                    <p class="bold white center inhoa">thông tin đơn hàng đã khảo sát và lắp đặt</p>
                </div>
                <table class="table-bordered">
                    <thead>
                        <tr>
                            <th>STT</th>
                            <th>Thời gian yêu cầu</th>
                            <th>Thời gian hoàn tất</th>
                            <th>ID đơn hàng</th>
                            <th>Tên KH</th>
                            <th>SDT KH</th>
                            <!-- <th>Email KH</th> -->
                            <th>Quận huyện</th>
                            <th>Phường xã</th>
                            <th>Chi tiết</th>
                            <th>Ghi chú</th>
                            <!-- <th>Hình thức trả cước</th> -->
                            <th>Dịch vụ</th>
                            <!-- <th>Trạng thái</th> -->
                            <th>KQ khảo sát</th>
                            <th>KQ lắp đặt</th>
                            <th>Trạng thái</th>
                            <th>Ghi chú</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr
                        v-for="(DonHang, index) in DanhSachDonHangDaKhaoSat"
                        
                        :key="index"
                        >   <td>{{index + 1}}</td>
                            <td>{{DonHang.THOIGIANTAO}}</td>
                            <td>{{DonHang.THOIGIANHOANTTAT}}</td>
                            <td>{{DonHang.ID_DONHANG}}</td>
                            <td>{{DonHang.HOTEN_KHACHHANG}}</td>
                            <td>{{DonHang.SDT_KHACHHANG}}</td>
                            <!-- <td>{{DonHang.EMAIL_KHACHHANG}}</td> -->
                            <td>{{DonHang.TENQUANHUYEN}}</td>
                            <td>{{DonHang.TENPHUONGXA}}</td>
                            <td>{{DonHang.CHITIET_KHACHHANG}}</td>
                            <td>{{DonHang.GHICHU_KHACHHANG}}</td>
                            <!-- <td>{{DonHang.TENHINHTHUC}}</td> -->
                            <td>{{DonHang.TENGDV}}</td>
                            <td>{{DonHang.TEN_KQ_KHAOSAT}}</td>
                            <td>{{DonHang.TEN_KQ_LAPDAT}}</td>
                            <td>
                                <!-- <span v-if="DonHang.TEN_TRANGTHAI_LAPDAT=== 'Thất bại' " style="color: red;background-color:#f7d7da;">{{DonHang.TEN_TRANGTHAI_LAPDAT}}</span> -->
                                <span v-if="DonHang.TEN_TRANGTHAI_LAPDAT=== 'Thất bại' " ><Icon icon="mdi:error" width="30" height="30"  style="color: #f20707" /></span>
                                <!-- <span v-if="DonHang.TEN_TRANGTHAI_LAPDAT=== 'Thành công' " style="background-color:#cff4fc;">{{DonHang.TEN_TRANGTHAI_LAPDAT}}</span> -->
                                <span v-if="DonHang.TEN_TRANGTHAI_LAPDAT=== 'Thành công' " ><Icon icon="ep:success-filled" width="30" height="30"  style="color: #07f217" /></span>

                            </td>
                            <td>{{DonHang.GHICHU_DONHANG}}</td>
                            
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>

    </div>
</template>

<script>
import axios from 'axios';
import {Icon} from '@iconify/vue2'
export default { 
    name:'QuanLyDonHang',
    components:{
        Icon,
    },
    data(){
        return {
            
            DanhSachDonHang:[],
            DanhSachDonHangChoKhaoSat:[],
            DonHangCapNhat:{},            
            HienThiFormCapNhatKetQuaKhaoSat: false,
            

            DanhSachQuanHuyen:[],
            DanhSachPhuongXa:[],
            DanhSachPhuongXaChonLoc:[],
            DanhSachHinhThucTraCuoc: [],
            DanhSachGoiDichVu:[],

            QuanHuyenKhachHang: null,
            PhuongXaKhachHang: null,
            HinhThucTraCuoc: null,
            DonHang: null,
            GoiDichVu: null,
            ID_QuanHuyenCapNhat:null,
            TaoMoi_ThongBao_ChuaNhapHetThongTin: false,
            CapNhat_ThongBao_ChuaNhapHetThongTin: false,
            TaoMoi_ThongBao_ThanhCong : false,
            CapNhat_ThongBao_ThanhCong : false,

            // cap nhat kq khao sat
            KetQuaKhaoSat: null,
            DanhSachKetQuaKhaoSat:[],
            KetQuaLapDat: null,
            DanhSachKetQuaLapDat:[],
            // don hang da khao sat
            DanhSachDonHangDaKhaoSat:[],
            TrangThaiLapDat: null,
            LuaChonKQLapDat: false,
            GhiChuKhaoSat: null,
            ThoiGianHoanTat: null,

            // tao tai khoan:
            TaiKhoan: null,
            MatKhau: null,
            PhanQuyen: null,

            // insert
            IDFK_TaiKhoanKhachHang: null,
            IDFK_ThongTinKhachHangChung: null,
            IDFK_DonHang: null,
        }
    },
    created(){
        this.fetchAPI_DanhSachDonHang();
        this.fetchAPI_DanhSachKetQuaKhaoSat();
        this.fetchAPI_DanhSachKetQuaLapDat();

        this.ThoiGianTao = this.FormatTime();
        this.ThoiGianHoanTat = this.FormatTime();
    },
    methods:{
        async fetchAPI_DanhSachDonHang(){
            try {
                const ketnoi = await fetch('http://localhost:8081/api/quanly/thongtindonhang');
                if(ketnoi.ok) {
                    const Data = await ketnoi.json();
                    this.DanhSachDonHang = Data;
                    this.DanhSachDonHangChoKhaoSat = this.DanhSachDonHang.filter(
                        (DonHang) => {
                            return DonHang.IDFK_TRANGTHAI_LAPDAT == null;
                        }
                    );
                    this.DanhSachDonHangDaKhaoSat = this.DanhSachDonHang.filter(
                        (DonHang) => {
                            return DonHang.IDFK_TRANGTHAI_LAPDAT != null;
                        }
                    )
                }
                // console.log("Danh sach don hang: ", this.DanhSachDonHangChoKhaoSat);
            }
            catch(error) {
                console.log("Loi: ", error);
            }
        } ,
        CapNhatKhaoSat(DonHang) {
            this.DonHangCapNhat = {...DonHang};
            this.HienThiFormCapNhatKetQuaKhaoSat= true;
            // khoi tao them :
            this.QuanHuyenKhachHang = DonHang.QUANHUYEN_KHACHHANG;
            this.HinhThucTraCuoc = DonHang.HINHTHUCTRACUOC;
            
            this.PhuongXaKhachHang = DonHang.PHUONGXA_KHACHHANG;
            this.GoiDichVu = DonHang.GOIDICHVU;
        },
        DongFormCapNhatKhaoSat(){
            this.HienThiFormCapNhatKetQuaKhaoSat = false;
        },
        
        async fetchAPI_DanhSachKetQuaKhaoSat(){
            try {
                const KetNoi = await fetch('http://localhost:8081/api/quanly/ketquakhaosat');
                if(KetNoi.ok) {
                    const Data = await KetNoi.json();
                    this.DanhSachKetQuaKhaoSat = Data.map(
                        (KetQua) => {
                            return {
                                id: KetQua.ID_KQ_KHAOSAT,
                                text: KetQua.TEN_KQ_KHAOSAT
                            }
                        }
                    );
                }
            }
            catch(error){
                console.log("Loi: ", error);
            }
        },
        
        async fetchAPI_DanhSachKetQuaLapDat(){
            try {
                const KetNoi = await fetch('http://localhost:8081/api/quanly/ketqualapdat');
                if(KetNoi.ok) {
                    const Data = await KetNoi.json();
                    this.DanhSachKetQuaLapDat = Data.map(
                        (KetQua) => {
                            return {
                                id: KetQua.ID_KQ_LAPDAT,
                                text: KetQua.TEN_KQ_LAPDAT
                            }
                        }
                    );
                }
            }
            catch(error){
                console.log("Loi: ", error);
            }
        },

        LuaChonKQKhaoSat(){
            if(this.KetQuaKhaoSat == 2) {
                this.LuaChonKQLapDat = true;
                this.KetQuaLapDat = 2;
            }
            else {
                this.LuaChonKQLapDat = false;
                this.KetQuaLapDat = null;
            }
        },

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
        
        async LuuCapNhatKetQuaKhaoSat(){
            if(
                this.KetQuaKhaoSat == null 
                || this.KetQuaLapDat == null
                || this.GhiChuKhaoSat == null
            ) {
                this.CapNhat_ThongBao_ChuaNhapHetThongTin = true;
                setTimeout(()=> {
                    this.CapNhat_ThongBao_ChuaNhapHetThongTin = false;
                }, 2500);
            }

            else {
                    if(this.KetQuaLapDat == 1) {
                        this.TrangThaiLapDat = 1;
                    }
                    if(this.KetQuaLapDat == 2) {
                        this.TrangThaiLapDat = 2;
                    }

                    this.IDFK_DonHang = this.DonHangCapNhat.ID_DONHANG;
                    console.log("IDFK_DonHang: ", this.IDFK_DonHang);
                    // xu ly insert tai khoan
                    try {
                        this.TaiKhoan = this.DonHangCapNhat.SDT_KHACHHANG;
                        const TaiKhoanKhachHang = {
                            TaiKhoan: this.TaiKhoan,
                            PhanQuyen: this.PhanQuyen
                        }
                        const insert_tk_kh = await axios.post(
                            'http://localhost:8081/api/quanly/quanlykythuat/inserttaikhoankhachhang',
                            TaiKhoanKhachHang,
                            {
                                headers: {
                                    'Content-Type':'application/json'
                                }
                            }
                        );
                        if(insert_tk_kh.status === 200) {
                            this.IDFK_TaiKhoanKhachHang = insert_tk_kh.data.IDFK_TaiKhoan_KhachHang;
                            console.log("IDFK_TaiKhoanKhachHang: ", this.IDFK_TaiKhoanKhachHang);
                        }
                        else {
                            console.log("Loi insert tai khoan khach hang");
                        }
                    }
                    catch(error) {
                        console.log("Loi insert tai khoan khach hang: ", error);
                    }

                    // xu ly thong tin khach hang chung
                    try {
                        const ThongTinKhachHangChung = {
                            HoTen_KhachHang: this.DonHangCapNhat.HOTEN_KHACHHANG,
                            SDT_KhachHang: this.DonHangCapNhat.SDT_KHACHHANG,
                            Email_KhachHang: this.DonHangCapNhat.EMAIL_KHACHHANG,
                            QuanHuyen_KhachHang: this.DonHangCapNhat.QUANHUYEN_KHACHHANG,
                            PhuongXa_KhachHang: this.DonHangCapNhat.PHUONGXA_KHACHHANG,
                            ChiTiet_KhachHang: this.DonHangCapNhat.CHITIET_KHACHHANG
                        };
                        console.log("thong tin khach hang chung: ", ThongTinKhachHangChung);
                        const Insert_ThongTinKhachHangChung = await axios.post('http://localhost:8081/api/quanly/quanlykythuat/insertthongtinkhachhangchung', ThongTinKhachHangChung, {
                            headers: {
                                'Content-Type': 'application/json'
                            }
                        });
                        if(Insert_ThongTinKhachHangChung.status === 200){
                            console.log("Insert thong tin khach hang chung thanh cong");
                            this.IDFK_ThongTinKhachHangChung = Insert_ThongTinKhachHangChung.data.IDFK_ThongTinKhachHangChung;
                            console.log("IDFK_ThongTinKhachHangChung: ", this.IDFK_ThongTinKhachHangChung);

                        }
                        else {
                            console.log("loi insert thong tin khachhang chung");
                        }
                        
                    }
                    catch(error) {
                        console.log("Loi insert thong tin khachhang chung: ", error);
                    }

                    // xu ly insert cap nhat donhang ky thuat
                    const CapNhatDonHang = {
                    DonHangCapNhat: this.DonHangCapNhat.ID_DONHANG ,
                    KetQuaKhaoSat: this.KetQuaKhaoSat,
                    KetQuaLapDat: this.KetQuaLapDat,
                    TrangThaiLapDat:this.TrangThaiLapDat,
                    GhiChuKhaoSat: this.GhiChuKhaoSat,
                    ThoiGianHoanTat: this.ThoiGianHoanTat,
                    }
                    console.log("Thong tin cap nhat khao sat: ", CapNhatDonHang);
                    try{
                        const YeuCau = await axios.post('http://localhost:8081/api/quanly/quanlykythuat/capnhatlapdat', CapNhatDonHang, {
                            headers: {
                                'Content-Type':'application/json'
                        } });
                        if (YeuCau.status === 200) {
                            console.log("Cập nhật đơn hàng thành công với thông tin tài khoản");
                            
                        }
                    }
                    catch(error) {
                        console.log("Loi cap nhat khao sat va lap dat: ", error);
                    }

                    // xu ly insert khachhang
                    try {
                        const ThongTinKhachHang = {
                            IDFK_TaiKhoanKhachHang: this.IDFK_TaiKhoanKhachHang,
                            IDFK_ThongTinKhachHangChung: this.IDFK_ThongTinKhachHangChung,
                            IDFK_DonHang: this.IDFK_DonHang
                        };
                        console.log("Thong tin cap nhat khach hang: ", ThongTinKhachHang);
                        const Insert_KhachHang = await axios.post('http://localhost:8081/api/quanly/quanlykythuat/insertkhachhang',ThongTinKhachHang, {
                            headers: {
                                'Content-Type':'application/json'
                            }
                        });
                        if(Insert_KhachHang.status === 200) {
                            console.log ("Cap nhat khach hang thanh cong");
                            this.CapNhat_ThongBao_ThanhCong = true;
                            setTimeout(() => {
                                this.CapNhat_ThongBao_ThanhCong = false;
                            }, 2500);
                        }
                    }
                    catch(error) {
                        console.log("Loi insert khach hang: ", error);
                    }

                    
            }

        },

        
        
    }
}

</script>
<style scope>
.blue {
    background-color: rgb(48, 84, 150);
}

.center {
    text-align: center;
}

.white {
    color: white;
}

.inhoa {
    text-transform: uppercase;
}

.h2 {
    font-weight: 500;
    font-size: 20px;
    padding:5px;
}

table {
    width: 100%;
}
.tenbang {
    margin-bottom: -15px;
}
.bang {
    margin-bottom: 20px;
}
.col-sm-4{
    flex-wrap: 20px;
}
.form-controll {
    display: block;
    width: 100%;
    margin-bottom: 10px;
    border: 1px solid black;
}
.button-group{
    display: flex;
    justify-content: center;
    gap: 40px;
    margin-bottom: 20px;
}
#button {
    padding-left: 50px;
    padding-right: 50px;
}
span {
    font-weight: 600;
    color:#305496;
}
.input-group{
    width: 100%;
}
.btn-taomoidonhang {
    background-color: #03ab6d;
    border: 1px solid #4e64b5;
    padding:5px;
}
.taomoidonhang {
    margin-bottom: 10px;
}

.taomoidonhang {
    margin-bottom: 10px;
}
.back-white {
    background-color: white;
}
.back-blue {
    background-color:#cff4fc ;
}
.back-orange {
    background-color: #fff3cc;
}
.capnhatdonhang {
    border: 1px solid black;
}

</style>
