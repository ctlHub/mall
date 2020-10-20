<template>
  <div>
    <remote-script src="font/iconfont.js"></remote-script>
    <div class="title">
      <span style="color: #666;">{{info.brand}}</span>
      <span v-if="info.partViewTop > 0">[置顶]</span>
      <span v-if="info.salesStatus > 0">{{'[' + shopTitle[info.salesStatus].name + ']'}}</span>
      <span>{{info.desc}}</span>
      <span v-if="info.spec">{{info.spec}}</span>
      <div class="shopping-time" v-if="info.classify === 0">
        <span>上市时间：
          <span style="color: #666;">
            {{info.pushMonth!==0?info.pushMonth:'(未知)'}}
          </span>
        </span>
      </div>
    </div>
    <div class="detail-shopping">
      <div>
        <span>零售价格：<i style="color: #858686;">￥{{info.listUp}}</i></span>
      </div>
      <div class="box-shopping-parent">
        <div class="box-shopping">
          商品系列:
          <span style="color: #666;">
            {{info.class1}}
            {{info.class2?','+info.class2:''}}
            {{info.class3?','+info.class3:''}}
          </span>
        </div>
        <div class="box-shopping">
          包装单位:<span style="color: #666;">{{info.boxNum}} / {{info.boxUnit}}</span>
        </div>
        <div class="box-shopping">
          商品单位:<span style="color: #666;">{{info.unit}}</span>
        </div>
      </div>
    </div>
    <div v-if="!info.optionList || info.optionList.length === 0">
      <div v-for="(item,index) in mallIcon" :key="index" @click="onClick(item.url)" class="iconList">
        <svg :class="item.url === '' ? 'icon gray' : 'icon'" aria-hidden="true">
          <use :xlink:href="'#' + item.icon"></use>
        </svg>
      </div>
    </div>
    <fieldset id="marque" class="marque" v-if="info.optionList && info.optionList.length > 0">
      <legend> 型号子项列表</legend>
      <div class="marque-box">
        <div class="option" id="option0" style="margin-bottom: 0.3em" v-for="(item,index) in info.optionList" :key="index">
          <label>{{item.name}}：</label>
          <button type="button" ref='subItem' :value="item.name" v-for="(sub,index) in item.option" :key="sub+','+index"
            @click="filterDescSpecEvent(sub,$event)">{{sub}}</button>
        </div>
      </div>

      <vxe-table keep-source height="400" ref="xTable" class="table" :data="info.childGoods" :edit-config="{trigger: 'click', mode: 'row', showStatus: true}">
        <vxe-table-column type="seq" width="60"></vxe-table-column>
        <vxe-table-column field="descSpec" title="品名规格" width="300" :filters="[{ data: '' }]" :filter-method="filterDescSpecMethod">
          <template v-slot:filter="{ $panel, column }">
            <template v-for="(option, index) in column.filters">
              <input class="filter-input" type="type" :key="index" v-model="option.data" @input="$panel.changeOption($event, !!option.data, option)"
                @keyup.enter="$panel.confirmFilter()" placeholder="按回车确认筛选">
            </template>
          </template>
        </vxe-table-column>
        <vxe-table-column field="class1" title="商品类别" width="200"></vxe-table-column>
        <vxe-table-column field="pushMonth" title="上市时间" width="100"></vxe-table-column>
        <vxe-table-column field="boxNum" title="包装量" width="80"></vxe-table-column>
        <vxe-table-column field="unit" title="单位" width="50"></vxe-table-column>
        <vxe-table-column field="listUp" title="零售价" width="100" fixed="right"></vxe-table-column>
        <vxe-table-column field="num" title="操作" width="150" fixed="right">
          <template v-slot:default="{ row }">
            <span @click="showProduct(row)" style="cursor: pointer;">查看</span>
          </template>
        </vxe-table-column>
      </vxe-table>
    </fieldset>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        shopTitle: this.$MYUtils.shopTitle,
        info: {
          Classify_: 1,
          LowerShelf_: false,
          Brand_: '狼王',
          PartViewTop_: '[置顶]',
          SalesStatus_: '[经典]',
          Desc_: '铂金,伏青屠龙,台钓竿,碳素,40T',
          Spec_: '规格:5.4~8.5m',
          Stock_: '0',
          OriUP_: '11-1680',
          ListUP_: '11-1680',
          PushMonth_: '2020-10-10',
          Class1_: '钓竿类',
          Class2_: '大物专攻',
          Class3_: '伏青屠龙',
          BoxNum_: 10,
          BoxUnit_: '个',
          Unit_: 'PSC',
          IsCollect_: false
        },
        mallIcon: {
          0: {
            icon: 'ditengtaobao',
            name: '淘宝',
            url: ''
          },
          1: {
            icon: 'ditengtianmao',
            name: '天猫',
            url: ''
          },
          2: {
            icon: 'ditengjingdong',
            name: '京东',
            url: ''
          },
          3: {
            icon: 'ditengpinduoduo',
            name: '拼多多',
            url: ''
          }
        },
        mallList: [],
        filter: []
      }
    },
    created() {
      this.getEshop(this.$route.query.partCode)
      if (this.GoodsInfo) {
        this.info = this.GoodsInfo
      }
    },
    props: {
      GoodsInfo: Object
    },
    watch: {
      GoodsInfo: {
        deep: true,
        handler(newVal, oldVal) {
          this.info = newVal
          this.getEshop(this.$route.query.partCode)
        }
      }
    },
    methods: {
      // 加入购物车
      addShopping() {
        this.$notify({
          title: '加入购物车成功',
          type: 'success'
        })
      },
      async getEshop(code) {
        const res = await this.$service.getEshop(code)
        if (res.result) {
          res.data.forEach(item => {
            this.mallIcon[item.eshopType].url = item.eshopGoodsUrl
          })
        }
      },
      onClick(url) {
        if (!url) {
          this.$message.error('对不起，该商品还没有添加链接')
          return false
        }
        window.open(url)
      },
      filterDescSpecEvent(item, $event) {
        var button = $event.currentTarget
        button.className = button.className ? '' : 'selectButton'
        if (this.filter.indexOf(item) > -1) {
          this.filter.splice(this.filter.indexOf(item), 1)
        } else {
          this.filter.push(item)
        }
        const xTable = this.$refs.xTable
        const column = xTable.getColumnByField('descSpec')
        if (this.filter.length > 0) {
          // 修改第一个选项为勾选状态
          const option = column.filters[0]
          option.data = this.filter.join(' ')
          option.checked = true
        } else {
          xTable.clearFilter(column)
        }
        // 修改条件之后，需要手动调用 updateData 处理表格数据
        xTable.updateData()
      },
      filterDescSpecMethod({
        option,
        row
      }) {
        var items = this.$XEUtils.trim(option.data).split(' ')
        var descSpec = this.$XEUtils.toString(row.descSpec).toLowerCase()
        var result = false
        items.forEach(item => {
          if (descSpec.indexOf(item) > -1) {
            result = true
          }
        })
        return result
      },
      showProduct(row) {
        this.$router.push({
          name: 'ProductDetail',
          query: {
            partCode: row.code
          }
        })
      }
    }
  }
</script>

<style scoped>
  .table {
    display: block;
    width: calc(95.428571rem - 27.6rem);
  }

  .title {
    font-size: 1.357142rem;
    font-weight: bold;
    margin-bottom: 0.5rem;
    position: relative;
  }

  .detail-shopping {
    color: #858686;
    background: url(../../../assets/images/shopping_detail_bg.png) no-repeat center scroll;
    background-size: 100% auto;
    height: auto;
    padding: 1rem;
    position: relative;
    display: -webkit-box;
    display: -ms-flexbox;
    display: -moz-box;
    display: box;
    display: -webkit-flex;
    display: flex;
    justify-content: flex-start;
    align-items: flex-start;
    margin-bottom: 1rem;
  }

  .detail-shopping>div:nth-child(1)>span {
    display: block;
    font-size: 1rem;
  }

  .detail-shopping>div:nth-child(1)>span i {
    font-size: 1.3rem;
  }

  .box-shopping-parent {
    display: -webkit-box;
    display: -ms-flexbox;
    display: -moz-box;
    display: box;
    display: -webkit-flex;
    display: flex;
  }

  .box-shopping {
    display: inline-block;
    border-right: 1px solid #ECECEC;
    text-align: left;
    flex-grow: 1;
    padding-left: 17px;
    color: #999999;
  }

  .box-shopping:nth-child(3) {
    border-right: 1px solid transparent;
  }

  .shopping-time {
    position: absolute;
    top: 0;
    right: 0;
    color: #666;
    font-size: 1rem;
    font-weight: initial;
  }

  .marque {
    margin: 0;
    padding: 0.7rem 0 0.7rem 0;
    width: 100%;
    font-size: 12px;
    box-sizing: border-box;
  }

  fieldset {
    border: 0 transparent;
    margin-top: 2rem;
    width: 100%;
  }

  fieldset>legend {
    font-size: 1.2rem;
    font-weight: bold;
  }

  .option {
    padding-left: 5.5rem;
    position: relative;
    height: 2.1rem;
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

  .marque>.shopping-buy-parent {
    height: 39px;
    margin-top: 25px;
    display: -webkit-box;
    display: -ms-flexbox;
    display: -moz-box;
    display: -webkit-flex;
    display: flex;
    -webkit-box-align: center;
    -webkit-align-items: center;
    -ms-flex-align: center;
    align-items: center;
    -ms-flex-pack: justify;
    -webkit-box-pack: justify;
    -webkit-justify-content: flex-end;
    justify-content: flex-end;
  }

  .addShopButton {
    background-color: #EE1C25;
    color: white;
    float: right;
    font-size: 1em;
    font-weight: 900;
    height: 39px;
    line-height: 39px;
    width: 131px;
    padding: 0;
    text-align: center;
    border-radius: 4px;
    -webkit-border-radius: 4px;
    cursor: pointer;
    outline: none;
    border: 0;
  }

  .buy-shopping {
    display: inline-block;
    background: #f7f7f7;
    width: 131px;
    text-align: center;
    border-radius: 4px;
    height: 39px;
    line-height: 39px;
    -webkit-border-radius: 4px;
    border: 1px solid;
    color: #999 !important;
    margin: 0 1.5rem;
  }

  .buy-shopping>img {
    margin-top: -5px;
    margin-right: 0.5rem;
    vertical-align: middle;
  }

  .filter-input {
    border: 1px solid #dedede;
    outline: 0;
    padding: 0.3rem 1rem;
  }

  .iconList {
    display: inline-block;
  }

  .iconList span {
    font-size: 6rem;
    margin-right: 2rem;
    vertical-align: bottom;
  }

  .icon {
    height: 6rem;
    width: 6rem;
    fill: currentColor;
    overflow: hidden;
    margin-right: 2rem;
    cursor: pointer;
    vertical-align: -0.6rem;
  }
</style>
