<template>
  <div style="background-color: white;">
    <div class="shopSearchBox">
      <div>
        <img :src="logoImg" />
      </div>
      <div>
        <el-form :inline="true" :model="formSearch">
          <el-form-item prop="searchText">
            <el-input placeholder="请输入品名或规格进行搜索" v-model="formSearch.searchText" class="input-with-select">
              <el-button slot="append" icon="el-icon-search" @click="search()">搜索</el-button>
            </el-input>
            <span class="expert" @click="expert">高级搜索</span>
            <div>
              <el-tag v-if="formSearch.brand !== ''" closable @close="tagClose('brand')">品牌：{{formSearch.brand}}</el-tag>
              <el-tag v-if="formSearch.class1 !== ''" closable @close="tagClose('class1')">大类：{{formSearch.class1}}</el-tag>
              <el-tag v-if="formSearch.class2 !== ''" closable @close="tagClose('class2')">中类：{{formSearch.class2}}</el-tag>
              <el-tag v-if="formSearch.salesStatus > -1" closable @close="tagClose('salesStatus')">推荐：{{shopTitle[formSearch.salesStatus]}}</el-tag>
              <el-tag v-if="clear()" closable @close="reset()">清空条件</el-tag>
            </div>
          </el-form-item>
        </el-form>
      </div>
      <div id="boxExit" class="proSearch_shoppingCart" @click="rightButtonClick()">
        <img :src="rightButton.imgUrl">
        <span> | {{rightButton.name}}{{this.$XEUtils.isNumber(rightButton.num)?'('+rightButton.num+')':''}}</span>
      </div>

      <el-dialog title="高级搜索" :visible.sync="dialogVisible">
        <el-collapse v-model="activeNames" class="search">
          <el-collapse-item title="品牌" name="1">
            <span v-for="(item,index) in listBrand" :key="index" @click="select('brand', item.name)" :class="formSearch.brand === item.name?'select':''">
              {{item.name}}
            </span>
          </el-collapse-item>
          <el-collapse-item title="大类" name="2">
            <span v-for="(item,index) in listClass" :key="index" @click="select('class1', item.className)" :class="formSearch.class1 === item.className?'select':''">
              {{item.className}}
            </span>
          </el-collapse-item>
          <el-collapse-item title="中类" name="3">
            <span v-for="(item,index) in listSubClass" :key="index" @click="select('class2', item.className)" :class="formSearch.class2 === item.className?'select':''">
              {{item.className}}
            </span>
          </el-collapse-item>
          <el-collapse-item title="推荐" name="4">
            <span v-for="(value, key, index) in shopTitle" :key="index" @click="select('salesStatus', key)" :class="formSearch.salesStatus === key?'select':''">
              {{value}}
            </span>
          </el-collapse-item>
        </el-collapse>
        <span slot="footer" class="dialog-footer">
          <el-button @click="reset()">重置</el-button>
          <el-button type="primary" @click="confirm()">确定</el-button>
        </span>
      </el-dialog>
    </div>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        shopTitle: {
          98: '置顶',
          1: '新品',
          2: '热销',
          3: '特价',
          4: '经典',
          99: '促销'
        },
        listBrand: [],
        listClass: [],
        listSubClass: [],
        activeNames: ['1', '2', '3', '4'],
        dialogVisible: false,
        formSearch: {
          searchText: '',
          brand: '',
          class1: '',
          class2: '',
          salesStatus: -1
        },
        rightButton: {
          imgUrl: require('../../../assets/images/登录.png'),
          name: '登陆',
          path: '/'
        },
        logoImg: ''
      }
    },
    created() {
      if (this.SearchConfig.hotList) {
        this.hotSearch = this.SearchConfig.hotList
      }
      if (this.SearchConfig.rightButton && this.$MYUtils.isLogin()) {
        this.rightButton = this.SearchConfig.rightButton
      }
      if (this.SearchConfig.logoImg) {
        this.logoImg = this.SearchConfig.logoImg
      }
      if (this.SearchConfig.formSearch) {
        this.formSearch = this.SearchConfig.formSearch
        if (this.formSearch.class2 !== '') {
          this.getSubClass(this.formSearch.class1)
        }
      }
      this.getMerchantInfo()
    },
    props: {
      SearchConfig: Object
    },
    watch: {
      SearchConfig: {
        deep: true,
        handler(newVal, oldVal) {
          if (newVal.hotList) {
            this.hotSearch = newVal.hotList
          }
          if (newVal.rightButton) {
            this.rightButton = newVal.rightButton
          }
          if (newVal.logoImg) {
            this.logoImg = newVal.logoImg
          }
          if (newVal.formSearch) {
            this.formSearch = newVal.formSearch
            if (this.formSearch.class2 !== '') {
              this.getSubClass(this.formSearch.class1)
            }
          }
        }
      },
      'formSearch.class1': {
        handler(newVal, oldVal) {
          if (newVal === '') {
            this.formSearch.class2 = ''
            this.listSubClass = []
          }
        }
      }
    },
    methods: {
      rightButtonClick() {
        this.$message.warning('待开放')
        // if (this.rightButton.path === '/logout') {
        //   this.$router.push('/login')
        // } else {
        //   this.$router.push(this.rightButton.path)
        // }
      },
      search(formName) {
        this.$emit('search', this.formSearch)
      },
      hotClick(formName, searchText) {
        this.formSearch.searchText = searchText
        this.search(formName)
      },
      async expert() {
        this.dialogVisible = true
        const brandRes = await this.$service.getListBrand()
        if (brandRes.result) {
          this.listBrand = brandRes.data
        }
        const classRes = await this.$service.getPersonClass()
        if (classRes.result) {
          this.listClass = classRes.data
        }
      },
      async getSubClass(className) {
        const res = await this.$service.getPersonSubClass(className)
        if (res.result) {
          this.listSubClass = res.data
        } else {
          this.$message.error(res.message)
        }
      },
      async getMerchantInfo() {
        const res = await this.$service.getMerchantInfo()
        if (res.result) {
          this.logoImg = res.data.logo
        }
      },
      select(formVal, newVla) {
        if (this.formSearch[formVal] === newVla) {
          if (formVal === 'salesStatus') {
            this.formSearch[formVal] = 0
          } else {
            this.formSearch[formVal] = ''
          }
        } else {
          this.formSearch[formVal] = newVla
          if (formVal === 'class1') {
            this.getSubClass(newVla)
          }
        }
      },
      reset() {
        this.formSearch.class1 = ''
        this.formSearch.class2 = ''
        this.formSearch.brand = ''
        this.formSearch.salesStatus = -1
        this.search()
      },
      confirm() {
        this.dialogVisible = false
        this.search()
      },
      clear() {
        return this.formSearch.class1 !== '' ||
          this.formSearch.class2 !== '' ||
          this.formSearch.brand !== '' ||
          this.formSearch.salesStatus !== -1
      },
      tagClose(key) {
        if (key === 'salesStatus') {
          this.formSearch.salesStatus = -1
        } else {
          this.formSearch[key] = ''
        }
        this.search()
      }
    }
  }
</script>

<style scoped="scoped">
  .input-with-select {
    width: 27.857142rem !important;
  }

  .link {
    margin-right: 0.5rem;
    color: #9a9a9a;
    /* 鼠标变为手 */
    cursor: pointer
  }

  .proSearch_logo>span {
    font-size: 1.5rem;
    font-weight: bold;
    color: #2884cc;
    cursor: pointer;
  }

  .proSearch_shoppingCart,
  .proSearch_logo {
    display: -webkit-box;
    display: -ms-flexbox;
    display: -moz-box;
    display: -webkit-flex;
    display: flex;
    justify-content: center;
    -webkit-box-align: center;
    -webkit-align-items: center;
    -ms-flex-align: center;
    align-items: center;
  }

  .proSearch_shoppingCart>img,
  .proSearch_logo>img {
    max-height: 5rem;
    width: auto;
  }

  .proSearch_shoppingCart {
    min-width: 8.625rem;
    height: 2.375rem;
    background: rgba(249, 130, 71, 1);
    -webkit-border-radius: 0.1875rem;
    -moz-border-radius: 0.1875rem;
    border-radius: 0.1875rem;
    padding: 0 0.625rem;
  }

  .proSearch_shoppingCart>img {
    width: 1.5625rem;
    margin-right: 0.3125rem;
  }

  .proSearch_shoppingCart>span {
    font-size: 1.25rem;
    font-weight: 400;
    color: #fff;
    cursor: pointer;
  }

  .shopSearchBox {
    width: 100%;
    height: 6.875rem;
    margin: 0 auto;
    background: #fff;
    padding: 1.3rem 0 0;
    max-width: 97.571428rem;
    display: -webkit-box;
    display: -ms-flexbox;
    display: -moz-box;
    display: -webkit-flex;
    display: flex;
    justify-content: space-between;
    -webkit-box-align: flex-start;
    -webkit-align-items: flex-start;
    -ms-flex-align: flex-start;
    align-items: flex-start;
  }

  .expert {
    margin-left: 1rem;
    color: #0086B3;
    cursor: pointer;
  }

  >>>.el-dialog {
    width: 57.142857rem;
    height: 42.857142rem;
    overflow: hidden;
    overflow-y: auto;
  }

  .search {
    height: 29rem;
    overflow: hidden;
    overflow-y: auto;
  }

  .search span {
    display: inline-block;
    min-width: 6rem;
    height: 2.5rem;
    line-height: 2.5rem;
    margin: 0.3rem;
    text-align: center;
    box-sizing: border-box;
  }

  .select {
    border: 1px solid blue;
    color: blue;
    border-radius: 0.3rem;
    padding: 0 0.3rem;
  }

  .el-tag {
    margin-right: 0.3rem;
  }

  >>>.el-collapse-item__wrap {
    max-height: 13rem;
    overflow: hidden;
    overflow-y: auto;
  }
</style>
