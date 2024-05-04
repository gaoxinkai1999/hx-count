import Vue from 'vue'
import App from './App.vue'
import axios from "axios";
import Vant from 'vant';
import 'vant/lib/index.css';
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
axios.defaults.baseURL = 'http://124.221.98.251:8087'
Vue.prototype.$http = axios
Vue.config.productionTip = false

// Vue.use(Toast);
Vue.use(ElementUI);
Vue.use(Vant);

new Vue({
  render: h => h(App),
}).$mount('#app')
