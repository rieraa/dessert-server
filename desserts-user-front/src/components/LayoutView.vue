<template>
  <div class="main-layout">
    <t-layout>
      <t-header>
        <t-head-menu value="item1" height="120px">
          <template #logo>
            <div style="width: 60px; height: 50px">
              <img style="width: 100%; height: 100%" class="logo" :src="logoSrc" alt="logo" />
            </div>
            <p style="line-height: 50px; font-size: 20px; color: rgba(26, 26, 26, 0.864)">甜品管理后台</p>
          </template>
          <template #operations>
            <p>{{ userName || '用户名' }}</p>
            <t-button theme="primary" @click="onClick" variant="text">退出</t-button>
          </template>
        </t-head-menu>
      </t-header>
      <t-layout>
        <t-aside style="border-top: 1px solid var(--component-border)">
          <t-menu theme="light" :value="current" style="margin-right: 50px" height="550px">
            <t-menu-item @click="onNavClick('/', 'dashboard')" value="dashboard">
              <template #icon>
                <t-icon name="server" />
              </template>
              甜品列表
            </t-menu-item>
            <t-menu-item @click="onNavClick('/user', 'resource')" value="resource">
              <template #icon>
                <t-icon name="server" />
              </template>
              用户列表
            </t-menu-item>
          </t-menu>
        </t-aside>
        <t-layout style="min-height: calc(100vh - 56px); padding: 6px">
          <router-view></router-view>
        </t-layout>
      </t-layout>
    </t-layout>
  </div>
</template>

<script setup>
import { clearToken } from '@/utils/auth.js';
import { ref } from 'vue';
import { useRouter } from 'vue-router';
import logoSrc from '@/assets/logo.png';

const router = useRouter();
const current = ref('dashboard');
const userName = localStorage.getItem('userName');

const onNavClick = (url, value) => {
  router.push(url);
  current.value = value;
};

const onClick = () => {
  clearToken();
  router.push('/login');
};
</script>

<style lang="scss" scoped>
.main-layout {
  width: 100%;
  margin: 0 auto;
}
</style>
