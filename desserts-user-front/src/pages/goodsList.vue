<template>
  <div class="main">
    <t-card style="margin-bottom: 10px">
      <t-button @click="visible = true">增加甜品</t-button>
    </t-card>
    <t-card>
      <t-table row-key="id" :loading="isLoading" :data="list" :columns="columns" :row-class-name="getRowClassName">
        <template #operation="{ row }">
          <t-popconfirm @confirm="handleDelete(row)" content="确认删除吗">
            <t-link theme="danger">删除</t-link>
          </t-popconfirm>
        </template>
      </t-table>
      <t-pagination
        style="margin-top: 10px"
        @current-change="handlePageChange"
        :total="total"
        :showPageSize="false"
        :pageSize="15"
        showPageNumber
        showPreviousAndNextBtn
      />
    </t-card>
    <t-dialog v-model:visible="visible" header="新增甜品" width="40%" :on-close="onReset" :footer="false">
      <t-form ref="form" :rules="rules" :data="formData" :colon="true" @reset="onReset" @submit="onSubmit">
        <t-form-item label="甜品名称" name="dessertName">
          <t-input v-model="formData.dessertName" placeholder="请输入甜品名称"></t-input>
        </t-form-item>

        <t-form-item label="甜品描述" name="dessertExplain">
          <t-input v-model="formData.dessertExplain" placeholder="请输入甜品描述"></t-input>
        </t-form-item>

        <t-form-item label="甜品图片" name="dessertImg">
          <t-upload theme="image" accept="image/*" @success="ondessertImg" :action="actionURL" />
        </t-form-item>

        <t-form-item label="甜品价格" name="dessertPrice">
          <t-input v-model="formData.dessertPrice" placeholder="请输入甜品价格"></t-input>
        </t-form-item>

        <t-form-item label="甜品长图" name="detailImg">
          <t-upload theme="image" accept="image/*" @success="ondetailImg" :action="actionURL" />
        </t-form-item>

        <t-form-item label="保质期" name="shelfLife">
          <t-input v-model="formData.shelfLife" placeholder="请输入甜品保质期时间"></t-input>
        </t-form-item>

        <t-form-item label="储存方法" name="storageMethod">
          <t-input v-model="formData.storageMethod" placeholder="请输入甜品储存方式"></t-input>
        </t-form-item>

        <t-form-item>
          <t-space size="small">
            <t-button theme="primary" type="submit">提交</t-button>
            <t-button theme="default" variant="base" type="reset">重置</t-button>
          </t-space>
        </t-form-item>
      </t-form>
    </t-dialog>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import { dessertListService, addService } from '@/apis/dessert';
import { MessagePlugin } from 'tdesign-vue-next';

const actionURL = `http://localhost:9898/api/file/upload`;

const columns = ref([
  {
    colKey: 'dessertId',
    title: 'id',
    cell: 'dessertId',
    width: 30,
  },
  {
    colKey: 'dessertName',
    title: '甜品名称',
    width: 100,
  },
  {
    colKey: 'dessertExplain',
    title: '甜品描述',
    width: 100,
  },
  {
    colKey: 'dessertImg',
    cell: 'dessertImg',
    title: '甜品图片',
    width: 100,
  },
  {
    colKey: 'dessertPrice',
    title: '甜品价格',
    width: 60,
  },
  {
    colKey: 'detailImg',
    title: '甜品长图',
    width: 100,
  },
  {
    colKey: 'shelfLife',
    title: '保质期',
    width: 60,
  },
  {
    colKey: 'storageMethod',
    title: '储存方法',
    width: 60,
  },
  {
    colKey: 'operation',
    cell: 'operation',
    title: '操作',
    width: 120,
  },
]);
const list = ref([]);
const isLoading = ref(false);
const currentPage = ref(1);
const total = ref(0);
const visible = ref(false);

const rules = {
  dessertName: [{ required: true }, { min: 2 }, { max: 10, type: 'warning' }],
  dessertExplain: [{ validator: val => val.length < 20, message: '不能超过 20 个字，中文长度等于英文长度' }],
  dessertImg: [{ required: true }],
  dessertPrice: [{ required: true }],
  detailImg: [{ required: true }],
  dessertPrice: [{ required: true }],
  shelfLife: [{ required: true }],
  storageMethod: [{ required: true }],
};

const formData = ref({
  dessertName: '',
  dessertExplain: '',
  dessertImg: '',
  dessertPrice: '',
  detailImg: '',
  shelfLife: '',
  storageMethod: '',
});

const handleDelete = async row => {
  await deleteService(row.dessertId);
  load(currentPage);
  MessagePlugin.success('删除成功');
};

const load = async (currentPage = 1) => {
  isLoading.value = true;
  const { desserts, total: totalValue } = await dessertListService(currentPage);
  list.value = desserts;
  total.value = totalValue;
  isLoading.value = false;
};

const onReset = () => {
  formData.value = {
    dessertName: '',
    dessertExplain: '',
    dessertImg: '',
    dessertPrice: '',
    detailImg: '',
    shelfLife: '',
    storageMethod: '',
  };
};

const onSubmit = async ({ validateResult, firstError }) => {
  if (validateResult === true) {
    MessagePlugin.success('提交成功');
    await addService(formData);
    visible.value = false;
  } else {
    console.log('Errors: ', validateResult);
    MessagePlugin.warning(firstError);
  }
};

const handlePageChange = async newPage => {
  currentPage.value = newPage;
  load(currentPage.value);
};

const ondetailImg = ({ response }) => {
  console.log(response);
  formData.detailImg = response.url;
};

const ondessertImg = ({ response }) => {
  console.log(response);
  formData.dessertImg = response.url;
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
