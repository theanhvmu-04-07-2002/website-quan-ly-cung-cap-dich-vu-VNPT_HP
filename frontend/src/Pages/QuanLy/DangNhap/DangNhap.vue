<template>
  <div class="content">
    <div class="header">
        <QuanLy_Header />
    </div>
    <div class="main-content">
        <div class="dangnhap">
            <div class="form-login">
                <form @submit.prevent="dangnhap" action="" class="form-group">
                    <p id="p-dangnhap" class="inhoa">Đăng nhập</p>
                    <p style="color:red" v-if="SaiThongTinDangNhap">Sai thông tin đăng nhập</p>
                    <div class="input-group">
                        <span>
                            <Icon class="icon" icon="bxs:user" width="20" height="20"  style="color: black" />
                        </span>
                        <input v-model="tendangnhap" class="form-control" type="text" placeholder="Tên đăng nhập">
                    </div>
                    
                    <div class="input-group">
                        <span>
                            <Icon class="icon" icon="material-symbols:lock" width="20" height="20"  style="color: black" />
                        </span>
                        <input v-model="matkhau" class="form-control" type="password" placeholder="Mật khẩu">
                    </div>
                    <div >
                        <button id="submit-form" type="submit" class="btn btn-primary" >Đăng nhập</button>
                        
                    </div>
                    
                    <div>
                        <button type="button" @click="moFormLayMK" id="btnquenmatkhau" class="btn btn-danger">Quên mật khẩu</button>
                        
                    </div>
                    <!-- <a href="/quanly/quanlybanhang" style="color:black;">Quan ly ban hang</a> -->
                </form>
                
            </div>
            <div class="form-laylaimatkhau" v-if="hienthiFormLayMK">
                <form action="" class="form-group">
                    <p id="p-dangnhap" class="inhoa">Lấy lại mật khẩu</p>
                    <div class="input-group">
                        <span>
                            <Icon class="icon" icon="bxs:user" width="20" height="20"  style="color: black" />
                        </span>
                        <input class="form-control" type="text" placeholder="Tên đăng nhập">
                    </div>
                    
                    <div class="input-group">
                        <span>
                            <Icon icon="icon-park:email-down" width="20" height="20" />
                        </span>
                        <input class="form-control" type="password" placeholder="Email">
                    </div>
                    <div class="button" >
                        <button id="submit-form" type="submit" class="btn btn-primary black" >Gửi mật khẩu</button>
                        <button id="submit-form" type="button" class="btn btn-danger black" @click="dongFormLayMK" >Đóng</button>
                        
                    </div>
                </form>
            </div>

        </div>
    </div>
    
  </div>
</template>

<script>
import axios from 'axios';
import { Icon } from '@iconify/vue2';
import QuanLy_Header from '../component/QuanLy_Header.vue'

export default {
  name: "DangNhap",
  components: {
    QuanLy_Header,
    Icon,
  },
  data() {
    return {
      hienthiFormLayMK: false,
      tendangnhap: null,
      matkhau: null,
      thongTinTaiKhoan: null,
      thongBaoLoi: null,
      SaiThongTinDangNhap: false,
    }
  },
  methods: {
    moFormLayMK() {
      this.hienthiFormLayMK = !this.hienthiFormLayMK;
    },
    dongFormLayMK() {
      this.hienthiFormLayMK = !this.hienthiFormLayMK;
    },
    async dangnhap() {
      const ThongTinDangNhap = {
        TenDangNhap: this.tendangnhap,
        MatKhau: this.matkhau,
      };
      console.log("Thong tin dang nhap: ", ThongTinDangNhap);
      try {
        const YeuCau = await axios.post('http://localhost:8081/api/quanly/dangnhap', ThongTinDangNhap, {
          headers: {
            'Content-Type': 'application/json'
          }
        });

        if (YeuCau.status === 200) {
          console.log("Gui du lieu dang nhap thanh cong ", ThongTinDangNhap);

          
          const thongTinResponse = await axios.post('http://localhost:8081/api/quanly/thongtintaikhoan', ThongTinDangNhap, {
            headers: {
              'Content-Type': 'application/json'
            }
          });
        
          if (thongTinResponse.status === 200) {
            this.thongTinTaiKhoan = thongTinResponse.data; 
            console.log("Thong tin tai khoan: ", this.thongTinTaiKhoan);
            if(this.thongTinTaiKhoan[0].IDFK_PHANQUYEN == 1){
                this.$router.push({ name: 'quanlybanhang' });
            }
            if(this.thongTinTaiKhoan[0].IDFK_PHANQUYEN == 2){
                this.$router.push({ name: 'quanlykythuat' });
            }
            this.SaiThongTinDangNhap = false;
          }
        } else {
          console.log("gui du lieu that bai");
        }
      } catch (error) {
        if(error.response && error.response.status === 401){
            this.thongBaoLoi = "sai dang nhap";
            console.log(this.thongBaoLoi);
            this.SaiThongTinDangNhap = true;
        }
        console.log("loi: ", error);
      }
    }
  }
};
</script>


<style scoped>
.content {
    display: flex;
    flex-direction: column;
    height: 100vh;
}
.main-content {
    /* flex:1; */
    flex-grow: 1;
    height: auto;
}
.dangnhap {
    background-image: url('http://localhost:8080/assets/HinhAnh/dangnhap/dangnhap.jpg');
    /* background-size: 100% 500px; */
    background-size: cover;
    background-repeat: no-repeat; 
    background-position: center;
    min-height: 400px; 
    position: relative;
    display: flex;
    justify-content: center;
    height: 100%;
}

.form-login, .form-laylaimatkhau {
    width: 350px;
    height: 350px;
    background-color: #fafafa;
    position: absolute;
    /* left: 50%; */
    top: 60px;
    border-radius: 10px;
    padding: 10px;
    border: 1px solid blue;
}
#btnquenmatkhau {
    margin-bottom: 20px;
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
</style>
