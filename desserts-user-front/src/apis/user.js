import http from '@/http/index.js';
import { MessagePlugin } from 'tdesign-vue-next';

const loginService = async ({ userName, password }) => {
  try {
    return await http.post(`/user/login`, { userName, password });
  } catch (error) {
    MessagePlugin.error(`登录失败,${error}`);
    return Promise.reject(error);
  }
};

export { loginService };
