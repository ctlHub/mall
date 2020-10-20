<template>
  <el-carousel :interval="switchTime" arrow="always" height="28.571428rem">
    <el-carousel-item v-for="(item,index) in imgList" :key="index">
      <img :src="item" class="image" />
    </el-carousel-item>
  </el-carousel>
</template>

<style>
  .image {
    width: 100%;
    height: 100%;
  }
</style>

<script>
  export default {
    data() {
      return {
        imgList: [
          'https://vinefiles.oss-cn-hangzhou.aliyuncs.com/enclosure/131001/null/pc/{0b87840a-b83b-4216-b1e5-01c33209371a}.jpg?x-oss-process=image/resize,h_400'
        ],
        switchTime: 5000
      }
    },
    created() {
      if (this.CarouselConfig.imgList) {
        this.imgList = this.CarouselConfig.imgList
      }
      if (this.CarouselConfig.switchTime) {
        this.switchTime = this.CarouselConfig.switchTime
      }
    },
    props: {
      CarouselConfig: {
        imgList: Array,
        switchTime: Number
      }
    },
    watch: {
      CarouselConfig: {
        deep: true, // 深度监听
        handler(newVal, oldVal) {
          if (newVal.imgList) {
            this.imgList = newVal.imgList
          }
          if (newVal.switchTime) {
            this.switchTime = newVal.switchTime
          }
        }
      }
    }
  }
</script>
