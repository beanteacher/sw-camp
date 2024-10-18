<script setup>
import {ref} from "vue";
import SlotChild from "@/components/02_soltintro/SlotChild.vue";

const slotData = ref("hello Data");
</script>

<template>
  <div class="parentContainer">
    <h1>Parent</h1>
    <SlotChild>
      {{slotData}}
    </SlotChild>
  </div>
</template>

<style scoped>
  .parentContainer {
    display: flex;
    align-items: center;
    flex-direction: column;
    border: 1px solid black;
  }
</style>