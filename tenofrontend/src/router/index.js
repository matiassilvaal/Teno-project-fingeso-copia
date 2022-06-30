import Vue from 'vue'
import VueRouter from 'vue-router'
import LoginView from '../views/LoginView.vue'
import LoadingView from '../views/LoadingView.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'login',
    component: LoginView
  },
  {
    path: '/',
    name: 'login',
    component: LoginView
  },
  {
    path: '/denuncialist',
    name: 'denuncialist',
    component: () => import('../views/DenouncesListView.vue')
  },
  {
    path: '/home',
    name: 'home',
    component: LoadingView
  },
  {
    path: '/newdenuncia',
    name: 'newdenuncia',
    component: () => import('../views/NewDenunciasView.vue')
  },
  {
    path: '/denuncialistfiscal',
    name: 'denuncialistfiscal',
    component: () => import('../views/DenouncesListViewFiscal.vue')
  },
  {
    path: '/denuncia',
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
