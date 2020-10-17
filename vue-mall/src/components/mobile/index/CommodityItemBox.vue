<template>
  <div class="commodity">
    <div v-for="(item,index) in productList" :key="index" class="commodityItemBox">
      <div class="item-boxTitle">
        <span>
          {{shopTitle[item.cmsIndexSalesAd.salesStatus].name}}
        </span>
        <a @click="jump(item.cmsIndexSalesAd.salesStatus)">
          更多
          <van-icon name="arrow" />
        </a>
      </div>
      <div class="supPartList">
        <ProductList :list="item.goodsList" :routreName="'ProductDetailPhone'" class="item"></ProductList>
      </div>
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
        shopTitle: this.$MYUtils.shopTitle,
        productList: []
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
            if (item.goodsList.length > 2) {
              item.goodsList = item.goodsList.slice(0, 2)
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
      jump(salesStatus) {
        this.$router.push({
          name: 'SearchPhone',
          params: {
            formData: {
              salesStatus: salesStatus
            }
          }
        })
      }
    }
  }
</script>

<style scoped>
  .item>>>.row-col5 {
    border-radius: 4px;
    margin-left: 0 !important;
    margin-bottom: 1rem;
    width: 50% !important;
    position: relative;
  }

  .item>>>.image-box {
    width: 12.5rem;
    height: 12.5rem;
  }

  .item>>>.image-box img,
  >>>.image {
    width: 100% !important;
    height: 100% !important;
  }

  >>>.info-box>span {
    width: 100%;
  }

  .item>>>.button {
    position: absolute;
    bottom: 0.4rem;
    right: 1rem;
  }

  .commodityItemBox {
    width: 100%;
    height: auto;
    padding: 0 0.7em;
    box-sizing: border-box;
  }

  .commodityItemBox {
    width: 100%;
    height: auto;
    padding: 0 0.7em;
  }

  .commodityItemBox .item-boxTitle {
    width: 100%;
    height: 2.4em;
    line-height: 2.4em;
    position: relative;
    text-align: center;
  }

  .commodityItemBox .item-boxTitle>a {
    position: absolute;
    top: 0;
    right: 0;
    display: flex;
    display: -webkit-flex;
    justify-content: space-between;
    align-items: center;
    width: auto;
    height: inherit;
    color: #999;
    font-size: 0.85em;
  }

  .commodityItemBox .item-boxTitle>a i {
    width: 1em;
    height: 1em;
    font-size: 1.15rem;
  }

  .commodityItemBox .item-boxTitle>span {
    font-size: 1.05em;
    font-weight: bold;
    color: #16D18F;
    position: relative;
  }

  .commodityItemBox .item-boxTitle>span:before {
    position: absolute;
    top: 50%;
    left: -4em;
    width: 3em;
    height: 1px;
    display: block;
    content: "";
    background: #16D18F;
    transform: translateY(-50%);
    -webkit-transform: translateY(-50%);
  }

  .commodityItemBox .item-boxTitle>span:after {
    position: absolute;
    top: 50%;
    right: -4em;
    width: 3em;
    height: 1px;
    display: block;
    content: "";
    background: #16D18F;
    transform: translateY(-50%);
    -webkit-transform: translateY(-50%);
  }
</style>
