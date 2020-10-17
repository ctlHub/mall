<template>
  <div>
    <van-row class="main">
      <van-col span="5" class="van-col-left">
        <van-sidebar v-model="activeKey">
          <van-sidebar-item :title="'标签名词'" v-for="(item) in 30" :key="'标签名称' + item" @click="sidebar" />
        </van-sidebar>
      </van-col>
      <van-col span="19" class="van-col-right">
        <div class="my-swipe">
          <div class="swipe-background-color"></div>
          <van-swipe :autoplay="3000" indicator-color="white">
            <van-swipe-item v-for="(item,index) in imgs" :key="index">
              <img :src="item" class="image" />
            </van-swipe-item>
          </van-swipe>
        </div>
        <div :class="activeKey === 0?'class2 class3':'class2'" v-for="(item,index) in classList" :key="index">
          <div class="title">
            {{item.name}}
            <van-icon name=" iconfont ditengarrow-right-ico" />
          </div>
          <van-row>
            <van-col span="8" class="van-col-left" v-for="(goods,index) in item.list" :key="index">
              {{goods}}
            </van-col>
          </van-row>
        </div>
        <div class="goods" v-if="activeKey !== 0">
          <van-row>
            <van-col span="12" v-for="(item,index) in goodsList" :key="index">
              <div class="item" :style="'background: url(' + item.imgUrl + ')no-repeat center /cover'">
              </div>
            </van-col>
          </van-row>
        </div>
      </van-col>
    </van-row>
  </div>
</template>

<script>
  export default {
    data () {
      return {
        navBarConfig: {
          title: '商品分类',
          left: true,
          right: true,
          leftIcon: 'ditengfanhui',
          rightIcon: 'ditengxinxi'
        },
        activeKey: 0,
        imgs: [
          'https://vinefiles.oss-cn-hangzhou.aliyuncs.com/enclosure/131001/null/pc/{0b87840a-b83b-4216-b1e5-01c33209371a}.jpg?x-oss-process=image/resize,h_400',
          'https://vinefiles.oss-cn-hangzhou.aliyuncs.com/enclosure/131001/null/pc/{0b87840a-b83b-4216-b1e5-01c33209371a}.jpg?x-oss-process=image/resize,h_400',
          'https://vinefiles.oss-cn-hangzhou.aliyuncs.com/enclosure/131001/null/pc/{0b87840a-b83b-4216-b1e5-01c33209371a}.jpg?x-oss-process=image/resize,h_400'
        ],
        classList: [{
          name: '配节',
          list: ['中空', '通感', '通感', '通感', '通感', '通感', '通感', '通感', '通感', '通感', '通感', '通感', '通感', '通感', '通感', '通感']
        }, {
          name: '配节',
          list: ['中空', '通感', '通感', '通感', '通感', '通感', '通感', '通感', '通感', '通感', '通感', '通感', '通感', '通感', '通感', '通感']
        }, {
          name: '配节',
          list: ['中空', '通感', '通感', '通感', '通感', '通感', '通感', '通感', '通感', '通感', '通感', '通感', '通感', '通感', '通感', '通感']
        }, {
          name: '配节',
          list: ['中空', '通感', '通感', '通感', '通感', '通感', '通感', '通感', '通感', '通感', '通感', '通感', '通感', '通感', '通感', '通感']
        }],
        goodsList: [{
          imgUrl: 'https://vinefiles.oss-cn-hangzhou.aliyuncs.com/enclosure/131001/null/pc/{0b87840a-b83b-4216-b1e5-01c33209371a}.jpg?x-oss-process=image/resize,h_400',
          partCode: '123123',
          supCode: '12312312'
        }, {
          imgUrl: 'https://vinefiles.oss-cn-hangzhou.aliyuncs.com/enclosure/131001/null/pc/{0b87840a-b83b-4216-b1e5-01c33209371a}.jpg?x-oss-process=image/resize,h_400',
          partCode: '123123',
          supCode: '12312312'
        }, {
          imgUrl: 'https://vinefiles.oss-cn-hangzhou.aliyuncs.com/enclosure/131001/null/pc/{0b87840a-b83b-4216-b1e5-01c33209371a}.jpg?x-oss-process=image/resize,h_400',
          partCode: '123123',
          supCode: '12312312'
        }]
      }
    },
    created () {
      this.$emit('setNavBar', this.navBarConfig)
    },
    methods: {
      onClickLeft () {
        this.$router.push('/mobile')
      },
      onClickRight () {
        this.show = true
      },
      sidebar () {
        console.log(this.activeKey)
      }
    }
  }
</script>

<style lang="less" scoped>
  @my-swipe-height: 9.142857rem;
  @class2height: 12rem;
  @mainHeight: calc(100vh - 3.2rem - 3.58rem);
  @goodsHeight: calc(@mainHeight - @class2height - @my-swipe-height - 4.6rem);

  .main {
    display: block;
    height: @mainHeight;
  }

  .van-col-left,
  .van-col-right {
    overflow: hidden;
    overflow-y: auto;
    height: 100%;
  }

  .van-sidebar-item {
    background-color: #fff !important;
  }

  .van-sidebar-item--select {
    background-color: #f5f5f5 !important;
    color: #16D18F;
  }

  .van-swipe {
    width: 90%;
    margin: 0 auto;
    margin-top: 0.5rem;
  }

  .class2 {
    margin: 0.7rem;
    background-color: #fff;
    padding: 0.5rem 1rem;
    color: #666;
    height: @class2height;
  }

  .class2 .title {
    font-size: 1.2rem;
    font-weight: bold;
    color: #000;
    margin-bottom: 0.5rem;
  }

  .class2 .van-row {
    overflow: hidden;
    overflow-y: auto;
    height: 10rem;
  }

  .class2 .van-col {
    text-align: center;
    margin-bottom: 0.8rem;
    height: 1.7rem;
  }

  .my-swipe {
    height: @my-swipe-height;
  }

  .goods {
    height: @goodsHeight;
    margin: 0.7rem;
    background-color: #fff;
    padding: 0.5rem;
    overflow: hidden;
    overflow-y: auto;
  }

  .van-image {
    padding: 0.3rem;
  }

  .goods .item {
    width: 95%;
    padding-bottom: 95%;
    height: 0;
    margin-bottom: 0.5rem;
    background-size: 100% 100% !important;
  }

  .class3 {
    height: auto;
  }

  .class3 .van-row {
    overflow: auto;
    height: auto;
  }
</style>
