// import { meta } from '@babel/eslint-parser';
import Vue from 'vue';
import Router from 'vue-router';
Vue.use(Router); // Đăng ký Vue Router

export const EventBus = new Vue();

const routes = [
    {
        path: '/trangchu',
        name: 'index', 
        component: () => import('@/Pages/BanHang/TrangChu.vue')
    },
    {
        path: '/trangchu/header',
        name: 'trangchu-header',
        component: () => import('@/Pages/BanHang/components/BanHang_Header.vue')
    },
    {
        path: '/trangchu/footer',
        name: 'trangachu-footer',
        component: () => import('@/Pages/BanHang/components/BanHang_Footer.vue')
    },
    {
        path: '/chitietdichvu/:tengdv',
        name: 'ChiTietDichVu',
        component:() => import('@/Pages/BanHang/MuaHang/ChiTietGoiDichVu.vue'),
        props: true
    },
    {
        path: '/goidichvu/internet', 
        name: 'goidichvu-internet',
        component:() => import('@/Pages/BanHang/MuaHang/MuaHang_Internet.vue'),
    },
    {
        path: '/goidichvu/internet-truyenhinh', 
        name: 'goidichvu-internet-truyenhinh',
        component:() => import('@/Pages/BanHang/MuaHang/MuaHang_Internet_TruyenHinh.vue'),
    },
    {
        path: '/goidichvu/truyenhinh', 
        name: 'goidichvu-truyenhinh',
        component:() => import('@/Pages/BanHang/MuaHang/MuaHang_TruyenHinh.vue'),
    },
    {
        path: '/goidichvu/dathang', 
        name: 'goidichvu-dathang',
        component:() => import('@/Pages/BanHang/MuaHang/MuaHang_DatHang.vue'),
    },
    {
        path: '/tintuc', 
        name: 'tintuc',
        component:() => import('@/Pages/BanHang/TinTuc/TinTuc_TrangChu.vue'),
    },
    {
        path: '/chuongtrinhkhuyenmai', 
        name: 'khuyenmai',
        component:() => import('@/Pages/BanHang/KhuyenMai/KhuyenMai_TrangChu.vue'),
    },
    {
        path: '/dangnhap', 
        name: 'dangnhap',
        component:() => import('@/Pages/BanHang/DangNhap/DangNhap.vue'),
    },
    {
        path: '/khachhang',
        name: 'khachhang',
        component:() => import('@/Pages/BanHang/KhachHang/KhachHang.vue')
    },
    {
        path: '/test',
        name: 'test',
        component:() => import('@/Pages/BanHang/KhachHang/TestID.vue')
    }

];

// Xuất mảng routes
export default routes;
