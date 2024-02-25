<template>
  <div class="main-layout">
    <t-layout>
      <t-header>
        <t-head-menu value="item1" height="120px">
          <template #logo>
            <img width="136" class="logo" src="https://www.tencent.com/img/index/menu_logo_hover.png" alt="logo" />
          </template>
          <template #operations>
            <p>用户名</p>
            <t-button theme="primary" variant="text">退出</t-button>
          </template>
        </t-head-menu>
      </t-header>
      <t-layout>
        <t-aside style="border-top: 1px solid var(--component-border)">
          <t-menu theme="light" value="dashboard" style="margin-right: 50px" height="550px">
            <t-menu-item value="dashboard">
              <template #icon>
                <t-icon name="dashboard" />
              </template>
              甜品列表
            </t-menu-item>
            <t-menu-item value="resource">
              <template #icon>
                <t-icon name="server" />
              </template>
              用户列表
            </t-menu-item>
          </t-menu>
        </t-aside>
        <t-layout>
          <t-content>
            <router-view></router-view>
          </t-content>
        </t-layout>
      </t-layout>
    </t-layout>
  </div>
</template>

<script setup></script>

<style lang="scss" scoped>
.main-layout {
  width: 100%;
  margin: 0 auto;
}
</style>
