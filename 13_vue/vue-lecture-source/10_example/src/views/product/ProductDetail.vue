<!--

<script setup>
import { ref, onMounted } from 'vue';
import axios from 'axios';
import {useRoute, useRouter} from 'vue-router';
import ProductDetail from '@/components/product/ProductDetail.vue';

// 상태 관리
const product = ref(null);
const route = useRoute(); // URL에서 productId를 가져오기 위한 훅
const router = useRouter(); // 라우팅을 위한 훅

// 상품 ID 가져오기
const productId = route.params.id;

// API 호출 함수
const fetchProductDetail = async () => {
  try {
    const response = await axios.get(`http://localhost:8080/api/v1/products/${productId}`);
    product.value = response.data.product; // 상품 데이터 설정
  } catch (error) {
    console.error('상품 정보를 불러오는 중 에러가 발생했습니다:', error);
  }
};

// 상품 수정 페이지로 이동하는 함수
const goToEditPage = () => {
  router.push(`/products/${productId}/edit`);
};

// 상품 삭제 함수
const deleteProduct = async () => {
  const confirmed = confirm('정말로 이 상품을 삭제하시겠습니까?');
  if (confirmed) {
    try {
      await axios.delete(`http://localhost:8080/api/v1/products/${productId}`);
      alert('상품이 성공적으로 삭제되었습니다.');
      router.push('/products'); // 상품 목록 페이지로 이동
    } catch (error) {
      console.error('상품 삭제 중 오류가 발생했습니다:', error);
      alert('상품 삭제에 실패했습니다.');
    }
  }
};

// 페이지가 로드될 때 API 호출
onMounted(fetchProductDetail);
</script>
<template>
  <button @click="goToEditPage">상품 수정</button>
  <button @click="deleteProduct">상품 삭제</button>
  <div v-if="product">
    &lt;!&ndash; ProductDetail 컴포넌트에 데이터를 전달 &ndash;&gt;
    <ProductDetail :product="product" />
  </div>
  <div v-else>
    <p>Loading...</p>
  </div>
</template>

<style scoped>

</style>
-->
<script setup>
import { ref, onMounted } from 'vue';
import axios from 'axios';
import { useRoute, useRouter } from 'vue-router';
import ProductDetail from '@/components/product/ProductDetail.vue';

// 상태 관리
const product = ref(null);
const route = useRoute();
const router = useRouter();

// 상품 ID 가져오기
const productId = route.params.id;

// API 호출 함수
const fetchProductDetail = async () => {
  try {
    const response = await axios.get(`http://localhost:8080/api/v1/products/${productId}`);
    product.value = response.data.product;
  } catch (error) {
    console.error('상품 정보를 불러오는 중 에러가 발생했습니다:', error);
  }
};

// 상품 수정 페이지로 이동하는 함수
const goToEditPage = () => {
  router.push(`/products/${productId}/edit`);
};

// 상품 삭제 함수
const deleteProduct = async () => {
  const confirmed = confirm('정말로 이 상품을 삭제하시겠습니까?');
  if (confirmed) {
    try {
      await axios.delete(`http://localhost:8080/api/v1/products/${productId}`);
      alert('상품이 성공적으로 삭제되었습니다.');
      router.push('/products');
    } catch (error) {
      console.error('상품 삭제 중 오류가 발생했습니다:', error);
      alert('상품 삭제에 실패했습니다.');
    }
  }
};

// 페이지가 로드될 때 API 호출
onMounted(fetchProductDetail);
</script>

<template>
  <div class="container mt-4">
    <div class="d-flex justify-content-end mb-3">
      <button @click="goToEditPage" class="btn btn-warning me-2">상품 수정</button>
      <button @click="deleteProduct" class="btn btn-danger">상품 삭제</button>
    </div>
    <div v-if="product">
      <ProductDetail :product="product" />
    </div>
    <div v-else>
      <p>Loading...</p>
    </div>
  </div>
</template>

<style scoped>

</style>
