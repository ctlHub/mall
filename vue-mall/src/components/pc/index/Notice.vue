<template>
  <div class="list">
    <div class="title">
      <span>新闻公告</span>
      <router-link :to="{name:'NewsIndex'}">
        更多<img src="../../../assets/images/more_right.png">
      </router-link>
    </div>
    <div id="box">
      <div id="con1" ref="con1" @mouseenter="mEnter" @mouseleave="mLeave">
        <div v-for='(item,index) in items' :key="index" class="bodyItem">
          <a @click="detail(item)">
            <img src="../../../assets/images/新闻箭头指示.png" />
            {{item.title}}
          </a>
        </div>
      </div>
    </div>
    <!-- <div class="title">
      <span>买家中心</span>
      <router-link to="/">
        进入<img src="../../../assets/images/more_right.png">
      </router-link>
    </div>
    <div class="credit_block">
      <div @click="shopping ()">
        <el-badge :value="shoppingNum" :max="99" class="item">
          <img src="../../../assets/images/购物车.png">
        </el-badge>
        我的购物车
      </div>
      <div @click="collection ()">
        <el-badge :value="collectionNum" :max="99" class="item">
          <img src="../../../assets/images/收藏.png">
        </el-badge>
        我的收藏
      </div>
    </div> -->
    <div class="serviceBox">
      <img src="../../../assets/images/电话.png">
      <div>
        <span>客服电话</span>
        <span>18826963739</span>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        items: [ // 消息列表对应的数组
          {
            title: '公告',
            noticeId: 0
          }
        ],
        moreUrl: '/',
        newsIndex: 'newsIndex',
        shoppingNum: 2,
        collectionNum: 10,
        newHeight: 0,
        newScroll: null
      }
    },
    created() {
      if (this.NoticeConfig.items) {
        this.items = this.NoticeConfig.items
      }
      this.shoppingNum = this.NoticeConfig.shoppingNum
      this.collectionNum = this.NoticeConfig.collectionNum
      if (!this.newScroll) {
        this.newScroll = setInterval(this.scroll, 10)
      }
    },
    props: {
      NoticeConfig: {
        items: Array,
        shoppingNum: Number,
        collectionNum: Number
      }
    },
    watch: {
      NoticeConfig: {
        deep: true,
        handler(newVal, oldVal) {
          this.shoppingNum = newVal.shoppingNum
          this.collectionNum = newVal.collectionNum
        }
      },
      'NoticeConfig.items': {
        deep: true,
        handler(newVal, oldVal) {
          if (newVal) {
            this.items = newVal
          }
        }
      }
    },
    methods: {
      scroll() {
        const con1 = this.$refs.con1
        if (this.items.length > 10 && con1) {
          this.newHeight = this.newHeight - 0.2
          con1.style.marginTop = `${this.newHeight}px`
          if (this.newHeight <= -28) {
            this.newHeight = 0
            this.$refs.con1.style.marginTop = this.newHeight
            this.items.push(this.items[0])
            this.items.shift()
          }
        }
      },
      mEnter() {
        clearInterval(this.newScroll)
        this.newScroll = null
      },
      mLeave() {
        if (!this.newScroll) {
          this.newScroll = setInterval(this.scroll, 10)
        }
      },
      shopping() {
        this.$router.push('/')
      },
      collection() {
        this.$router.push('/')
      },
      detail(item) {
        this.$router.push({
          name: 'NewsDetail',
          query: {
            uid: item.noticeId
          }
        })
      }
    }
  }
</script>

<style scoped>
  .list {
    width: 17.857142rem;
    height: 28.571428rem;
    background: #fff;
    z-index: 33;
    border: 1px solid #e6e6e6;
    padding: 0 0.714285rem;
  }

  #box {
    width: 17.857142rem;
    height: 19.714285rem;
    overflow: hidden;
    transition: all 0.5s;
    padding-bottom: 0.357142rem;
    border-bottom: 0.071428rem solid #e6e6e6;
  }

  .title {
    background-color: #FFFFFF;
    width: 100%;
    height: 3.214285rem;
    display: -webkit-box;
    display: -ms-flexbox;
    display: -moz-box;
    display: -webkit-flex;
    display: flex;
    justify-content: space-between;
    -webkit-align-items: center;
    align-items: center;
  }

  .title span,
  .title a {
    color: #666;
    font-size: 1.142857rem;
    cursor: pointer;
  }

  .bodyItem {
    height: 2rem;
  }

  .bodyItem a {
    width: 100%;
    display: -webkit-box;
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 1;
    overflow: hidden;
    color: #666;
    cursor: pointer;
  }

  .title a>img {
    margin-left: 5px;
    margin-top: -2px;
  }

  .credit_block {
    width: 100%;
    height: auto;
    display: -webkit-box;
    display: -ms-flexbox;
    display: -moz-box;
    display: -webkit-flex;
    display: flex;
    justify-content: space-between;
    -webkit-align-items: center;
    align-items: center;
    padding-bottom: 10px;
    border-bottom: 1px solid #e6e6e6;
  }

  .credit_block>div {
    width: 50%;
    height: auto;
    text-align: center;
    position: relative;
    cursor: pointer;
  }

  .credit_block .item {
    display: block;
    width: 100%;
    height: auto;
    text-align: center;
    position: relative;
    cursor: pointer;
  }

  .credit_block>div:first-child {
    background: url("../../../assets/images/line.png") no-repeat right center scroll;
    background-size: 1px 5rem;
  }

  .credit_block .item img {
    width: 2.714285rem;
    height: 2.714285rem;
    display: block;
    margin: 3px auto;
  }

  .item {
    width: 2.714285rem !important;
    margin: 0 auto;
  }

  .serviceBox {
    width: 100%;
    height: auto;
    display: -webkit-box;
    display: -ms-flexbox;
    display: -moz-box;
    display: -webkit-flex;
    display: flex;
    justify-content: flex-start;
    -webkit-align-items: center;
    align-items: center;
    margin-top: 15px;
  }

  .serviceBox>div>span {
    display: block;
    font-size: 16px;
    font-weight: bold;
    color: #6BCAFD;
  }

  .serviceBox>div>span:first-child {
    color: #666;
  }

  .serviceBox>div {
    background: url("../../../assets/images/line.png") no-repeat left center scroll;
    background-size: 1px 37px;
    margin-left: 10px;
    padding-left: 12px;
  }
</style>
