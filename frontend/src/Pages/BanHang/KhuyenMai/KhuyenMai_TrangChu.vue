<template>
  <div class="content">
    <div class="header">
        <BanHang_Header />
    </div>
    <div class="main-content">
        <div class="noidung">
            <div class="trai">
                <KhuyenMai_TomTat />
            </div>
            <div class="phai">
                <TinTuc_ThongTinMoiNhat />
            </div>
        </div>
    </div>
    <div class="footer">
        <BanHang_Footer />
    </div>
  </div>
</template>

<script>
import BanHang_Footer from '../components/BanHang_Footer.vue';
import BanHang_Header from '../components/BanHang_Header.vue';
import KhuyenMai_TomTat from './KhuyenMai_TomTat.vue'
import TinTuc_ThongTinMoiNhat from '../components/TinTuc_ThongTinMoiNhat.vue';
// import TinTuc_ChiTiet from "./TinTuc_ChiTiet.vue";

export default{
    components:{
        TinTuc_ThongTinMoiNhat,
        BanHang_Footer,
        BanHang_Header,
        KhuyenMai_TomTat,
    }
}
</script>
<style scoped>
.content {
    display: flex;
    flex-direction: column;
    min-height: 100vh;
}
.main-content {
    flex:1;
    margin-top: 40px;
    margin-bottom: 60px;
}
.noidung {
    width: 90%;
    margin-left: auto;
    margin-right: auto;
    display: flex;
    justify-content: space-around;
}
.trai {
    width: 65%;
    /* border: 1px solid black; */
}
.phai {
    width: 30%;;
    /* border: 1px solid black; */
}

</style>
