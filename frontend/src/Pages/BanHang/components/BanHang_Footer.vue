<template>
    <div class="maincontent">
        <div class="content">
            <div class="hang hang1">
                <div class="row">
                    <div class="col-sm-4">
                        <p>TRUNG TÂM KINH DOANH VNPT HẢI PHÒNG</p>
                        <ul>
                            <li>Tòa nhà VNPT Hải Phòng, Lô C6, khu Trung tâm Hành chính quận Hải An, đường Lê Hồng Phong, phường Đằng Hải, quận Hải An, TP. Hải Phòng</li>
                            <li>Hotline bán hàng, tư vấn dịch vụ:</li>
                            <li>02253.839.839 (KH cá nhân)</li>
                            <li>02253.247.247 (KH doanh nghiệp)</li>
                            <li>Email: vnptvinaphone.hpg@vnpt.vn</li>
                            <li>Mã số doanh nghiệp: 0106869738-056 do Sở KHĐT TP. Hải Phòng cấp ngày 01/06/2021.</li>
                        </ul>
                    </div>
                    <div class="col-sm-3">
                        <p>CHÍNH SÁCH - ĐIỀU KHOẢN</p>
                        <ul>
                            <li>
                                <a href="">Điều khoản sử dụng</a>
                            </li>
                            <li>
                                <a href="">Chính sách thanh toán</a>
                            </li>
                            <li>
                                <a href="">Chính sách giao hàng</a>
                            </li>
                            <li>
                                <a href="">Chính sách bảo mật</a>
                            </li>
                            <li>
                                <a href="">Ấn phẩm công bố - niêm yết</a>
                            </li>
                        </ul>
                    </div>
                    <div class="col-sm-2">
                        <p>HỖ TRỢ KHÁCH HÀNG</p>
                        <ul>
                            <li>
                                <a href="">Tra cứu đơn hàng</a>
                            </li>
                            <li>
                                <a href="">Góp ý - Phản ánh</a>
                            </li>
                            <li>
                                <a href="">Báo hỏng dịch vụ</a>
                            </li>
                            <li>
                                <a href="">Thanh toán trực tuyến</a>
                            </li>
                            <li>
                                <a href="">Câu hỏi thường gặp</a>
                            </li>
                            <li>
                                <a href="">Điểm bán hàng lưu động</a>
                            </li>
                        </ul>
                    </div>
                    <div class="col-sm-3">
                        <p>PHƯƠNG THỨC THANH TOÁN</p>
                        <ul>
                            <li>
                                <img src="@/assets/HinhAnh/index/footer/footer-phuongthucthanhtoan.png" alt="">
                            </li>
                            <li>
                                <a href="http://online.gov.vn/Home/WebDetails/65984?AspxAutoDetectCookieSupport=1">
                                    <img src="@/assets/HinhAnh/index/footer/footer-dathongbao.png" alt="">
                                </a>
                                <a href="#">
                                    <img src="@/assets/HinhAnh/index/footer/footer-thuonghieuquocgia.png" alt="">
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="hang hang2">
                <p>Thành viên của VNPT</p>
                <p>GPCC DV viễn thông: 469/GP-BTTTT, Ngày cấp:14/10/2016, Nơi cấp: Bộ TTTT; GPCC DV viễn thông: 18/GP-CVT, Ngày cấp: 18/01/2018, Nơi cấp: Cục Viễn thông;</p>
                <p> GPCC DV truyền hình trả tiền: 1341/GP-BTTTT; Ngày cấp: 26/07/2012, Nơi cấp: Bộ TTTT; GP sửa đổi, bổ sung: 213/GP-BTTTT, Ngày cấp 08/07/2014, Nơi cấp: Bộ TTTT</p>
            </div>
        </div>
    </div>
</template>
<script>
    export default {
        name: 'BanHang_Footer',
    }
</script>
<style scoped>
.maincontent {
    background-color:#278cd9;
    color: white;
    max-width: 100%;
}
.content {
    width:90%;
    /* border: 1px solid black; */
    margin: auto;
    padding: 10px;
}

.hang2 {
    line-height: 5px;
    text-align: center;
    border-top: 1px solid white;
    padding-top: 10px;
    font-style: italic;
}
li {
    list-style: none;
    font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
    font-size: 15px;
    line-height: 30px;
}
a {
    text-decoration: none;
    color: white;
}
a:hover {
    color: black;
}
.col-sm-3 ul li img {
    max-width: 100%;
}
p{
    line-height: 1.5;
}
</style>