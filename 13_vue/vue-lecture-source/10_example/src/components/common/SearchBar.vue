<script setup>
import { reactive } from 'vue';

// 검색 상태 관리
const state = reactive({
  categoryCode: '',
  productName: ''
});

const emit = defineEmits(['search']);

// 부모 컴포넌트로 검색 이벤트 전달
const emitSearch = () => {
  emit('search', {
    categoryCode: state.categoryCode || null, // 선택 안되면 null
    productName: state.productName || null     // 입력 안되면 null
  });
};
</script>

<template>
  <div class="search-bar">
    <select v-model="state.categoryCode">
      <option value="">전체 카테고리</option>
      <option value="1">식사</option>
      <option value="2">디저트</option>
      <option value="3">음료</option>
    </select>

    <input
        type="text"
        v-model="state.productName"
        placeholder="상품명을 입력하세요"
    />

    <button @click="emitSearch">검색</button>
  </div>
</template>

<style scoped>
.search-bar {
  display: flex;
  gap: 10px;
  margin-bottom: 20px;
  justify-content: end;
}

input {
  padding: 5px;
}

button {
  padding: 5px 10px;
  background-color: #2196f3;
  color: white;
  border: none;
  cursor: pointer;
}

button:hover {
  background-color: #1976d2;
}
</style>
