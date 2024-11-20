import Vue from 'vue';
import App from './App.vue';
import VueRouter from 'vue-router';
import BanHangRoutes from './Pages/BanHang/router';
import QuanLyRoutes from './Pages/QuanLy/router'; 
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min.js';
import Select2 from 'v-select2-component';

export const EventBus = new Vue();
Vue.component('VueSelect2', Select2);

Vue.use(VueRouter);


const routes = [...BanHangRoutes, ...QuanLyRoutes];

const router = new VueRouter({
  mode: 'history', 
  routes
});

new Vue({
  render: h => h(App),
  router
}).$mount('#app');
