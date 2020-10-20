<template>
  <div class="class-select">
    <div class="class-block">
      商品类别
    </div>
    <div class="class-list">
      <el-popover placement="right-start" width="400" :visible-arrow="false" trigger="hover" :close-delay="50"
        :popper-class="items" v-for="classItem in classData" :key="classItem.className" class="popper-item">
        <el-link type="info" v-for="(item,index) in classItem.subClass" :key="classItem.className +'_'+index" class="link"
          @click="onClick(classItem.className,item.className)">
          {{item.className}}
        </el-link>
        <el-button slot="reference" @click="onClick(classItem.className)">
          <img :src="classItem.imgSrc?classItem.imgSrc:imgSrc" />
          {{classItem.className}}
        </el-button>
      </el-popover>
    </div>
  </div>
</template>
<script>
  export default {
    data() {
      return {
        classData: [],
        items: 'buttom',
        imgSrc: require('@/assets/images/其它.png'),
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
      ClassSelectConfig: Array
    },
    created() {
      if (this.ClassSelectConfig) {
        this.classData = this.ClassSelectConfig
      }
    },
    watch: {
      // 父组件变更子组件值跟着变更
      ClassSelectConfig: {
        deep: true,
        handler(newVal, oldVal) {
          if (newVal) {
            this.classData = newVal
          }
        }
      }
    },
    methods: {
      onClick(className, subClassName) {
        this.formSearch.class1 = className
        if (subClassName) {
          this.formSearch.class2 = subClassName
        }
        this.$emit('search', this.formSearch)
      }
    }
  }
</script>
<style>
  .el-popper[x-placement^=right] {
    margin-left: 0 !important;
    top: 16rem !important;
    height: 23.2rem;
    overflow: hidden;
    overflow-y: auto;
  }
</style>
<style scoped="scoped">
  .el-popover {
    min-height: 7.142857rem;
  }

  .class-select {
    width: 17.857142rem;
    height: 28.571428rem;
  }

  .class-list {
    overflow: hidden;
    overflow-y: auto;
    height: calc(100% - 3.571428rem);
    background-color: white;
  }

  .class-block {
    display: block;
    width: 100%;
    height: 3.571428rem;
    line-height: 3.571428rem;
    text-align: center;
    background: #379AD0;
    color: #fff;
    font-size: 18px;
    font-family: MicrosoftYaHei-Bold;
    font-weight: bold;
  }

  .el-button {
    width: 50%;
    border-radius: 0 !important;
    padding: 0.8rem 0;
    padding-left: 0.5em;
    text-align: left;
  }

  .el-button img {
    vertical-align: middle;
    width: 2.4rem;
    height: 2.4rem;
  }

  .link {
    width: 26.33%;
    display: inline-block;
    height: 1.3rem;
    line-height: 1.3rem;
    border-left: 1px solid;
    padding-left: 0.5rem;
    margin: 0.5em 0;
  }

  .popper-item button {
    border-right: 1px solid #379AD0;
    border-bottom: 1px solid #379AD0;
    color: #379AD0;
  }
</style>
