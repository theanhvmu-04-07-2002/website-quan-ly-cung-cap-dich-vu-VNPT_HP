<template>
    <div class="content">
        <div class="header">
            <BanHang_Header />
        </div>
        <!--  -->
        <div class="main-content">
            <div class="row">
                <div class="col-sm-8">
                    <p class="text-center tieude blue" >
                        <strong>GÓI COMBO INTERNET KÈM TRUYỀN HÌNH</strong>
                    </p>
                    <table class="table table-bordered blue" id="blue">
                        <thead class="blue">
                            <tr>
                                <th>STT</th>
                                <th>Gói cước</th>
                                <th>Tốc độ</th>
                                <th>Trang bị <br> Wifi Mesh</th>
                                <th>Giá niêm yết <br> (đồng)</th>
                            </tr>
                        </thead>
                        <tbody class="blue">
                            <tr 
                            v-for="(HomeNetCong, index) in DanhSachHomeNetCong"
                            :key="index"
                            >
                                <td>{{index + 1}}</td>
                                <td>{{HomeNetCong.TENGDV}}</td>
                                <td>{{HomeNetCong.BANGTHONGTRONGNUOC}} Mbps</td>
                                <td>
                                    <p v-if="HomeNetCong.WIFIMESH == null && HomeNetCong.WIFIMESH5 == null && HomeNetCong && HomeNetCong.WIFIMESH6 == null">X</p>
                                    <p v-if="HomeNetCong.WIFIMESH != null && HomeNetCong.WIFIMESH5 == null ">{{HomeNetCong.WIFIMESH}} Wifi Mesh</p>
                                    <p v-if="HomeNetCong.WIFIMESH5 != null">{{HomeNetCong.WIFIMESH5}} Wifi Mesh</p>
                                </td>
                                
                                <td>{{HomeNetCong.GIANIEMYET1}}</td>
                            </tr>
                        </tbody>

                    </table>
                    <div class="blue">
                        <p class="text-center">(Giá cước đã có VAT và chưa bao gồm phí lắp đặt)</p>
                        <p><strong>Nội dung gói cước MyTV Nâng cao Plus:</strong></p>
                        <ul>
                            <li><i>Trên 170 kênh trong nước và quốc tế chất lượng cao, bao gồm chùm kênh SpoTV, VTVCab, gói phim Galaxy cao cấp</i></li>
                            <li><i>Nội dung VOD theo yêu cầu (Âm nhạc, Karaoke, Clip hài...);</i></li>
                            <li><i>Tính năng xem lại nội dung đã phát sóng trong vòng 24-72h (tùy từng kênh);</i></li>
                            <li><i></i>Đăng nhập tối đa 5 thiết bị, xem đồng thời 2 thiết bị.</li>
                        </ul>
                        <p><strong><i>(*) Gói cước Home Net 7+/Home Mesh 7+ có tốc độ tối thiểu 300Mbps và tối đa 1Gbps (1000Mbps) tùy theo chủng loại thiết bị của khách hàng và khoảng cách từ thiết bị đến Modem. Ngoài ra tốc độ còn phụ thuộc điều kiện hạ tầng của khu vực cung cấp dịch vụ.</i></strong></p>
                        
                    </div>
                    <p class="red"><strong>Khuyến mại: </strong></p>
                    <ul class="red">
                        
                        <li><strong>Trang bị Modem wifi 2 băng tần;</strong></li>
                        <li><strong>Tặng kèm dịch vụ GreenNet chặn website xấu, độc, bảo vệ trẻ em; Tính năng khóa/mở Internet từ xa qua Zalo;</strong></li>
                        <li><strong>Trả trước 06 tháng tặng thêm 01 tháng; trả trước 12 tháng tặng thêm 02 tháng.</strong></li>
                        <li><strong>Dịch vụ MyTV cài đặt trực tiếp trên Smart TV; trường hợp khách hàng nhận trang bị thêm 01 Smart Box MyTV để kết nối TV thường thì cộng thêm 30.000đ/tháng.</strong></li>

                    </ul>
                    <p>---------------------------</p>
                    <div class="dangkymua">
                        <p>Để đăng ký và nhận khuyến mại khi lắp đặt Internet cáp quang - Truyền hình VNPT Hải Phòng, <br> Quý khách hàng vui lòng <strong>click ĐẶT MUA</strong> trực tuyến qua website hoặc liên hệ <strong>Hotline 02253.839.839</strong></p>
                        <img id="img-datmua" src="/assets/HinhAnh/goidichvu/internet/gioithieu-lienhe.png" alt="">
                    </div>
                    <p class="huongung blue">
                        <i>
                            Hưởng ứng "Chương trình chuyển đổi số quốc gia" của Chính phủ và nhằm tạo thuận lợi cho khách hàng trong việc thanh toán cước phí sử dụng, VNPT VinaPhone Hải Phòng khuyến nghị khách hàng thực hiện ký kết hợp đồng điện tử và sử dụng hình thức trực tuyến, chuyển khoản... khi đăng ký dịch vụ hoặc thanh toán cước sử dụng. Trân trọng cảm ơn Quý khách!
                        </i>
                    </p>
                    <div class="div-img-chuyenkhoan">
                        <img class="img-chuyenkhoan" src="/assets/HinhAnh/goidichvu/chuyenkhoan.jpg" alt="">
                    </div>
                </div>
                <!--  -->
                <div class="col-sm-1">
                    <p class="inhoa xoaydoc">vnpt hai phong</p>
                </div>
                <!--  -->
                <div class="col-sm-3">
                    <TinTuc_ThongTinMoiNhat/>
                </div>
            </div>
        </div>
        <!--  -->
        <div class="footer">
            <BanHang_Footer />
        </div>
    </div>
</template>
<script>   
    import BanHang_Footer from "../components/BanHang_Footer.vue";
    import BanHang_Header from "../components/BanHang_Header.vue";
    import TinTuc_ThongTinMoiNhat from '../components/TinTuc_ThongTinMoiNhat.vue';
    export default {
        components:{
            BanHang_Header,
            BanHang_Footer,
            TinTuc_ThongTinMoiNhat,
        },
        data() {
            return {
                DanhSachHomeNetCong:[],
            }
        },
        created(){
            this.fetchData();
        },
        methods: {
            async fetchData() {
                try {
                    const response = await fetch('http://localhost:8081/api/banhang/chitietgiodichvu');
                    const data = await response.json(); 
                    const internet = data.filter(item => item.TENDANHMUCGDV === "Internet - Truyền hình");
                    console.log(internet); 
                    this.DanhSachHomeNetCong = internet; 
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
    width: 90%;
    margin-left: auto;
    margin-right: auto;
    margin-top: 40px;
    margin-bottom: 60px;
}

.blue, th, td {
    color:#1f497d !important;
}
.red {
    color: #ff0000;
}
table {
    /* border: 1px solid #1f497d; */
    text-align: center;
}
.dangkymua {
    text-align: center;
    /* border: 1px solid black; */
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}
#img-datmua {
    width: 60%;
    height: auto;
}
.huongung {
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    font-size: 20px;
}
.div-img-chuyenkhoan {
    justify-content: center;
    display: flex;
    /* border: 1px solid red; */
    margin-top: 20px;
}
.img-chuyenkhoan {
    width: 80%;
    height: auto;
}
.inhoa {
    text-transform: uppercase;
}
.xoaydoc {
    transform: rotate(90deg);
    white-space: nowrap;
    margin-top: 120px;
    font-size: 40px;
    font-weight: bold;
    opacity: 0.3;
    letter-spacing: 40px;
}

p {
    line-height: 1.5;
}
</style>