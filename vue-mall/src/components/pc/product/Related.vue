<template>
  <div class="collection-box">
    <div class="collection">
      <div class="part_list_tips">相关商品</div>
      <ProductList :list="list" :gutterNum="0" class="items"></ProductList>
      <span v-if="list.length == 0">
        <van-empty description="没有相关商品" />
      </span>
    </div>
    <div class="imageList">
      <el-tabs type="border-card">
        <el-tab-pane label="商品详情">
          <div class="attribute" v-if="attributeList.length > 0">
            <span>产品参数</span>
            <el-row :gutter="10" class="item">
              <el-col :span="8" v-for="(item, index) in attributeList" :key="index" class="record">
                {{item.name}}:{{item.value}}
              </el-col>
            </el-row>
          </div>
          <el-image v-for="url in urls" :key="url" :src="url" lazy></el-image>
          <span v-if="urls.length == 0">
            <van-empty description="商品暂时没有说明信息" />
          </span>
        </el-tab-pane>
        <el-tab-pane label="商品评价">
          <van-empty description="暂无评价" />
        </el-tab-pane>
      </el-tabs>
    </div>
  </div>
</template>

<script>
  import ProductList from '../index/ProductList.vue'
  export default {
    components: {
      ProductList
    },
    data() {
      return {
        list: [],
        urls: [],
        attributeList: [{
          name: '品牌',
          value: 'AQUA/爱克'
        }]
      }
    },
    created() {
      this.initData()
    },
    watch: {
      $route: {
        handler() {
          this.initData()
        }
      }
    },
    methods: {
      initData() {
        const code = this.$route.query.partCode
        if (code) {
          this.getDescription(code)
          this.listBindGoods(code)
          this.listAttr(code)
        }
      },
      async getDescription(code) {
        const res = await this.$service.getDescription(code)
        if (res.result) {
          this.urls = res.data
        }
      },
      async listBindGoods(code) {
        const res = await this.$service.listBindGoods(code)
        if (res.result) {
          res.data.forEach(item => {
            item.descSpec = `${item.desc},${item.spec}`
            item.imgUrl = item.mainImages && item.mainImages.length > 0 ? item.mainImages[0] : ''
          })
          this.list = res.data
        }
      },
      async listAttr(code) {
        const res = await this.$service.listAttr(code)
        this.attributeList = []
        if (res.result) {
          this.attributeList = res.data
        }
      }
    }
  }
</script>

<style scoped>
  .collection-box {
    width: 97.571428rem;
    margin: 0 auto;
  }

  .collection {
    width: 18.8rem;
    display: inline-block;
    vertical-align: top;
  }

  .imageList {
    width: calc(100% - 18.9rem);
    display: inline-block;
    vertical-align: top;
    padding-left: 1rem;
    box-sizing: border-box;
  }

  .items>>>.row-col5 {
    border-radius: 4px;
    margin-left: 0 !important;
    margin-bottom: 1rem;
    width: 18.8rem;
  }

  .part_list_tips {
    width: 18.8rem;
    height: 2.714285rem;
    line-height: 2.714285rem;
    text-align: center;
    color: #22A6E0;
    background: #E6F7FF;
    font-size: 1.285714rem;
    margin: 0 0 0.714285rem 0;
    font-weight: 400;
  }

  .el-image {
    width: 100%;
    margin-bottom: 1rem;
  }

  >>>.el-tabs--border-card {
    box-shadow: initial;
  }

  .attribute {
    margin-bottom: 1rem;
    padding: 1rem;
    border: 1px solid #dedede;
    color: #7b7b7b;
  }

  .attribute>span {
    margin-bottom: 1rem;
    display: block;
  }

  .record {
    margin-bottom: 0.3rem;
  }
</style>
