<script setup>
import { RouterLink } from 'vue-router';
import { useAuthStore } from '@/stores/auth';
import {computed} from "vue";
const authStore = useAuthStore();
const isLoggedIn = computed(() => !!authStore.accessToken); // accessToken이 있으면 로그인 상태
</script>

<template>
  <header>
    <nav>
      <RouterLink to="/">MAIN</RouterLink>
      <RouterLink to="/basic">BASIC</RouterLink>
      <RouterLink v-if="!isLoggedIn" to="/login">LOGIN</RouterLink>
      <RouterLink v-if="!isLoggedIn" to="/register">REGISTER</RouterLink>
      <RouterLink v-if="isLoggedIn" to="/mypage">MYPAGE</RouterLink>
    </nav>
    <main>
      <RouterView/>
    </main>
  </header>
</template>

<style scoped>
header {
  background-color: rgba(0, 123, 255, 0.5);
  padding: 10px 20px;
}

nav {
  display: flex;
  align-items: center;
}

nav a {
  color: white;
  text-decoration: none;
  padding: 10px 15px;
  transition: background-color 0.3s;
}

nav a:hover {
  background-color: #007bff;
  border-radius: 4px;
}

main {
  padding: 20px;
  background-color: #f9f9f9;
  min-height: calc(100vh - 60px);
  border-top: 1px solid #ddd;
}
</style>
