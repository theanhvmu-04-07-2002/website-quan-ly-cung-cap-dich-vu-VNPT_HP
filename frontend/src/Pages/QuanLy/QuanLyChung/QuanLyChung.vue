<template>
    <div class="content">
        <div class="header">
            <h4>VNPT HẢI PHÒNG</h4>
            <h5>HỆ THỐNG QUẢN LÝ KINH DOANH TẬP TRUNG - QUẢN LÝ BÁN HÀNG</h5>
        </div>
        <!--  -->
        <div class="maincontent">
            <div class="dieuhuong">
                <ul>
                    <li>
                        <button class="bold white">QUẢN LÝ ĐƠN HÀNG</button>
                    </li>
                    <li>
                        <button class="bold white">QUẢN LÝ KHÁCH HÀNG</button>
                    </li>
                    <li>
                        <button class="bold white">QUẢN LÝ HỢP ĐỒNG</button>
                    </li>
                    <li>
                        <button class="bold white">QUẢN LÝ THANH TOÁN</button>
                    </li>
                    <li>
                        <button class="bold white">QUẢN LÝ BÁO HỎNG</button>
                    </li>
                    <li>
                        <button class="bold white">QUẢN LÝ THAY ĐỔI</button>
                    </li>
                </ul>
            </div>
            <!-- end dieu huong - left -->
            <div class="quanly">
                <div class="content-quanly">
                    <p>12</p>
                </div>
            </div>  
            <!-- end quan ly - right -->
        </div>
    </div>    
</template>
<script>

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

.dieuhuong {
    width: 20%;
    background-color: #212120;
    display: flex;
    flex-direction: column;
    justify-content: space-between ;
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
</style>
