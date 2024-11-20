<template>
    <div class="main-content">
        <p class="bold blue inhoa center gachchan" id="tieude">tra cứu hóa đơn</p>
        <!-- loc hoa don -->
        <div class="search">
            <div class="input-timkiem">
                <input v-model="NoiDungTimKiem" type="text" class="form-control" id="input-timkiem" placeholder="Nhập mã hóa đơn/ Tên tài khoản thanh toán/ STK thanh toán">
                <button class="button" @click="TimKiem">Tìm kiếm</button>
            </div>
            <form action="" class="flex form">
                <div class="form-group block">
                    <p class="bold">Từ ngày: </p>
                    <input v-model="TuNgay" type="date">
                </div>
                <div class="form-group block">
                    <p class="bold">Tới ngày: </p>
                    <input v-model="DenNgay" type="date">
                </div>
                <button @click="LocHoaDon" type="button" class="button" id="btn-truyvan">Truy vấn</button>
            </form>
            <p v-show="TimThayKetQua" class="bold red center size20">Tìm được {{SoLuongKetQuaTimKiem}} kết quả</p>
            <p v-show="KhongTimThayKetQua" class="bold red center size20">Không có kết quả</p>
        </div>
        <!-- het loc hoa don -->
        <!-- hien thi hoa don -->
        <div class="chitiethoadon">
            <table class="table-bordered">
                <thead>
                    <tr>
                        <th>STT</th>
                        <th>Mã <br> hóa đơn</th>
                        <th>Thời gian <br> thanh toán</th>
                        <th>Tên <br> khách hàng</th>
                        <th>Tài khoản <br> thanh toán</th>
                        <th>STK <br> thanh toán</th>
                        <th>Ngân hàng <br> thanh toán</th>
                        <th>Dịch vụ</th>
                        <th>Số lượng (Tháng)</th>
                        <th>Tiền dịch vụ</th>
                        <th>Thuế GTGT</th>
                        <th>Tổng tiền</th>
                    </tr>
                </thead>
                <tbody>
                    <tr
                    v-for="(HoaDon, Index) in DanhSachHoaDonTimKiem"
                    :key="Index"
                    >
                        <td>{{Index + 1}}</td>
                        <td>{{HoaDon.ID_HOADONGTGT}}</td>
                        <td>{{HoaDon.THOIGIANTHANHTOAN}}</td>
                        <td>{{HoaDon.HOTEN_KHACHHANG}}</td>
                        <td>{{HoaDon.TENTAIKHOANTHANHTOAN}}</td>
                        <td>{{HoaDon.SOTAIKHOANTHANHTOAN}}</td>
                        <td>{{HoaDon.TENNGANHANG}}</td>
                        <td>{{HoaDon.TENGDV}}</td>
                        <td>{{HoaDon.SOLUONG}}</td>
                        <td>{{HoaDon.THANHTIENGDV}}</td>
                        <td>{{HoaDon.TIENTHUEGTGT}}</td>
                        <td>{{HoaDon.TONGCONGTIENTHANHTOAN}}</td>
                        
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</template>
<script>
import axios from 'axios';
export default {
    name: 'KhachHangTraCuu',
    data() {
        return {
            STT: 0,
            DanhSachHoaDonTimKiem: [],
            DanhSachHoaDonBanDau:[],
            NoiDungTimKiem: null,
            TuNgay: null,
            DenNgay: null,
            SoLuongKetQuaTimKiem: null,
            TimThayKetQua: false,
            KhongTimThayKetQua: false,

        }
    },
    created(){
        this.ID_KhachHang = localStorage.getItem("ID_KhachHang");
        this.AxiosGetAPI_ChiTietHoaDon();
    },
    mounted(){
        
    },
    methods:{
        async AxiosGetAPI_ChiTietHoaDon() {
            try {
                const DuLieu = await axios.get(
                    `http://localhost:8081/api/banhang/getlichsuthanhtoan/${this.ID_KhachHang}`,
                );
                if(DuLieu.status === 200) {
                    console.log("DuLieu ", DuLieu);
                    this.DanhSachHoaDonBanDau = DuLieu.data.slice().reverse();
                    this.DanhSachHoaDonTimKiem = DuLieu.data.slice().reverse();
                }
                else {
                    console.log("AxiosAxiosAPI_ChiTietHoaDon");
                }
            }
            catch(error) {
                console.log("LOI AxiosAxiosAPI_ChiTietHoaDon: ", error);
            }
        },
        TimKiem() {
            const TimKiem = this.NoiDungTimKiem.toLowerCase().normalize("NFD").replace(/[\u0300-\u036f]/g, "");
            
            // console.log("Noi dung tim kiem: ", TimKiem);
            this.DanhSachHoaDonTimKiem = this.DanhSachHoaDonBanDau.filter(
                (HoaDon) => {
                    const FormatID = HoaDon.ID_HOADONGTGT.toString();
                    return FormatID.includes(TimKiem)
                    || HoaDon.TENTAIKHOANTHANHTOAN.toLowerCase().includes(TimKiem)
                    || HoaDon.SOTAIKHOANTHANHTOAN.includes(TimKiem);
                }
            );
            this.SoLuongKetQuaTimKiem = this.DanhSachHoaDonTimKiem.length;
            if(this.SoLuongKetQuaTimKiem > 0) {
                this.TimThayKetQua = true;
            }
            else {
                this.KhongTimThayKetQua = true;
            }
            console.log("Tìm được : ", this.DanhSachHoaDonTimKiem.length, " kết quả");
        },

        ConvertDate(dateString) {
            const parts = dateString.split(" ");
            const timeParts = parts[0].split(":");
            const dateParts = parts[1].split("/");
            return new Date(
                dateParts[2],
                dateParts[1] - 1,
                dateParts[0],
                timeParts[0],
                timeParts[1],
                timeParts[2]
            );
        },


        LocHoaDon(){
            const FormatTuNgay = new Date( this.TuNgay); 
            FormatTuNgay.setHours(0, 0, 0, 0); 
            const FormatDenNgay = new Date( this.DenNgay); 
            FormatDenNgay.setHours(23, 59, 59, 999);
            this.DanhSachHoaDonTimKiem = this.DanhSachHoaDonBanDau.filter(
                (HoaDon) => {
                    const ThoiGianThanhToan = this.ConvertDate(HoaDon.THOIGIANTHANHTOAN);
                    // console.log("ThoiGianThanhToan: ", ThoiGianThanhToan);
                    return ThoiGianThanhToan >= FormatTuNgay 
                        && ThoiGianThanhToan <= FormatDenNgay;
                }
            );
            this.SoLuongKetQuaTimKiem = this.DanhSachHoaDonTimKiem.length;
            if(this.SoLuongKetQuaTimKiem > 0) {
                this.TimThayKetQua = true;
            }
            else {
                this.KhongTimThayKetQua = true;
            }
            console.log("Tìm được : ", this.DanhSachHoaDonTimKiem.length, " kết quả");
        }
    }
}
</script>

<style scoped>
.main-container{
    background-color: white;
    width: 100%;
}
.bold {
    font-weight: 500;
}
.blue {
    color :#31649e;
}
.red {
    color: red;
}
.inhoa {
    text-transform: uppercase;
}
.center {
    text-align: center;
}
.gachchan {
    text-decoration: underline;
}
.size20 {
    font-size: 20px;
}
table {
    width: 100%;
}
thead tr {
    text-align: center;
}
#tieude {
    font-size: 22px;
    font-weight: bold;
}
.input-timkiem{
    display: flex;
    justify-content: center;
}
#input-timkiem {
    width: 50%;
    text-align: center;
    margin-right: 20px;
}
.button {
    padding: 5px 20px;
    border: 2px solid #1f7ed1;
    background-color: #1f7ed1;
    color: white;
    font-weight: bold;
}
button:hover {
    border: 2px solid #1f7ed1;
    background-color: white;
    color: #1f7ed1;
}
.form {
    margin-top: 20px;
    margin-bottom: 20px;
    justify-content: center;
    align-items: flex-end;
    gap: 40px;
}
.flex {
    display: flex;
    
}
.block {
    display: flex;
    flex-direction: column;
    gap: 0;
}
#btn-truyvan {
    height: 40px;
}

</style>

