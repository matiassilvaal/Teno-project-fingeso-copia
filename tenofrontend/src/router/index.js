import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
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
    path: '/denuncialist',
    name: 'denuncialist',
    component: () => import('../views/DenouncesListView.vue')
  }
]

const router = new VueRouter({
  routes
})

export default router
