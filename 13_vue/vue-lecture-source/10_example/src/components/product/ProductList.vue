<script setup>

import ProductItem from "@/components/product/ProductItem.vue";

const props = defineProps({
  products: {
    type: Array,
    required: true
  }
});

</script>

<template>
  <div class="container">
   <ProductItem v-for="product in products" :key="product.productCode" :product="product" />
  </div>
</template>

<style scoped>
  .container {
    display : flex;
    flex-direction: column;
  }
</style>