import { createApp } from 'vue'
import App from './App.vue'
import '../node_modules/bootstrap/dist/css/bootstrap.css';
import router from './routers'
import store from "./store";

createApp(App)
  .use(store)
  .use(router)
  .mount('#app');
