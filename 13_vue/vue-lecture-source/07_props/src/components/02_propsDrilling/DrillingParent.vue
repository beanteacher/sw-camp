<script setup>
  import { ref, provide,readonly } from "vue";
  import DrillingChild from "@/components/02_propsDrilling/DrillingChild.vue";
  const count = ref(1);
  provide("count", readonly(count))
</script>

<!--
  Props Drilling
  상위 컴포넌트에서 하위 컴포넌트로 데이터를 전달하는 과정에서 중간에 여러 컴포넌트를 거쳐가는 경우를 말한다.
  여러 컴포넌트를 거쳐 props를 전달하게 되면 코드가 복잡해지고 유지보수가 어려어ㅜ진다.
  필요한 부모 컴포넌트의 하위 컴포넌트 중 필요 시 inject 하여 어디서는 사용할 수 있도록 Provide를
  제공한다. (다만 readonly 에 대한 고려가 필요하고 어떤 컴포넌트가 inject하는 지 알기 어려운 문제가 있다.)
-->
<template>
  <div class="container">
    <h1>Parent : {{count}}</h1>
    <DrillingChild/>
  </div>

</template>

<style scoped>

</style>