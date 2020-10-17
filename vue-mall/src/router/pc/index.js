import Login from '../../components/pc/Login.vue'
import Index from '../../components/pc/Index.vue'
import IndexMain from '../../components/pc/index/IndexMain.vue'
import ProductDetail from '../../components/pc/product/ProductDetail.vue'
import ProductSearch from '../../components/pc/product/ProductSearch.vue'
import MallIndex from '../../components/pc/index/MallIndex.vue'
import NewsIndex from '../../components/pc/news/NewsIndex.vue'
import NewsDetail from '../../components/pc/news/NewsDetail.vue'

export default [{
    path: '/pc',
    redirect: '/pc/mallIndex',
    meta: {
      title: '首页'
    }
  },
  {
    path: '/pc/login',
    component: Login,
    meta: {
      title: '登陆'
    }
  },
  {
    path: '/pc/mallIndex',
    name: 'MallIndex',
    component: MallIndex,
    meta: {
      title: '首页'
    }
  },
  {
    path: '/pc/:corpNo/index',
    component: Index,
    children: [{
        path: '',
        name: 'IndexMain',
        component: IndexMain,
        meta: {
          title: '商城首页'
        }
      },
      {
        path: 'productDetail',
        name: 'ProductDetail',
        component: ProductDetail,
        meta: {
          title: '商品明细'
        }
      },
      {
        path: 'productSearch',
        name: 'ProductSearch',
        component: ProductSearch,
        meta: {
          title: '商品查询',
          keepAlive: false
        }
      },
      {
        path: 'newsIndex',
        name: 'NewsIndex',
        component: NewsIndex,
        meta: {
          title: '新闻列表',
          keepAlive: false
        },
        children: [{
          path: 'newsDetail',
          name: 'NewsDetail',
          component: NewsDetail,
          meta: {
            title: '新闻详情',
            keepAlive: false
          }
        }]
      }
    ]
  }
]
