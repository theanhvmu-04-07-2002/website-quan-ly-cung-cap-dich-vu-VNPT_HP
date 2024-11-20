<template>
  <div class="content">
    <div class="header">
        <BanHang_Header />
    </div>
    <div class="main-content">
        <div class="gioithieu">
            <p id="tieude">Home Internet - Gói cước Internet dành riêng cho gia đình Việt</p>
            <p>Với nhu cầu sử dụng Internet của các hộ gia đình đang ngày càng tăng lên như hiện nay, Internet cáp quang VNPT Hải Phòng được xem là một giải pháp hoàn hảo khi vừa có tốc độ đường truyền cao vừa không bị giới hạn dung lượng, đồng thời cũng có mức giá ưu đãi trên thị trường.</p>
            <div class="logo">
                <img id="hinhanh-logo" src="/assets/HinhAnh/goidichvu/internet/logo-internet.png" alt="">
            
            </div>
            <p>Dành cho khách hàng hộ gia đình/cá nhân/doanh nghiệp vừa và nhỏ có nhu cầu sử dụng đường truyền Internet tốc độ cao, công nghệ mới nhất, Home Internet của VNPT bao gồm rất nhiều gói cước đa dạng, cung cấp đường truyền Internet có tốc độ siêu cao từ 150Mbps đến 1Gbps (1.000Mbps), kèm theo thiết bị Modem Wifi, thiết bị mở rộng sóng Wifi Mesh thế hệ mới.</p>
            <p>Tốc độ của các gói cước đảm bảo đường truyền mượt mà đáp ứng nhiều người dùng, nhiều thiết bị truy cập cùng lúc, thích hợp cho mức độ sử dụng cho cá nhân, cho đến cả gia đình nhiều thành viên hay thậm chí là hộ kinh doanh có nhu cầu sử dụng cao.</p>
            <p>Đặc biệt, tiêu chuẩn tốc độ mới của VNPT cũng nhằm hỗ trợ khách hàng nâng cao trải nghiệm giải trí khi xem phim, truyền hình 4K (Ultra HD) hay các dịch vụ trực tuyến như livestream, video call, video conference, game online… Với Home Internet của VNPT, những hạn chế về đường truyền trước đây như độ trễ, giật lag đều sẽ được giảm thiểu tối đa, duy trì kết nối nhanh chóng, ổn định cho người dùng.</p>
            <p>Quý khách hàng có nhu cầu lắp mạng Internet tại Hải Phòng, vui lòng đặt mua trực tiếp trên website hoặc liên hệ tổng đài VNPT: <strong>02253.839.839</strong></p>
        </div>
        <!--  -->
        <div class="chitiet">
            <div class="goidichvu">
                <div class="card"
                v-for="(GoiDichVu, index) in DanhSachGoiDichVu"
                v-bind:key="index"
                >
                    <a href="" class="text-center" id="tengdv">
                        <div>
                            <p>{{GoiDichVu.TENGDV}}</p>
                        </div>
                    </a>
                    <a href="" >
                        <div class="hinhanh">
                            <img :src="GoiDichVu.HINHANH"  alt="X" id="anhgdv">
                        </div>
                    </a>
                    <p class="blue" id="giatien">
                                    <strong>{{GoiDichVu.GIANIEMYET1}} VNĐ</strong>
                                </p>
                    <div class="noidung">
                        <ul>
                            <li>
                                <p class="blue">
                                    <strong>Internet tốc độ <span>{{GoiDichVu.BANGTHONGTRONGNUOC}}</span>Mbps</strong>
                                </p>
                            </li>
                            <!-- <li v-if="GoiDichVu.WIFIMESH5 != null">
                                <p class="blue">
                                    <strong>{{GoiDichVu.WOFOMESH5}} Wifi Mesh</strong>
                                </p>
                            </li> -->
                            <li v-if="GoiDichVu.TENDANHMUCGDV === 'Internet - Truyền hình'">
                                <p class="blue">
                                    <strong>Truyền hình MyTV gói Nâng cao Plus</strong>
                                </p>
                            </li>
                            <li v-if="GoiDichVu.BANGTHONGQUOCTE != null">
                                <p class="blue">
                                    <strong>Cam kết tốc độ quốc tế {{GoiDichVu.BANGTHONGQUOCTE}}Mbps </strong>
                                </p>
                            </li>
                            <li v-if="GoiDichVu.IPTINH != null">
                                <p class="blue">
                                    <strong>Miễn phí {{GoiDichVu.IPTINH}} IP tĩnh </strong>
                                </p>
                            </li>
                            <li v-if="GoiDichVu.WIFIMESH  != null ">
                                <p class="blue">
                                    <strong>{{GoiDichVu.WIFIMESH}} Wifi Mesh </strong>
                                </p>
                            </li>
                            <li v-if="GoiDichVu.WIFIMESH5  != null ">
                                <p class="blue">
                                    <strong>{{GoiDichVu.WIFIMESH5}} Wifi Mesh </strong>
                                </p>
                            </li>
                            <li v-if="GoiDichVu.BANGTHONGQUOCTE  != null ">
                                <p class="blue">
                                    <strong> Cam kết băng thông quốc tế {{GoiDichVu.BANGTHONGQUOCTE}}Mbps</strong>
                                </p>
                            </li>
                            <li>
                                <p class="blue">
                                    <strong>{{GoiDichVu.GIANIEMYET1}} đồng/tháng</strong>
                                </p>
                            </li>
                            
                        </ul>
                    </div>
                    <!-- <a href="" class="text-center" id="a-xemchitiet">
                        <p id="xemchitiet">Xem chi tiết</p>
                    </a> -->
                    <router-link 
                        :to="{ name: 'ChiTietDichVu', params: { tengdv: GoiDichVu.TENGDV } }" 
                        class="text-center" 
                        id="a-xemchitiet">
                        <p id="xemchitiet">Xem chi tiết</p>
                    </router-link>
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
    export default {
        components:{
            BanHang_Header,
            BanHang_Footer,
        },
        data() {
            return {
                DanhSachGoiDichVu:[],
            }
        },
        created() {
            this.fetchData();
        },
        methods: {
            async fetchData() {
                try {
                    const response = await fetch('http://localhost:8081/api/banhang/chitietgiodichvu');
                    const data = await response.json(); 
                    const internet = data.filter(item => item.TENDANHMUCGDV === "Internet");
                    console.log(internet); 
                    this.DanhSachGoiDichVu = internet; 
                } catch (error) {
                    console.log(error);
                    throw new Error('Loi ket noi');
                }
            },
        }
    }
</script>
<style scoped>
.main-content {
    margin-top: 60px;
    margin-bottom: 60px;
    width: 90%;
    margin-left: auto;
    margin-right: auto;
}
.goidichvu {
    display: flex;
    justify-content: space-around;
    flex-wrap: wrap;
    margin-top: 20px;
    gap: 10px;
}
.card {
    flex: 0 1 calc(40% - 20px);
    /* display: none; */
}
.text-center {
    text-align: center;
}
#tengdv {
    font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
    font-weight: 700;
    font-size: 20px;

}
.hinhanh {
    /* border: 1px solid black; */
    display: flex;
    justify-content: center;
    
}
#anhgdv {
    width: 80%;
    display: inline-block;
}
.logo {
    display: flex;
    justify-content: center;
    /* border: 1px solid black; */
}
#hinhanh-logo {
    /* border: 1px solid black; */
    width: 200px;
    height: auto;
}
.noidung{
    margin-top: 10px;
    margin-left: 30px;
    font-size: 15px;
    line-height: 10px;
}
a {
    text-decoration: none;
    /* color: white; */
}
#a-xemchitiet {
    justify-content: left;
    align-items: center;
    padding: 20px;
}
#xemchitiet{
    /* border: 1px solid black; */
    background-color: #119ef5;
    color: white;
    font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
    display: inline-block;
    padding: 5px 20px 5px 20px;
    font-weight: bold;
}
#tieude {
    text-transform: uppercase;
    font-weight: bold;
    font-size: 25px;
    text-align: center;
    color: #3c7fde;
}
#giatien {
    text-align: center;
    margin-top: 20px;
    color: #ff0000;
    font-size: 18px;
    border-bottom: 1px solid #f2f2f2;
}
p {
    line-height: 1.5;
}
</style>
