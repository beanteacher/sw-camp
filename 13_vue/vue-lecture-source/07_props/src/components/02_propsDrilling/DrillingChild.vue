<script setup>
  import{inject} from "vue"
  const injectCount = inject("count");
</script>

<template>
  <h3>Child : {{injectCount}}</h3>
  <button @click="injectCount++">injectCount++</button>

</template>

<style scoped>

</style>