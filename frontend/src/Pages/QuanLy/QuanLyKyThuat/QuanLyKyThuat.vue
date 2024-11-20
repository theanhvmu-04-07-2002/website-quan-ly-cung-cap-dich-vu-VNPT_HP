<template>
    <div class="content">
        <div class="header">
            <h4>VNPT HẢI PHÒNG</h4>
            <h5>HỆ THỐNG QUẢN LÝ KINH DOANH TẬP TRUNG - QUẢN LÝ KỸ THUẬT</h5>
        </div>
        <!--  -->
        <div class="maincontent">
            <div class="dieuhuong">
                <ul>
                    <li>
                        <button class="bold white" @click="showquanlykhaosat">QUẢN LÝ KHẢO SÁT <br> LẮP ĐẶT</button>
                    </li>
                    <li>
                        <button class="bold white" @click="showquanlysuachua">QUẢN LÝ SỬA CHỮA</button>
                    </li>
                    <li>
                        <button class="bold white">QUẢN LÝ THAY ĐỔI</button>
                    </li>
                   
                </ul>
            </div>
            <!-- end dieu huong - left -->
            <div class="quanly">
                <div class="content-quanly">
                    <div class="quanly-khaosat-lapdat" v-show="hienthiquanlykhaosat">
                        <QuanLyKhaoSatLapDat />
                    </div>
                    <div class="quanly-baohong" v-show="hienthiquanlysuachua">
                        <QuanLyKhaoBaoHong />
                    </div>
                </div>
            </div>  
            <!-- end quan ly - right -->
        </div>
    </div>    
</template>
<script>
    import QuanLyKhaoSatLapDat from './QuanLyKhaoSatLapDat.vue'
    import QuanLyKhaoBaoHong from './QuanLyBaoHong.vue'
    export default {
        name: 'QuanLyKyThuat',
        components:{
            QuanLyKhaoSatLapDat,
            QuanLyKhaoBaoHong,
        },
        data() {
            return {
                hienthiquanlykhaosat: true,
                hienthiquanlysuachua: false
            }
        },
        methods:{
            showquanlykhaosat(){
                this.hienthiquanlykhaosat = true;
                this.hienthiquanlysuachua = false;
            },
            showquanlysuachua(){
                this.hienthiquanlysuachua = true;
                this.hienthiquanlykhaosat = false;
            }
        }
    }

</script>


<style scoped>

.content {
    display: flex;
    flex-direction: column;
    height: 100%;
}

.header {
    width: 100%;
    background-color: #1f7ed1;
    color: white;
    text-align: center;
    padding-top: 10px;
    padding-bottom: 10px;
}

.maincontent {
    display: flex;
    flex-grow: 1;
    min-height: calc(100vh - 90px);
    background-color:#f5f4f0 ;
}
/* 
.dieuhuong {
    width: 20%;
    background-color: #212120;
    display: flex;
    flex-direction: column;
    justify-content: space-between ;
} */

.dieuhuong {
    width: 20%;
    background-color: #212120;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    position: sticky;
    top: 0;
    height: fit-content; 
    min-height: 100vh;
}


.quanly {
    width: 80%;
    background-color: #f5f4f0;
}

.bold {
    font-weight: 500;
    color: white;
    background-color: #212120;
    width: 100%;
}

li {
    margin-top: 20px;
}
.content-quanly{
    margin: 20px;
    border: 1px solid black;
}
.blue {
    background-color: rgb(48, 84, 150);
}
.center {
    text-align: center;
}
.white {
    color: white;
}
.h2 {
    font-weight: 500;
    font-size: 20px;
    padding:5px;
}
</style>
