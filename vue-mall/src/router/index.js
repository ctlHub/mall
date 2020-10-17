import Vue from 'vue'
import VueRouter from 'vue-router'
import routerPc from './pc/index.js'
import routerMobile from './mobile/index.js'

Vue.use(VueRouter)

const router = new VueRouter({
  routes: [
    ...routerPc,
    ...routerMobile
  ]
})

/**
 * 验证
 */
router.beforeEach((to, from, next) => {
  if (to.params.corpNo) {
    window.sessionStorage.setItem('corpNo', to.params.corpNo)
  }
  if (to.path && to.path.indexOf('pc') === -1 && to.path.indexOf('mobile') === -1) {
    const isPhone = /Android|webOS|iPhone|iPod|BlackBerry/i.test(navigator.userAgent)
    let uri = ''
    if (to.path.indexOf('/product-share') > -1) {
      if (isPhone) {
        uri = `/${to.query.corpNo}/index/productDetailPhone?partCode=${to.query.partCode}&share=true`
      } else {
        uri = `/${to.query.corpNo}/index/productDetail?partCode=${to.query.partCode}`
      }
    }
    if (isPhone) {
      document.querySelector('meta[name="viewport"]').setAttribute('content',
        'width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no')
      next('/mobile' + uri)
    } else {
      document.querySelector('meta[name="viewport"]').setAttribute('content',
        'width=device-width,initial-scale=1.0')
      next('/pc' + uri)
    }
    return
  }
  next()
})

export default router
