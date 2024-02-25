import { createRouter, createWebHistory } from 'vue-router';
import route from './routes';

const router = createRouter({
  history: createWebHistory(),
  routes: route,
});

router.beforeEach((to, from, next) => {
  document.body.scrollTop = 0;
  // firefox
  document.documentElement.scrollTop = 0;
  next();
});

export default router;
