<template>
  <div>
    <!-- 父组件breadcrumb变化自动刷新子组件 -->
    <vHead :breadcrumb="breadcrumb" :pageName="pageName"></vHead>
    <router-view></router-view>
    <Footer></Footer>
  </div>
</template>

<script>
  import vHead from './Head.vue'
  import Footer from './Footer.vue'
  export default {
    components: {
      vHead,
      Footer
    },
    data() {
      return {
        breadcrumb: [{
          name: '首页',
          path: ''
        }],
        pageName: '在线商城'
      }
    },
    watch: {
      $route() {
        this.setBreadcrumb()
      }
    },
    created() {
      this.setBreadcrumb()
    },
    methods: {
      setBreadcrumb() {
        let matched = this.$route.matched
        matched = [{
          path: '/pc/mallIndex',
          meta: {
            title: '首页'
          }
        }].concat(matched)
        matched[1].meta = {
          title: window.sessionStorage.getItem('corpNoName')
        }
        this.breadcrumb = []
        const tmp = []
        matched.forEach(item => {
          if (tmp.indexOf(item.path.substring(0, item.path.length - 1)) === -1) {
            tmp.push(item.path)
            this.breadcrumb.push({
              name: item.meta.title,
              path: item.path.replace(/:corpNo/g, window.sessionStorage.getItem('corpNo'))
            })
          }
        })
      }
    }
  }
</script>

<style>
</style>
