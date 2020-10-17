<template>
  <div class="collection-box">
    <div class="collection">
      <div class="part_list_tips">我的收藏</div>
      <ProductList :list="list" :gutterNum="0" class="items"></ProductList>
      <span v-if="list.length == 0">
        <van-empty description="没有收藏商品" />
      </span>
    </div>
    <div class="imageList">
      <el-image v-for="url in urls" :key="url" :src="url" lazy></el-image>
      <span v-if="urls.length == 0">
        <van-empty description="商品暂时没有说明信息" />
      </span>
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
        urls: []
      }
    },
    created() {
      if (this.$route.query.partCode) {
        this.getDescription(this.$route.query.partCode)
      }
    },
    methods: {
      async getDescription(code) {
        const res = await this.$service.getDescription(code)
        if (res.result) {
          this.urls = res.data
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
</style>
