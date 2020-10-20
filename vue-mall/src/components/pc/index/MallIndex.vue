<template>
  <div>
    <!-- 父组件breadcrumb变化自动刷新子组件 -->
    <vHead :breadcrumb="breadcrumb" :pageName="pageName"></vHead>
    <div class="mall">
      <el-image :src="item.imgUrl" @click="onClick(item)" v-for="(item,index) in merchantList" :key="index">
        <div slot="placeholder" class="image-slot">
          加载中<span class="dot">...</span>
        </div>
      </el-image>
    </div>
  </div>
</template>

<script>
  import vHead from '../Head.vue'
  export default {
    components: {
      vHead
    },
    methods: {
      onClick(item) {
        window.sessionStorage.setItem('corpNo', item.corpNo)
        window.sessionStorage.setItem('corpNoName', item.name)
        this.$router.push(`/pc/${item.corpNo}/index`)
      },
      setBreadcrumb(data) {
        this.breadcrumb = data
      },
      async getListMerchant() {
        const res = await this.$service.getListMerchant()
        if (res.result) {
          this.merchantList = []
          res.data.forEach(item => {
            this.merchantList.push({
              name: item.name,
              imgUrl: item.logo,
              corpNo: item.corpNo
            })
          })
        }
      }
    },
    data() {
      return {
        merchantList: [{
          name: '狼王商城',
          imgUrl: require('../../../assets/images/logoImg.jpg'),
          corpNo: '911001'
        }],
        breadcrumb: [{
          name: '首页',
          path: ''
        }],
        pageName: '在线商城'
      }
    },
    created() {
      window.sessionStorage.setItem('corpNo', '')
      this.getListMerchant()
    }
  }
</script>

<style lang="less" scoped="scoped">
  @height: 4.285714rem;

  .mall {
    max-width: 97.571428rem;
    margin: 0 auto;
  }

  .el-image {
    width: calc(@height * 3.11667);
    height: @height;
    display: inline-block;
    margin-right: 2rem;
    margin-top: 1rem;
  }
</style>
