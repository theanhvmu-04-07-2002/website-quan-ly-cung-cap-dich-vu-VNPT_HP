<template>
    <div class="content">
        <div class="title">
            <h2>CÁC SẢN PHẨM HOT HIỆN NAY</h2>
        </div>
        <div class="goidichvu">
            <div class="card"
            v-for="(GoiDichVu, index) in GDVTungO"
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
                
                
                <div class="noidung">
                    <ul>
                        <li>
                            <p class="blue">
                                <strong>Internet tốc độ <span>{{GoiDichVu.BANGTHONGTRONGNUOC}}</span>Mbps</strong>
                            </p>
                        </li>
                        <li v-if="GoiDichVu.WIFIMESH5 != null">
                            <p class="blue">
                                <strong>{{GoiDichVu.WOFOMESH5}} Wifi Mesh</strong>
                            </p>
                        </li>
                        <li v-if="GoiDichVu.TENDANHMUCGDV === 'Internet - Truyền hình'">
                            <p class="blue">
                                <strong>Truyền hình MyTV gói Nâng cao Plus</strong>
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
        <div class="chuyentiep">
            <span 
                v-for="(page, index) in SoLuongO" 
                :key="index"
                @click="SoTrang = index" 
                :class="{ active: SoTrang === index }" 
                class="dot">
            </span>
        </div>
    </div>
</template>

<script> 
    // import axios from 'axios';
    export default {
        data() {
            return {
                DanhSachGoiDichVu:[],
                SoTrang: 0,
                SoO1Hang: 3,
            }
        },
        created() {
            this.fetchData();
        },
        computed: {
            
            SoLuongO() {
                return Math.ceil(this.DanhSachGoiDichVu.length / this.SoO1Hang);
            },
            
            GDVTungO() {
                const start = this.SoTrang * this.SoO1Hang;
                const end = start + this.SoO1Hang;
                return this.DanhSachGoiDichVu.slice(start, end);
            }
        },
        methods: {
            async fetchData() {
                try {
                    const response = await fetch('http://localhost:8081/api/banhang/chitietgiodichvu');
                    const data = await response.json(); 
                    console.log(data); 
                    this.DanhSachGoiDichVu = data; 
                } catch (error) {
                    console.log(error);
                    throw new Error('Loi ket noi');
                }
            },
        }
    }
</script>
    
<style scoped>
.title {
    margin-top: 20px ;
    margin-bottom: 10px;
    border-bottom: 1px solid #dedede;
}
a {
    text-decoration: none;
}
p {
    line-height: 1.5;
}
.text-center {
    text-align: center;
}
h2 {
    font-size: 20px;
    text-align: center;
}
.content {
    width: 90%;
    /* border: 1px solid black; */
    margin: auto;
    
}
.goidichvu {
    display: flex;
    justify-content: space-around;
    flex-wrap: wrap;
    margin-top: 20px;
    gap: 10px;
}
.card {
    flex: 1 1 calc(30% - 20px);
    /* display: none; */
}
/* .card:nth-child(-n+3) {
    display: block;
} */
.chuyentiep {
    display: flex;
    justify-content: center;
    margin-top: 20px;
}

.dot {
    height: 15px;
    width: 15px;
    margin: 0 5px;
    background-color: #bbb;
    border-radius: 50%;
    display: inline-block;
    cursor: pointer;
}

.dot.active {
    background-color: #119ef5;
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
#xemchitiet:hover {
    background-color: #2ed1ae;
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
li {
    line-height: 10px;
}
.noidung{
    margin-top: 20px;
}

</style>