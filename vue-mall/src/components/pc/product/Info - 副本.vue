<template>
  <div>
    <div class="title">
      <span style="color: #666;">{{info.Brand_}}</span>
      <span>{{info.PartViewTop_}}</span>
      <span>{{info.SalesStatus_}}</span>
      <span>{{info.Desc_}}</span>
      <span v-if="info.Spec_">{{info.Spec_}}</span>
      <div class="shopping-time" v-if="info.subitem.length === 0">
        <span>上市时间：
          <span style="color: #666;">
            {{info.PushMonth_!==0?info.PushMonth_:'(未知)'}}
          </span>
        </span>
      </div>
    </div>
    <div class="detail-shopping">
      <div>
        <span> 进货价：<i style="color: #BD0702;">￥{{info.OriUP_}}</i></span>
        <span>零售价格：<i style="color: #858686;">￥{{info.ListUP_}}</i></span>
      </div>
      <div class="box-shopping-parent">
        <div class="box-shopping">
          商品系列:
          <span style="color: #666;">
            {{info.Class1_}}
            {{info.Class2_?','+info.Class2_:''}}
            {{info.Class3_?','+info.Class3_:''}}
          </span>
        </div>
        <div class="box-shopping">
          包装单位:<span style="color: #666;">{{info.BoxNum_}} / {{info.BoxUnit_}}</span>
        </div>
        <div class="box-shopping">
          商品单位:<span style="color: #666;">{{info.Unit_}}</span>
        </div>
      </div>
    </div>
    <fieldset id="marque" class="marque" v-if="info.subitem.length > 0">
      <legend> 型号子项列表</legend>
      <div class="marque-box">
        <div class="option" id="option0" style="margin-bottom: 0.3em" v-for="(item,index) in info.subitem" :key="index">
          <label>{{item.name}}：</label>
          <button type="button" ref='subItem' :value="item.name" v-for="(sub,index) in item.value" :key="sub+','+index" @click="filterDescSpecEvent(sub,$event)">{{sub}}</button>
        </div>
      </div>

      <vxe-table keep-source height="400" ref="xTable" class="table" @cell-click="cellClickEvent" :data="tableData"
        :edit-config="{trigger: 'click', mode: 'row', showStatus: true}">
        <vxe-table-column type="checkbox" width="60" fixed="left"></vxe-table-column>
        <vxe-table-column type="seq" width="60"></vxe-table-column>
        <vxe-table-column field="descSpec" title="品名规格" width="300" :filters="[{ data: '' }]" :filter-method="filterDescSpecMethod">
          <template v-slot:filter="{ $panel, column }">
            <template v-for="(option, index) in column.filters">
              <input class="filter-input" type="type" :key="index" v-model="option.data" @input="$panel.changeOption($event, !!option.data, option)"
                @keyup.enter="$panel.confirmFilter()" placeholder="按回车确认筛选">
            </template>
          </template>
        </vxe-table-column>
        <vxe-table-column field="Class3_" title="商品类别" width="200"></vxe-table-column>
        <vxe-table-column field="PushMonth_" title="上市时间" width="100"></vxe-table-column>
        <vxe-table-column field="BoxNum_" title="包装量" width="80"></vxe-table-column>
        <vxe-table-column field="Unit_" title="单位" width="50"></vxe-table-column>
        <vxe-table-column field="OriUP_" title="进货价" width="100" fixed="right"></vxe-table-column>
        <vxe-table-column field="ListUP_" title="零售价" width="100" fixed="right"></vxe-table-column>
        <vxe-table-column field="Num_" title="数量" :edit-render="{}" width="150" fixed="right">
          <template v-slot:default="{ row }">
            <el-input-number v-model="row.Num_" :min="0" :max="100" size="small"></el-input-number>
          </template>
          <template v-slot:edit="{ row }">
            <el-input-number v-model="row.Num_" :min="0" :max="100" size="small"></el-input-number>
          </template>
        </vxe-table-column>
      </vxe-table>

      <div class="shopping-buy-parent">
        <a href="javascrpit:void(0)" id="collect" onclick="cancelCollect(this,'21FQTL-I-X')" class="buy-shopping"><img
            role="collectImg_active" src="../../../assets/images/collect-active.png"><span>已收藏</span></a>
        <input type="button" value="加入购物车" class="addShopButton" @click="addShopping()">
      </div>

    </fieldset>
  </div>
</template>

<script>
  export default {
    data () {
      return {
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
          subitem: [{
              name: '规格',
              value: [
                '5405', '6306', '7207', '7507', '8108', '8508'
              ]
            },
            {
              name: '单重',
              value: [
                '287g', '408g', '458g', '471g', '581g', '606g'
              ]
            }
          ],
          IsCollect_: false
        },
        allAlign: null,
        tableData: [{
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
            IsCollect_: false,
            Num_: 1
          },
          {
            Classify_: 1,
            LowerShelf_: false,
            Brand_: '狼王',
            PartViewTop_: '[置顶]',
            SalesStatus_: '[经典]',
            Desc_: '铂金,伏青屠龙,台钓竿,碳素,40T',
            Spec_: '规格:5~8m',
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
            IsCollect_: false,
            Num_: 1
          },
          {
            Classify_: 1,
            LowerShelf_: false,
            Brand_: '狼王',
            PartViewTop_: '[置顶]',
            SalesStatus_: '[经典]',
            Desc_: '铂金,伏青屠龙2asd,台钓竿,碳素,40T',
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
            IsCollect_: false,
            Num_: 1
          },
          {
            Classify_: 1,
            LowerShelf_: false,
            Brand_: '狼王',
            PartViewTop_: '[置顶]',
            SalesStatus_: '[经典]',
            Desc_: '铂金,伏青屠aa龙,台钓竿,碳素,40T',
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
            IsCollect_: false,
            Num_: 1
          },
          {
            Classify_: 1,
            LowerShelf_: false,
            Brand_: '狼王',
            PartViewTop_: '[置顶]',
            SalesStatus_: '[经典]',
            Desc_: '铂金,伏青屠df龙,台钓竿,碳素,40T',
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
            IsCollect_: false,
            Num_: 1
          },
          {
            Classify_: 1,
            LowerShelf_: false,
            Brand_: '狼王',
            PartViewTop_: '[置顶]',
            SalesStatus_: '[经典]',
            Desc_: '铂金,伏青屠ccc龙,台钓竿,碳素,40T',
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
            IsCollect_: false,
            Num_: 1
          },
          {
            Classify_: 1,
            LowerShelf_: false,
            Brand_: '狼王',
            PartViewTop_: '[置顶]',
            SalesStatus_: '[经典]',
            Desc_: '铂金,伏青屠龙,台sdf钓竿,碳素,40T',
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
            IsCollect_: false,
            Num_: 1
          },
          {
            Classify_: 1,
            LowerShelf_: false,
            Brand_: '狼王',
            PartViewTop_: '[置顶]',
            SalesStatus_: '[经典]',
            Desc_: '铂金,伏青屠vbv龙,台钓竿,碳素,40T',
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
            IsCollect_: false,
            Num_: 1
          },
          {
            Classify_: 1,
            LowerShelf_: false,
            Brand_: '狼王',
            PartViewTop_: '[置顶]',
            SalesStatus_: '[经典]',
            Desc_: '铂金,伏青屠龙,fgh台钓竿,碳素,40T',
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
            IsCollect_: false,
            Num_: 1
          },
          {
            Classify_: 1,
            LowerShelf_: false,
            Brand_: '狼王',
            PartViewTop_: '[置顶]',
            SalesStatus_: '[经典]',
            Desc_: '铂金,伏青屠龙,台钓竿,碳ddg素,40T',
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
            IsCollect_: false,
            Num_: 1
          }
        ],
        num: 1,
        filter: []
      }
    },
    created () {
      this.tableData.forEach(item => {
        item.descSpec = item.Spec_ ? item.Desc_ + ',' + item.Spec_ : item.Desc_
      })
    },
    methods: {
      // 加入购物车
      addShopping () {
        this.tableData.forEach(item => {
          item.age = 0
        })
        this.$notify({
          title: '加入购物车成功',
          type: 'success'
        })
      },
      cellClickEvent ({
        row,
        column
      }) {
        if (column.property !== 'Num_' && column.type !== 'checkbox') {
          this.$refs.xTable.setCheckboxRow([row], this.$refs.xTable.getCheckboxRecords().indexOf(row) === -1)
        } else if (row.Num_ > 0) {
          this.$refs.xTable.setCheckboxRow([row], true)
        } else if (row.Num_ === 0) {
          this.$refs.xTable.setCheckboxRow([row], false)
        }
      },
      filterDescSpecEvent (item, $event) {
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
      filterDescSpecMethod ({
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
    padding: 1em;
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
    font-size: 1em;
  }

  .detail-shopping>div:nth-child(1)>span i {
    font-size: 1.3em;
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
    padding: 0.7em 0 0.7em 0;
    width: 100%;
    font-size: 12px;
    box-sizing: border-box;
  }

  fieldset {
    border: 0 transparent;
    margin-top: 2em;
    width: 100%;
  }

  fieldset>legend {
    font-size: 1.2em;
    font-weight: bold;
  }

  .option {
    padding-left: 5.5em;
    position: relative;
    height: 2.1rem;
    line-height: 2.1rem;
  }

  .option button {
    border: 0;
    outline: none;
    background: #e6f4fa;
    border-radius: 0.1em;
    -webkit-border-radius: 0.1em;
    margin: 0 0.2em;
    color: #058fca;
  }

  .option .selectButton {
    background: #058fca;
    color: #fff;
  }

  .option>label {
    display: inline-block;
    width: 5.5em;
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
    margin: 0 1.5em;
  }

  .buy-shopping>img {
    margin-top: -5px;
    margin-right: 0.5em;
    vertical-align: middle;
  }
  .filter-input{
    border: 1px solid #dedede;
    outline: 0;
    padding: 0.3rem 1rem;
  }
</style>
