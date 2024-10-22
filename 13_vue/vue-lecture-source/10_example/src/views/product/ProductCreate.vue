<script setup>
import ProductForm from "@/components/product/ProductForm.vue";
import axios from "axios";
import { useRouter } from "vue-router";

const router = useRouter();

const handleProductCreate = async (formData) => {
  try {
    // FormData를 서버로 전송
    await axios.post("http://localhost:8080/api/v1/products", formData, {
      headers: {
        "Content-Type": "multipart/form-data",
      },
    });

    // 상품 등록이 완료되면 목록 페이지로 이동
    router.push("/products");
  } catch (error) {
    console.error("상품 등록 중 오류 발생:", error);
  }
};
</script>

<template>
  <div>
    <h1>상품 등록</h1>
    <ProductForm @submit="handleProductCreate" />
  </div>
</template>


<style scoped>
  h1 {
    margin: 10px;
    padding : 10px;
    border-bottom: 1px solid black;
  }
</style>
