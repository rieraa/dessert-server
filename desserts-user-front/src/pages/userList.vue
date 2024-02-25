<template>
  <div class="main">
    <t-card>
      <t-table row-key="id" :loading="isLoading" :data="list" :columns="columns">
        <template #userSex="{ row }">
          {{ row.userSex || '-' }}
        </template>
        <template #isAdmin="{ row }">
          {{ row.isAdmin === 1 ? '管理员' : '普通用户' }}
        </template>
        <template #operation="{ row }">
          <t-popconfirm @confirm="handleDelete(row)" content="确认删除吗">
            <t-link theme="danger">删除</t-link>
          </t-popconfirm>
        </template>
      </t-table>
    </t-card>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import { MessagePlugin } from 'tdesign-vue-next';
import { allUserService, deleteService } from '@/apis/user.js';

const columns = ref([
  {
    colKey: 'userId',
    title: 'id',
    width: 30,
  },
  {
    colKey: 'userName',
    title: '用户名',
    width: 100,
  },
  {
    colKey: 'userSex',
    cell: 'userSex',
    title: '用户性别',
    width: 100,
  },
  {
    colKey: 'isAdmin',
    cell: 'isAdmin',
    title: '类别',
    width: 100,
  },
  {
    colKey: 'operation',
    cell: 'operation',
    title: '操作',
    width: 120,
  },
]);
const isLoading = ref(false);
const list = ref([]);

const handleDelete = async row => {
  await deleteService(row.userId);
  await load();
  MessagePlugin.success('删除成功');
};

const load = async () => {
  isLoading.value = true;
  list.value = await allUserService();
  isLoading.value = false;
};

onMounted(() => {
  load();
});
</script>

<style lang="scss" scoped>
.main {
  width: 100%;
  margin: 0 auto;
}
</style>
