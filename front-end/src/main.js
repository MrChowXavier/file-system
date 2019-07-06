import Vue from 'vue'
import App from './App.vue'
import router from './router'
import axios from 'axios'

import Vuex from 'vuex'
import store from './vuex/store.js'

import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'

Vue.use(ElementUI)
Vue.use(Vuex)

Vue.config.productionTip = false

Vue.prototype.axios = axios
//
// axios.interceptors.request.use(function (config) {
//   if (localStorage.token) {
//     config.headers.Authorization = `Bearer ${localStorage.token}`
//   }
//   return config
// }, function (err) {
//   return Promise.reject(err)
// })
// router.beforeEach((to, from, next) => {
//   // 这里的meta就是我们刚刚在路由里面配置的meta
//   if (to.meta.requireAuth) {
//     console.log(store.getters.isLogin)
//     // 下面这个判断是自行实现到底是否有没有登录
//     if (store.getters.isLogin) {
//       // 登录就继续
//       next()
//     } else {
//       // 没有登录跳转到登录页面，登录成功之后再返回到之前请求的页面
//       next({
//         path: '/login',
//         query: { redirect: to.fullPath }
//       })
//     }
//   } else {
//     next()
//   }
// })

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
