<script setup>
import {onMounted} from "vue";

// script에 setup이 없을 경우 작성해야하는 바전
// export default {
//   setup() {
    onMounted(() => {
      console.log("Hello Vue");
    });
//   }
// }
</script>
<template>
  <div>
    <h1>MyComponent</h1>
  </div>
</template>

<style scoped>
  h1 {
    color :red
  }
</style>