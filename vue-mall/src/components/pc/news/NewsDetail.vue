<template>
  <div>
    <div class="news_detail">
      <label>{{title}}</label>
      <span>{{appDate}}</span>
      <div>
        <span>
          <p v-html="content"></p>
        </span>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        title: '',
        content: '',
        appDate: ''
      }
    },
    created() {
      this.initData()
    },
    methods: {
      async initData() {
        const res = await this.$service.getNewsDetail(this.$route.query.uid)
        if (res.result) {
          this.title = res.data.title
          this.content = res.data.value
          this.appDate = res.data.appDate
        } else {
          this.$message.error(res.message)
        }
      }
    }
  }
</script>

<style scoped>
  .news_detail {
    width: 100%;
    height: auto;
    padding: 10px;
    background: #fff;
    margin-top: 1rem;
    box-sizing: border-box;
  }

  .news_detail>label {
    display: block;
    width: 100%;
    text-align: center;
    height: 30px;
    line-height: 30px;
    font-size: 18px;
    color: #000;
    font-weight: bold;
  }

  .news_detail>span {
    display: block;
    width: 100%;
    text-align: center;
    font-size: 13px;
    color: #999;
  }

  .news_detail>div {
    display: block;
    width: 80%;
    margin: 0 auto;
  }

  .news_detail>div img {
    width: 100%;
    height: auto;
    display: block;
    margin: 0 auto 5px;
  }
</style>
