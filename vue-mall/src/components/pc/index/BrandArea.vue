<template>
  <div class="collapse">
    <el-collapse accordion>
      <el-collapse-item>
        <template slot="title">
          <span class="active">
            <img src="../../../assets/images/brand.png">
            <img src="../../../assets/images/line.png">
            品牌专区
          </span>
          <div class="brand">
            <template v-for="(item,index) in brandList">
              <el-link type="primary" :key="index" v-if="index < 5" :href="item.path" @click.stop="onClick(item.name)">
                <span>{{item.name}}</span>
              </el-link>
            </template>
          </div>
        </template>
        <div class="brand brand-items">
          <el-link type="primary" v-for="(item,index) in brandList" :key="index" :href="item.path" @click="onClick(item.name)">
            <span>{{item.name}}</span>
          </el-link>
        </div>
      </el-collapse-item>
    </el-collapse>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        brandList: [{
          name: '其他'
        }],
        formSearch: {
          searchText: '',
          brand: '',
          class1: '',
          class2: '',
          salesStatus: -1
        }
      }
    },
    props: {
      BrandAreaConfig: Array
    },
    watch: {
      BrandAreaConfig: {
        deep: true,
        handler(newVal, oldVla) {
          if (newVal) {
            this.brandList = newVal
          }
        }
      }
    },
    created() {
      if (this.BrandAreaConfig) {
        this.brandList = this.BrandAreaConfig
      }
    },
    methods: {
      onClick(name) {
        this.formSearch.brand = name
        this.$emit('search', this.formSearch)
      }
    }
  }
</script>

<style>
  .collapse {
    width: 97.571428rem;
    margin: 0 auto;
  }

  .active {
    color: #379AD0;
    font-size: 20px;
    font-weight: bold;
    margin-right: 10px;
    display: -webkit-box;
    display: -ms-flexbox;
    display: -moz-box;
    display: -webkit-flex;
    display: flex;
    justify-content: space-between;
    -webkit-align-items: center;
    align-items: center;
    width: 145px;
    height: 32px;
    padding: 0 1rem;
  }

  .active>img {
    width: 32px;
    height: 32px;
  }

  .active>img:nth-child(2) {
    height: 32px;
    width: 1px;
  }

  .brand span {
    display: inline-block;
    min-width: 11rem;
    height: 2.5rem;
    line-height: 2.5rem;
  }

  .brand-items {
    padding: 0 1rem;
  }
</style>
