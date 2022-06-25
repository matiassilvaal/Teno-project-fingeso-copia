import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import LoginView from '../views/LoginView.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/denuncialist',
    name: 'denuncialist',
    component: () => import('../views/DenouncesListView.vue')
  },
  {
    path: '/login',
    name: 'login',
    component: LoginView
  },
  {
    path: '/about',
    name: 'about',
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  {
    path: '/newdenuncia',
    name: 'newdenuncia',
    component: () => import('../views/NewDenunciasView.vue')
  },
  {
    path: '/denuncia/:id',
    name: 'DenounceView',
    component: () => import('../views/DenounceView.vue')
  }/* ,
  {
    path: '/denuncialist',
    name: 'denuncialist',
    component: () => import('../views/DenouncesListView.vue')
  } */
]

const router = new VueRouter({
  routes
})

export default router
