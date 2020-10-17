<template>
  <div>
    <van-nav-bar fixed placeholder :title="navBarConfig.title" @click-left="onClickLeft" @click-right="onClickRight"
      class="nav-bar" v-show="headAndBottomShow">
      <template #left v-if="navBarConfig.left">
        <van-icon :name="' iconfont ' + navBarConfig.leftIcon" size="14" />
      </template>
      <template #right v-if="navBarConfig.right">
        <van-icon :name="' iconfont ' + navBarConfig.rightIcon" size="25" />
      </template>
    </van-nav-bar>
    <router-view ref="router" @setNavBar="setNavBar" @setHeadAndBottomShow="setHeadAndBottomShow"></router-view>
    <van-tabbar route active-color="#16D18F" inactive-color="#999" :placeholder="true" v-show="headAndBottomShow">
      <van-tabbar-item replace :to="{name:'IndexPhone'}" icon=" iconfont ditengshouye">商城首页</van-tabbar-item>
      <van-tabbar-item replace :to="{name:'SearchPhone'}" icon=" iconfont ditengleimupinleifenleileibie">商品查询</van-tabbar-item>
      <van-tabbar-item replace :to="{name:'ShopCart'}" icon=" iconfont ditenggouwuche">购物车</van-tabbar-item>
      <van-tabbar-item replace :to="{name:'Order'}" icon=" iconfont ditengYDUI-wodedingdan">订单</van-tabbar-item>
      <van-tabbar-item replace :to="{name:'MyPage'}" icon=" iconfont ditengwode">我的</van-tabbar-item>
    </van-tabbar>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        navBarConfig: {
          title: '在线商城',
          left: true,
          right: true,
          leftIcon: 'ditengqiehuan',
          rightIcon: 'ditengxinxi'
        },
        headAndBottomShow: true
      }
    },
    beforeRouteUpdate(to, from, next) {
      this.headAndBottomShow = to.name !== 'ProductDetailPhone'
      next()
    },
    methods: {
      onClickLeft() {
        this.$router.push({
          name: 'MallIndexPhone'
        })
      },
      onClickRight() {
        try {
          this.$refs.router.onClickRight()
        } catch (e) {
          console.error('没有设置右侧回调方法')
        }
      },
      setNavBar(navBarConfig) {
        this.navBarConfig = navBarConfig
      },
      setHeadAndBottomShow(show) {
        this.headAndBottomShow = show
      }
    }
  }
</script>

<style>
  .ditengshouye,
  .ditengleimupinleifenleileibie,
  .ditenggouwuche,
  .ditengYDUI-wodedingdan,
  .ditengwode {
    font-size: 1.5rem !important;
  }

  .van-tabbar__placeholder {
    height: 3.571428rem !important;
  }

  .nav-bar {
    height: 3.2rem !important;
  }

  .nav-bar .van-nav-bar {
    background-color: #16D18F !important;
  }

  .van-nav-bar__title {
    color: #fff !important;
    font-size: 1.3rem;
  }

  .nav-bar .van-icon {
    color: #fff !important;
  }
</style>
