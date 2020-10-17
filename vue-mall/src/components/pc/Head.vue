<template>
  <div class="header-root">
    <header class="clear header">
      <nav>
        <div class="header-left">
          <el-breadcrumb separator="/" class="breadcurmb">
            <el-breadcrumb-item v-for="(item, index) in navigation.breadcrumb" :to="item.path" :key="index">{{item.name}}</el-breadcrumb-item>
          </el-breadcrumb>
        </div>
        <div class="header-right">
          <ul>
            <li v-for="(item, index) in navigation.opera" :key="index">
              <a v-if="item.routerName === '#'" @click="$message.warning('请登录')">{{item.title}}</a>
              <router-link :to="{name:item.routerName}" :class="getClass(item.title)" v-else>{{item.title}}</router-link>
            </li>
          </ul>
        </div>
      </nav>
    </header>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        linkName: '',
        navigation: {
          breadcrumb: [{
            name: '首页',
            path: '/'
          }],
          opera: [{
              title: '在线商城',
              routerName: 'IndexMain'
            },
            {
              title: '我的订单',
              routerName: '#'
            },
            {
              title: '对账单',
              routerName: '#'
            },
            {
              title: '个人中心',
              routerName: '#'
            }
          ]
        }
      }
    },
    created() {
      this.navigation.breadcrumb = this.breadcrumb
      if (this.pageName) {
        this.linkName = this.pageName
      }
      if (!window.sessionStorage.getItem('corpNoName')) {
        this.getCorpNoName(this.$route.params.corpNo)
      }
    },
    props: {
      breadcrumb: Array,
      pageName: String
    },
    watch: {
      breadcrumb: {
        deep: true,
        handler(newVla, oldVal) {
          this.navigation.breadcrumb = newVla
        }
      },
      pageName: {
        deep: true,
        handler(newVla, oldVal) {
          if (newVla) {
            this.linkName = newVla
          }
        }
      }
    },
    methods: {
      getClass(name) {
        return this.linkName === name ? 'select' : ''
      },
      async getCorpNoName(corpNo) {
        console.log(this.navigation.breadcrumb)
        let name = ''
        const res = await this.$service.getListMerchant()
        if (res.result) {
          res.data.forEach(item => {
            if (item.corpNo === corpNo) {
              name = item.name
              this.navigation.breadcrumb[1].name = name
              return name
            }
          })
        }
        window.sessionStorage.setItem('corpNoName', name)
      }
    }
  }
</script>

<style lang="less" scoped="scoped">
  @headHeight : 4.285714rem;
  @header-right: 33rem;

  .header-root {
    height: @headHeight;
  }

  .header {
    height: @headHeight;
    background-color: #dedede;
    position: fixed;
    width: 100%;
    z-index: 100;
  }

  .header nav {
    max-width: 97.571428rem;
    margin: 0 auto;
  }

  .header-left {
    width: calc(100% - @header-right);
    display: inline-block;
    height: @headHeight;
    line-height: @headHeight;
  }

  .header-right {
    display: inline-block;
    height: @headHeight;
    line-height: @headHeight;
    float: right;
  }

  .breadcurmb {
    line-height: @headHeight  !important;
    font-size: 1rem !important;
  }

  .header-right ul {
    float: right;
    padding-left: 5.5rem;
  }

  .header-right ul li {
    float: left;
    height: @headHeight;
    line-height: @headHeight;
    color: #0f6cb4;
  }

  .header-right a {
    color: #fff;
    border-right: 1px solid #fff;
    display: inline-block;
    height: 1rem;
    line-height: 1rem;
    padding-right: 0.7rem;
    margin-left: 0.7rem;
  }

  .header-right li:last-child a {
    border-right: 0;
  }

  .header-right {
    background-image: linear-gradient(45deg, transparent 60px, #0F658D 0);
  }

  .select {
    color: #4EC1F5 !important;
  }
</style>
