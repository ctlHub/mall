<template>
  <div>
    <Search :SearchConfig="SearchConfig" @search="search"></Search>
    <div class="main-ad">
      <div class="adBox">
        <ClassSelect :ClassSelectConfig="ClassSelectConfig" @search="search"></ClassSelect>
        <Carousel class="carousel" :CarouselConfig="CarouselConfig"></Carousel>
        <Notice :NoticeConfig="NoticeConfig"></Notice>
      </div>
    </div>
    <BrandArea class="brand-area" :BrandAreaConfig="BrandAreaConfig" @search="search"></BrandArea>
    <CommodityItemBox :CommodityConfig="CommodityConfig" @search="search"></CommodityItemBox>
  </div>
</template>

<script>
  import ClassSelect from './ClassSelect.vue'
  import Carousel from './Carousel.vue'
  import Notice from './Notice.vue'
  import BrandArea from './BrandArea.vue'
  import CommodityItemBox from './CommodityItemBox.vue'
  import Search from './Search.vue'

  export default {
    components: {
      ClassSelect,
      Carousel,
      Notice,
      BrandArea,
      CommodityItemBox,
      Search
    },
    data() {
      return {
        ClassSelectConfig: [{
          className: '钓竿类1',
          imgSrc: require('@/assets/images/电话.png'),
          subClass: {
            className: '台钓竿'
          }
        }],
        CarouselConfig: {
          imgList: [],
          switchTime: 3000
        },
        NoticeConfig: {
          items: [ // 消息列表对应的数组
            {
              title: '公告',
              path: 'https://www.baidu.com'
            }
          ],
          shoppingNum: 0,
          collectionNum: 0
        },
        BrandAreaConfig: [{
            name: '其他'
          },
          {
            name: '狼王'
          },
          {
            name: '金盾'
          },
          {
            name: '金盾2'
          }
        ],
        CommodityConfig: [{
          cmsIndexSalesAd: {
            salesStatus: 99,
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
          }]
        }],
        SearchConfig: {
          hotSearch: ['钓竿类', '渔轮类', '钓线类', '钓钩类', '饵料类', '饵料类'],
          rightButton: {
            imgUrl: require('../../../assets/images/退出登录.png'),
            name: '退出登陆',
            path: '/'
          },
          logoImg: '',
          formSearch: {
            searchText: '',
            brand: '',
            class1: '',
            class2: '',
            salesStatus: -1
          }
        }
      }
    },
    created() {
      this.getCarouselConfig()
      this.loadClass()
      this.getCountCart()
      this.getCountCollect()
      this.getListNotice()
      this.getListBrand()
      this.getGoodsBlock()
    },
    methods: {
      search(data) {
        this.$router.push({
          name: 'ProductSearch',
          params: data
        })
      },
      async getCarouselConfig() {
        const res = await this.$service.getListCarousel()
        if (res.result) {
          this.CarouselConfig = res.data
        }
      },
      async loadClass() {
        const res = await this.$service.getPersonClass()
        if (res.result) {
          this.ClassSelectConfig = res.data
          this.ClassSelectConfig.forEach(async item => {
            const res = await this.$service.getPersonSubClass(item.className)
            if (res.result) {
              // 增加响应式对象属性
              this.$set(item, 'subClass', res.data)
            } else {
              this.$message.error(res.message)
            }
          })
        }
      },
      async getCountCart() {
        const res = await this.$service.getCountCart()
        if (res.result) {
          this.NoticeConfig.shoppingNum = res.data
        }
      },
      async getCountCollect() {
        const res = await this.$service.getCountCollect()
        if (res.result) {
          this.NoticeConfig.collectionNum = res.data
        }
      },
      async getListNotice() {
        const res = await this.$service.getListNotice()
        if (res.result) {
          this.NoticeConfig.items = res.data
        }
      },
      async getListBrand() {
        const res = await this.$service.getListBrand()
        if (res.result) {
          this.BrandAreaConfig = res.data
        }
      },
      async getGoodsBlock() {
        const items = [98, 1, 2, 3, 4, 99]
        this.CommodityConfig = []
        items.forEach(async item => {
          const res = await this.$service.getGoodsBlock(item)
          if (res.result) {
            this.CommodityConfig.push(res.data)
          }
        })
      }
    }
  }
</script>

<style scoped="scoped">
  .main-ad {
    background: #59B7E0;
    height: 28.571428rem;
  }

  .adBox {
    width: 100%;
    height: 28.571428rem;
    max-width: 97.571428rem;
    margin: 0 auto;
    position: relative;
    display: -webkit-box;
    display: -ms-flexbox;
    display: -moz-box;
    display: -webkit-flex;
    display: flex;
    justify-content: space-between;
    align-items: stretch;
    -webkit-align-items: stretch;
  }

  .adBox .carousel {
    width: auto;
    height: 28.571428rem;
    overflow: hidden;
    flex: 1;
  }

  .brand-area {
    margin-top: 1rem;
  }
</style>
