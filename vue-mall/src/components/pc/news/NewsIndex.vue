<template>
  <div class="news-index">
    <Search :SearchConfig="SearchConfig" @search="search"></Search>
    <div v-if="this.$route.name === 'NewsIndex'">
      <el-row :gutter="gutter" class="item">
        <el-col :span="8" v-for="(item, index) in list" :key="index" class="news-record">
          <el-card :body-style="{ padding: '0px' }">
            <div class="image-box" @click="detail(item)">
              <el-image :src="item.newsUrl" class="image" lazy>
                <div slot="error" class="image-slot">
                  <i class="el-icon-picture-outline"></i>
                </div>
              </el-image>
            </div>
            <div class="info-box">
              <span>{{item.title}}</span>
            </div>
          </el-card>
        </el-col>
      </el-row>
      <span v-if="list.length == 0">
        <van-empty description="没有新闻" />
      </span>
      <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="page"
        :page-sizes="pageSizes" :page-size="pageSize" layout="total, sizes, prev, pager, next, jumper" :total="total"
        v-if="total > 0">
      </el-pagination>
    </div>
    <!-- 子路由显示 -->
    <router-view></router-view>
  </div>
</template>

<script>
  import Search from '../index/Search.vue'
  export default {
    components: {
      Search
    },
    data() {
      return {
        SearchConfig: {
          rightButton: {
            imgUrl: require('../../../assets/images/shopping_car.png'),
            name: '购物车',
            path: '/',
            num: 0
          }
        },
        list: [],
        loading: false,
        finished: false,
        refreshing: false,
        page: 1,
        total: 0,
        pageSize: 30,
        pageSizes: [9, 18, 24, 99],
        gutter: 10
      }
    },
    created() {
      this.initData()
    },
    methods: {
      search(data) {
        this.$router.push({
          name: 'ProductSearch',
          params: data
        })
      },
      async initData() {
        const res = await this.$service.getNewsList(this.page, this.pageSize)
        if (res.result) {
          this.list = res.data.list
          this.total = res.data.total
          this.page = res.data.pageNum
          this.pageSize = res.data.pageSize
        } else {
          this.$message.error(res.message)
        }
      },
      handleSizeChange(val) {
        this.pageSize = val
      },
      handleCurrentChange(val) {
        this.page = val
        this.search(this.SearchConfig.formSearch)
      },
      detail(item) {
        this.$router.push({
          name: 'NewsDetail',
          query: {
            uid: item.uid
          }
        })
      }
    }
  }
</script>

<style scoped>
  .news-index {
    min-height: 10rem;
    width: 97.571428rem;
    margin: 0 auto !important;
  }

  .el-pagination {
    margin: 1rem auto;
    text-align: center;
  }

  .news-record {
    height: 20rem;
    margin-top: 1rem;
  }

  .news-record div {
    height: 100%;
  }

  .image {
    height: 17rem !important;
  }

  .info-box {
    font-weight: bold;
    padding-left: 2rem;
  }
</style>
