<script setup>
import {useCounterStore1, useCounterStore2} from '@/stores/counter'
import {useUserStore} from "@/stores/user.js";
import { ref } from 'vue'

// counterStore: useCounterStore()를 호출하여 Pinia 스토어에서 상태와 액션을 가져온다.
// const counterStore = useCounterStore1()
const counterStore = useCounterStore2()
// userStore: useUserStore()를 호출하여 Pinia 스토어에서 상태와 액션을 가져온다.
const userStore = useUserStore()
const newName = ref('')

const updateUserName = () => {
  if (newName.value) {
    userStore.setName(newName.value)
    newName.value = ''
  }
}
</script>

<template>
  <div class="container">
    <h1>Counter</h1>
    <p>현재 값 : {{ counterStore.count }}</p>
    <p>두 배의 값 : {{ counterStore.doubleCount }}</p>
    <button @click="counterStore.increment">카운트 증가</button>

    <h1>User</h1>
    <p>User 이름 : {{ userStore.name }}</p>
    <input v-model="newName" placeholder="변경할 이름을 입력하세요" />
    <button @click="updateUserName">이름 변경</button>
  </div>
</template>

<style scoped>
.container {
  max-width: 600px;
  margin: 0 auto;
  padding: 20px;
}
</style>
