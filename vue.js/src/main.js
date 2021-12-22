import { createApp } from 'vue'
import App from './App.vue'
import router from './router'

createApp(App).use(router).mount('#app')
window.Kakao.init('b3d69e4f38156e7b7971e7b8cb7d56db');