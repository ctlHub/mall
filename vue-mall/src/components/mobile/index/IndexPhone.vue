<template>
  <div>
    <van-search v-model="searchText" show-action placeholder="请输入品名或规格进行搜索" @search="onSearch" background="#16D18F"
      shape="round">
      <template #action>
        <div @click="onSearch" class="screen_search_button">搜索</div>
      </template>
    </van-search>
    <div class="my-swipe">
      <div class="swipe-background-color"></div>
      <van-swipe :autoplay="CarouselConfig.switchTime" indicator-color="white">
        <van-swipe-item v-for="(item,index) in CarouselConfig.imgList" :key="index">
          <img :src="item" class="image" />
        </van-swipe-item>
      </van-swipe>
    </div>
    <CommodityItemBox :CommodityConfig="CommodityConfig"></CommodityItemBox>
  </div>
</template>

<script>
  import CommodityItemBox from './CommodityItemBox.vue'

  export default {
    components: {
      CommodityItemBox
    },
    data() {
      return {
        active: 0,
        searchText: '',
        CarouselConfig: {
          imgList: [],
          switchTime: 3000
        },
        navBarConfig: {
          title: '在线商城',
          left: true,
          right: true,
          leftIcon: 'ditengqiehuan',
          rightIcon: 'ditengxinxi'
        },
        CommodityConfig: [],
        formData: {}
      }
    },
    created() {
      this.$emit('setNavBar', this.navBarConfig)
      this.getCarouselConfig()
      this.getGoodsBlock()
    },
    methods: {
      onSearch() {
        this.formData.searchText = this.searchText
        this.$router.push({
          name: 'SearchPhone',
          params: {
            formData: this.formData
          }
        })
      },
      onClickRight() {
        console.log('右侧')
      },
      async getCarouselConfig() {
        const res = await this.$service.getListCarousel()
        if (res.result) {
          this.CarouselConfig = res.data
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

<style scoped>
  .swipe-background-color {
    background-color: #16D18F;
    height: 5rem;
    width: 100%;
    border-bottom-left-radius: 100%;
    border-bottom-right-radius: 100%;
    position: absolute;
  }

  .van-swipe {
    width: 96%;
    margin: 0 auto;
  }

  .screen_search_button {
    width: 8rem;
    height: 2.4em;
    line-height: 2.4em;
    text-align: center;
    border: 0;
    outline: none;
    border-radius: 1.2em;
    background: #0CBDAD;
    color: #fff;
  }
</style>
