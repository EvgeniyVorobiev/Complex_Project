import Vue from 'vue'
import VueRouter from 'vue-router'
//import HomeView from '../views/HomeView.vue'
import MainNoLoginView from '../views/MainNoLoginView.vue'
import MainComponent from '../components/MainComponent.vue'
import TechCardsComponent from '../components/TechCardsComponent.vue'
import DishSetCards from '../components/DishSetCards.vue'
import TariffsComponent from '../components/tariffsComponent.vue'
import DishInfoComponent from '../components/DishInfoComponent.vue'
import ProductInfoComponent from '../components/ProductInfoComponent.vue'

Vue.use(VueRouter)

const routes = [
  { path: '/', name: 'Main', component: MainNoLoginView },
  { path: '/techCards', name: 'techCards', component: TechCardsComponent },
  { path: '/dishSetCards', name: 'dishSetCards', component: DishSetCards },
  { path: '/tariffs', name: 'tariffs', component: TariffsComponent },
  { path: '/main', name: 'main', component: MainComponent},
  { path: '/dishInfo', name: 'dishInfo', component: DishInfoComponent},
  { path: '/productInfo', name: 'productInfo', component: ProductInfoComponent}
  // {
  //   path: '/about',
  //   name: 'about',
  //   // route level code-splitting
  //   // this generates a separate chunk (about.[hash].js) for this route
  //   // which is lazy-loaded when the route is visited.
  //   component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  // },
  // {
  //   path: '/main',
  //   name: 'Main',
  //   component: () => import('../views/MainNoLoginView.vue')
  // }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
