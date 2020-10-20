<template>
  <div class="image-box">
    <div class="image-max">
      <el-image :src="maxImage" :fit="fit"></el-image>
    </div>
    <div class="list">
      <a class="arrow-left" @click="arrowLeft"></a>
      <div class="image-min-box" ref="imgList">
        <el-image :src="item.url" :fit="fit" v-for="(item,index) in imgs" :key="index" :class="'image ' +item.classImg"
          @mouseenter="enter(item)" @mouseleave="leave(item)"></el-image>
      </div>
      <a class="arrow-right" @click="arrowRight"></a>
    </div>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        imgs: [{
          url: 'https://www.hmwdj.com/ImgUpload/202009020031.jpg',
          classImg: ''
        }],
        maxImage: '',
        fit: 'fill'
      }
    },
    created() {
      if (this.ProductImgs) {
        this.imgs = this.ProductImgs
      }
      if (this.imgs.length > 0 && this.imgs[0].url) {
        this.maxImage = this.imgs[0].url
      }
    },
    props: {
      ProductImgs: Array
    },
    watch: {
      ProductImgs: {
        deep: true,
        handler(newVal, oldVal) {
          this.imgs = newVal
          if (newVal.length > 0) {
            this.maxImage = this.imgs[0].url
          } else {
            this.maxImage = ''
          }
        }
      }
    },
    methods: {
      enter(item) {
        this.maxImage = item.url
        item.classImg = 'action'
      },
      leave(item) {
        item.classImg = ''
      },
      arrowLeft() {
        const item = this.$refs.imgList
        item.scrollBy(-84, 0)
      },
      arrowRight() {
        const item = this.$refs.imgList
        item.scrollBy(84, 0)
      }
    }
  }
</script>

<style scoped>
  .image-box {
    width: 28.571428rem;
  }

  .list {
    height: 7.142857rem;
    width: 100%;
    position: relative;
  }

  .image-max {
    width: 28.571428rem;
    height: 28.571428rem;
    border: 1px solid #fff;
  }

  .image-max img {
    width: 100%;
  }

  .image-min-box {
    height: 7.142857rem;
    width: 100%;
    overflow-x: auto;
    overflow-y: hidden;
    justify-content: space-between;
    white-space: nowrap;
    padding: 0 2rem;
    box-sizing: border-box;
    position: relative;
  }

  .image-min-box::-webkit-scrollbar {
    display: none;
  }

  .image {
    height: 6rem;
    width: 6rem;
    margin-top: 0.5rem;
    margin-right: 0.3rem;
    box-sizing: border-box;
  }

  .action {
    border: 0.071428rem solid #000000;
  }

  .arrow-left {
    background: url(../../../assets/images/feel3.png) no-repeat #fff center;
    position: absolute;
    left: 0;
    top: 0;
    width: 1.5rem;
    height: 98%;
    z-index: 10;
    border: 1px solid #dedede;
  }

  .arrow-right {
    background: url(../../../assets/images/feel4.png) no-repeat #fff center;
    position: absolute;
    right: 0;
    top: 0;
    width: 1.5rem;
    height: 98%;
    z-index: 10;
    border: 1px solid #dedede;
  }
</style>
