import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'
import Login from './views/Login'
import Register from './views/Register'
import MainPage from './views/MainPage'

Vue.use(Router)

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      username: 'login',
      component: Login
    },
    {
      path: '/register',
      username: 'register',
      component: Register
    },
    {
      path: '/mainpage',
      username: 'mainpage',
      meta: {
        requireAuth: true
      },
      component: MainPage
    },
    {
      path: '/home',
      username: 'home',
      component: Home
    },
    {
      path: '/about',
      username: 'about',
      // route level code-splitting
      // this generates a separate chunk (about.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import(/* webpackChunkName: "about" */ './views/About.vue')
    }
  ]
})
