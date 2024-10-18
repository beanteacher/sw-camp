<script setup>
  /* defineProps 함수를 활용해 String 형의 message props를 받아 props라는 변수에 담늗나.
  * 객체의 형태로 반환되며 변수에 담아주고 계속해서 사용할 수 있다. */
  const props = defineProps({
    message : String
  })
</script>

<template>
  <h3>전달 받은 props : {{props.message}}</h3>
</template>

<style scoped>

</style>