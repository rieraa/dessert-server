import http from '@/http/index.js';
import { MessagePlugin } from 'tdesign-vue-next';

const loginService = async ({ userName, password }) => {
  try {
    const { data } = await http.post(`/user/login`, { userName, password });
    return data;
  } catch (error) {
    MessagePlugin.error(`登录失败,${error}`);
    return Promise.reject(error);
  }
};

const allUserService = async () => {
  try {
    const { data } = await http.get(`/user/allUser`);
    return data;
  } catch (error) {
    MessagePlugin.error(`查找失败,${error}`);
    return Promise.reject(error);
  }
};

const deleteService = async userId => {
  try {
    await http.post(`/user/deleteUser`, { userId });
    return;
  } catch (error) {
    MessagePlugin.error(`删除失败,${error}`);
    return Promise.reject(error);
  }
};

export { loginService, allUserService, deleteService };
