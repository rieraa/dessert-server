<template>
  <div class="main">
    <div class="content">
      <t-card>
        <p class="title">星辰甜品管理后台</p>
        <t-form
          :rules="rules"
          ref="form"
          :data="formData"
          :colon="true"
          :label-width="0"
          @reset="onReset"
          @submit="onSubmit"
        >
          <t-form-item name="userName">
            <t-input v-model="formData.userName" clearable placeholder="请输入用户名">
              <template #prefix-icon>
                <desktop-icon />
              </template>
            </t-input>
          </t-form-item>

          <t-form-item name="password">
            <t-input v-model="formData.password" type="password" clearable placeholder="请输入密码">
              <template #prefix-icon>
                <lock-on-icon />
              </template>
            </t-input>
          </t-form-item>

          <t-form-item>
            <t-button theme="primary" type="submit" block>登录</t-button>
          </t-form-item>
        </t-form>
      </t-card>
    </div>
  </div>
</template>

<script setup>
import { loginService } from '@/apis/user.js';
import { reactive } from 'vue';
import { useRouter } from 'vue-router';
import { MessagePlugin } from 'tdesign-vue-next';
import { setToken } from '@/utils/auth';
import { DesktopIcon, LockOnIcon } from 'tdesign-icons-vue-next';

const router = useRouter();

const formData = reactive({
  userName: '',
  password: '',
});

const rules = {
  userName: [{ required: true, message: '用户名必填', type: 'error' }],
  password: [{ required: true, message: '密码必填', type: 'error' }],
};

const onReset = () => {
  MessagePlugin.success('重置成功');
};

const onSubmit = async ({ validateResult, firstError }) => {
  if (validateResult === true) {
    const res = await loginService({ ...formData });
    console.log(res);
    if (res.isAdmin !== 1) {
      MessagePlugin.warning('登录失败，权限不足');
    } else {
      MessagePlugin.success('登录成功');
      setToken(res.token);
      localStorage.setItem('userName', res.userName);
      router.push('/');
    }
  } else {
    console.log('Validate Errors: ', firstError, validateResult);
  }
};
</script>

<style lang="scss" scoped>
.main {
  display: flex;
  width: 100%;
  height: 100vh;
  margin: 0 auto;
  background-image: url(../assets/login.png);
  background-size: 100% 100%;
  .content {
    margin: auto;
    width: 550px;
    border-radius: 20px;
    .title {
      color: rgba(18, 30, 43, 0.656);
      text-align: center;
      font-size: 30px;
      line-height: 30px;
      padding-bottom: 26px;
      padding-top: 6px;
    }
  }
}
</style>
