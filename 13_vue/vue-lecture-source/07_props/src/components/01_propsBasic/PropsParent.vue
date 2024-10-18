<script setup>
  import {ref} from "vue";
  import PropsChild from "@/components/01_propsBasic/PropsChild.vue";
  import DarkMode from "@/components/01_propsBasic/DarkMode.vue";
  import ReadProps from "@/components/01_propsBasic/ReadProps.vue";
  const message = ref("hello");
  const darkState = ref(false);
  const readValue = ref("Vue는 재밌다.^^~");
  function toggleDarkMode() {
    darkState.value = !darkState.value;
  }
</script>

<template>
  <div :class="{container: true, dark : darkState}">
    props 입력 : <input type="text" v-model="message">
    <!-- 다른 이름으로 전달하는 것도 가능하긴 하지만 일반적으로 같은 이름을 사용한다. (:props이름) -->
    <PropsChild :message="message"/>
    <DarkMode @toggle="toggleDarkMode"></DarkMode>
    부모의 readValue : <input type="text" v-model="readValue">
    <ReadProps/>
  </div>

</template>

<style scoped>
  .container {
    display: flex;
    flex-direction: column;
    align-items: center;
    border: 1px solid;
  }
  .dark {
    background-color: #263238;

    color: #CE9178;
  }
</style>