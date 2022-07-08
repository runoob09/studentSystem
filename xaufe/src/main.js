import Vue from 'vue'
import App from './App.vue'
import ElementUI from 'element-ui'
import router from '@/router/index'
import axios from 'axios'
Vue.config.productionTip = false
Vue.use(ElementUI)

axios.defaults.withCredentials = true
Vue.prototype.$axios = axios
new Vue({
  render: (h) => h(App),
  router
}).$mount('#app')
