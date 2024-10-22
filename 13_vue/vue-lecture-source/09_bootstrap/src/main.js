import { createApp } from 'vue'
import App from './App.vue'
import BootstrapVue3 from 'bootstrap-vue-3'

// Bootstrap과 BootstrapVue 3의 CSS 파일을 임포트
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue-3/dist/bootstrap-vue-3.css'

// 애플리케이션에 BootstrapVue 설치
const app = createApp(App)
app.use(BootstrapVue3)
app.mount('#app')