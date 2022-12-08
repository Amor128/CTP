import Vue from 'vue'
import App from './App.vue'

import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
// import locale from 'element-ui/lib/locale/lang/en' // lang i18n


import store from '@/store'
import router from '@/router'

// import '@/permission' // permission control


Vue.config.productionTip = false
// 如果想要英文版 element-ui，按如下方式声明
// Vue.use(ElementUI, { locale })
Vue.use(ElementUI)

new Vue({
  render: h => h(App),
  router,
  store,
}).$mount('#app')
