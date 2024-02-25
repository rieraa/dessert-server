import LayoutView from '@/components/LayoutView.vue';
import GoodList from '@/pages/goodsList.vue';
import LoginView from '@/pages/LoginView.vue';
import UserList from '@/pages/userList.vue';

const routes = [
  {
    path: '/',
    name: 'layout',
    component: LayoutView,
    children: [
      {
        path: '/',
        name: 'home',
        component: GoodList,
      },
      {
        path: '/user',
        name: 'user',
        component: UserList,
      },
    ],
  },
  {
    path: '/login',
    name: 'login',
    component: LoginView,
  },
];

export default routes;
