<template>
  <div class="search" v-infinite-scroll="loadPartList" infinite-scroll-disabled="disabled" infinite-scroll-immediate="false">
    <van-search v-model="formData.searchText" show-action placeholder="请输入品名或规格进行搜索">
      <template #action>
        <div @click="onSearch(formData, true)" class="screen_search_button">搜索</div>
      </template>
    </van-search>
    <div class="price">
      <el-input v-model="formData.priceFrom" placeholder="最低价"></el-input>
      -
      <el-input v-model="formData.priceTo" placeholder="最高价"></el-input>
      <el-button @click="onReset" class="reset">重置</el-button>
    </div>
    <van-dropdown-menu>
      <van-dropdown-item v-model="formData.class1" :options="class1List" @change="class1Change" />
      <van-dropdown-item v-model="formData.class2" :options="class2List" />
      <van-dropdown-item v-model="formData.brand" :options="brandList" />
      <van-dropdown-item v-model="formData.salesStatus" :options="salesStatusList" />
    </van-dropdown-menu>
    <div class="supPartList">
      <ProductList :list="list" class="item" :routreName="'ProductDetailPhone'"></ProductList>
      <span v-if="list.length == 0">
        <van-empty image="search" description="没有查到数据" />
      </span>
      <p v-if="loading && this.list.length > 0">加载中...</p>
      <p v-if="noMore && this.list.length > 0">总记录：{{total}}条，没有更多了</p>
    </div>
  </div>
</template>

<script>
  import ProductList from '../../pc/index/ProductList.vue'
  export default {
    components: {
      ProductList
    },
    data() {
      return {
        initData: {
          searchText: '',
          class1: '',
          class2: '',
          salesStatus: -1,
          brand: '',
          priceFrom: '',
          priceTo: ''
        },
        formData: {
          searchText: '',
          class1: '',
          class2: '',
          salesStatus: -1,
          brand: '',
          priceFrom: '',
          priceTo: ''
        },
        class1List: [{
          text: '全部大类',
          value: ''
        }],
        class2List: [{
          text: '全部中类',
          value: ''
        }],
        salesStatusList: [{
          text: '为您推荐',
          value: -1
        }, {
          text: '置顶',
          value: 98
        }, {
          text: '新品',
          value: 1
        }, {
          text: '热销',
          value: 2
        }, {
          text: '特价',
          value: 3
        }, {
          text: '经典',
          value: 4
        }, {
          text: '促销',
          value: 99
        }],
        brandList: [{
          text: '全部品牌',
          value: ''
        }],
        navBarConfig: {
          title: '商品搜索',
          left: true,
          right: true,
          leftIcon: 'ditengfanhui',
          rightIcon: 'ditengxinxi'
        },
        list: [],
        page: 1,
        pages: 0,
        total: 0,
        pageSize: 30,
        pageSizes: [10, 20, 30, 100],
        loading: false
      }
    },
    computed: {
      noMore() {
        return this.page >= this.pages
      },
      disabled() {
        return this.loading || this.noMore
      }
    },
    created() {
      this.getPersonClass()
      this.getListBrand()
      if (this.$route.params.formData) {
        const items = this.$route.params.formData
        Object.keys(items).forEach(key => {
          this.formData[key] = items[key]
        })
        this.onSearch(this.formData, true)
      }
    },
    methods: {
      async class1Change() {
        this.formData.class2 = ''
        this.class2List = [{
          text: '全部中类',
          value: ''
        }]
        if (this.formData.class1) {
          const res = await this.$service.getPersonSubClass(this.formData.class1)
          if (res.result) {
            res.data.forEach(item => {
              this.class2List.push({
                text: item.className,
                value: item.className
              })
            })
          } else {
            this.$message.error(res.message)
          }
        }
      },
      onClickLeft() {
        this.$router.go(-1)
      },
      onClickRight() {},
      async onSearch(formData, cache) {
        const res = await this.$service.searchGoods(formData, this.page, this.pageSize)
        if (res.result) {
          if (cache) {
            this.list = []
            this.page = 1
          }
          res.data.list.forEach(item => {
            item.descSpec = '[' + item.desc + ',' + item.spec + ']'
            item.imgUrl = item.mainImages && item.mainImages.length > 0 ? item.mainImages[0] : ''
            this.list.push(item)
          })
          this.total = res.data.total
          this.page = res.data.pageNum
          this.pages = res.data.pages
          this.pageSize = res.data.pageSize
          this.loading = false
        } else {
          this.$message.error(res.message)
        }
      },
      async getPersonClass() {
        const classRes = await this.$service.getPersonClass()
        if (classRes.result) {
          this.class1List = [{
            text: '全部大类',
            value: ''
          }]
          classRes.data.forEach(item => {
            this.class1List.push({
              text: item.className,
              value: item.className
            })
          })
        }
      },
      async getListBrand() {
        const brandRes = await this.$service.getListBrand()
        if (brandRes.result) {
          brandRes.data.forEach(item => {
            this.brandList.push({
              text: item.name,
              value: item.name
            })
          })
        }
      },
      onReset() {
        this.formData = JSON.parse(JSON.stringify(this.initData))
        this.class2List = [{
          text: '全部中类',
          value: ''
        }]
      },
      loadPartList() {
        this.loading = true
        this.page++
        this.onSearch(this.formData, false)
      }
    }
  }
</script>

<style scoped>
  .item>>>.row-col5 {
    border-radius: 4px;
    margin-left: 0;
    margin-bottom: 1rem;
    width: 50%;
    position: relative;
  }

  .item>>>.image-box {
    width: 12.5rem;
    height: 12.5rem;
  }

  .item>>>.image-box img,
  >>>.image {
    width: 100%;
    height: 100%;
  }

  >>>.info-box>span {
    width: 100%;
  }

  .item>>>.button {
    position: absolute;
    bottom: 0.4rem;
    right: 1rem;
  }

  .supPartList {
    width: 100%;
    height: auto;
    padding: 0.7em;
    box-sizing: border-box;
  }

  .search {
    overflow: auto;
    height: calc(100vh - 3.571428rem - 3.2rem);
  }

  .supPartList>p {
    text-align: center;
  }

  .screen_search_button {
    min-width: 4em;
    border-radius: .4em;
    -webkit-border-radius: .4em;
    background: #16D18F;
    color: #FFFFFF;
    text-align: center;
    padding: 0 1em;
    border: none;
    outline: none;
    cursor: pointer;
  }

  .price {
    padding: 0.5rem;
  }

  .el-input {
    width: 34% !important;
  }

  .reset {
    width: 26% !important;
    margin-left: 2% !important;
  }
</style>
