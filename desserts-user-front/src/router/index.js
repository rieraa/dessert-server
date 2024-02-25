import { createRouter, createWebHistory } from 'vue-router';
import route from './routes';
import { getToken } from '@/utils/auth.js';
import { MessagePlugin } from 'tdesign-vue-next';

const router = createRouter({
  history: createWebHistory(),
  routes: route,
});

router.beforeEach((to, from, next) => {
  document.body.scrollTop = 0;
  // firefox
  document.documentElement.scrollTop = 0;

  if (to.path !== '/login' && !getToken()) {
    MessagePlugin.warning('请登录');
    router.replace('/login');
  }
  next();
});

export default router;
