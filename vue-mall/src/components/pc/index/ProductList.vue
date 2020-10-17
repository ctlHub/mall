<template>
  <el-row :gutter="gutter" class="item">
    <el-col :span="25" v-for="(item, index) in list" :key="index" class="row-col5">
      <el-card :body-style="{ padding: '0px' }">
        <div class="image-box" @click="detail(item)">
          <el-image :src="item.imgUrl" class="image" lazy>
            <div slot="error" class="image-slot">
              <i class="el-icon-picture-outline"></i>
            </div>
          </el-image>
          <span v-if="item.classify == 1" class="sales-model">
            <i class="sales7">型号</i>
          </span>
          <span class="sales-class">
            <i :class="'sales' + item.salesStatus"></i>
          </span>
        </div>
        <div class="info-box">
          <span>{{item.descSpec}}</span>
          <div class="bottom clearfix">
            <span class="unit">单位：<i style="color:#058FCA">{{item.unit}}</i></span>
            <span class="list-up">
              销售：<i style="color:#058FCA">{{item.listUp}}</i>
            </span>
            <el-button type="text" class="button"></el-button>
          </div>
        </div>
      </el-card>
    </el-col>
  </el-row>
</template>

<script>
  export default {
    data() {
      return {
        gutter: 10,
        url: 'ProductDetail'
      }
    },
    props: {
      list: Array,
      gutterNum: Number,
      routreName: String
    },
    created() {
      if (this.$XEUtils.isNumber(this.gutterNum)) {
        this.gutter = this.gutterNum
      }
      if (this.routreName) {
        this.url = this.routreName
      }
    },
    methods: {
      detail(item) {
        this.$router.push({
          name: this.url,
          query: {
            partCode: item.code
          }
        })
      }
    }
  }
</script>

<style scoped>
  .item>>>.row-col5 {
    margin-bottom: 0.8rem;
    position: relative;
  }

  i {
    font-style: normal;
  }

  .bottom {
    margin-top: 13px;
    line-height: 12px;
  }

  .button {
    padding: 0;
    float: right;
  }

  .image {
    width: 18.8rem;
    height: 16.2rem;
    display: block;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }

  .clearfix button {
    background: url(../../../assets/images/addShopping.png) no-repeat scroll center center;
    background-size: 2.5em 2.5em;
    height: 2.5rem;
    width: 2.5rem;
  }

  .clearfix:after {
    clear: both
  }

  .image-box {
    position: relative;
  }

  .sales-model {
    position: absolute;
    bottom: 0;
    left: 0;
  }

  .sales-class {
    position: absolute;
    top: 0;
    right: 0;
  }

  .sales-class i {
    display: block;
    width: 3.5rem;
    height: 3.5rem;
  }

  .sales7 {
    display: inline-block;
    width: 3em;
    height: 3em;
    line-height: 3.6em;
    -webkit-border-top-right-radius: 3em;
    border-top-right-radius: 3em;
    background: #0066CC;
    color: #fff;
    font-size: 0.85em;
    padding-left: 0.3em;
  }

  .sales1 {
    background: url(../../../assets/images/sales1.png) no-repeat right center scroll;
    background-size: 3.5em 3.5em;
  }

  .sales2 {
    background: url(../../../assets/images/sales2.png) no-repeat right center scroll;
    background-size: 3.5em 3.5em;
  }

  .sales3 {
    background: url(../../../assets/images/sales3.png) no-repeat right center scroll;
    background-size: 3.5em 3.5em;
  }

  .sales4 {
    background: url(../../../assets/images/sales4.png) no-repeat right center scroll;
    background-size: 3.5em 3.5em;
  }

  .sales6 {
    background: url(../../../assets/images/sales6.png) no-repeat right center scroll;
    background-size: 3.5em 3.5em;
  }

  .info-box {
    padding: 0.6rem;
  }

  .info-box>span {
    font-weight: bold;
    width: 17.6rem;
    word-break: break-all;
    word-wrap: break-word;
    display: block;
    display: -webkit-box;
    /*作为弹性伸缩盒子模型显示*/
    -webkit-line-clamp: 2;
    /*显示的行数；如果要设置2行加...则设置为2*/
    overflow: hidden;
    /*超出的文本隐藏*/
    text-overflow: ellipsis;
    /* 溢出用省略号*/
    -webkit-box-orient: vertical;
    /*伸缩盒子的子元素排列：从上到下*/
    height: 3rem;
  }

  .clearfix span {
    font-size: 0.9rem;
    line-height: 1.3rem;
  }

  .unit {
    display: block;
  }

  .list-up {
    display: block;
  }

  >>>.image-slot {
    width: 100%;
    height: 18rem;
    text-align: center;
    line-height: 18rem;
  }

  .el-icon-picture-outline {
    font-size: 3rem;
  }
</style>
