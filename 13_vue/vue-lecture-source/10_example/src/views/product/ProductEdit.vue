<script setup>
import ProductForm from "@/components/product/ProductForm.vue";
import axios from "axios";
import { ref, onMounted } from "vue";
import { useRouter } from "vue-router";

const router = useRouter();
const productData = ref(null);

const fetchProductData = async (productId) => {
  try {
    const response = await axios.get(`http://localhost:8080/api/v1/products/${productId}`);
    productData.value = response.data.product;
  } catch (error) {
    console.error("상품 정보를 가져오는 중 오류 발생:", error);
  }
};

const handleProductEdit = async (formData) => {
  try {

    await axios.put(`http://localhost:8080/api/v1/products/${productData.value.productCode}`, formData, {
      headers: {
        "Content-Type": "multipart/form-data",
      },
    });

    router.push("/products");
  } catch (error) {
    console.error("상품 수정 중 오류 발생:", error);
  }
};

// 페이지가 마운트될 때 상품 데이터 가져오기
onMounted(() => {
  const productId = router.currentRoute.value.params.id; // URL에서 상품 ID 가져오기
  fetchProductData(productId);
});
</script>

<template>
  <div>
    <h1>상품 수정</h1>
    <ProductForm
        @submit="handleProductEdit"
        :initialData="productData"
    />
  </div>
</template>



<style scoped>
h1 {
  margin: 10px;
  padding : 10px;
  border-bottom: 1px solid black;
}
</style>
