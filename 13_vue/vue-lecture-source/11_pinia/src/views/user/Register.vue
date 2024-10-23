
<script setup>
import axios from 'axios';
import { ref } from 'vue';
import {useRouter} from "vue-router";


const userId = ref('');
const pwd = ref('');
const email = ref('');
const name = ref('');

const router = useRouter();

const handleRegister = async () => {
  try {
    const response = await axios.post('http://localhost:8080/users', {
      userId: userId.value,
      pwd: pwd.value,
      email: email.value,
      name: name.value,
    });

    if(response.status === 201) {
      router.push('/login');
    }
  } catch (error) {
    console.error('회원가입 실패', error);
  }
};
</script>

<template>
  <div class="register-container">
    <h1>회원 가입</h1>
    <form @submit.prevent="handleRegister">
      <div>
        <label for="userId">사용자 ID</label>
        <input v-model="userId" id="userId" required />
      </div>
      <div>
        <label for="pwd">비밀번호</label>
        <input type="password" v-model="pwd" id="pwd" required />
      </div>
      <div>
        <label for="email">이메일</label>
        <input v-model="email" id="email" type="email" required />
      </div>
      <div>
        <label for="name">이름</label>
        <input v-model="name" id="name" required />
      </div>
      <button type="submit">회원가입</button>
    </form>
  </div>
</template>


<style scoped>
.register-container {
  max-width: 400px;
  margin: 0 auto;
  padding: 20px;
}

h1 {
  text-align: center;
  margin-bottom: 20px;
}

form div {
  margin-bottom: 15px;
}

label {
  display: block;
  margin-bottom: 5px;
  font-weight: bold;
}

input {
  width: 95%;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 4px;
}

button {
  width: 100%;
  padding: 10px;
  background-color: #007bff;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: 16px;
}

button:hover {
  background-color: #0056b3;
}
</style>
