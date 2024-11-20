<template>
    <div class="quanly-BaoHong">
        <div class="header blue">
            <p class="bold white center inhoa h2">quản lý báo hỏng</p>
        </div>
        
        <div class="content-BaoHong">
            <!-- don hang cho khao sat va lap dat -->
            <div class="thongtinBaoHong back-blue bang">
                <div class="blue tenbang">
                    <p class="bold white center inhoa">thông tin báo hỏng chờ sửa chữa</p>
                </div>
                <table class="table-bordered">
                    <thead>
                        <tr>
                            <th>STT</th>
                            <th>Thời gian báo hỏng</th>
                            <th>ID báo hỏng</th>
                            <th>Tên KH</th>
                            <th>SDT KH</th>
                            <th>Quận huyện</th>
                            <th>Phường xã</th>
                            <th>Chi tiết</th>
                            <th>Dịch vụ</th>
                            <th>Nội dung báo hỏng</th>
                            <th>Chi tiết báo hỏng</th>
                            <th>Thao tác</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr
                        v-for="(BaoHong, index) in DanhSachBaoHongDaGui"
                        
                        :key="index"
                        >   <td>{{index + 1}}</td>
                            <td>{{BaoHong.THOIGIANBAOHONG}}</td>
                            <td>{{BaoHong.ID_BAOHONG}}</td>
                            <td>{{BaoHong.HOTEN_KHACHHANG}}</td>
                            <td>{{BaoHong.SDT_KHACHHANG}}</td>
                            <td>{{BaoHong.TENQUANHUYEN}}</td>
                            <td>{{BaoHong.TENPHUONGXA}}</td>
                            <td>{{BaoHong.CHITIET_KHACHHANG}}</td>
                            <td>{{BaoHong.TENGDV}}</td>
                            <td>{{BaoHong.NOIDUNGBAOHONG}}</td>
                            <td>{{BaoHong.CHITIET_BAOHONG}}</td>
                            <td>
                                <button class="btn btn-primary" @click="CapNhatSuaChua(BaoHong)">cập nhật</button>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <!-- het thong tin don hang cho khao sat va lap dat-->
            
            <!-- cap nhat ket qua khao sat va lap dat -->
            <div class="capnhatBaoHong back-white bang" v-show="HienThiFormCapNhatKetQuaSuaChua">
                
                <div class="thongtinBaoHong">
                    <div class="blue tenbang">
                        <p class="bold white center inhoa">cập nhật kết quả sửa chữa</p>
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
                                    <input type="text" class="form-controll" disabled="true" v-model="BaoHongCapNhat.THOIGIANBAOHONG">
                                </div>
                                <div class="input-group">
                                    <span>ID báo hỏng</span>
                                    <input type="text" class="form-controll" disabled="true" v-model="BaoHongCapNhat.ID_BAOHONG">
                                </div>
                                <div class="input-group">
                                    <span>Tên khách hàng</span>
                                    <input type="text" class="form-controll" disabled="true" v-model="BaoHongCapNhat.HOTEN_KHACHHANG">
                                </div>
                                <div class="input-group">
                                    <span>SDT khách hàng</span>
                                    <input type="text" class="form-controll" disabled="true" v-model="BaoHongCapNhat.SDT_KHACHHANG">
                                </div>
                                <div class="input-group">
                                    <span>Quận huyện:</span>
                                    <input disabled="true" type="text" class="form-controll" v-model="BaoHongCapNhat.TENQUANHUYEN">
                                    
                                </div>
                                <div class="input-group">
                                    <span>Phường xã</span>
                                    <input disabled="true" type="text" class="form-controll" v-model="BaoHongCapNhat.TENPHUONGXA">
                                    
                                </div>
                                <div class="input-group">
                                    <span>Chi tiết</span>
                                    <input disabled="true" type="text" class="form-controll" v-model="BaoHongCapNhat.CHITIET_KHACHHANG">
                                    
                                </div>
                                
                            </div>
                            <!-- end -->
                            <div class="col-sm-4">
                                
                                <div class="input-group">
                                    <span>Dịch vụ</span>
                                    <input disabled="true" type="text" class="form-controll" v-model="BaoHongCapNhat.TENGDV">
                                </div>
                                <div class="input-group">
                                    <span>Nội dung báo hỏng</span>
                                    <textarea disabled="true" class="form-controll" name="" id="" cols="30" rows="3" v-model="BaoHongCapNhat.NOIDUNGBAOHONG"></textarea>
                                    <!-- <input disabled="true" type="text" class="form-controll" v-model="BaoHongCapNhat.NOIDUNGBAOHONG"> -->
                                </div>
                                <div class="input-group">
                                    <span>Chi tiết báo hỏng</span>
                                    <textarea disabled="true" class="form-controll" name="" id="" cols="30" rows="3" v-model="BaoHongCapNhat.CHITIET_BAOHONG"></textarea>
                                    <!-- <input disabled="true" type="text" class="form-controll" v-model="BaoHongCapNhat.CHITIET_BAOHONG"> -->
                                </div>
                                
                                
                            </div>
                            <!--  -->
                            <div class="col-sm-4">
                                <div class="input-group">
                                    <span>Chi tiết địa chỉ:</span>
                                    <textarea disabled="true" class="form-controll" v-model="BaoHongCapNhat.CHITIET_KHACHHANG" name="" id="" cols="30" rows="2" ></textarea>
                                    <!-- <input type="text" class="form-controll" v-model="BaoHongCapNhat.CHITIET_KHACHHANG"> -->
                                </div>
                                
                                <div class="input-group">
                                    <span>Lỗi gây hỏng: </span>
                                    <textarea class="form-controll" name="" id="" cols="30" rows="4" v-model="LoiGayHong"></textarea>
                                    <!-- <input type="text" class="form-controll" v-model="BaoHongCapNhat.GHICHU_KHACHHANG"> -->
                                </div>
                                <div class="input-group">
                                    <span>Tiến hành sửa chữa: </span>
                                    <textarea class="form-controll" name="" id="" cols="30" rows="4" v-model="TienHanhSuaChua"></textarea>
                                    <!-- <input type="text" class="form-controll" v-model="BaoHongCapNhat.GHICHU_KHACHHANG"> -->
                                </div>
                                <div class="input-group">
                                    <span>Kết quả sửa chữa</span>
                                    <!-- <input type="text" class="form-controll" v-model="BaoHongCapNhat.TENHINHTHUC"> -->
                                    <VueSelect2
                                        v-model="KetQuaSuaChua"
                                        :options="DanhSachKetQuaSuaChua"
                                        class="form-controll"
                                        placeholder="-----------------"
                                        
                                        >
                                    </VueSelect2>
                                </div>
                            </div>
                        </div>
                        <div class="button-group">
                            <!-- <input type="submit" value="Lưu" class="btn btn-success" id="button"> -->
                            <button class="btn btn-success" @click="LuuCapNhatKetQuaSuaChua" type="button" id="button">Lưu</button>
                            <button class="btn btn-danger" @click="DongFormCapNhatSuaChua" type="button" id="button">Hủy</button>
                        </div>
                        <!-- <div class="alert alert-success" v-show="DaLuuDuLieuCapNhat">
                            <strong>Thông báo: </strong>Đã lưu dữ liệu cập nhật
                        </div> -->
                        <input type="hidden" v-model="BaoHongCapNhat.ID_BaoHong" >
                    </form>
                </div>
                
            </div>
            <!-- het cap nhat khao sat -->
            <!-- danh sach don hang da khao sat va lap dat -->
            <div class="thongtinBaoHong back-orange bang">
                <div class="blue tenbang">
                    <p class="bold white center inhoa">thông tin báo hỏng đã sửa chữa</p>
                </div>
                <table class="table-bordered">
                    <thead>
                        <tr>
                            <th>STT</th>
                            <th>Thời gian báo hỏng</th>
                            <th>Thời gian hoàn tất</th>
                            <th>ID báo hỏng</th>
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
                        v-for="(BaoHong, index) in DanhSachBaoHongDaSuaChua"
                        
                        :key="index"
                        >   <td>{{index + 1}}</td>
                            <td>{{BaoHong.THOIGIANTAO}}</td>
                            <td>{{BaoHong.THOIGIANHOANTTAT}}</td>
                            <td>{{BaoHong.ID_BAOHONG}}</td>
                            <td>{{BaoHong.HOTEN_KHACHHANG}}</td>
                            <td>{{BaoHong.SDT_KHACHHANG}}</td>
                            <!-- <td>{{BaoHong.EMAIL_KHACHHANG}}</td> -->
                            <td>{{BaoHong.TENQUANHUYEN}}</td>
                            <td>{{BaoHong.TENPHUONGXA}}</td>
                            <td>{{BaoHong.CHITIET_KHACHHANG}}</td>
                            <td>{{BaoHong.GHICHU_KHACHHANG}}</td>
                            <!-- <td>{{BaoHong.TENHINHTHUC}}</td> -->
                            <td>{{BaoHong.TENGDV}}</td>
                            <td>{{BaoHong.TEN_KQ_SuaChua}}</td>
                            <td>{{BaoHong.TEN_KQ_LAPDAT}}</td>
                            <td>
                                <!-- <span v-if="BaoHong.TEN_TRANGTHAI_LAPDAT=== 'Thất bại' " style="color: red;background-color:#f7d7da;">{{BaoHong.TEN_TRANGTHAI_LAPDAT}}</span> -->
                                <span v-if="BaoHong.TEN_TRANGTHAI_LAPDAT=== 'Thất bại' " ><Icon icon="mdi:error" width="30" height="30"  style="color: #f20707" /></span>
                                <!-- <span v-if="BaoHong.TEN_TRANGTHAI_LAPDAT=== 'Thành công' " style="background-color:#cff4fc;">{{BaoHong.TEN_TRANGTHAI_LAPDAT}}</span> -->
                                <span v-if="BaoHong.TEN_TRANGTHAI_LAPDAT=== 'Thành công' " ><Icon icon="ep:success-filled" width="30" height="30"  style="color: #07f217" /></span>

                            </td>
                            <td>{{BaoHong.GHICHU_BaoHong}}</td>
                            
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
    name:'QuanLyBaoHong',
    components:{
        Icon,
    },
    data(){
        return {
            
            DanhSachBaoHong:[],
            DanhSachBaoHongDaGui:[],
            BaoHongCapNhat:{},            
            HienThiFormCapNhatKetQuaSuaChua: false,
            

            DanhSachQuanHuyen:[],
            DanhSachPhuongXa:[],
            DanhSachPhuongXaChonLoc:[],
            DanhSachHinhThucTraCuoc: [],
            DanhSachGoiDichVu:[],

            QuanHuyenKhachHang: null,
            PhuongXaKhachHang: null,
            HinhThucTraCuoc: null,
            BaoHong: null,
            GoiDichVu: null,
            ID_QuanHuyenCapNhat:null,
            TaoMoi_ThongBao_ChuaNhapHetThongTin: false,
            CapNhat_ThongBao_ChuaNhapHetThongTin: false,
            TaoMoi_ThongBao_ThanhCong : false,
            CapNhat_ThongBao_ThanhCong : false,

            // cap nhat kq khao sat
            KetQuaSuaChua: null,
            DanhSachKetQuaSuaChua:[],
            KetQuaLapDat: null,
            DanhSachKetQuaLapDat:[],
            // don hang da khao sat
            DanhSachBaoHongDaSuaChua:[],
            TrangThaiLapDat: null,
            LuaChonKQLapDat: false,
            LoiGayHong: null,
            ThoiGianHoanTat: null,

            // tao tai khoan:
            TaiKhoan: null,
            MatKhau: null,
            PhanQuyen: null,

            // insert
            IDFK_TaiKhoanKhachHang: null,
            IDFK_ThongTinKhachHangChung: null,
            IDFK_BaoHong: null,

            // bao hong
            TienHanhSuaChua: null,
        }
    },
    created(){
        this.AxiosAPI_GetBaoHongChoSuaChua();
        this.fetchAPI_DanhSachKetQuaSuaChua();
        // this.fetchAPI_DanhSachKetQuaLapDat();

        this.ThoiGianTao = this.FormatTime();
        this.ThoiGianHoanTat = this.FormatTime();
    },
    methods:{
        async AxiosAPI_GetBaoHongChoSuaChua(){
            try {
                const YeuCau = await axios.get(
                    'http://localhost:8081/api/banhang/baohongkythuattiepnhan'
                );
                if(YeuCau.status === 200) {
                    const Data = YeuCau.data;
                    console.log("Data AxiosAPI_GetBaoHongChoSuaChua: ", Data);
                    this.DanhSachBaoHongDaGui = Data;
                    console.log("DanhSachBaoHongDaGui: ", Data);
                }
            }
            catch(error) {
                console.log("Loi AxiosAPI_GetBaoHongChoSuaChua: ", error);
            }
        } ,
        CapNhatSuaChua(BaoHong) {
            this.BaoHongCapNhat = {...BaoHong};
            this.HienThiFormCapNhatKetQuaSuaChua= true;
            // khoi tao them :
            this.QuanHuyenKhachHang = BaoHong.QUANHUYEN_KHACHHANG;
            this.HinhThucTraCuoc = BaoHong.HINHTHUCTRACUOC;
            
            this.PhuongXaKhachHang = BaoHong.PHUONGXA_KHACHHANG;
            this.GoiDichVu = BaoHong.GOIDICHVU;
        },
        DongFormCapNhatSuaChua(){
            this.HienThiFormCapNhatKetQuaSuaChua = false;
        },
        
        async fetchAPI_DanhSachKetQuaSuaChua(){
            try {
                const KetNoi = await fetch('http://localhost:8081/api/quanly/ketquakhaosat');
                if(KetNoi.ok) {
                    const Data = await KetNoi.json();
                    this.DanhSachKetQuaSuaChua = Data.map(
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
        
        async LuuCapNhatKetQuaSuaChua(){
            try {
                if(this.TienHanhSuaChua == null || this.LoiGayHong == null || this.KetQuaSuaChua == null){
                    this.CapNhat_ThongBao_ChuaNhapHetThongTin = true;
                    setTimeout(()=>{
                        this.CapNhat_ThongBao_ChuaNhapHetThongTin = false;
                    }, 3000);
                    
                }
                const Data = {
                    ThoiGianSuaChua: this.ThoiGianHoanTat,
                    IDFK_BaoHong: this.BaoHongCapNhat.ID_BAOHONG,
                    Loi: this.LoiGayHong,
                    SuaChua: this.TienHanhSuaChua,
                    KetQuaSuaChua: this.KetQuaSuaChua
                };
                console.log("Data LuuCapNhatKetQuaSuaChua: ", Data);
                const YeuCau = await axios.post(
                    'http://localhost:8081/api/quanly/insertsuachuabaohong',
                    Data,
                    {
                        headers: {
                            'Content-Type':'application/json'
                        }
                    }
                );
                if(YeuCau.status === 200) {
                    console.log("Insert thanh cong");
                    this.CapNhat_ThongBao_ThanhCong = true;
                    setTimeout(()=>{
                        this.CapNhat_ThongBao_ThanhCong = false;
                    }, 3000);

                }
                else {
                    console.log("Loi insert");
                }
            }
            catch(error) {
                console.log("Loi Cap nhat ket qua sua chua");
                throw new Error("Loi Cap nhat ket qua sua chua");
                
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
.btn-taomoiBaoHong {
    background-color: #03ab6d;
    border: 1px solid #4e64b5;
    padding:5px;
}
.taomoiBaoHong {
    margin-bottom: 10px;
}

.taomoiBaoHong {
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
.capnhatBaoHong {
    border: 1px solid black;
}
.bold {
    font-weight: 500;
    padding-top: 1em;
    padding-bottom: 1em;
}
</style>
