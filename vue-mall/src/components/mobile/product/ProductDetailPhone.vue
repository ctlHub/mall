<template>
  <div>
    <div class="my-swipe">
      <div class="return" @click="onBack()">
        <van-icon name=" iconfont ditengfanhui" />
      </div>
      <van-swipe :autoplay="3000" indicator-color="white">
        <van-swipe-item v-for="(item,index) in ProductImgs" :key="index">
          <img :src="item.url" class="image" />
        </van-swipe-item>
      </van-swipe>
    </div>
    <div>
      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>商品描述</span>
          <i class="el-icon-share" @click="onShare"></i>
        </div>
        <div class="text item">
          <span class="left">商品品牌: {{GoodsInfo.brand}}</span>
          <span>商品系列: {{GoodsInfo.class3}}</span>
        </div>
        <div class="text item">
          商品编号: {{GoodsInfo.code}}
        </div>
        <div class="text item">
          品名规格: {{GoodsInfo.descSpec}}
        </div>
        <div class="text item">
          <span class="left">单位: {{GoodsInfo.unit}}</span>
          <span>包装单位: {{GoodsInfo.boxNum}}</span>
        </div>
        <div class="text item">
          <span class="left">上市时间: {{GoodsInfo.pushMonth!==0?GoodsInfo.pushMonth:'(未知)'}}</span>
          <span>零售价格：<i>{{GoodsInfo.listUp}}</i> </span>
        </div>
      </el-card>
    </div>
    <div v-if="GoodsInfo.childGoods.length > 0">
      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>商品型号子项列表</span>
          <el-button style="float: right; padding: 3px 0" type="text" @click="showPopup">筛选</el-button>
        </div>
        <div v-for="(item,index) in GoodsInfo.childGoods" :key="index" class="goods" @click="showProduct(item)" v-show="item.show">
          <div class="text item">
            <span class="left" style="font-weight: bold;width: 100%;color: #409EFF;">
              {{index + 1}}、{{item.descSpec}}
            </span>
          </div>
          <div class="text item">
            <span class="left">
              商品类别:
              {{item.class1}}
              {{item.class2?'-'+item.class2:''}}
              {{item.class3?'-'+item.class3:''}}
            </span>
          </div>
          <div class="text item">
            <span class="left">单位: {{item.listUp}}</span>
            <span>上市时间: {{item.pushMonth!==0?item.pushMonth:'(未知)'}}</span>
          </div>
          <div class="text item">
            <span class="left">包装量: {{item.boxNum}}</span>
            <span>零售价格：<i>{{item.listUp}}</i> </span>
          </div>
        </div>
      </el-card>
      <van-popup v-model="show" position="right">
        <div class="marque-box">
          <div class="option" id="option0" style="margin-bottom: 0.3em" v-for="(item,index) in GoodsInfo.optionList"
            :key="index">
            <label>{{item.name}}：</label>
            <button type="button" ref='subItem' :value="sub" v-for="(sub,index) in item.option" :key="sub+','+index"
              @click="filterDescSpecEvent(sub,$event)">{{sub}}</button>
          </div>
          <div class="opera">
            <el-button @click="onReset" class="reset">重置</el-button>
            <el-button @click="onConfirm" class="confirm">确定</el-button>
          </div>
        </div>
      </van-popup>
    </div>
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <span>实物图片</span>
      </div>
      <div class="imageList">
        <el-image v-for="url in urls" :key="url" :src="url" lazy></el-image>
        <span v-if="urls.length == 0">
          <van-empty description="商品暂时没有说明信息" />
        </span>
      </div>
    </el-card>
    <van-share-sheet v-model="showShare" :options="options" title="立即分享给好友" @select="selectShare" />
  </div>
</template>

<script>
  export default {
    data() {
      return {
        show: false,
        partCode: '',
        GoodsInfo: {
          childGoods: [],
          optionList: []
        },
        ProductImgs: [],
        filter: [],
        urls: [],
        showShare: false,
        options: [{
            name: '微信',
            icon: 'wechat'
          },
          {
            name: '微博',
            icon: 'weibo'
          },
          {
            name: '复制链接',
            icon: 'link',
            description: ''
          },
          {
            name: '分享海报',
            icon: 'poster'
          },
          {
            name: '二维码',
            icon: 'qrcode'
          }
        ]
      }
    },
    created() {
      const code = this.$route.query.partCode
      this.initData(code)
      this.$emit('setHeadAndBottomShow', false)
    },
    beforeRouteUpdate(to, from, next) {
      if (to.query && from.query && to.query.partCode !== from.query.partCode) {
        this.initData(to.query.partCode)
      }
      next()
    },
    watch: {
      filter: {
        deep: true,
        handler(newVal, oldVal) {
          this.GoodsInfo.childGoods.forEach(item => {
            if (newVal.length === 0) {
              item.show = true
            } else {
              let show = false
              newVal.some(o => {
                if (item.descSpec.indexOf(o) > -1) {
                  show = true
                  return show
                }
              })
              item.show = show
            }
          })
        }
      }
    },
    methods: {
      initData(code) {
        this.getEshop(code)
        this.getGoodsDetail(code)
        this.getDescription(code)
      },
      showPopup() {
        this.show = true
      },
      async getEshop(code) {
        const res = await this.$service.getEshop(code)
        if (res.result) {
          res.data.forEach(item => {
            this.mallIcon[item.eshopType].url = item.eshopGoodsUrl
          })
        }
      },
      showProduct(item) {
        this.$router.push({
          name: 'ProductDetailPhone',
          query: {
            partCode: item.code
          }
        })
      },
      async getGoodsDetail(code) {
        const res = await this.$service.getGoodsDetail(code)
        if (res.result) {
          res.data.childGoods.forEach(item => {
            item.descSpec = `${item.desc},${item.spec}`
            item.show = true
          })
          const priceRange = res.data.priceRange
          if (priceRange && priceRange.minListUp !== priceRange.maxListUp) {
            res.data.listUp = `${priceRange.minListUp}-${priceRange.maxListUp}`
          }
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
      },
      async getDescription(code) {
        const res = await this.$service.getDescription(code)
        if (res.result) {
          this.urls = res.data
        }
      },
      filterDescSpecEvent(item, $event) {
        var button = $event.currentTarget
        button.className = button.className ? '' : 'selectButton'
        if (this.filter.indexOf(item) > -1) {
          this.filter.splice(this.filter.indexOf(item), 1)
        } else {
          this.filter.push(item)
        }
      },
      onReset() {
        this.filter = []
        this.$refs.subItem.forEach(item => {
          item.className = ''
        })
      },
      onConfirm() {
        this.show = false
      },
      onBack() {
        console.log(this.$router.history.length)
        if (this.$route.query.share) {
          this.$router.push({
            name: 'IndexPhone'
          })
        } else {
          this.$router.go(-1)
        }
      },
      onShare() {
        this.showShare = true
      },
      selectShare(option, index) {
        this.showShare = false
        if (option.icon === 'link') {
          const url =
            `${location.origin}/#/product-share?partCode=${this.$route.query.partCode}&corpNo=${this.$route.params.corpNo}`
          this.$copyText(url).then(e => {
            this.$message.success('分享链接复制成功，赶快分享给你的小伙伴吧')
          }, e => {
            this.$message.error('分享链接复制失败，请重新再试')
          })
        } else {
          this.$message.info('功能未开放')
        }
      }
    }
  }
</script>

<style scoped>
  .van-swipe {
    width: 100vw;
    height: 100vw;
  }

  .return {
    background: rgba(0, 0, 0, 0.6);
    width: 3rem;
    height: 3rem;
    text-align: center;
    line-height: 3rem;
    border-radius: 50%;
    margin-left: 0.5rem;
    position: fixed;
    top: 0.5rem;
    left: 0;
    z-index: 1000;
  }

  .ditengfanhui {
    color: #fff;
  }

  .clearfix {
    position: relative;
  }

  .clearfix span {
    border-left: 3px solid #058fca;
    color: #333;
    font-size: 1.2em;
    display: inline-block;
    padding-left: 0.5em;
    height: 1.1em;
    line-height: 1.1em;
    font-weight: bold;
  }

  .item {
    margin-bottom: 0.5rem;
  }

  .item .left {
    display: inline-block;
    width: 50%;
  }

  .item i {
    color: red;
  }

  .option {
    padding-left: 5.5rem;
    position: relative;
    line-height: 2.1rem;
  }

  .option button {
    border: 0;
    outline: none;
    background: #e6f4fa;
    border-radius: 0.1rem;
    -webkit-border-radius: 0.1rem;
    margin: 0 0.2rem;
    color: #058fca;
    margin-bottom: 0.3rem;
  }

  .option .selectButton {
    background: #058fca;
    color: #fff;
  }

  .option>label {
    display: inline-block;
    width: 5.5rem;
    position: absolute;
    top: 0;
    left: 0;
  }

  >>>.van-popup--right {
    top: 0;
    -webkit-transform: initial;
    transform: initial;
    padding: 1rem 1rem 4rem;
    height: calc(100vh - 5rem) !important;
    width: calc(80vw - 2rem);
  }

  .opera {
    position: fixed;
    bottom: 1.5rem;
    right: 1rem;
  }

  .opera button {
    margin-right: 1rem;
  }

  .opera .confirm {
    background: #16D18F;
    color: #FFFFFF;
  }

  .goods {
    margin-bottom: 1rem;
    border-bottom: 0.071428rem solid #DEDEDE;
  }

  .goods:last-child {
    border-bottom: 0;
  }

  .el-icon-share {
    font-size: 2.3rem;
    position: absolute;
    top: -0.5rem;
    right: 0;
    color: #2196F3;
  }
</style>
