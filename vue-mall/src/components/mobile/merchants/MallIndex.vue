<template>
  <div>
    <van-nav-bar fixed placeholder :title="navBarConfig.title" class="nav-bar">
      <template #left v-if="navBarConfig.left">
        <van-icon :name="' iconfont ' + navBarConfig.leftIcon" size="14" />
      </template>
      <template #right v-if="navBarConfig.right">
        <van-icon :name="' iconfont ' + navBarConfig.rightIcon" size="25" />
      </template>
    </van-nav-bar>
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
  export default {
    methods: {
      onClick(item) {
        window.sessionStorage.setItem('corpNo', item.corpNo)
        window.sessionStorage.setItem('corpNoName', item.name)
        this.$router.push(`/mobile/${item.corpNo}/index`)
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
          name: '地藤商城',
          imgUrl: '',
          corpNo: '911001'
        }],
        breadcrumb: [{
          name: '首页',
          path: ''
        }],
        pageName: '在线商城',
        navBarConfig: {
          title: '请选择商家',
          left: false,
          right: false,
          leftIcon: 'ditengqiehuan',
          rightIcon: 'ditengxinxi'
        }
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
    margin: 0 auto;
    text-align: center;
  }

  .el-image {
    width: calc(@height * 3.11667);
    height: @height;
    display: inline-block;
    margin-right: 2rem;
    margin-top: 1rem;
  }

  .title {
    text-align: center;
    font-size: 2rem;
    margin-top: 1rem;
    color: blue;
  }
</style>
