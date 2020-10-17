import Vue from 'vue'
import App from './App.vue'
import router from './router'
import './plugins/element.js'
import './plugins/vxeTable.js'
import './plugins/vant.js'
import './assets/css/global.css'
import '../public/font/iconfont.css'
import less from 'less'
import XEUtils from 'xe-utils'
import Api from './axios/api.js'
import MyUtils from './utils/utils.js'
import VueClipboard from 'vue-clipboard2'

Vue.use(VueClipboard)
Vue.config.productionTip = false
Vue.prototype.$XEUtils = XEUtils
Vue.prototype.$service = Api
Vue.prototype.$MYUtils = MyUtils

Vue.use(less)

Vue.config.productionTip = false

Vue.component('remote-script', {
  render: function(createElement) {
    var self = this
    return createElement('script', {
      attrs: {
        type: 'text/javascript',
        src: this.src
      },
      on: {
        load: function(event) {
          self.$emit('load', event)
        },
        error: function(event) {
          self.$emit('error', event)
        },
        readystatechange: function(event) {
          if (this.readyState === 'complete') {
            self.$emit('load', event)
          }
        }
      }
    })
  },
  props: {
    src: {
      type: String,
      required: true
    }
  }
})

const vue = new Vue({
  router,
  render: h => h(App)
}).$mount('#app')

window.vue = vue

export default vue
