<script setup>
import { ref, onMounted } from 'vue';
import axios from 'axios';
import { useAuthStore } from '@/stores/auth';
import {useRouter} from "vue-router";

const authStore = useAuthStore();
const userData = ref(null);
const router = useRouter();

const fetchUserData = async () => {
  try {
    const token = authStore.accessToken;
    const response = await axios.get('http://localhost:8080/users/1', {
      headers: {
        Authorization: `Bearer ${token}`,
      },
    });
    userData.value = response.data;
  } catch (error) {
    console.error('사용자 정보 가져오기 실패', error);
  }
};

const handleLogout = () => {
  authStore.logout();
  router.push('/');
};

onMounted(() => {
  fetchUserData();
});
</script>

<template>
  <div class="mypage-container" v-if="userData">
    <h1>내 정보</h1>
    <div class="user-info">
      <p><strong>사용자 ID :</strong> {{ userData.userId }}</p>
      <p><strong>이름 :</strong> {{ userData.name }}</p>
      <p><strong>이메일 :</strong> {{ userData.email }}</p>
      <p><strong>권한 확인 테스트 : </strong>{{ authStore.isAuthorized('USER') }}</p>
    </div>
    <button @click="handleLogout">로그아웃</button>
  </div>
  <div v-else>
    <p>로딩 중...</p>
  </div>
</template>

<style scoped>
.mypage-container {
  max-width: 400px;
  margin: 20px auto;
  padding: 20px;
}

h1 {
  text-align: center;
  margin-bottom: 20px;
}

.user-info {
  margin-bottom: 20px;
}

.user-info p {
  margin: 5px 0;
  font-size: 16px;
}

button {
  width: 100%;
  padding: 10px;
  background-color: #dc3545;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: 16px;
}

button:hover {
  background-color: #c82333;
}
</style>
