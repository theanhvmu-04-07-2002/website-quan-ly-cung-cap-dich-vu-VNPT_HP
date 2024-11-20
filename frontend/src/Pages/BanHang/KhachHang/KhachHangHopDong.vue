<template>
<form action="">
    <div class="main-container">
        <div class="header">
            <div class="img-logo">
                <img id="logovnpt" src="/assets/HinhAnh/khachhang/logovnpt.png" alt="">
            </div>
            <div class="element">
                <div class="conghoa">
                    <p class="font-bold color-blue inhoa">cộng hòa xã hội chủ nghĩa việt nam</p>
                    <p class="font-bold color-blue underline-blue">Độc lập - Tự do - Hạnh phúc</p>
                </div>
                <div>
                    <div class="form-group flex">
                        <p>Hợp đồng số: </p>
                        <p v-if="ID_HopDong == null">...</p>
                        <p v-if="ID_HopDong != null" class="blue">{{ID_HopDong}}</p>
                    </div>
                    <div class="form-group flex">
                        <p>Mã khách hàng: </p>
                        <!-- <span class="blue">{{HopDong.ID_KhachHang}}</span> -->
                        <p class="blue">{{ID_KhachHang}}</p>
                        <p v-show="ID_KhachHang == null">error</p>
                    </div>
                </div>
                
            </div>
            
            
        </div>
        <!-- het header -->
        <div class="content">
            <div class="element tenhopdong">
                <p  id="tenhopdong">HỢP ĐỒNG CUNG CẤP VÀ SỬ DỤNG DỊCH VỤ</p>
                <p v-if="ID_HopDong == null" class=" trangthaihopdong innghieng blue">(ĐANG CHỜ KÝ)</p>
                <p v-if="ID_HopDong != null" class="trangthaihopdong innghieng blue">(ĐÃ KÝ)</p>
            </div>
            <div class="element">
                <ul class="innghieng">
                    <li>- Căn cứ Bộ Luật Dân sự ngày 24 tháng 11 năm 2015;</li>
                    <li>- Căn cứ Luật Viễn thông ngày 23 tháng 11 năm 2009;</li>
                    <li>- Căn cứ Luật Bảo vệ quyền lợi người tiêu dùng ngày 17 tháng 11 năm 2010;</li>
                    <li>- Căn cứ Nghị định số 25/2011/NĐ-CP ngày 06 tháng 4 năm 2011</li>
                    <li>- Căn cứ Nghị định số 99/2011/NĐ-CP ngày 27 tháng 10 năm 2011,</li>
                    <li>- Nghị định số 81/2016/NĐ-CP của Chính phủ ngày 01/7/2016</li>
                    <li>- Nghị định số 49/2017/NĐ-CP ngày 24 tháng 4 năm 2017.</li>
                    
                </ul>
            </div>
            <div disable="true" class="element">
                <p>
                    Hợp đồng cung cấp và sử dụng dịch vụ (dưới đây gọi tắt là “Hợp đồng”) được ký trực tuyến ngày <span class="blue">{{NgayThangHienTai}}</span>  giữa và bởi:
                </p>
                <!-- ben a:  -->
                <div class="bena" v-bind:class="{'view-only': TrangThai_HopDong == 1}">
                    <p class="bold">Bên sử dụng dịch vụ (gọi tắt là “Bên A”): (Tên Khách hàng/ Tên cơ quan/ tổ chức)</p>
                    <div class="flex">
                        <p>Người đại diện:</p>
                        <input type="text" class="blue" :readonly="ReadOnly.PointerEvent" v-model="SuDung_DaiDien" >
                    </div>
                    <div class="row">
                        <div class="col-sm-4 flex" >
                            <p class="ok">Chức vụ:</p>
                            <input  placeholder="" type="text" class="blue" :readonly="ReadOnly.PointerEvent" v-model="SuDung_ChucVu">
                        </div>
                        <div class="col-sm-4 flex">
                            <p>Ngày sinh: </p>
                            <input required type="text" class="blue"  :readonly="ReadOnly.PointerEvent" v-model="SuDung_NgaySinh">
                        </div>
                        <div class="col-sm-4 flex">
                            <p>Nam/Nữ: </p>
                            <input required type="text" class="blue" :readonly="ReadOnly.PointerEvent" v-model="SuDung_GoiTinh">
                        </div>
                    </div>
                    <!--  -->
                    <div class="row">
                        <div class="col-sm-5 flex">
                            <p>Số CCCD/CMND/Hộ chiếu: </p>
                            <input required type="text" class="blue" :readonly="ReadOnly.PointerEvent" v-model="SuDung_SoCCCD">
                        </div>
                        <div class="col-sm-4 flex">
                            <p>Ngày cấp: </p>
                            <input required type="text" class="blue" :readonly="ReadOnly.PointerEvent" v-model="SuDung_NgayCapCCCD">
                        </div>
                        <div class="col-sm-3 flex">
                            <p>Nơi cấp: </p>
                            <input required type="text" class="blue" :readonly="ReadOnly.PointerEvent" v-model="SuDung_NoiCapCCCD">
                        </div>
                    </div>
                    <!--  -->
                    <div class="row">
                        <div class="col-sm-5 flex">
                            <p>Số Giấy chứng nhận ĐKDN/QĐTL/GPTL: </p>
                            <input placeholder="" type="text" class="blue" :readonly="ReadOnly.PointerEvent" v-model="SuDung_GiayChungNhan">
                        </div>
                        <div class="col-sm-4 flex">
                            <p>Ngày cấp: </p>
                            <input placeholder="" type="text" class="blue" :readonly="ReadOnly.PointerEvent" v-model="SuDung_NgayCapGCN">
                        </div>
                        <div class="col-sm-3 flex">
                            <p>Nơi cấp: </p>
                            <input placeholder="" type="text" class="blue" :readonly="ReadOnly.PointerEvent" v-model="SuDung_NoiCap_GDN">
                        </div>
                    </div>
                    <!--  -->
                    <div class="flex">
                        <p>Địa chỉ thường trú</p>
                        <input required type="text" class="blue" :readonly="ReadOnly.PointerEvent" v-model="SuDung_DiaChiThuongTru">
                    </div>
                    <div class="flex">
                        <p>Địa chỉ thanh toán</p>
                        <input required type="text" class="blue" :readonly="ReadOnly.PointerEvent" v-model="SuDung_DiaChiThanhToan">
                    </div>
                    <div class="flex">
                        <p>Địa chỉ trụ sở giao dịch</p>
                        <input type="text" class="blue" :readonly="ReadOnly.PointerEvent" v-model="SuDung_TruSoGiaoDich">
                    </div>
                    <!--  -->
                    <div class="row">
                        <div class="col-sm-4 flex">
                            <p>Tài khoản số: </p>
                            <input type="text" class="blue" :readonly="ReadOnly.PointerEvent" v-model="SuDung_TaiKhoanSo">
                        </div>
                        <div class="col-sm-4 flex">
                            <p>Tại ngân hàng: </p>
                            <input type="text" class="blue" :readonly="ReadOnly.PointerEvent" v-model="SuDung_NganHang">
                        </div>
                        <div class="col-sm-4 flex">
                            <p>MST/Mã NNS: </p>
                            <input required type="text" class="blue" :readonly="ReadOnly.PointerEvent" v-model="SuDung_MST">
                        </div>
                    </div>
                    <!--  -->
                    <div class="row">
                        <div class="col-sm-4 flex">
                            <p>Điện thoại: </p>
                            <input type="text" class="blue" :readonly="ReadOnly.PointerEvent" v-model="SuDung_SDT">
                        </div>
                        <div class="col-sm-4 flex">
                            <p>E-mail: </p>
                            <input type="text" class="blue" :readonly="ReadOnly.PointerEvent" v-model="SuDung_Email">
                        </div>
                        <div class="col-sm-4 flex">
                            <p>Thông tin liên hệ khác: </p>
                            <input placeholder="" type="text" class="blue" :readonly="ReadOnly.PointerEvent" v-model="SuDung_LienHeKhac">
                        </div>
                    </div>
                </div>
                <!-- het ben a  -->
                <!-- sang ben b -->
                <div class="benb">
                    <p class="bold">Bên cung cấp dịch vụ (gọi tắt là “Bên B”): Trung tâm kinh doanh VNPT Tỉnh/TP - Chi nhánh Tổng Công ty Dịch vụ Viễn thông</p>
                    
                    <div class="row">
                        <div class="col-sm-6 flex">
                            <p>Đại diện bên B: </p>
                            <p class="blue">{{BenB[0].DAIDIEN}} </p>
                        </div>
                        <div class="col-sm-6 flex">
                            <p>Chức vụ:</p>
                            <p class="blue">{{BenB[0].CHUCVU}} </p>
                        </div>
                        
                    </div>
                    <div class="flex">
                        <p>Theo giấy ủy quyền số: </p>
                        <p class="blue">13305 </p>
                    </div>
                    <!--  -->
                    
                    <!--  -->
                    
                    <div class="row">
                        <div class="col-sm-3 flex">
                            <p>Tài khoản số: </p>
                            <p class="blue">{{BenB[0].TAIKHOANSO}} </p>
                        </div>
                        <div class="col-sm-4 flex">
                            <p>Tại ngân hàng: </p>
                            <p class="blue">{{BenB[0].NGANHANG}}</p>
                        </div>
                        <div class="col-sm-5 flex">
                            <p>MST/Mã NNS: </p>
                            <p class="blue">{{BenB[0].MASOTHUE}}</p>
                        </div>
                    </div>
                    <!--  -->
                    <div class="row">
                        <div class="col-sm-3 flex">
                            <p>GPKD số:</p>
                            <p class="blue">{{BenB[0].GPKD}}</p>
                        </div>
                        <div class="col-sm-4 flex">
                            <p>Ngày cấp: </p>
                            <p class="blue">{{BenB[0].NGAYCAP}}</p>
                        </div>
                        <div class="col-sm-5 flex">
                            <p>Nơi cấp: </p>
                            <p class="blue">{{BenB[0].NOICAP}}</p>
                        </div>
                    </div>
                    <p >Địa chỉ: <span class="blue">{{BenB[0].DIACHI}}</span></p>
                    <div class="row">
                        <div class="col-sm-6 flex">
                            <p>Điện thoại</p>
                            <p class="blue">{{BenB[0].DIENTHOAI}}</p>
                        </div>
                        <div class="col-sm-6 flex">
                            <p>Website</p>
                            <p class="blue">{{BenB[0].WEBSITE}}</p>
                        </div>
                    </div>
                </div>
                <!-- het ben b -->
                <!-- hop dong -->
                <div class="noidung">
                    <p class="bold">Điều 1: Bên B cung cấp cho Bên A dịch vụ: </p>

                    <table class="table-bordered">
                        <thead>
                            <tr>
                                <th>STT</th>
                                <th>Loại dịch vụ</th>
                                <th>Địa chỉ lắp đặt</th>
                                <th>Số thuê bao <br> Tên thuy cập</th>
                                <th>Gói cước/ Loại cổng <br>Tốc độ/ Số hiệu kênh</th>
                                <th>Loại dịch vụ cộng thêm</th>
                                <th>Thông tin khác</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr class="blue">
                                <td>1</td>
                                <td>{{LoaiDichVu}}</td>
                                <td>{{DiaChiLapDat}}</td>
                                <td>{{SoThueBao}}</td>
                                <td>{{GoiDichVu}}</td>
                                <td></td>
                                <td></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <!-- het noi dung dich vu -->
                <!-- d -->
                <div class="dieu2">
                    <p class="bold">Điều 2: Hình thức thanh toán, nhận thông báo cước, thông tin chăm sóc khách hàng:</p>
                    <p>Các bên thống nhất các hình thức nhận thông báo cước, thông tin khuyến mại/chăm sóc khách hàng, hình thức thanh toán Bên A đăng kýnhư sau:</p>
                    <div class="row">
                        <div class="col-sm-6">
                            <p class="bold">Hình thức thanh toán của bên A</p>
                            <ul>
                                <li><input type="checkbox" v-model="HinhThucThanhToan" value="1"> Qua ngân hàng/TMĐT</li>
                                <li><input type="checkbox" v-model="HinhThucThanhToan" value="2"> Tại các điểm giao dịch của Bên B</li>
                                <li><input type="checkbox" v-model="HinhThucThanhToan" value="3"> Tại địa chỉ thanh toán</li>
                                <li><input type="checkbox" v-model="HinhThucThanhToan" value="4"> Khác</li>
                            </ul>
                        </div>
                        
                        <div class="col-sm-6">
                            <p class="bold">Hình thức nhận thông báo cước</p>
                            <ul>
                                <li><input type="checkbox" v-model="HinhThucThongBao" value="1"> Qua cổng thông tin điện tử</li>
                                <li><input type="checkbox" v-model="HinhThucThongBao" value="2"> Qua thư điện tử (email)</li>
                                <li><input type="checkbox" v-model="HinhThucThongBao" value="3"> Qua tin nhắn (số điện thoại)</li>
                                <li><input type="checkbox" v-model="HinhThucThongBao" value="4"> Bản in</li>
                            </ul>
                            
                        </div>
                        
                    </div>
                </div>
                <!-- het dieu 2 -->
                <!-- thoa thuan -->
                <div class="thoathuan">
                    <p class="bold">
                        Sau khi Bên A đã đọc kỹ các Điều khoản ban hành kèm theo Hợp đồng này, Bên A và Bên B thoả thuận
                    </p>
                    <ul class="sothutu">
                        <li>Hai Bên cam kết tuân thủ các điều khoản và mọi thay đổi về nội dung của Hợp đồng này sẽ được quy định trong các phụ lục kèm theo Hợp đồng. (Hợp đồng mẫu, điều kiện giao dịch chung được niêm yết công khai tại các điểm giao dịch, trên website của Bên B).</li>
                        <li>Bên B cam kết cung cấp các dịch vụ cho Bên A như đã quy định tại Hợp đồng. Biên bản bàn giao, nghiệm thu là phụ lục của Hợp đồng này. Ngày bắt đầu tính cước của Bên A là ngày nghiệm thu bàn giao theo Biên bản nghiệm thu, bàn giao hoặc ngày hòa mạng đối với dịch vụ di động.</li>
                        <li>Bên A thanh toán chậm nhất trong vòng (N) ngày kể từ ngày cuối cùng của tháng phát sinh cước. Quả thời hạn đó, Bên B có quyền tạm ngừng cung cấp dịch vụ theo quy định của hợp đồng</li>
                        <li>Hợp đồng này được lập thành 02 bản, mỗi Bên giữ 01 bản và có hiệu lực kể từ ngày ký.</li>
                    </ul>
                </div>
                <!-- het thoa thuan -->
                <div class="center">
                    <div class="row">
                        <div class="col-sm-4 chuky">
                            <p class="bold">Đại diện Bên A</p>
                            <p class="innghieng">(Ký, ghi rõ họ tên)</p>
                            <!-- <canvas :readonly="ReadOnly.PointerEvent" ref="signatureCanvas" class="chukybena"></canvas> -->
                            <canvas  ref="signatureCanvas" class="chukybena" ></canvas>
                        </div>
                        <div class="col-sm-4 chuky">
                            <p class="bold">Nhân viên giao dịch</p>
                            <p class="innghieng">(Ký, ghi rõ họ tên)</p>
                            <p>Xuân</p>
                            <p>Nguyễn Thanh Xuân</p>
                        </div>
                        <div class="col-sm-4 chuky">
                            <p class="bold">Đại diện Bên B</p>
                            <p class="innghieng">(Ký, ghi rõ họ tên)</p>
                            <p class="blue">{{BenB_Ten}}</p>
                            <p class="blue">{{BenB[0].DAIDIEN}}</p>
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
    </div>
    <div v-if="ButtonHopDong" class="group-button">
        <button type="button" id="btn-hoantat" @click="LuuHopDong" >Hoàn tất</button>
        <button type="button" id="btn-huy">Hủy</button>
    </div>
    <div class="thongbao" v-show="thongbao">
         <div class="thongbaothanhcong" v-show="thongbaothanhcong">
            <Icon icon="line-md:uploading-loop" width="30" height="30"  style="color: white" />
            <p class="inhoa">đang lưu thông tin</p>
            
        </div>
        <div class="thongbaothatbai" v-show="thongbaothatbai">
            <div class="button-close">
               <button type="button" @click="dongthongbaothatbai">
                 <Icon class="icon" icon="zondicons:close-solid" width="30" height="30"  style="color: white" />
               </button>
            </div>
            <p>CHƯA NHẬP HẾT THÔNG TIN</p>
            <p>QUÝ KHÁCH VUI LÒNG KIỂM TRA LẠI THÔNG TIN</p>
        </div>
    </div>
</form>

</template>
<script>
    import {Icon} from '@iconify/vue2'
    import SignaturePad from 'signature_pad';
    import axios from 'axios'
    export default {
        name: 'KhachHangHopDong',
        components:{
            Icon,
        },
        data(){
            return {
                NgayThangHienTai: null,
                
                BenB:[],
                ID_KHACHHANG: null,
                ID_KhachHang: null,

                // ben a:
                SuDung_DaiDien: null,
                SuDung_ChucVu: null,
                SuDung_NgaySinh: null,
                SuDung_GoiTinh: null,
                SuDung_SoCCCD: null,
                SuDung_NgayCapCCCD: null,
                SuDung_NoiCapCCCD: null,
                SuDung_GiayChungNhan: null,
                SuDung_NgayCapGCN: null,
                SuDung_NoiCap_GDN: null,
                SuDung_DiaChiThuongTru: null,
                SuDung_DiaChiThanhToan: null,
                SuDung_TruSoGiaoDich: null,
                SuDung_TaiKhoanSo: null,
                SuDung_NganHang: null,
                SuDung_MST: null,
                SuDung_SDT: null,
                SuDung_Email: null,
                SuDung_LienHeKhac: null,

                BenB_Ten: null,

                // dich vu
                LoaiDichVu: null,
                DiaChiLapDat: null,
                SoThueBao: null,
                GoiDichVu: null,
                DichVuCongThem: null,
                ThongTinKhac: null,
                
                // insert danh sach hinh thuc thanh toan
                HinhThucThanhToan: [],
                HinhThucThongBao: [],

                // insert hop dong
                ThoiGianKyHopDong: null, // ok
                IDFK_ThongTinKhachHangChung: null, // ok
                IDFK_KhachHangHopDong: null, // ok
                IDFK_HopDongBenB: 3, // ok
                TrangThai_HopDong: 0,

                signaturePad: null,
                
                // hopdong - hinhthuc - ben a
                IDFK_HopDong: null,

                //
                ID_HopDong: null,
                ReadOnly: {
                    PointerEvent: true,
                },
                ButtonHopDong: true,
                ChuKyURL: null,
                // thong bao
                thongbao: false,
                thongbaothanhcong: false,
                thongbaothatbai: false,
            }
        },
        created(){
            this.ID_KhachHang = localStorage.getItem("ID_KhachHang");
            this.fetchAPI_hopdongbenb();
            this.NgayThangHienTai =  this.FormatTimeNgayThangHienTai();
            // console.log("ngay thang hien tai ",this.NgayThangHienTai)
            this.ThoiGianKyHopDong = this.FormatTime();
            
        },
        mounted() {
            
            // console.log("ID_KhachHang_mounted: ", this.ID_KhachHang);
            this.fetchAPI_hopdong_noidungdichvu();
        
            // chu ky
            setTimeout(() => {
                const canvas = this.$refs.signatureCanvas;
                if (canvas) {
                    canvas.width = canvas.offsetWidth;
                    canvas.height = canvas.offsetHeight;
                    // canvas.width = canvas.clientWidth || 500; 
                    // canvas.height = canvas.clientHeight || 300;
                    this.signaturePad = new SignaturePad(canvas);
                    console.log("Canvas đã được khởi tạo thành công.");
                } else {
                    console.error("Không thể tìm thấy phần tử canvas.");
                }
            }, 100);
            this.fetchAPI_thongtin_khachhang_chung();
            this.fetchAPI_HopDong_GetKhachHang();
            this.axiosAPI_IDFKHopDongFromKhachHang();
        },
        
        watch:{
            HinhThucThanhToan(val) {
                console.log("id hinh thuc thanh toan: ", val.join(", "));
            },
            HinhThucThongBao(val) {
                console.log("id hinh thuc thong bao: ", val.join(", "));
            }
            
        },
        methods:{
            async axiosAPI_IDFKHopDongFromKhachHang() {
                try {
                    // console.log("Gửi yêu cầu API với ID_KhachHang:", this.ID_KhachHang);
                    const response = await axios.post(
                        `http://localhost:8081/api/banhang/idfkhopdongfromkhachhang/${this.ID_KhachHang}`,
                        
                    );
                    // console.log("Dữ liệu từ API:", response.data);
                    if (response.status === 200) {
                        if (response.data.length > 0) {
                            this.ID_HopDong = response.data[0].IDFK_HOPDONG;
                            if(this.ID_HopDong != null){ // da ky hop dong
                                this.ReadOnly = {
                                    PointerEvent: true
                                };
                                this.ButtonHopDong= false;
                                await this.fetchAPI_LayDuLieuKhachHangChungHopDong();

                            
                            }
                            else {
                                this.ReadOnly = {
                                    PointerEvent: false
                                };
                                this.ButtonHopDong= true;
                            }
                            
                        } 
                        
                    } 
                    else {
                        console.log("Lỗi khi nhận dữ liệu từ API");
                    }
                } catch (error) {
                    console.error("Lỗi khi gọi API:", error);
                }
            },
            async fetchAPI_LayDuLieuKhachHangChungHopDong(){
                try {
                    const LayDuLieuKhachHangChungHopDong = await axios.post(`http://localhost:8081/api/banhang/laydulieukhachhanghopdong/${this.ID_KhachHang}`, {}, {
                        
                    });
                    if(LayDuLieuKhachHangChungHopDong.status === 200) {
                        // const DuLieu = LayDuLieuKhachHangChungHopDong.json();
                        // console.log("da lay duoc fetchAPI_LayDuLieuKhachHangChungHopDong");
                        // console.log("laydulieukhachhanghopdong: ", LayDuLieuKhachHangChungHopDong );
                        const DuLieu = LayDuLieuKhachHangChungHopDong.data[0];
                        this.SuDung_ChucVu = DuLieu.CHUCVU;
                        this.SuDung_NgaySinh = DuLieu.NGAYSINH  ;
                        this.SuDung_GoiTinh = DuLieu.GIOITINH  ; 
                        this.SuDung_SoCCCD = DuLieu.SO_CCCD  ;
                        this.SuDung_NgayCapCCCD = DuLieu.NGAYCAP_CCCD  ;
                        this.SuDung_NoiCapCCCD = DuLieu.NOICAP_CCCD  ;
                        this.SuDung_GiayChungNhan = DuLieu.SO_GIAYCHUNGNHAN  ;
                        this.SuDung_NgayCapGCN = DuLieu.NGAYCAP_GIAYCHUNGNHAN  ;
                        this.SuDung_NoiCap_GDN = DuLieu.NOICAP_GIAYCHUNGNHAN  ;
                        this.SuDung_DiaChiThuongTru = DuLieu.DIACHI_THUONGTRU  ;
                        this.SuDung_DiaChiThanhToan = DuLieu.DIACHI_THANHTOAN  ;
                        this.SuDung_TruSoGiaoDich = DuLieu.DIACHI_TRUSOGIAODICH  ; 
                        this.SuDung_TaiKhoanSo = DuLieu.TAIKHOANSO  ;
                        this.SuDung_NganHang = DuLieu.TAINGANHANG  ;
                        this.SuDung_MST = DuLieu.MASOTHUE  ;
                        this.SuDung_LienHeKhac = DuLieu.LIENHEKHAC  ;
                        // this.SuDung_DiaChiThuongTru = 
                        this.ChuKyURL = DuLieu.CHUKY_KHACHHANG;
                        // console.log("URL: ", this.ChuKyURL);
                        const canvas = this.$refs.signatureCanvas;

                        if (canvas && this.ChuKyURL) {
                            const ctx = canvas.getContext('2d');
                            const image = new Image();

                            image.onload = () => {
                                // console.log("Ảnh đã tải xong, bắt đầu vẽ...");
                                ctx.clearRect(0, 0, canvas.width, canvas.height);
                                ctx.drawImage(image, 0, 0, canvas.width, canvas.height);
                                // console.log("Đã vẽ ảnh lên canvas.");
                            };

                            image.onerror = () => {
                                console.error("Không thể tải ảnh từ URL:", this.ChuKyURL);
                            };

                            image.src = this.ChuKyURL;
                        } else {
                            console.error("Canvas hoặc URL chữ ký không tồn tại.");
                        }


                    }
                    else {
                        console.log("Loi laydulieukhachhanghopdong");
                    }
                }
                catch(error) {
                    console.log("Loi laydulieukhachhanghopdong", error);
                }
            },
            FormatTimeNgayThangHienTai(){
                const now = new Date();
                const year = now.getFullYear();
                const month = String(now.getMonth() + 1).padStart(2, '0');
                const day = String(now.getDate()).padStart(2, '0');
                return `${day}-${month}-${year}`;
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
            async fetchAPI_hopdongbenb(){
                try {
                    const KetNoi = await fetch('http://localhost:8081/api/quanly/hopdongbenb');
                    if(KetNoi.ok) {
                        const Data = await KetNoi.json();
                        this.BenB = Data;
                        this.BenB_Ten = this.BenB[0].DAIDIEN.split(" ").pop();
                    }
                }
                catch(error) {
                    console.log("loi:", error);
                }
                // axios.post :
                // IDTaiKhoanKhachHang
            },
            async fetchAPI_hopdong_noidungdichvu(){
                try {
                    
                    const YeuCau = await axios.post(
                        `http://localhost:8081/api/banhang/getHopDong/${this.ID_KhachHang}`, 
                        
                    );
                    if(YeuCau.status === 200) {
                        this.LoaiDichVu = YeuCau.data[0].TENDANHMUCGDV;
                        this.DiaChiLapDat = YeuCau.data[0].TENQUANHUYEN ;
                        this.SoThueBao = YeuCau.data[0].SDT_KHACHHANG;
                        this.GoiDichVu = YeuCau.data[0].TENGDV;
                    }
                }
                catch(error) {
                    console.log("Loi: ", error);
                }
            },
            async fetchAPI_thongtin_khachhang_chung(){
                try {
                    const YeuCau = await axios.post(
                        `http://localhost:8081/api/banhang/getthongtinkhachhangchung/${this.ID_KhachHang}`,
                    );
                    if(YeuCau.status === 200) {
                        // console.log("Thong tin khach hang chung: ", YeuCau.data);
                        this.SuDung_DaiDien = YeuCau.data[0].HOTEN_KHACHHANG;
                        this.SuDung_SDT = YeuCau.data[0].SDT_KHACHHANG;
                        this.SuDung_Email = YeuCau.data[0].EMAIL_KHACHHANG;
                        this.IDFK_ThongTinKhachHangChung = YeuCau.data[0].ID_THONGTIN_KHACHHANG_CHUNG;
                        
                    }
                    else {
                        console.log("loi thong tin khachhang chung");
                    }
                }
                catch(error){
                    console.log("loi lay thong tin khach hang chung: ", error);
                }
            },

            async fetchAPI_HopDong_GetKhachHang(){
                try {
                    const YeuCau = await axios.post(
                        `http://localhost:8081/api/banhang/getkhachhanghopdong/${this.ID_KhachHang}`,
                    );
                    if(YeuCau.status === 200) {
                        // console.log("data fetchAPI_HopDong_GetKhachHang: ", YeuCau.data);
                        
                    }
                    else {
                        console.log("loi fetchAPI_HopDong_GetKhachHang");
                    }
                }
                catch(error){
                    console.log("loi fetchAPI_HopDong_GetKhachHang: ", error);
                }
            },
            // const ChuKyKhachHang = this.signaturePad.toDataURL();

            async LuuHopDong(){
                if(this.SuDung_NgaySinh == null
                    || this.SuDung_GoiTinh == null
                    || this.SuDung_SoCCCD == null
                    || this.SuDung_NgayCapCCCD == null
                    || this.SuDung_NoiCapCCCD == null
                    || this.SuDung_DiaChiThuongTru == null
                    || this.SuDung_DiaChiThanhToan == null
                    
                ) {
                    this.thongbao = true;
                    this.thongbaothatbai = true;
                }
                else {
                    await this.fetchAPI_Insert_KhachHangHopDong();
                    await this.fetchAPI_Insert_HopDong();
                    await this.fetchAPI_Insert_HopDong_ThanhToan();
                    await this.fetchAPI_Insert_HopDong_ThongBao();
                    await this.fetchAPI_Insert_KhachHang();
                }
            },        

            async fetchAPI_Insert_KhachHangHopDong(){
                
                const KhachHangHopDong = {
                    ChucVu: this.SuDung_ChucVu,
                    NgaySinh: this.SuDung_NgaySinh,
                    GioiTinh: this.SuDung_GoiTinh,
                    SoCCCD: this.SuDung_SoCCCD,
                    NgayCapCCCD: this.SuDung_NgayCapCCCD,
                    NoiCapCCCD: this.SuDung_NoiCapCCCD,
                    SoGiayChungNhan: this.SuDung_GiayChungNhan,
                    NgayCapGCN: this.SuDung_NgayCapGCN,
                    NoiCapGCN: this.SuDung_NoiCap_GDN,
                    DiaChiThuongTru: this.SuDung_DiaChiThuongTru,
                    DiaChiThanhToan: this.SuDung_DiaChiThanhToan,
                    TruSoGiaoDich: this.SuDung_TruSoGiaoDich,
                    TaiKhoanSo: this.SuDung_TaiKhoanSo,
                    NganHang: this.SuDung_NganHang,
                    MaSoThue: this.SuDung_MST,
                    LienHeKhac: this.SuDung_LienHeKhac,
                }
                console.log("insert khachhang hopdong: ",KhachHangHopDong);
                try {
                    const Insert_KhachHangHopDong = await axios.post(
                        'http://localhost:8081/api/banhang/insertkhachhanghopdong',
                        KhachHangHopDong,
                        {
                            headers: {
                                'Content-Type':'application/json'
                            }
                        }
                    );
                    if(Insert_KhachHangHopDong.status === 200) {
                        console.log("Insert khachhang hopdong thanh cong", Insert_KhachHangHopDong.data);
                        this.IDFK_KhachHangHopDong = Insert_KhachHangHopDong.data.IDFK_KhachHangHopDong;
                        console.log("IDFK_KhachHangHopDong: ", this.Insert_KhachHangHopDong); 
                    }
                    else {
                        console.log("Loi insert khachhang hopdong");
                    }
                }
                catch(error) {
                    console.log("Loi insert hopdong: ", error);
                }
            },
            async fetchAPI_Insert_HopDong(){
                try {
                    const ThongTin_HopDong = {
                    ThoiGianKyHopDong: this.ThoiGianKyHopDong,
                    IDFKThongTinKhachHangChung: this.IDFK_ThongTinKhachHangChung,
                    IDFKKhachHangHopDong: this.IDFK_KhachHangHopDong,
                    IDFKHopDongBenB: this.IDFK_HopDongBenB,
                    ChuKyKhachHang: this.signaturePad.toDataURL(),
                    // ChuKyKhachHang: "a",
                    TrangThaiHopDong: 1
                    };
                    console.log("Insert hop dong: ", ThongTin_HopDong);
                    const Insert_HopDong = await axios.post('http://localhost:8081/api/banhang/inserthopdong',
                        ThongTin_HopDong, {
                        headers: {
                            'Content-Type':'application/json'
                        }
                    });
                    if(Insert_HopDong.status === 200) {
                        console.log("insert hopdong thanh cong");
                        this.IDFK_HopDong = Insert_HopDong.data.IDFK_HopDong;
                        console.log("IDFK_HopDong: ", this.IDFK_HopDong);
                    }
                }
                catch(error) {
                    console.log("Loi insert hop dong: ", error);
                }
                
            },
            
            
            async fetchAPI_Insert_HopDong_ThanhToan(){
                try {
                    const ThongTin_HopDong_ThanhToan = {
                        IDFKHopDong: this.IDFK_HopDong,
                        IDFKHinhThucThanhToan: this.HinhThucThanhToan
                    };
                    const Insert_HopDong_ThanhToan = await axios.post('http://localhost:8081/api/banhang/inserthopdongthanhtoan',
                     ThongTin_HopDong_ThanhToan, {
                        headers: {
                            'Content-Type':'application/json'
                        }
                    });
                    if(Insert_HopDong_ThanhToan.status === 200) {
                        console.log("insert hopdong + thanh toan THANH CONG");
                    }
                    else {
                        console.log("insert hopdong + thanhtoan that bai");
                    }
                }
                catch(error) {
                    console.log("Loi insert hopdong -thanhtoan: ", error);
                }
            },

            
            async fetchAPI_Insert_HopDong_ThongBao(){
                try {
                    const ThongTin_HopDong_ThongBao = {
                        IDFKHopDong: this.IDFK_HopDong,
                        IDFKHinhThucThongBao: this.HinhThucThongBao
                    };
                    const Insert_HopDong_ThongBao = await axios.post('http://localhost:8081/api/banhang/inserthopdongthongbao', 
                        ThongTin_HopDong_ThongBao, {
                        headers: {
                            'Content-Type':'application/json'
                        }
                    });
                    if(Insert_HopDong_ThongBao.status === 200) {
                        console.log("insert hopdong + thongbao THANH CONG");
                    }
                    else {
                        console.log("insert hopdong + thongbao that bai");
                    }
                }
                catch(error) {
                    console.log("Loi insert hopdong - thongbao: ", error);
                }
            },
            async fetchAPI_Insert_KhachHang(){
                try {
                    const ThongTinInsert = {
                        ID_KhachHang: this.ID_KhachHang,
                        IDFK_HopDong: this.IDFK_HopDong
                    };
                    console.log("fetchAPI_Insert_KhachHang data: ", ThongTinInsert);
                    const InsertHopDong = await axios.post('http://localhost:8081/api/banhang/inserthopdongkhachhang', 
                        ThongTinInsert, {
                        headers:{
                            'Content-Type': 'application/json'
                        }
                    });
                    if (InsertHopDong.status === 200) {
                        console.log("Insert IDFK_HopDong vao bang KhachHang thanh cong");
                        console.log("Response data: ", InsertHopDong.data); 
                        this.thongbao = true;
                        this.thongbaothanhcong = true;
                        setTimeout(() => {
                            this.thongbao = false;
                            this.thongbaothanhcong = false;
                            window.location.reload();
                        }, 2500);
                    } else {
                        console.log("Loi insert IDFK_HopDong vao bang KhachHang. Status code: ", InsertHopDong.status);
                        console.log("Response body: ", InsertHopDong.data); 
                    }

                }
                catch(error) {
                    console.log("Loi insert IDFK_HopDong vao bang KhachHang: ", error);
                }

            },
            dongthongbaothatbai(){
                this.thongbao = false;
                this.thongbaothatbai = false;
            }


        }
    }
</script>
<style scoped>

.main-container {
    background-color: white;
    /* border: 1px solid black; */
}
.font-bold {
    font-weight: bold;
}
.color-blue {
    color: #00619e;
}
.inhoa {
    text-transform: uppercase;
}

#logovnpt {
    width: 60px;
    height: auto;
    margin-left: 100px;
    margin-top:20px
}
.header {
    display: flex;
    justify-content: space-between;
    margin-left: 10px;
    margin-right: 10px;
}
.content {
    margin-left: 10px;
    margin-right: 10px;
}

.underline-blue {
    text-align: center;
    text-decoration: underline;
    text-decoration-color: #00619e;
    margin-top: -15px;
}
ul {
    list-style-type: none;
}
#tenhopdong {
    text-align: center;
    color: #00619e;
    font-size: 22px;
    font-weight: bold;
    text-transform: uppercase;
}
.innghieng {
    font-style: italic;
}
.bold {
    font-weight: bold;
}
.blue {
    color:#00619e;
    font-weight: 500;
}
.flex{
    display: flex;
}
.flex p
{ 
    margin: 0;
    margin-right:10px;
    white-space: nowrap;
}
p{
    line-height: 35px;
}
input {
    flex-grow: 1;
    width: 100%;
    height: 30px;
    border: none;
    background-color: #f5f4f0;
    outline: none;
    /* border: 1px solid black; */
}
input:hover{
    border: none;
}
table{
    width: 100%;
}
.kyhopdong {
    display: flex;
    justify-content: space-evenly;
}
.center {
    width: 100%;
    margin-left: 10px;
}
.row {
    width: 100%;
}
.chuky {
    /* width: 30%; */
    text-align: center;
    /* border: 1px solid black; */
}
canvas.chukybena {
    background-color: #fafafa;
    width: 100%;
    height: auto;
    border: 1px solid black;
}
.border {
    border: 1px solid black;
}
.noidung {
    line-height: 35px;
}
.hinhthucthanhtoan {
    display: flex;
}
.group-button {
    width: 100%;
    display: flex;
    margin-top: 100px;
    margin-bottom: 30px;
    gap: 30px;
    justify-content: center;
    background-color: #ffffff;
}
.group-button button {
    width: 200px;
    height: 40px;
    border: none;
    border-radius: 3px;
    
}
#btn-hoantat:hover {
    background-color: #26bbdd;
    color: #265261;
    
}
#btn-hoantat {
    background-color: #cff4fc;
    border:2px solid #265261;
    font-weight: bold;
    color: #265261;
    
}
#btn-huy:hover {
    background-color: #fb818d;
    color: #59151c;
    
}
#btn-huy {
    background-color: #f7d7da;
    border: 2px solid #59151c;
    font-weight: bold;
    color: #59151c;
}
form {
    background-color: white;
}
.tenhopdong {
    text-align: center;
}
.trangthaihopdong {
    margin-top: -20px;
}
/* .view-only {
  pointer-events: none;
 
} */
.thongbao {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.5);
    display: flex;
    justify-content: center;
    align-items: center;
    z-index: 1000;
}
.thongbaothanhcong,
.thongbaothatbai
{
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    text-align: center;
    width: 20% ;
    min-height: 20%;
    background-color: #1f7ed1;
    color: white;
    padding: 0 20 20px;
    text-align: center;
    font-weight: 500;
    border: 3px solid white;
    border-radius: 10px;
}
.thongbaothatbai{
    background-color: brown;
}
.button-close {
    display: flex;
    justify-content: flex-end;
    /* border: 1px solid black; */
    width: 100%;
    
}
.button-close button {
    width: auto;
    height: auto;
    display: inline-block;
    margin-right: 20px;
    background:transparent;
    border: none;
    cursor: pointer;
}

</style>

