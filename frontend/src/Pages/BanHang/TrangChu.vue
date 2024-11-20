<template>
  <div class="content">
    <div class="header">
        <BanHang_Header />
    </div>
    <div class="main-content">
        <GioiThieu />
        <BanHang_SanPhamHot />
        <BanHang_TinTuc />
    </div>
    <div class="footer">
        <BanHang_Footer />
    </div>
  </div>
</template>

<script>
import BanHang_Header from './components/BanHang_Header.vue'
import BanHang_Footer from './components/BanHang_Footer.vue'
import BanHang_SanPhamHot from './TrangChu/SanPhamHot.vue'
import BanHang_TinTuc from './TrangChu/TinTucKhuyenMai.vue'
import GioiThieu from './TrangChu/GioiThieu.vue'
export default {
  name: "TrangChu",
  components:{
    BanHang_Header,
    BanHang_Footer,
    BanHang_SanPhamHot,
    BanHang_TinTuc,
    GioiThieu,
  }
};
</script>

<style scoped>
.content {
    display: flex;
    flex-direction: column;
    min-height: 100vh;
    max-width: 100%;
}
.main-content {
    flex:1;
} 
.main-content {
    max-width: 100%;
}
.header {
    max-width: 100%;
    /* border: 1px solid black; */
}
.footer{
    max-width: 100%;
}

</style>
