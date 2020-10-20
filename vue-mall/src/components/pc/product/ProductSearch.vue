<template>
  <div>
    <Search :SearchConfig="SearchConfig" @search="search"></Search>
    <div class="product-list">
      <ProductList :list="list"></ProductList>
      <span v-if="list.length == 0">
        <van-empty image="search" description="没有查到数据" />
      </span>
      <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="page"
        :page-sizes="pageSizes" :page-size="pageSize" layout="total, sizes, prev, pager, next, jumper" :total="total"
        v-if="total > 0">
      </el-pagination>
    </div>
  </div>
</template>

<script>
  import Search from '../index/Search.vue'
  import ProductList from '../index/ProductList.vue'
  export default {
    components: {
      Search,
      ProductList
    },
    data() {
      return {
        SearchConfig: {},
        list: [],
        loading: false,
        finished: false,
        refreshing: false,
        page: 1,
        total: 0,
        pageSize: 30,
        pageSizes: [10, 20, 30, 100]
      }
    },
    created() {
      this.initData()
    },
    activated() {
      // console.log('formSearch', this.$route.params)
      // this.initData()
      // console.log('进入', this)
      // this.$router.meta.keepAlive = true
    },
    deactivated() {
      // this.initData()
      // console.log('退出', this)
      // this.$router.meta.keepAlive = true
    },
    beforeRouteEnter(to, from, next) {
      // to.meta.keepAlive = from.name === 'ProductDetail'
      // next()
      // next(vm => {
      //   console.log(vm)
      //   vm.initData()
      // })
      // console.log(this)
      next()
    },
    beforeRouteLeave(to, from, next) {
      // if (to.name === 'ProductDetail') {
      //   this.$vnode.parent.componentInstance.cache = {}
      //   this.$vnode.parent.componentInstance.key = []
      // }
      // to.meta.keepAlive = to.name === 'ProductDetail'
      // from.meta.keepAlive = to.name === 'ProductDetail'
      // console.log('离开', to, from)
      // console.log(to.name === 'ProductDetail', from.name === 'ProductDetail')
      // console.log(this)
      // console.log(this.$vnode.parent.componentInstance.key)
      next()
    },
    methods: {
      initData() {
        if ('searchText' in this.$route.params) {
          this.SearchConfig.formSearch = this.$route.params
          this.search(this.SearchConfig.formSearch)
        }
      },
      async search(formData) {
        this.SearchConfig.formSearch = formData
        const res = await this.$service.searchGoods(formData, this.page, this.pageSize)
        if (res.result) {
          document.documentElement.scrollTop = 0
          this.list = res.data.list
          this.list.forEach(item => {
            item.descSpec = '[' + item.desc + ',' + item.spec + ']'
            item.imgUrl = item.mainImages && item.mainImages.length > 0 ? item.mainImages[0] : ''
          })
          this.total = res.data.total
          this.page = res.data.pageNum
          this.pageSize = res.data.pageSize
        } else {
          this.$message.error(res.message)
        }
      },
      handleSizeChange(val) {
        this.pageSize = val
      },
      handleCurrentChange(val) {
        this.page = val
        this.search(this.SearchConfig.formSearch)
      }
    }
  }
</script>

<style scoped>
  .product-list {
    min-height: 10rem;
    width: 97.571428rem;
    margin: 0 auto !important;
  }

  .el-pagination {
    margin: 1rem auto;
    text-align: center;
  }
</style>
