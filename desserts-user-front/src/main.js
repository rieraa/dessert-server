import { createApp } from 'vue';
import TDesign from 'tdesign-vue-next';
// 引入组件库的少量全局样式变量
import 'tdesign-vue-next/es/style/index.css';
import '@/styles/index.scss';
import router from './router';
import App from './App.vue';

const app = createApp(App);
app.use(router);
app.use(TDesign);
app.mount('#app');
