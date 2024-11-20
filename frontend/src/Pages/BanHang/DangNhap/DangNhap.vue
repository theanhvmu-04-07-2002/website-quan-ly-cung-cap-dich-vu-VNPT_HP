<template>
  <div class="content">
    <div class="header">
        <BanHang_Header />
    </div>
    <div class="main-content">
        <div class="dangnhap">
            <div class="form-login">
                <form action="" class="form-group">
                    
                    <div class="header">
                        <p id="p-dangnhap" class="inhoa">Đăng nhập</p>
                        <p v-show="SaiThongTin" style="color: red;">Sai thông tin Tài khoản / Mật khẩu</p>
                    </div>
                    <div class="input-group">
                        <span>
                            <Icon class="icon" icon="bxs:user" width="20" height="20"  style="color: black" />
                        </span>
                        <input v-model="TaiKhoan" class="form-control" type="text" placeholder="Số điện thoại">
                    </div>
                    
                    <div class="input-group">
                        <span>
                            <Icon class="icon" icon="material-symbols:lock" width="20" height="20"  style="color: black" />
                        </span>
                        <input v-model="MatKhau" class="form-control" type="password" placeholder="Mật khẩu">
                    </div>
                    <div >
                        <button id="submit-form" type="button" class="btn btn-primary" @click="DangNhap" >Đăng nhập</button>
                        
                    </div>
                    
                    <div>
                        <button type="button" @click="moFormLayMK" class="btn btn-danger">Quên mật khẩu</button>
                    </div>
                </form>
                
            </div>
            <div class="form-laylaimatkhau" v-if="hienthiFormLayMK">
                <form action="" class="form-group">
                    <p id="p-dangnhap" class="inhoa">Lấy lại mật khẩu</p>
                    <div class="input-group">
                        <span>
                            <Icon class="icon" icon="bxs:user" width="20" height="20"  style="color: black" />
                        </span>
                        <input class="form-control" type="text" placeholder="Số điện thoại">
                    </div>
                    
                    <div class="input-group">
                        <span>
                            <Icon icon="icon-park:email-down" width="20" height="20" />
                        </span>
                        <input class="form-control" type="password" placeholder="Email">
                    </div>
                    <div class="button" >
                        <button id="submit-form" type="button" class="btn btn-primary black" >Gửi mật khẩu</button>
                        <button id="submit-form" type="button" class="btn btn-danger black" @click="dongFormLayMK" >Đóng</button>
                        
                    </div>
                </form>
            </div>
        
        </div>
    </div>
    <div class="footer">
        <BanHang_Footer />
    </div>
    
  </div>
</template>

    <script>
    import { Icon } from '@iconify/vue2'
    import axios from 'axios'
    // import { decode } from 'jwt-decode'
    import jwt_decode from 'jwt-decode'
    import BanHang_Header from '../components/BanHang_Header.vue'
    import BanHang_Footer from '../components/BanHang_Footer.vue'
    export default {
    name: "TrangChu",
    components:{
        BanHang_Header,
        BanHang_Footer,
        Icon,
    },
    data() {
        return {
            hienthiFormLayMK: false,
            TaiKhoan: null,
            MatKhau: null,
            SaiThongTin: false,
        }
    },
    methods:{
        moFormLayMK(){
            this.hienthiFormLayMK=!this.hienthiFormLayMK;
        },
        dongFormLayMK(){
            this.hienthiFormLayMK= !this.hienthiFormLayMK;
        },
        
        async DangNhap() {
            const ThongTinDangNhap = {
                TaiKhoan: this.TaiKhoan,
                MatKhau: this.MatKhau,
                PhanQuyen: 21,
            };
            try {
                const YeuCau = await axios.post(
                    'http://localhost:8081/api/banhang/dangnhapkhachhang', 
                    ThongTinDangNhap,
                    {
                        headers: {
                            'Content-Type': 'application/json'
                        }
                    }
                );
                
                if (YeuCau.status === 200) {
                    console.log("data YeuCau dangnhapkhachhang: ", YeuCau);
                    const accessToken = YeuCau.data.accessToken;
                    const GaiMa = jwt_decode(accessToken);
                    console.log("Du lieu giai ma token: ", GaiMa);
                    
                    localStorage.setItem("ID_KhachHang", GaiMa.id_khachhang);
                    console.log("ID_KhachHang: ",GaiMa.id_khachhang );
                    this.$router.push({ name: 'khachhang' });
                    
                } else {
                    console.log("sai thong tin");
                    this.SaiThongTin = true; 
                }
            } catch (error) {
                if (error.response) {
                    if (error.response.status === 400 || error.response.status === 401) {
                        console.log("sai thong tin dang nhap");
                        this.SaiThongTin = true;
                    } else {
                        console.log("Loi khac:", error.response.status, error.response.data);
                    }
                } else {
                    console.log("Không thể kết nối đến server:", error.message);
                }
            }
        }

    }
    };
    </script>

<style scoped>
.content {
    display: flex;
    flex-direction: column;
    min-height: 100vh;
}
.main-content {
    flex:1;
}
.dangnhap {
    background-image: url('http://localhost:8080/assets/HinhAnh/dangnhap/dangnhap.jpg');
    /* background-size: 100% 500px; */
    background-size: cover;
    background-repeat: no-repeat; 
    background-position: center;
    min-height: 400px; 
    position: relative;
    /* display: flex; */
}
.form-login, .form-laylaimatkhau {
    width: 350px;
    height: 300px;
    background-color: #fafafa;
    position: absolute;
    left: 180px;
    top: 60px;
    border-radius: 10px;
    padding: 10px;
}
#p-dangnhap {
    text-align: center;
}
.input-group {
    align-items: center;
    /* border: 1px solid black; */
}
.submit {
    display: block;
}
.form-group {
    line-height:50px;
}
.form-group {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}
/* #submit-form {
    
} */
.inhoa {
    text-transform: uppercase;
    font-weight: bold;
}
a {
    cursor: pointer;
    text-decoration: underline;
}
.button {
    display: flex;
    justify-content: space-around;
    /* border: 1px solid black; */
    width: 100%;
    margin-top: 20px;
}
.header {
    line-height: 1.5em;
}
/* tai khoan dang nhap:
112233
7ECA1
*/
</style>

