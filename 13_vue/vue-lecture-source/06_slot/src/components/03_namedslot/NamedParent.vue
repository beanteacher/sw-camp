<script setup>
  import {reactive} from "vue";
  import NamedChild from "@/components/03_namedslot/NamedChild.vue";
  const obj = reactive({
    name : "vue",
    founder : "Evan Yu",
    img : "https://images.ctfassets.net/s5uo95nf6njh/5PpFIeuDxz2T89nZNED1EP/48d62a69f31a3ab6dfc58938eb7b8c2a/evan-you-portrait.jpg?w=1200&fm=jpg"
  })
</script>

<template>
  <div class="container">
    <NamedChild>
      <template v-slot:name>
        <h1>name : {{obj.name}}</h1>
      </template>
      <template v-slot:founder>
        <p>name : {{obj.founder}}</p>
      </template>
      <template v-slot:img>
        <img :src="obj.img" alt="이미지 없음">
      </template>
    </NamedChild>
  </div>
</template>

<style scoped>
  .container {
    display: flex;
    flex-direction: column;
    align-items: center;
    border: 1px solid black;
  }
</style>