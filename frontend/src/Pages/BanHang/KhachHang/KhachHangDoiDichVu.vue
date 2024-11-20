<template>
    <div class="main-container">
        <p class="bold blue inhoa center" id="tieude">thanh toán dịch vụ trực tuyến</p>
        <div class="thanhtoan">
            <form action="" class="formthanhtoan">
                <!-- ten hoa don -->
                <div class="element">
                    <div class="row">
                        <div class="col-sm-3 justify-align">
                            <img id="logo" src="/assets/HinhAnh/khachhang/logovnpt.png" alt="">
                        </div>
                        <div class=" col-sm-6 justify-align">
                            <p class="bold red inhoa center " id="tenhoadon">hóa đơn giá trị gia tăng</p>
                            <p class="bold red inhoa center innghieng"> vat invoice</p>
                        </div>
                        <div class="col-sm-3 justify-align">
                        <p>ok</p>
                        </div>
                    </div>
                </div>
                <!-- het ten hoa don -->
            </form>
        </div>
    
    </div>
</template>
<script>
export default {
    name : 'KhachHangThanhToan'
}
</script>

<style scoped>
.main-container{
    background-color: white;
    width: 100%;
}
.thanhtoan{
    display: flex;
    width: 100%;
    justify-content: center;
}
.formthanhtoan {
    width: 80%;
}
.bold {
    font-weight: 500;
}
.blue {
    color :#31649e;
}
.red {
    color: #ff0808;
}
.inhoa {
    text-transform: uppercase;
}
.center {
    text-align: center;
}
#tieude {
    font-size: 22px;
    font-weight: bold;
}
.innghieng {
    font-style: italic;
}
#logo {
    width: 60px;
    height: auto;
    /* display: inline-block; */
}
.justify-align {
    display: flex;
    justify-content: center;
    align-items: center;
    text-align: center;
    flex-direction: column;
    border: 1px solid black;
    height: 100%;
}
</style>
