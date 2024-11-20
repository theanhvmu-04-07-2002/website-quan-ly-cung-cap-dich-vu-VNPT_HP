<template>
    <div class="content">
        <div class="thongtinmoinhat">
            <!-- <p class="inhoa">Tin tức</p> -->
            <div class="grid-container">
                <div 
                    class="tomtatKhuyenMai" 
                    v-for="(KhuyenMai, index) in DanhSachKhuyenMai1Cot" 
                    :key="index"
                >
                    <a href="" class="hinhanhKhuyenMai">
                        <img id="hinhanhKhuyenMai" :src="KhuyenMai.HINHANH" alt="">
                    </a>
                    <a href="" class="noidungKhuyenMai">{{ KhuyenMai.TIEUDE }}</a>
                    <p>
                        {{KhuyenMai.TOMTAT}}
                    </p>
                </div>
            </div>
            <div class="chuyentiep">
                <span
                    v-for="(page, index) in KhuyenMaiTungO"
                    :key="index"
                    @click="SoTrang = index"
                    :class="{active: SoTrang === index}"
                    class="dot"
                >
                </span>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: 'KhuyenMai_TomTat',
    data() {
        return {
            DanhSachKhuyenMai: [],
            SoTrang: 0,
            SoO1Hang: 2, // Đặt số ô mỗi hàng là 2
        };
    },
    created() {
        this.fetchAPI_KhuyenMai();
    },
    methods: {
        async fetchAPI_KhuyenMai() {
            try {
                const ketnoi = await fetch('http://localhost:8081/api/banhang/chuongtrinhkhuyenmai');
                if (ketnoi.ok) {
                    const data = await ketnoi.json();
                    this.DanhSachKhuyenMai = data;
                }
            } catch (error) {
                console.log("Lỗi: " + error);
            }
        }
    },
    computed: {
        KhuyenMaiTungO() {
            return Math.ceil(this.DanhSachKhuyenMai.length / (this.SoO1Hang * 3)); // Tính tổng số trang (3 hàng)
        },
        DanhSachKhuyenMai1Cot() {
            const start = this.SoTrang * this.SoO1Hang * 3; // Hiển thị 3 hàng, mỗi hàng 2 ô
            const end = start + this.SoO1Hang * 3;
            return this.DanhSachKhuyenMai.slice(start, end);
        }
    }
};
</script>

<style scoped>
.grid-container {
    display: grid;
    grid-template-columns: repeat(2, 1fr); /* Hiển thị 2 ô mỗi hàng */
    gap: 10px;
}
.tomtatKhuyenMai {
    display: flex;
    flex-direction: column;
    margin-top: 30px;
}
.hinhanhKhuyenMai {
    margin-bottom: 10px;
}
.noidungKhuyenMai {
    color: black;
    font-size: 14px;
    text-decoration: none;
    font-weight: 500;
    text-transform: uppercase;
}
.noidungKhuyenMai:hover{
    color: #119ef5;
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
#hinhanhKhuyenMai {
    width: 90%;
    height: 250px;
}
.inhoa {
    text-transform: uppercase;
    font-size: 20px;
    font-weight: 500;
}
</style>

