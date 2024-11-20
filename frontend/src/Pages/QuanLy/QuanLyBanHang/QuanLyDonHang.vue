<template>
    <div class="quanly-donhang">
        <div class="header blue">
            <p class="bold white center inhoa h2">quản lý đơn hàng</p>
        </div>
        <div class="taomoidonhang">
            <button @click="MoFormTaoMoiDonHang" class="btn-taomoidonhang" style="color:white"> Tạo mới đơn hàng</button>
        </div>
        <div class="content-donhang">
            <div class="thongtindonhang back-blue bang">
                <div class="blue tenbang">
                    <p class="bold white center inhoa">thông tin đơn hàng chờ duyệt</p>
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
                            <th>Hình thức trả cước</th>
                            <th>Dịch vụ</th>
                            <th>Thao tác</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr
                        v-for="(DonHang, index) in DanhSachDonHangChoDuyet"
                        
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
                            <td>{{DonHang.TENHINHTHUC}}</td>
                            <td>{{DonHang.TENGDV}}</td>
                            <td>
                                <button class="btn btn-primary" @click="CapNhatDonHang(DonHang)">cập nhật</button>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <!-- het thong tin don hang -->
            <!-- tao moi don hang -->
            <div class="capnhatdonhang bang back-white" v-show="HienThiFormTaoMoiDonHang">
                
                <div class="thongtindonhang">
                    <div class="blue tenbang">
                        <p class="bold white center inhoa">tạo mới đơn hàng</p>
                    </div>
                    <div v-show="TaoMoi_ThongBao_ChuaNhapHetThongTin" class="thongbao_chuanhaphetthongtin">
                        <div class="alert alert-danger">
                            <strong>Lỗi !</strong> Chưa nhập hết thông tin.
                        </div>
                    </div>
                    <div v-show="TaoMoi_ThongBao_ThanhCong" class="thongbao_chuanhaphetthongtin">
                        <div class="alert alert-info">
                            <strong>Thông báo !</strong> Đã tạo đơn hàng.
                        </div>
                    </div>
                    <form  action="" class="form-group">
                        
                        <div class="row">
                            <div class="col-sm-4">
                                <div class="input-group">
                                    <span>Thời gian tạo:</span>
                                    <input type="text" class="form-controll" disabled="true" placeholder="Hệ thống tự cập nhật">
                                </div>
                                <div class="input-group">
                                    <span>ID đơn hàng</span>
                                    <input type="text" class="form-controll" disabled="true" placeholder="Hệ thống tự cập nhật">
                                </div>
                                <div class="input-group">
                                    <span>Tên khách hàng</span>
                                    <input v-model="TaoMoi_HoTenKhachHang" class="form-controll" type="text" placeholder="Họ và tên">
                                </div>
                                <div class="input-group">
                                    <span>SDT khách hàng</span>
                                    <input v-model="TaoMoi_SDTKhachHang" class="form-controll" type="text" placeholder="Số điện thoại">
                                </div>
                                <div class="input-group">
                                    <span>Email khách hàng</span>
                                    <input v-model="TaoMoi_EmailKhachHang" class="form-controll" type="text" placeholder="Email">
                                </div>
                                
                            </div>
                            <!-- end -->
                            <div class="col-sm-4">
                                <div class="input-group">
                                    <span>Quận huyện:</span>
                                    <!-- <input type="text" class="form-controll" v-model="DonHangCapNhat.TENQUANHUYEN"> -->
                                    <VueSelect2
                                        v-model="TaoMoi_QuanHuyenKhachHang"
                                        :options="TaoMoi_DanhSachQuanHuyen"
                                        class="form-controll"
                                        placeholder="Chọn quận huyện"
                                        @change="ChonQuanHuyen"
                                        >
                                    </VueSelect2>   
                                </div>
                                <div class="input-group">
                                    <span>Phường xã</span>
                                    <!-- <input type="text" class="form-controll" v-model="DonHangCapNhat.TENPHUONGXA"> -->
                                    <VueSelect2
                                        v-model="TaoMoi_PhuongXaKhachHang"
                                        :options="TaoMoi_DanhSachPhuongXaChonLoc"
                                        class="form-controll"
                                        placeholder="Chọn phường xã"
                                        
                                        >
                                    </VueSelect2>  
                                </div>
                                <div class="input-group">
                                    <span>Hình thức trả cước</span>
                                    <!-- <input type="text" class="form-controll" v-model="DonHangCapNhat.TENHINHTHUC"> -->
                                    <VueSelect2
                                        v-model="TaoMoi_HinhThucTraCuoc"
                                        :options="TaoMoi_DanhSachHinhThucTraCuoc"
                                        class="form-controll"
                                        placeholder="Chọn hình thức"
                                        
                                        >
                                    </VueSelect2>
                                </div>
                                <div class="input-group">
                                    <span>Dịch vụ</span>
                                    <!-- <input type="text" class="form-controll" v-model="DonHangCapNhat.TENGDV"> -->
                                    <VueSelect2
                                    v-model="TaoMoi_GoiDichVu"
                                    :options="TaoMoi_DanhSachGoiDichVu"
                                    class="form-controll"
                                    placeholder="Chọn dịch vụ"
                                    >
                                    </VueSelect2>
                                    
                                </div>
                                
                                
                            </div>
                            <!--  -->
                            <div class="col-sm-4">
                                <div class="input-group">
                                    <span>Chi tiết địa chỉ:</span>
                                    <textarea v-model="TaoMoi_ChiTietKhachHang" class="form-controll" name="" id="" cols="30" rows="4" ></textarea>
                                    <!-- <input type="text" class="form-controll" v-model="DonHangCapNhat.CHITIET_KHACHHANG"> -->
                                </div>
                                <div class="input-group">
                                    <span>Ghi chú</span>
                                    <textarea v-model="TaoMoi_GhiChuKhachHang" class="form-controll" name="" id="" cols="30" rows="4"></textarea>
                                    <!-- <input type="text" class="form-controll" v-model="DonHangCapNhat.GHICHU_KHACHHANG"> -->
                                </div>
                                
                            </div>
                        </div>
                        <div class="button-group">
                            <!-- <input type="submit" value="Lưu" class="btn btn-success" id="button"> -->
                            <button class="btn btn-success" @click="LuuTaoMoiDonHang" type="button" id="button">Lưu</button>
                            <button class="btn btn-danger" @click.prevent="DongFormTaoMoiDonHang" type="button" id="button">Hủy</button>
                        </div>
                        <!-- <div class="alert alert-success" v-show="DaLuuDuLieuCapNhat">
                            <strong>Thông báo: </strong>Đã lưu dữ liệu cập nhật
                        </div> -->
                        
                    </form>
                </div>
                
            </div>
            <!-- het tao moi don hang -->
            <!-- cap nhat don hang -->
            <div class="capnhatdonhang  back-white bang" v-show="HienThiFormCapNhatDonHang">
                
                <div class="thongtindonhang">
                    <div class="blue tenbang">
                        <p class="bold white center inhoa">cập nhật đơn hàng</p>
                    </div>
                    <div v-show="CapNhat_ThongBao_ChuaNhapHetThongTin" class="thongbao_chuanhaphetthongtin">
                        <div class="alert alert-danger">
                            <strong>Lỗi !</strong> Chưa nhập hết thông tin.
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
                                    <input type="text" class="form-controll" v-model="DonHangCapNhat.HOTEN_KHACHHANG">
                                </div>
                                <div class="input-group">
                                    <span>SDT khách hàng</span>
                                    <input type="text" class="form-controll" v-model="DonHangCapNhat.SDT_KHACHHANG">
                                </div>
                                <div class="input-group">
                                    <span>Email khách hàng</span>
                                    <input type="text" class="form-controll" v-model="DonHangCapNhat.EMAIL_KHACHHANG">
                                </div>
                                
                            </div>
                            <!-- end -->
                            <div class="col-sm-4">
                                <div class="input-group">
                                    <span>Quận huyện:</span>
                                    <!-- <input type="text" class="form-controll" v-model="DonHangCapNhat.TENQUANHUYEN"> -->
                                    <VueSelect2
                                        v-model="QuanHuyenKhachHang"
                                        :options="DanhSachQuanHuyen"
                                        class="form-controll"
                                        placeholder="Chọn quận huyện"
                                        @change="ChonQuanHuyen"
                                        >
                                    </VueSelect2>   
                                </div>
                                <div class="input-group">
                                    <span>Phường xã</span>
                                    <!-- <input type="text" class="form-controll" v-model="DonHangCapNhat.TENPHUONGXA"> -->
                                    <VueSelect2
                                        v-model="PhuongXaKhachHang"
                                        :options="DanhSachPhuongXaChonLoc"
                                        class="form-controll"
                                        placeholder="Chọn phường xã"
                                        
                                        >
                                    </VueSelect2>  
                                </div>
                                <div class="input-group">
                                    <span>Hình thức trả cước</span>
                                    <!-- <input type="text" class="form-controll" v-model="DonHangCapNhat.TENHINHTHUC"> -->
                                    <VueSelect2
                                        v-model="HinhThucTraCuoc"
                                        :options="DanhSachHinhThucTraCuoc"
                                        class="form-controll"
                                        placeholder="Chọn hình thức"
                                        
                                        >
                                    </VueSelect2>
                                </div>
                                <div class="input-group">
                                    <span>Dịch vụ</span>
                                    <!-- <input type="text" class="form-controll" v-model="DonHangCapNhat.TENGDV"> -->
                                    <VueSelect2
                                    v-model="GoiDichVu"
                                    :options="DanhSachGoiDichVu"
                                    class="form-controll"
                                    >
                                    </VueSelect2>
                                    
                                </div>
                                
                                
                            </div>
                            <!--  -->
                            <div class="col-sm-4">
                                <div class="input-group">
                                    <span>Chi tiết địa chỉ:</span>
                                    <textarea class="form-controll" v-model="DonHangCapNhat.CHITIET_KHACHHANG" name="" id="" cols="30" rows="4" ></textarea>
                                    <!-- <input type="text" class="form-controll" v-model="DonHangCapNhat.CHITIET_KHACHHANG"> -->
                                </div>
                                <div class="input-group">
                                    <span>Ghi chú</span>
                                    <textarea class="form-controll" name="" id="" cols="30" rows="4" v-model="DonHangCapNhat.GHICHU_KHACHHANG"></textarea>
                                    <!-- <input type="text" class="form-controll" v-model="DonHangCapNhat.GHICHU_KHACHHANG"> -->
                                </div>
                                
                            </div>
                        </div>
                        <div class="button-group">
                            <!-- <input type="submit" value="Lưu" class="btn btn-success" id="button"> -->
                            <button class="btn btn-success" @click="LuuCapNhatDonHang" type="button" id="button">Lưu</button>
                            <button class="btn btn-danger" @click.prevent ="DongFormCapNhatDonHang" type="button" id="button">Hủy</button>
                        </div>
                        <!-- <div class="alert alert-success" v-show="DaLuuDuLieuCapNhat">
                            <strong>Thông báo: </strong>Đã lưu dữ liệu cập nhật
                        </div> -->
                        <input type="hidden" v-model="DonHangCapNhat.ID_DONHANG" >
                    </form>
                </div>
                
            </div>
            <!-- het cap nhat don hang -->
            <!-- danh sach don hang da gui -->
            <div class="thongtindonhang back-orange bang">
                <div class="blue tenbang">
                    <p class="bold white center inhoa">thông tin đơn hàng đã gửi</p>
                </div>
                <div v-show="CapNhat_ThongBao_ThanhCong" class="thongbao_chuanhaphetthongtin">
                        <div class="alert alert-info">
                            <strong>Thông báo !</strong> Đã cập nhật thông tin.
                        </div>
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
                            <th>Hình thức trả cước</th>
                            <th>Dịch vụ</th>
                            <th>Trạng thái</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr
                        v-for="(DonHang, index) in DanhSachDonHangDaGui"
                        
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
                            <td>{{DonHang.TENHINHTHUC}}</td>
                            <td>{{DonHang.TENGDV}}</td>
                            <td >
                                <span style="background-color:#cff4fc;">Đã gửi</span>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>

    </div>
</template>

<script>
import axios from 'axios';
export default { 
    name:'QuanLyDonHang',
    data(){
        return {
            
            DanhSachDonHang:[],
            DanhSachDonHangChoDuyet:[],
            DonHangCapNhat:{},            
            HienThiFormCapNhatDonHang: false,
            

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

            // tao moi don hang
            HienThiFormTaoMoiDonHang: false,
            ThoiGianTao: null,
            TaoMoi_HoTenKhachHang:null,
            TaoMoi_SDTKhachHang:null,
            TaoMoi_EmailKhachHang:null,
            TaoMoi_QuanHuyenKhachHang:null,
            TaoMoi_PhuongXaKhachHang:null,
            TaoMoi_HinhThucTraCuoc:null,
            TaoMoi_GoiDichVu: null,
            TaoMoi_ChiTietKhachHang: null,
            TaoMoi_GhiChuKhachHang: null,
            ID_QuanHuyenTaoMoi: null,

            TaoMoi_DanhSachQuanHuyen:[],
            TaoMoi_DanhSachPhuongXaChonLoc:[],
            TaoMoi_DanhSachHinhThucTraCuoc:[],
            TaoMoi_DanhSachGoiDichVu:[],
            
            // don hang da gui
            DanhSachDonHangDaGui:[],
        }
    },
    created(){
        this.fetchAPI_DanhSachDonHang();
        this.fetchAPI_quanhuyen();
        this.fetchAPI_phuongxa();
        this.fetchAPI_hinhthuc();
        this.fetchChiTietGDV();
        this.ThoiGianTao = this.FormatTime();
    },
    methods:{
        async fetchAPI_DanhSachDonHang(){
            try {
                const ketnoi = await fetch('http://localhost:8081/api/quanly/thongtindonhang');
                if(ketnoi.ok) {
                    const Data = await ketnoi.json();
                    this.DanhSachDonHang = Data;
                    this.DanhSachDonHangChoDuyet = this.DanhSachDonHang.filter(
                        (DonHang) => {
                            return DonHang.IDFK_TRANGTHAI_DONHANG == 1;
                        }
                    );
                    this.DanhSachDonHangDaGui = this.DanhSachDonHang.filter(
                        (DonHang) => {
                            return DonHang.IDFK_TRANGTHAI_DONHANG == 2;
                        }
                    )
                }
                // console.log("Danh sach don hang: ", this.DanhSachDonHangChoDuyet);
            }
            catch(error) {
                console.log("Loi: ", error);
            }
        } ,
        CapNhatDonHang(DonHang) {
            this.DonHangCapNhat = {...DonHang};
            this.HienThiFormCapNhatDonHang= true;
            // khoi tao them :
            this.QuanHuyenKhachHang = DonHang.QUANHUYEN_KHACHHANG;
            this.HinhThucTraCuoc = DonHang.HINHTHUCTRACUOC;
            this.ChonQuanHuyen();
            this.PhuongXaKhachHang = DonHang.PHUONGXA_KHACHHANG;
            this.GoiDichVu = DonHang.GOIDICHVU;
        },
        DongFormCapNhatDonHang(){
            this.HienThiFormCapNhatDonHang = false;
        },
        MoFormTaoMoiDonHang(){
            this.HienThiFormTaoMoiDonHang = true;
        },
        DongFormTaoMoiDonHang(){
            this.HienThiFormTaoMoiDonHang = false;
        },
        // LuuCapNhatDonHang(){
        //     this.DaLuuDuLieuCapNhat = true;
        // },
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
                        this.TaoMoi_DanhSachQuanHuyen = data.map(
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
                        this.TaoMoi_DanhSachPhuongXa = data.map(
                            (item) => {
                                return {
                                    id: item.ID_PHUONGXA,
                                    text: item.TENPHUONGXA,
                                    IDFK_QUANHUYEN: item.IDFK_QUANHUYEN,
                                }
                            }
                        );
                        // console.log(this.DanhSachPhuongXa);
                    }
                }
                catch(error) {
                    console.log("Loi ket noi" + error);
                }
        },
        ChonQuanHuyen() {
                const ID_QuanHuyenCapNhat = Number(this.QuanHuyenKhachHang);
                const ID_QuanHuyenTaoMoi = Number(this.TaoMoi_QuanHuyenKhachHang);
                // console.log('idfk: ' + this.QuanHuyenKhachHang);
                this.DanhSachPhuongXaChonLoc = this.DanhSachPhuongXa.filter(
                    (item) => item.IDFK_QUANHUYEN === ID_QuanHuyenCapNhat
                );
                this.TaoMoi_DanhSachPhuongXaChonLoc = this.DanhSachPhuongXa.filter(
                    (item) => item.IDFK_QUANHUYEN === ID_QuanHuyenTaoMoi
                );
                
                // khoi tao them:
                if (!this.DanhSachPhuongXaChonLoc.find(item => item.ID === this.PhuongXaKhachHang)) {
                    this.PhuongXaKhachHang = null;
                }
                // console.log("length: " + this.DanhSachPhuongXaChonLoc.length);
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
                        this.TaoMoi_DanhSachHinhThucTraCuoc = data.map(
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
        async fetchChiTietGDV(){
                try {
                    const ketnoi = await fetch(`http://localhost:8081/api/banhang/chitietgiodichvu?name=${this.tengdv}`);
                    if(ketnoi.ok) {
                        const data = await ketnoi.json();
                        this.DanhSachGoiDichVu = data.map(
                            (goidichvu) => {
                                return {
                                    id: goidichvu.ID_GDV,
                                    text: goidichvu.TENGDV,
                                }
                            }
                        );
                        this.TaoMoi_DanhSachGoiDichVu = data.map(
                            (goidichvu) => {
                                return {
                                    id: goidichvu.ID_GDV,
                                    text: goidichvu.TENGDV,
                                }
                            }
                        );
                    }
                }
                catch(error){
                    throw new Error("sai ket noi");
                }
        },
        async LuuCapNhatDonHang(){
            if(
                this.DonHangCapNhat.HOTEN_KHACHHANG == null ||
                this.DonHangCapNhat.SDT_KHACHHANG == null ||
                this.DonHangCapNhat.EMAIL_KHACHHANG == null ||
                this.QuanHuyenKhachHang == null ||
                this.PhuongXaKhachHang == null ||
                this.HinhThucTraCuoc == null ||
                this.GoiDichVu == null ||
                this.DonHangCapNhat.CHITIET_KHACHHANG == null ||
                this.DonHangCapNhat.GHICHU_KHACHHANG == null
            ) {
                this.CapNhat_ThongBao_ChuaNhapHetThongTin = true;
                setTimeout(()=> {
                    this.CapNhat_ThongBao_ChuaNhapHetThongTin = false;
                }, 2500);
                // window.location.reload = false;
            }

            else {
                const ThongTinKhachHang = {
                DonHang: this.DonHangCapNhat.ID_DONHANG ,
                HoTenKhachHang: this.DonHangCapNhat.HOTEN_KHACHHANG,
                SDTKhachHang: this.DonHangCapNhat.SDT_KHACHHANG,
                EmailKhachHang: this.DonHangCapNhat.EMAIL_KHACHHANG,
                QuanHuyenKhachHang: this.QuanHuyenKhachHang,
                PhuongXaKhachHang: this.PhuongXaKhachHang,
                HinhThucTraCuoc: this.HinhThucTraCuoc,
                GoiDichVu: this.GoiDichVu,
                ChiTietKhachHang: this.DonHangCapNhat.CHITIET_KHACHHANG,
                GhiChuKhachHang: this.DonHangCapNhat.GHICHU_KHACHHANG,
                TrangThaiDonHang: 2
                }
                // console.log("Thong tin cap nhat: ", ThongTinKhachHang);
                try {
                    const YeuCau = await axios.post('http://localhost:8081/api/quanly/quanlybanhang/capnhatdonhang', ThongTinKhachHang, {
                        headers: {
                            'Content-Type':'application/json'
                        }
                    })
                    if(YeuCau.status === 200) {
                        console.log("gui du lieu thanh cong");
                        this.CapNhat_ThongBao_ThanhCong = true;
                        setTimeout(() => {
                            this.CapNhat_ThongBao_ThanhCong = false;
                        }, 3000);
                    }
                    
                }
                catch(error) {
                    console.log("loi cap nhat don hang: ", error);
                }
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
        async LuuTaoMoiDonHang(){
            if(
                this.TaoMoi_HoTenKhachHang == null ||
                this.TaoMoi_SDTKhachHang == null ||
                this.TaoMoi_EmailKhachHang == null ||
                this.TaoMoi_QuanHuyenKhachHang == null ||
                this.TaoMoi_PhuongXaKhachHang == null ||
                this.TaoMoi_HinhThucTraCuoc == null ||
                this.TaoMoi_GoiDichVu == null ||
                this.TaoMoi_ChiTietKhachHang == null ||
                this.TaoMoi_GhiChuKhachHang == null
            ) {
                this.TaoMoi_ThongBao_ChuaNhapHetThongTin = true;
                setTimeout(()=> {
                    this.TaoMoi_ThongBao_ChuaNhapHetThongTin = false;
                    }, 3000
                );
            }
            else {
                const ThongTinKhachHang = {
                ThoiGianTao: this.ThoiGianTao,
                HoTenKhachHang: this.TaoMoi_HoTenKhachHang,
                SDTKhachHang: this.TaoMoi_SDTKhachHang,
                EmailKhachHang: this.TaoMoi_EmailKhachHang,
                QuanHuyenKhachHang: this.TaoMoi_QuanHuyenKhachHang,
                PhuongXaKhachHang: this.TaoMoi_PhuongXaKhachHang,
                HinhThucTraCuoc: this.TaoMoi_HinhThucTraCuoc,
                GoiDichVu: this.TaoMoi_GoiDichVu,
                ChiTietKhachHang: this.TaoMoi_ChiTietKhachHang,
                GhiChuKhachHang: this.TaoMoi_GhiChuKhachHang,
                TrangThaiDonHang: 2
                }
                // console.log("Thong tin cap nhat: ", ThongTinKhachHang);
                try {
                    const YeuCau = await axios.post('http://localhost:8081/api/banhang/yeucaudonhang', ThongTinKhachHang, {
                        headers: {
                            'Content-Type':'application/json'
                        }
                    })
                    if(YeuCau.status === 200) {
                        // console.log("gui du lieu thanh cong");
                        this.TaoMoi_ThongBao_ThanhCong = true;
                        setTimeout(
                            () => {
                                this.TaoMoi_ThongBao_ThanhCong = false;
                            }, 3000
                        );
                    }
                }
                catch(error) {
                    console.log("loi tao moi don hang: ", error);
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
