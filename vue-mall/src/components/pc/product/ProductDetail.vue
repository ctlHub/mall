<template>
  <div>
    <Search :SearchConfig="SearchConfig" @search="search"></Search>
    <div class="product-detail">
      <ProductSwiper class="swiper" :ProductImgs="ProductImgs"></ProductSwiper>
      <Info class="info" :GoodsInfo="GoodsInfo"></Info>
    </div>
    <Related :partCode="partCode"></Related>
  </div>
</template>

<script>
  import Search from '../index/Search.vue'
  import ProductSwiper from './ProductSwiper.vue'
  import Info from './Info.vue'
  import Related from './Related.vue'

  export default {
    components: {
      Search,
      ProductSwiper,
      Info,
      Related
    },
    data() {
      return {
        SearchConfig: {
          rightButton: {
            imgUrl: require('../../../assets/images/shopping_car.png'),
            name: '购物车',
            path: '/',
            num: 0
          }
        },
        partCode: '',
        GoodsInfo: {},
        ProductImgs: []
      }
    },
    created() {
      this.getGoodsDetail(this.$route.query.partCode)
    },
    beforeRouteUpdate(to, from, next) {
      if (to.query && from.query && to.query.partCode !== from.query.partCode) {
        this.getGoodsDetail(to.query.partCode)
      }
      next()
    },
    methods: {
      search(data) {
        this.$router.push({
          name: 'ProductSearch',
          params: data
        })
      },
      async getGoodsDetail(code) {
        const res = await this.$service.getGoodsDetail(code)
        if (res.result) {
          res.data.childGoods.forEach(item => {
            item.descSpec = `${item.desc},${item.spec}`
          })
          const priceRange = res.data.priceRange
          if (priceRange && priceRange.minListUp !== priceRange.maxListUp) {
            res.data.listUp = `${priceRange.minListUp}-${priceRange.maxListUp}`
          }
          this.GoodsInfo = []
          this.GoodsInfo = res.data
          this.ProductImgs = []
          if (!res.data.mainImages) {
            return false
          }
          res.data.mainImages.forEach(item => {
            this.ProductImgs.push({
              url: item,
              classImg: ''
            })
          })
        }
      }
    }
  }
</script>

<style scoped>
  .product-detail {
    width: 97.571428rem;
    margin: 0 auto;
    padding-top: 1rem;
    margin-bottom: 1.5rem;
  }

  .swiper {
    width: 28.571428rem;
    display: inline-block;
  }

  .info {
    width: calc(100% - 28.571428rem);
    display: inline-block;
    vertical-align: top;
    padding-left: 1rem;
    box-sizing: border-box;
  }
</style>
