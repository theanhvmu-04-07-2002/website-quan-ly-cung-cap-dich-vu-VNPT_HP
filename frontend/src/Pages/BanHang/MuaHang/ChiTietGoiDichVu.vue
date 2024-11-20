<template>
    
    <div class="content">
        <div class="header">
            <BanHang_Header />
        </div>
        <div class="goidichvu"
           
        >
            <div class="noidungcoban"> 
                <div class="heading">
                    <p>thông tin chi tiết gói dịch vụ <span class="heading-ten"><strong>{{GoiDichVu.TENGDV}}</strong></span></p>
                </div>
                <div class="row">
                    <div class="col-sm-6">
                        <img v-bind:src="GoiDichVu.HINHANH"  alt="" id="anhgdv">
                    </div>
                <!--  -->
                <div class="col-sm-1"></div>
                <div class="col-sm-5">
                    <p class="blue">
                        <strong>Internet tốc độ <span>{{GoiDichVu.BANGTHONGTRONGNUOC}}</span>Mbps</strong>
                    </p>
                    <p class="blue" v-if="GoiDichVu.TENDANHMUCGDV === 'Internet - Truyền hình'">
                        <strong>Truyền hình MyTV gói Nâng cao Plus</strong>
                    </p>
                    <p  class="blue" v-if="GoiDichVu.WIFIMESH5 != null">
                        <strong>{{GoiDichVu.WIFIMESH5}} Wifi Mesh 5</strong>
                    </p>
                    <p  class="blue" v-if="GoiDichVu.WIFIMESH6 != null && GoiDichVu.WIFIMESH5 != null">
                        <strong>{{GoiDichVu.WIFIMESH6}} Wifi Mesh 6</strong>
                    </p>
                    <p class="blue" v-if="GoiDichVu.BANGTHONGQUOCTE != null">
                        <strong>Cam kết tốc độ quốc tế {{GoiDichVu.BANGTHONGQUOCTE}}Mbps</strong>
                    </p>
                    <p class="blue" v-if="GoiDichVu.IPTINH != null">
                        <strong>Miễn phí {{GoiDichVu.IPTINH}} IP tĩnh</strong>
                    </p>
                    <p class="blue">
                        <strong class="blue" >{{GoiDichVu.GIANIEMYET1}} đồng/tháng</strong>
                    </p>
                    <div class="tuvan">
                        <Icon icon="icon-park-twotone:phone" width="40" height="40"  style="color: #ff0000" id="icondienthoai" />
                        <div class="thongtin">
                            <p><strong>Tổng đài tư vấn:</strong></p>
                            <p><strong>0225.3839839</strong></p>
                        </div>
                    </div>
                    <button class="btnDatMua" @click="DatMua">
                        <!-- <a href="/goidichvu/dathang" @click.prevent="DatMua"></a> -->
                       <strong class="white">ĐẶT MUA</strong> 
                    </button>
                    
                </div>
            </div>
            </div>
            <!--  -->
            <div class="gioithieu">
                <div class="gioithieu-modau">
                    <div class="row">
                        <div class="col-sm-4">
                            <p><strong style="font-size:20px; color:#1f7ed1">Giới thiệu</strong></p>
                        </div>
                        <div class="col-sm-8"
                        ></div>
                    </div>
                </div>
                <div class="gioithieu-noidung">
                    <p>
                        <strong>{{GoiDichVu.TENGDV}}</strong>
                         là gói cước {{GoiDichVu.TENDVTICHHOP}} VNPT Hải Phòng dành cho khách hàng là cá nhân/hộ gia đình, với mức cước hấp dẫn và nhiều ưu đãi:</p>
                    <ul>
                        <li>
                            <p>Công nghệ cáp quang 
                                <span v-if="GoiDichVu.TENCONGNGHECAPQUANG">{{GoiDichVu.TENCONGNGHECAPQUANG}}</span>
                                 thế hệ mới, đáp ứng đầy đủ các tiện ích cần thiết trong gia đình (máy tính, laptop, điện thoại, TV thông minh, hệ thống camera quan sát từ xa, hệ thống điện – nước thông minh,..);\
                            </p>
                        </li>
                        <li v-if="GoiDichVu.TENDANHMUCGDV === 'Internet - Truyền hình'">
                            <p>
                                Truyền hình MyTV gói Nâng cao Plus với hơn 180 kênh trong nước và quốc tế tiêu chuẩn SD/HD và 4K; có thể đăng nhập trên 5 thiết bị và xem trên 2 thiết bị cùng lúc;
                                Miễn phí chùm kênh VTVCab, kênh SpoTV/SpoTV2 quốc tế chuyên thể thao độc quyền và kho nội dung VOD;
                            </p>
                        </li>
                        <li v-if="GoiDichVu.TENDANHMUCGDV === 'Internet - Truyền hình'">
                            <p>
                                ƯU ĐÃI đặc biệt: đăng ký thêm chùm kênh K+ chỉ với 110.000đ/tháng;
                            </p>
                        </li>
                        <li>
                            <p>
                                <strong>Băng thông <span class="bold-blue">{{GoiDichVu.BANGTHONGTRONGNUOC}}Mbps</span></strong>, đường truyền ổn định không suy hao;
                                <span v-if="GoiDichVu.TENGDV === 'Home net 6'">Cam kết tốc độ quốc tế tối thiểu 2Mbps</span>
                            </p>
                        </li>
                        <li>
                            <p>
                                Ưu tiên trang bị 
                                <strong>Modem Wifi thế hệ mới <span v-if="GoiDichVu.WIFIMESH5 != null">và {{GoiDichVu.WIFIMESH5}} Wifi Mesh5</span> <span>, {{GoiDichVu.WIFIMESH6}} Wifi Mesh6</span> </strong> 
                                cho kết nối mạnh mẽ, độ phủ sóng rộng, đáp ứng nhiều thiết bị truy cập cùng lúc;
                            </p>
                        </li>
                        <li>
                            <p>Miễn phí dịch vụ GreenNet chặn website xấu, độc; bảo vệ trẻ em.</p>
                        </li>
                        <li v-if="GoiDichVu.IPTINH != null">
                            <p>Miễn phí {{GoiDichVu.IPTINH}} địa chỉ IP tĩnh</p>
                        </li>
                    </ul>
                    <p v-if="GoiDichVu.LUUY != null">
                        <strong>Lưu ý: {{GoiDichVu.LUUY}}</strong>
                        
                    </p>
                    <p>
                        <span class="blue-bold">Cước lắp đặt và hòa mạng:</span>
                        300.000 đồng/lần/thuê bao (đã bao gồm VAT)
                    </p>
                    <p>
                        <strong class="blue">Giá niêm yết: </strong>
                        <span>{{GoiDichVu.GIANIEMYET1}}</span>
                        đồng/tháng (đã bao gồm VAT)
                    </p>
                    <p v-if="GoiDichVu.TENDANHMUCGDV === 'Internet'">
                        <span class="blue-bold">Khách đăng ký lắp đặt mới vui lòng lựa chọn một trong các hình thức sau:</span>
                    </p>
                    <ul v-if="GoiDichVu.TENDANHMUCGDV === 'Internet'">
                        <li>
                            <p> 
                                <span class="blue-bold">- Lựa chọn 1: </span>
                                Đóng 6 tháng - Số tiền: {{GoiDichVu.GIA6THANG1}} đồng;
                            </p>
                        </li>
                        <li>
                            <p>
                                <span class="blue-bold">- Lựa chọn 2: </span>
                                Đóng 12 tháng (tặng thêm 01 tháng) - Số tiền: {{GoiDichVu.GIA12THANG1}} đồng;
                            </p>
                        </li>
                    </ul>
                    <p v-if="GoiDichVu.TENDANHMUCGDV === 'Internet - Truyền hình'">
                        <strong>* Khách hàng sử dụng Smart TV (cài đặt trực tiếp ứng dụng MyTV):</strong> 
                    </p>
                    <ul v-if="GoiDichVu.TENDANHMUCGDV === 'Internet - Truyền hình'">
                        <li>
                            <p>
                                <strong>Giá niêm yết:</strong> {{GoiDichVu.GIANIEMYET1}} đồng/tháng (đã bao gồm VAT)
                            </p>
                        </li>
                        <li>
                            <p> 
                                <span class="blue-bold">- Lựa chọn 1: </span>
                                Đóng 6 tháng - Số tiền: {{GoiDichVu.GIA6THANG1}} đồng;
                            </p>
                        </li>
                        <li>
                            <p>
                                <span class="blue-bold">- Lựa chọn 2: </span>
                                Đóng 12 tháng (tặng thêm 01 tháng) - Số tiền: {{GoiDichVu.GIA12THANG1}} đồng;
                            </p>
                        </li>
                    </ul>
                    <!--  -->
                    <p v-if="GoiDichVu.TENDANHMUCGDV === 'Internet - Truyền hình'">
                        <strong>* Khách hàng sử dụng TV thường (VNPT trang bị 01 Smart Box MyTV): </strong> 
                    </p>
                    <ul v-if="GoiDichVu.TENDANHMUCGDV === 'Internet - Truyền hình'">
                        <li>
                            <p>
                                <strong>Giá niêm yết:</strong> {{GoiDichVu.GIANIEMYET2}} đồng/tháng (đã bao gồm VAT)
                            </p>
                        </li>
                        <li>
                            <p> 
                                <span class="blue-bold">- Lựa chọn 1: </span>
                                Đóng 6 tháng - Số tiền: {{GoiDichVu.GIA6THANG2}} đồng;
                            </p>
                        </li>
                        <li>
                            <p>
                                <span class="blue-bold">- Lựa chọn 2: </span>
                                Đóng 12 tháng (tặng thêm 01 tháng) - Số tiền: {{GoiDichVu.GIA12THANG2}} đồng;
                            </p>
                        </li>
                    </ul>


                    <p>
                        Để lắp đặt Internet cáp quang - Truyền hình VNPT Hải Phòng, Quý khách hàng vui lòng click <span class="blue-bold" style="">ĐẶT MUA</span> trực tuyến qua Website hoặc liên hệ số <span class="blue-bold">Hotline bán hàng - tư vấn dịch vụ: 02253.839.839</span>
                    </p>
                    <input type="hidden" v-model="GoiDichVu.ID_GDV">
                    <p>ok baby: {{GoiDichVu.ID_GDV}}</p>
                </div>
                <div class="gioithieu-lienhe">
                    <img src="/assets/HinhAnh/goidichvu/internet/gioithieu-lienhe.png" alt="" id="hinhanh-lienhe">
                </div>
            </div>
        </div>
        <div class="footer">
            <BanHang_Footer />
        </div>
    </div>
</template>

<script>
    import {Icon} from '@iconify/vue2';
    // import {EventBus} from '../../../main.js'
    import BanHang_Header from '../components/BanHang_Header.vue';
    import BanHang_Footer from '../components/BanHang_Footer.vue';
    export default {
        props: ['tengdv'],
        components:{
            Icon,
            BanHang_Header,
            BanHang_Footer,
        },
        data() {
            return{
                GoiDichVu:{},
            };
        },
        mounted() {
            this.fetchChiTietGDV();
        },
        methods: {
            async fetchChiTietGDV(){
                try {
                    const ketnoi = await fetch(`http://localhost:8081/api/banhang/chitietgiodichvu?name=${this.tengdv}`);
                    if(ketnoi.ok) {
                        const data = await ketnoi.json();
                        const locData = data.find(item => item.TENGDV === this.tengdv);
                        this.GoiDichVu = locData;
                        console.log("GDV: ", this.GoiDichVu);
                    }
                }
                catch(error){
                    throw new Error("sai ket noi");
                }
            },
            DatMua() {
                console.log("da gui du lieu ");
                
                const DuLieuGuiDi = {
                    HINHANH: this.GoiDichVu.HINHANH,
                    TENGDV: this.GoiDichVu.TENGDV,
                    GIANIEMYET1: this.GoiDichVu.GIANIEMYET1,
                    ID_GDV: this.GoiDichVu.ID_GDV,
                };
                
                sessionStorage.setItem('gdvData', JSON.stringify(DuLieuGuiDi));
                console.log("Dữ liệu gửi: ", DuLieuGuiDi);
                setTimeout(() => {
                    window.location.href = '/goidichvu/dathang'; 
                }, 100);
            }

        }
    }
</script>

<style scoped>
.btnDatMua {
    
    background-color: #ff0f03;
    padding-top: 10px;
    padding-bottom: 10px;
    padding-left: 40px;
    padding-right: 40px;
    border: none;
}
.btnDatMua:hover {
    background-color: #ff9a0d;
}
.blue-bold {
    color: #006fc4;
    font-weight: bold;
}
.bold {
    font-weight: bold;
}
.blue {
    color: #006fc4;
}
#hinhanh-lienhe {
    width: 50%;
}
.goidichvu {
    margin-top: 20px;
    margin-bottom: 20px;
    margin-left: auto;
    margin-right: auto;
    width: 80%;
}
#anhgdv {
    width: 100%;
}
.gioithieu {
    margin-top: 20px;
}
a {
    text-decoration: none;
    color: white;
}
.tuvan {
    align-items: center;
    /* border: 1px solid black; */
    display: flex;  
    height: 100px;
}
.thongtin {
    display: block;
    /* border: 1px solid black; */
    align-items: center;

    line-height: 10px;
}
#icondienthoai {
    /* border: 1px solid black; */
    margin-bottom: 10px;
}
.white {
    color: white;
}
.heading {
    text-align: center;
    margin-top: 40px;
    text-transform: uppercase;
    font-size: 25px;
}

p {
    line-height: 1.5;
}
</style>
