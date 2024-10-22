import { createApp } from 'vue'
import App from './App.vue'
// import router from "@/router/01_router.js";
import router2 from "@/router/02_nestedRoute.js";

// createApp(App).mount('#app')
const app = createApp(App);
// app.use(router);
app.use(router2);
app.mount("#app");