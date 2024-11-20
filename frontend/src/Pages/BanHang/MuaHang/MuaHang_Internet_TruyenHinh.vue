<template>
  <div class="content">
    <div class="header">
        <BanHang_Header />
    </div>
    <div class="main-content">
        <div class="gioithieu">
            <p id="tieude">Gói cước combo Internet và Truyền hình</p>
            <p>Gói cước tích hợp dịch vụ Internet và truyền hình của VNPT Hải Phòng phục vụ nhu cầu kết nối toàn diện của các hộ gia đình Việt, với đường truyền Internet tiêu chuẩn quốc tế, dịch vụ truyền hình tương tác thông minh 4K cùng nhiều tiện ích hấp dẫn khác, tất cả chỉ gói gọn trong một gói cước duy nhất, tiết kiệm nhất.</p>
            <p>Đúng như slogan “Sử dụng gói HOME - Ôm trọn giải trí”, kể từ thời điểm ra mắt, gói tích hợp Internet kèm truyền hình của VNPT đã ghi dấu ấn mạnh khi hướng trực tiếp đến phục vụ nhu cầu kết nối của các hộ gia đình/cá nhân với băng thông Internet từ 150Mbps lên đến 1Gbps (1.000Mbps) cho kết nối thực sự mạnh mẽ, kèm theo dịch vụ truyền hình hỗ trợ chất lượng 4K (UltraHD) và giá cước cực kỳ hấp dẫn. Gói tích hợp Internet kèm truyền hình của VNPT đáp ứng trọn vẹn tất cả các nhu cầu giải trí đa dạng của khách hàng như nghe nhạc, xem phim, kết nối, chơi game...</p>
            <div class="row">
                <div class="col-sm-4">
                    <div class="hinhanh">
                        <img class="img-logo" src="/assets/HinhAnh/goidichvu/internet-truyenhinh/logo1.png" alt="">
                    </div>
                    <p class="blue tieude"><strong>Internet Cáp quang</strong></p>
                    <p>
                        Tốc độ <strong>từ 150Mbps đến 1Gbps</strong>: đáp ứng tốt nhu cầu của mọi thành viên trong gia đình cùng lướt web, chơi game, xem phim
                    </p>
                    
                </div>
                <div class="col-sm-4">
                    <div class="hinhanh">
                        <img class="img-logo" src="/assets/HinhAnh/goidichvu/internet-truyenhinh/logo2.png" alt="">
                    </div>
                    <!-- <img class="img-logo" src="/assets/HinhAnh/goidichvu/internet-truyenhinh/logo2.png" alt=""> -->
                    <p class="blue tieude"><strong>Miễn phí nội dung theo yêu cầu (VOD)</strong></p>
                    <p>
                        Các dịch vụ nội dung theo yêu cầu: phim truyện, thiếu nhi, âm nhạc, karaoke, hài, trò chơi, phong cách sống, thể thao, sức khỏe làm đẹp… tận hưởng ngay trên màn hình TV. Ngoài ra truyền hình MyTV trong gói cước tích hợp còn được miễn phí gói dịch vụ Galaxy cao cấp xem phim bom tấn, phim chiếu rạp mới nhấ
                    </p>
                </div>
                <div class="col-sm-4">
                    <div class="hinhanh">
                        <img class="img-logo" src="/assets/HinhAnh/goidichvu/internet-truyenhinh/logo3.png" alt="">
                    </div>
                    <!-- <img class="img-logo" src="/assets/HinhAnh/goidichvu/internet-truyenhinh/logo3.png" alt=""> -->
                    <p class="blue tieude"><strong>Truyền hình 4K</strong></p>
                    
                    <p>
                        Với hơn <strong>170 kênh</strong> truyền hình bản quyền trong nước và quốc tế tiêu chuẩn SD/HD và 4K, miễn phí chùm <strong>kênh SpoTV thể thao độc quyền, chùm VTV Cab</strong>, đa dạng kênh tin tức, giải trí hấp dẫn...; đăng ký xem K+ ngay trên màn hình. Tính năng tua lại/xem lại các chương trình đã phát sóng. Công nghệ truyền hình tiên tiến, hiện đại có thể cài đặt trực tiếp trên Smart TV, giúp tối ưu chi phí và thẩm mỹ.
                    </p>
                </div>
            </div>
        </div>
        <!--  -->
        <div class="chitiet">
            <p class="black tieude" id="homecombo"><strong>HOME COMBO</strong></p>
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
    flex: 0 1 calc(30% - 10px);
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
.blue {
    color: #3d79d9;
}
.col-sm-4{
    justify-content: center;
    align-items: center;
}
.tieude {
    text-align: center;
}
.img-logo {
    width: 40%;
    height: auto;
}
#homecombo {
    font-size: 20px;
}
.black {
    color:black;
}
.chitiet {
    margin-top: 80px;
}

p {
    line-height: 1.5;
}
</style>
