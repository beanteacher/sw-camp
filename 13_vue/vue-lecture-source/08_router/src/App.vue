<script setup>
import { RouterLink, RouterView } from "vue-router";
</script>

<template>
  <header>
    <div class="wrapper">
      <h1>Router 사용하기</h1>
      <hr>
<!--      <h2>Basic Router</h2>
      <nav>
        <RouterLink to="/" active-class="active" replace>Home</RouterLink>
        <RouterLink to="/pathvariable/1" active-class="active" replace>PathVariable</RouterLink>
        <RouterLink to="/querystring?name=홍길동&age=20" active-class="active" replace>QueryString</RouterLink>
      </nav>-->
      <h2>Nested Router</h2>
      <nav>
        <RouterLink to="/" active-class="active" replace>HOME</RouterLink>
        <RouterLink to="/nested/home" active-class="active" replace>중첩 HOME</RouterLink>
        <RouterLink to="/nested/view" active-class="active" replace>중첩 VIEW</RouterLink>
      </nav>
    </div>
  </header>
  <main>
    <RouterView/>
  </main>
</template>

<style scoped>
nav {
  width: 100%;
  font-size: 12px;
  text-align: center;
  margin-top: 2rem;
  font-size: 30px;
}

a {
  margin-left: 10px;
}

.active {
  color: red;
}

main {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

header {
  text-align: center;
}
</style>
