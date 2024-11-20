    <template>
        <div class="content">
            <div class="thongtinmoinhat">
                <p class="inhoa gachchan">Thông tin mới nhất</p>
                <div class="tomtattintuc"
                v-for="(TinTuc, index) in DanhSachTinTuc1Cot"
                :key="index"
                >
                    <a href="" class="hinhanhtintuc">
                        <img id="hinhanhtintuc" :src="TinTuc.HINHANH_TRANGCHU_TINTUC" alt="">
                    </a>
                    <a href="" class="noidungtintuc">{{TinTuc.TEN_TRANGCHU_TINTUC}}</a>
                </div>
                <div class="chuyentiep">
                    <span
                    v-for="(page, index) in TinTucTungO"
                    :key="index"
                    @click="SoTrang = index"
                    :class="{active: SoTrang === index}"
                    class="dot"
                    >
                        
                    </span>
                </div>
            </div>
            <!--  -->
            <div class="video">
                <p class="inhoa gachchan">video</p>
                <div class="noidungvideo">
                    <iframe id="videoYTB" width="320" height="200" src="https://www.youtube.com/embed/UpuGr6LKNYE?si=41qQwzrwRYJLh0-N" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
                    <iframe id="videoYTB" width="320" height="220" src="https://www.youtube.com/embed/ceJA_hnbGjE" title="Hướng dẫn chuyển tiếp cuộc gọi VinaPhone" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
                    <iframe id="videoYTB" width="320" height="220" src="https://www.youtube.com/embed/HUZrT_GajSI" title="Giới thiệu và hướng dẫn sử dụng ứng dụng My VNPT" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
                </div>
            </div>
        </div>
    </template>
    <script>
        export default{
            name:'TinTuc_ThongTinMoiNhat',
            data() {
                return{
                    DanhSachTinTuc:[],
                    SoTrang: 0,
                    SoO1Hang: 5,
                }
            },
            created(){
                this.fetchAPI_tintuc();
            },
            methods:{
                async fetchAPI_tintuc(){
                    try {
                        const ketnoi = await fetch('http://localhost:8081/api/banhang/tintuc');
                        if(ketnoi.ok) {
                            const data = await ketnoi.json();
                            this.DanhSachTinTuc = data;
                        }
                    }
                    catch(error){
                        console.log("loi: " + error);
                    }
                }
            },
            computed:{
                TinTucTungO(){
                    return Math.ceil(this.DanhSachTinTuc.length / this.SoO1Hang);
                },
                DanhSachTinTuc1Cot(){
                    const start = this.SoTrang * this.SoO1Hang;
                    const end = start + this.SoO1Hang;
                    return this.DanhSachTinTuc.slice(start, end);
                }
            }
        }
    </script>

    <style scoped>
   .content {
    max-width: 100%;
   }
    .tomtattintuc {
        display: flex;
        
    }
    .hinhanhtintuc {
        margin-right:10px ;
        margin-bottom: 20px;
    }
    .noidungtintuc {
        color: black;
        font-size: 14px;
        text-decoration: none;
    }
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
    #hinhanhtintuc {
        width: 100px;
        height: 80px;
    }
    .inhoa {
        text-transform:uppercase;
        font-size: 20px;
        font-weight: 500;
    }
    .gachchan {
        border-bottom: 3px solid #119ef5;
    }
    #videoYTB{
        max-width: 100%;
        height: auto;
    }
    </style>
