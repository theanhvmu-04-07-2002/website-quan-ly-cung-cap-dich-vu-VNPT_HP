<template>
    <div class="content">
        <div class="title">
            <h2>TIN TỨC - KHUYẾN MẠI</h2>
        </div>
        <div class="tintuc">
            <div class="card"
            v-for="(TinTuc, index) in DanhSachTungO"
            :key="index"
            >
                <a href="" >
                    <div class="hinhanh">
                        <img :src="TinTuc.HINHANH_TRANGCHU_TINTUC"  alt="X" id="anhtintuc">
                    </div>
                </a>
                <div class="noidung">
                    <router-link
                    :to="{name: 'ChiTietTinTuc', params:{tentintuc:TinTuc.TEN_TRANGCHU_TINTUC} }"
                    >
                        <strong id="tentintuc">{{TinTuc.TEN_TRANGCHU_TINTUC}}</strong>
                    </router-link>
                    <P id="tomtattintuc" >
                        {{TinTuc.TOMTAT_TRANGCHU_TINTUC}}
                    </P>
                </div>

            </div>
            
        </div>
        <div class="chuyentiep">
                <span
                    v-for="(page, index) in SoLuongO"
                    :key="index"
                    @click="SoTrang = index"
                    :class="{active: SoTrang === index}"
                    class="dot"
                >
                    
                </span>
            </div>
    </div>
</template>
<script>
    export default {
        name: 'TinTucKhuyenMai',
        data(){
            return {
                DanhSachTinTuc:[],
                SoTrang: 0,
                SoO1Hang: 3,
            }
        },
        mounted(){
            this.fetchAPI_tintuc();
        },
        computed:{
            SoLuongO() {
                return Math.ceil(this.DanhSachTinTuc.length / this.SoO1Hang);
            },
            DanhSachTungO(){
                const start = this.SoTrang * this.SoO1Hang;
                const end = start + this.SoO1Hang;
                return this.DanhSachTinTuc.slice(start, end);
            }

        },
        methods:{
            async fetchAPI_tintuc(){
                try {
                    const ketnoi = await fetch('http://localhost:8081/api/banhang/tintuc');
                    if(ketnoi.ok) {
                        const data = await ketnoi.json();
                        this.DanhSachTinTuc = data
                    }
                else {
                    console.log("sai ket noi");
                }
                }
                catch(error) {
                    throw new Error("sai ket noi");
                }
            }
        }
    }
    
</script>
    
<style scoped>
a {
    text-decoration: none;
}
h2 {
    font-size: 20px;
    text-align: center;
}
.content {
    width: 90%;
    margin: auto;
    
}
.title {
    border-bottom: 1px solid #dedede;
}
.tintuc {
    display: flex;
    justify-content: space-around;
    flex-wrap: wrap;
    margin-top: 20px;
    gap: 10px;
    
}

.card {
    display: flex;
    flex-direction: column;
    flex: 0 1 calc(30% - 10px);
    border: none;
    
}

.hinhanh {
    display: flex;
    justify-content: center;
    width: 100%;
    height: 100%;
}
#anhtintuc {
    width: 100%;
    display: inline-block;
    height: 260px;
}
#tentintuc {
    color: #383838;
    font-size: 15px;
    font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
}
#tentintuc:hover{
    color:#119ef5;
}
#tomtattintuc {
    margin-top: 10px;
    color: black;
    font-size: 15px;
}
.chuyentiep {
    display: flex;
    justify-content: center;
    margin-top: 20px;
}
.dot {
    width: 15px;
    height: 15px;
    margin: 0 5px;
    border-radius: 50px;
    background-color: #bbb;
    display: inline-block;
    cursor:pointer;
}

.dot.active{
    background-color: #119ef5;
}
</style>