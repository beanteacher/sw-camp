<script setup>
  /* 부모로부터 물려받은 toggle 이라는 이름의 이벤트를 호출할 수 있는 반환
  * 배열에 이벤트 이름을 작성했다. */
  const emit = defineEmits(["toggle"])
</script>

<template>
  <button @click="emit('toggle')">다크 모드</button>
</template>

<style scoped>

</style>