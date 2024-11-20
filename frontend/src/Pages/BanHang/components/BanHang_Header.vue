<template>
    <div class="header">
        <div class="content content1">
            <div class="row">
                <div class="col-sm-4">
                    <a href="/trangchu" id="logo">
                        <img src="@/assets/HinhAnh/index/header/logovnpt.png" alt="" id="logo-img" >
                    </a>
                </div>
                
                <div class="col-sm-4">
                    <div class="group">
                        <span><Icon icon="basil:search-solid" width="20" height="20" /></span>
                        <input type="text" class="form-control" placeholder="Tìm kiếm" />
                    </div>
                    
                </div>
                <div class="col-sm-2">
                    <div class="group">
                        <Icon icon="akar-icons:location" width="20" height="20" />
                        <a href="" class="black">Điểm giao dịch</a>
                    </div>
                </div>
                <div class="col-sm-2">
                    <div class="group dangnhap white" v-show="this.ID_KhachHang == null">
                        <Icon icon="mdi:account-arrow-right-outline" width="20" height="20" />
                        <a href="/dangnhap" class="black hover-white">Đăng nhập</a>
                    </div>
                    <!-- dang xuat -->
                    <div class="group dangxuat red" v-show="this.ID_KhachHang != null">
                        <Icon icon="hugeicons:logout-04" width="20" height="20"  style="color: #f20707" />
                        <a href="/trangchu" class="black hover-white red" @click="DangXuat">Đăng xuất</a>
                    </div>
                    
                </div>
            </div>
        </div>
        <div class="content content2">
            <ul class="hang2">
                <li>
                    <a href="/trangchu" id="index-vnpt" class="white">vnpthaiphong.com</a>
                </li>
                <!-- <li >
                    <a href="" >Sim số</a>
                </li> -->
                <li>
                    <a 
                    v-on:click="HienThi"
                    >Mua hàng</a>
                </li>
                <li>
                    <a href="/chuongtrinhkhuyenmai" >Khuyến mại</a>
                </li>
                <li>
                    <a href="/tintuc" >Tin tức</a>
                </li>
                <li>
                    <a href="" >Hỗ trợ</a>
                </li>
                <li>
                    <a 
                    v-on:click="HienThi_ThanhToan"
                    >Thanh toán - Hóa đơn</a>
                </li>
                
            </ul>
        </div>
        <div class="muahang" v-show="HienThiMuaHang"
        >
            <!-- v-show="HienThi_MuaHang" -->
            <ul>
                <li>
                    <a href="/goidichvu/internet">
                        <img src="@/assets/HinhAnh/index/header/header-muahang-internet.png" alt="">
                        <label for="" class="bold">Internet</label>
                    </a>
                </li>
                <li>
                    <a href="/goidichvu/internet-truyenhinh">
                        <img src="@/assets/HinhAnh/index/header/header-muahang-combo.png" alt="">
                        <label for="" class="bold">Internet - Truyển hình</label>
                    </a>
                </li>
                <li>
                    <a href="/goidichvu/truyenhinh">
                        <img src="@/assets/HinhAnh/index/header/header-muahang-truyenhinh.png" alt="">
                        <label for="" class="bold">Truyền hình</label>
                    </a>
                </li>
            </ul>
        </div>
        <div class="thanhtoan" v-show="HienThiThanhToan">
            <ul>
                <li>
                    <a href="">
                        <img src="@/assets/HinhAnh/index/header/header-thanhtoan-thanhtoantructuyen.png" alt="">
                        <label for="" class="bold">Thanh toán trực tuyến</label>
                    </a>
                </li>
                <li>
                    <a href="">
                        <img src="@/assets/HinhAnh/index/header/header-thanhtoan-tracuuhoadon.png" alt="">
                        <label for="" class="bold">Tra cứu hóa đơn điện tử</label>
                    </a>
                </li>
                <li>
                    <a href="">
                        <img src="@/assets/HinhAnh/index/header/header-thanhtoan-tracuuhoadondientu.png" alt="">
                        <label for="" class="bold">Tra cứu hóa đơn điện tử - FKey</label>
                    </a>
                </li>
                <li>
                    <a href="">
                        <img src="@/assets/HinhAnh/index/header/header-thanhtoan-thongtindonhang.png" alt="">
                        <label for="" class="bold">Thông tin đơn hàng</label>
                    </a>
                </li>
            </ul>
        </div>
        
    </div>
</template>

<script>
import { Icon } from '@iconify/vue2';

export default {
    name: "BanHang_Header",
    components: {
        Icon,
    },
    data() {
        return {
            HienThiMuaHang : false,
            HienThiThanhToan: false,
            ID_KhachHang: null,
        }
    },
    created(){
        this.ID_KhachHang = localStorage.getItem("ID_KhachHang");
    },
    methods: {
        HienThi(){
            this.HienThiMuaHang = !this.HienThiMuaHang;
        },
        HienThi_ThanhToan(){
            this.HienThiThanhToan = !this.HienThiThanhToan;
        },
        DangXuat(){
            localStorage.removeItem("ID_KhachHang");
            this.$router.push({name: 'trangchu'});
        }
    }
    
}
</script>

<style scoped>
.header {
    background-color: white;
    max-width: 100%;
    padding: 0;
    margin: 0;
    max-width: 100%;
    /* padding: 10px; */
    /* border: 1px solid black; */
}
.content {
    justify-content: center;
    width: 100%;
    /* border: 1px solid black; */
}
li {
    list-style: none;
    display: flex;
    /* border: 1px solid black; */
}
a {
    text-decoration: none;
    color: blue;
    /* border: 1px solid black; */
}
.group {
    display: flex;
    align-items: center;
}
#index-vnpt {
    text-decoration: none;
    font-size: 25px;
    font-weight: bold;
}
.hang1, .hang2 {
    display: flex;
    align-items: center;
    justify-content: space-between;
    width: 80%;
    /* border: 1px solid white; */
    /* margin: auto; */
    padding-bottom: 10px;
}

.content2{
    background-color:#1f7ed1;
    padding:0;
}
.hang2 {
    width: 90%;
    height: 100%;
    margin: auto;
    padding-top: 10px;
}
input {
    border-radius: 20px;
    
}
.icon {
    border: 1px solid white; /* Thêm đường viền để thấy vị trí */
}
.bold {
    font-weight: 500;
    font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
    font-size: 20px;
}
.black {
    color: black;
}
.hang2 li a {
    font-weight: 500;
    font-size: 20px;
}
.hang2 a {
    color:white;
}
.hang2 li a:hover{
    color: black;
}
.thanhtoan ul{
    width: 80%;
}
.muahang, .thanhtoan{
    width: 100%;
    position: absolute;
    /* top: 100%; */
    /* left: 50%; */
    /* transform: translate(50%); */
    background-color: white;
    border-bottom: 1px solid #f0f0f0;
    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1); /* Đổ bóng cho thẻ div */
    z-index: 1000; /* Đặt z-index cao để nổi lên trên các phần tử khác */
    /* display: none;  */
}
.muahang ul {
    width: 60%;
}
.muahang ul,
.thanhtoan ul{
    display: flex;
    justify-content: space-between;
    margin: auto;
}
.muahang ul li,
.thanhtoan ul li {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    /* flex: 1; */
    /* border: 1px solid black; */
}
.muahang ul li img,
.thanhtoan ul li img
{
    display: block;
    margin: auto;
}
.muahang ul li label,
.thanhtoan ul li label,
a {
    cursor: pointer;
}
.dangnhap, .dangxuat
 {
    padding-top: 5px;
    padding-bottom: 5px;
}

.dangnhap:hover, .dangxuat:hover 
{
    background-color: #1f7ed1;
    color: white;
}
.hover-white:hover {
    color: white;
}
#logo-img {
    max-width: 100%;
}
.row {
    display: flex;
    text-align: center;
    align-items: center;
    justify-content: center;
    max-width: 100%;
}
.red {
    color: red;
}
</style>
