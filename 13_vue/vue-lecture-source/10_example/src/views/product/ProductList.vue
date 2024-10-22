<script setup>
import { ref, reactive, onMounted } from "vue";
import ProductList from "@/components/product/ProductList.vue";
import axios from "axios";
import PagingBar from "@/components/common/PagingBar.vue";
import SearchBar from "@/components/common/SearchBar.vue";
import { useRouter } from "vue-router";

// 상태 관리를 위한 반응형 객체 생성
const state = reactive({
  products: [],
  currentPage: 1,
  totalPages: 1,
  totalItems: 0,
  categoryCode: null,
  productName: ''
});

// API 호출 함수
const fetchProducts = async (page = 1) => {
  try {
    const response = await axios.get(`http://localhost:8080/api/v1/products`, {
      params: {
        page,
        categoryCode: state.categoryCode || null,
        productName: state.productName || null
      }
    });
    state.products = response.data.products;
    state.currentPage = response.data.currentPage;
    state.totalPages = response.data.totalPages;
    state.totalItems = response.data.totalItems;
  } catch (error) {
    console.error('상품 목록을 불러오는 중 에러가 발생했습니다:', error);
  }
};

// 검색 조건이 변경될 때마다 API 호출
const onSearch = (searchParams) => {
  state.categoryCode = searchParams.categoryCode;
  state.productName = searchParams.productName;
  fetchProducts(1);  // 페이지를 1로 초기화하고 다시 호출
};

const router = useRouter();

// 상품 등록 페이지 route
const goToProductCreate = () => {
  router.push(`/products/create`);
};

// 컴포넌트 마운트 시 제품 목록 로드
onMounted(() => fetchProducts());
</script>

<template>
  <SearchBar @search="onSearch" />
  <ProductList :products="state.products" />
  <PagingBar
      :currentPage="state.currentPage"
      :totalPages="state.totalPages"
      :totalItems="state.totalItems"
      @page-changed="fetchProducts"
  />
  <div>
    <button @click="goToProductCreate">상품 등록</button>
  </div>
</template>

<style scoped>
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

div {
  text-align: right;
  margin-bottom: 10px;
}
</style>