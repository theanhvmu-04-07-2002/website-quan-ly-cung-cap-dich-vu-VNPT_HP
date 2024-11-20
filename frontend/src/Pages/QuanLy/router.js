// import { meta } from '@babel/eslint-parser';
import Vue from 'vue';
import Router from 'vue-router';
// import { component } from 'vue/types/umd';
Vue.use(Router); // Đăng ký Vue Router

const routes = [
    {
        path: '/quanly/dangnhap',
        name: 'quanly-dangnhap', 
        component: () => import('@/Pages/QuanLy/DangNhap/DangNhap.vue')
    },
    {
        path: '/quanly/quanlybanhang',
        name:'quanlybanhang',
        component:() => import('@/Pages/QuanLy/QuanLyBanHang/QuanLyBanHang.vue')
    },
    {
        path: '/quanly/quanlykythuat',
        name:'quanlykythuat',
        component:() => import('@/Pages/QuanLy/QuanLyKyThuat/QuanLyKyThuat.vue')
    }

];

// Xuất mảng routes
export default routes;
