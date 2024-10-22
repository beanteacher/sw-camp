<template>
  <form @submit.prevent="submitForm" class="container mt-4">
    <div class="mb-3">
      <label for="productName" class="form-label">상품명</label>
      <input type="text" id="productName" v-model="formData.productName" class="form-control" required />
    </div>

    <div class="mb-3">
      <label for="productPrice" class="form-label">상품 가격</label>
      <input type="number" id="productPrice" v-model.number="formData.productPrice" class="form-control" required />
    </div>

    <div class="mb-3">
      <label for="productDescription" class="form-label">상품 설명</label>
      <textarea id="productDescription" v-model="formData.productDescription" class="form-control" required></textarea>
    </div>

    <div class="mb-3">
      <label for="categoryCode" class="form-label">카테고리</label>
      <select id="categoryCode" v-model.number="formData.categoryCode" class="form-select" required>
        <option value="1">식사</option>
        <option value="2">디저트</option>
        <option value="3">음료</option>
      </select>
    </div>

    <div class="mb-3">
      <label for="productStock" class="form-label">재고 수량</label>
      <input type="number" id="productStock" v-model.number="formData.productStock" class="form-control" required />
    </div>

    <div class="mb-3">
      <label for="productImg" class="form-label">상품 이미지</label>
      <input type="file" id="productImg" @change="handleFileChange" class="form-control" accept="image/*" />
    </div>

    <button type="submit" class="btn btn-primary w-100" :disabled="!isFormValid">제출</button>
  </form>
</template>

<script setup>
import { ref, watch, computed } from "vue";

const props = defineProps({
  initialData: Object,
});

const formData = ref({
  productName: "",
  productPrice: 0,
  productDescription: "",
  categoryCode: 1,
  productStock: 0,
  productImg: null,
});

watch(() => props.initialData, (newData) => {
  if (newData) {
    Object.assign(formData.value, {
      productName: newData.productName,
      productPrice: newData.productPrice,
      productDescription: newData.productDescription,
      categoryCode: newData.category.categoryCode,
      productStock: newData.productStock,
    });
  }
});

const handleFileChange = (e) => {
  formData.value.productImg = e.target.files[0]; // 선택된 파일 저장
};

const emit = defineEmits(['submit']);

const submitForm = () => {
  const { productImg, ...rest } = formData.value;
  const formDataToSend = new FormData();
  formDataToSend.append("productRequest", new Blob([JSON.stringify({
    ...rest,
    status: 'USABLE'
  })], { type: 'application/json' }));
  formDataToSend.append("productImg", productImg);

  emit("submit", formDataToSend);
};

const isFormValid = computed(() => {
  return (
      formData.value.productName &&
      formData.value.productPrice > 0 &&
      formData.value.productStock > 0 &&
      formData.value.productDescription &&
      formData.value.categoryCode &&
      formData.value.productImg
  );
});
</script>
