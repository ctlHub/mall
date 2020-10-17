<template>
  <div class="commodity">
    <div v-for="(item,index) in productList" :key="index" class="commodityItemBox">
      <div class="item-boxTitle">
        <span>
          <a @click="onClick(item.cmsIndexSalesAd.salesStatus)">
            <img :src="shopTitle[item.cmsIndexSalesAd.salesStatus].icon">
          </a>
          <img :src="item.cmsIndexSalesAd.imgUrl">
        </span>
        <a @click="onClick(item.cmsIndexSalesAd.salesStatus)">
          更多<i></i>
        </a>
      </div>
      <div class="supPartList">
        <ProductList :list="item.goodsList"></ProductList>
      </div>
    </div>
  </div>
</template>

<script>
  import ProductList from './ProductList.vue'
  export default {
    components: {
      ProductList
    },
    data() {
      return {
        shopTitle: this.$MYUtils.shopTitle,
        productList: [{
          cmsIndexSalesAd: {
            salesStatus: 1,
            code: 'S00002',
            imgUrl: 'https://vinefiles.oss-cn-hangzhou.aliyuncs.com/enclosure/131001/null/pc/{669a062a-71f7-4d34-b7ad-0782030093e7}.jpg'
          },
          goodsList: [{
              // 商品热销类别
              salesStatus: 1,
              // 是否下架
              lowerShelf: false,
              // 是否型号
              classify: 1,
              // 商品图片
              imgUrl: 'https://vinefiles.oss-cn-hangzhou.aliyuncs.com/131001/product/21FQTL-I-X/{c97828d7-4e25-4143-b049-f9a98bc3e002}.jpg',
              // 商家编号
              supCode: false,
              // 商品编号
              partCode: '1231927371628',
              // 单位
              unit: '有货',
              // 进货价
              goodUP: '19.9',
              // 销售价
              listUP: '10',
              // 品名规格
              descSpec: '[铂金,饵料,战狼,雾化豆,190+\\-10 颗,]'
            },
            {
              // 商品热销类别
              salesStatus: 1,
              // 是否下架
              lowerShelf: false,
              // 是否型号
              classify: 1,
              // 商品图片
              imgUrl: 'https://vinefiles.oss-cn-hangzhou.aliyuncs.com/131001/product/21FQTL-I-X/{c97828d7-4e25-4143-b049-f9a98bc3e002}.jpg',
              // 商家编号
              supCode: false,
              // 商品编号
              partCode: '1231927371628',
              // 单位
              unit: '有货',
              // 进货价
              goodUP: '19.9',
              // 销售价
              listUP: '10',
              // 品名规格
              descSpec: '[铂金,饵料,战狼,雾化豆,190+\\-10 颗,]'
            }
          ]
        }],
        formSearch: {
          searchText: '',
          brand: '',
          class1: '',
          class2: '',
          salesStatus: -1
        }
      }
    },
    props: {
      CommodityConfig: Array
    },
    watch: {
      CommodityConfig: {
        deep: true,
        handler(newVal, oldVal) {
          this.initData()
        }
      }
    },
    created() {
      this.initData()
    },
    methods: {
      initData() {
        if (this.CommodityConfig) {
          this.productList = []
          this.CommodityConfig.forEach(item => {
            if (item.goodsList.length > 10) {
              item.goodsList = item.goodsList.slice(0, 10)
            }
            item.goodsList.forEach(record => {
              record.descSpec = '[' + record.desc + ',' + record.spec + ']'
              record.imgUrl = record.mainImages && record.mainImages.length > 0 ? record.mainImages[0] : ''
            })
            this.productList.push(item)
          })
          this.productList.sort(function(a, b) {
            if (b.cmsIndexSalesAd.salesStatus === 98) {
              return true
            } else {
              return a.cmsIndexSalesAd.salesStatus - b.cmsIndexSalesAd.salesStatus
            }
          })
        }
      },
      onClick(salesStatus) {
        this.formSearch.salesStatus = salesStatus
        this.$emit('search', this.formSearch)
      }
    }
  }
</script>

<style scoped>
  .commodity {
    width: 97.571428rem;
    margin: 0 auto;
  }

  .commodityItemBox {
    background: url("../../../assets/images/index_bg.png") repeat center scroll;
    background-size: 1.428571rem;
    width: 100%;
    height: auto;
  }

  .commodityItemBox .item-boxTitle {
    height: 8.928571rem;
    width: 100%;
    background: #63C8F4;
    margin-bottom: 0.714285rem;
    margin-top: 1.785714rem;
    line-height: 5rem;
    position: relative;
  }

  .item-boxTitle>a {
    position: absolute;
    top: 0;
    right: 0.7rem;
    color: #fff;
    display: block;
    height: 8.928571rem;
    line-height: 8.928571rem;
    width: 7.142857rem;
    padding-right: 1.071428rem;
    text-align: right;
    font-size: 1.142857rem;
  }

  .item-boxTitle>a i {
    display: inline-block;
    width: 1.142857rem;
    height: 1.071428rem;
    background: url("../../../assets/images/more_white.png") no-repeat center scroll;
    background-size: 1.142857rem 1.071428rem;
  }

  .supPartList {
    background: transparent;
  }

  .supPartList {
    width: 100%;
    height: auto;
    overflow: hidden;
    zoom: 1;
  }
</style>
