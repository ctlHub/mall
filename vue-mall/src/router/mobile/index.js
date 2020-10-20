import Home from '../../components/mobile/Home.vue'
import IndexPhone from '../../components/mobile/index/IndexPhone.vue'
import Classification from '../../components/mobile/classification/Classification.vue'
import ShopCart from '../../components/mobile/shopCart/ShopCart.vue'
import Order from '../../components/mobile/order/Order.vue'
import MyPage from '../../components/mobile/myPage/MyPage.vue'
import SearchPhone from '../../components/mobile/classification/SearchPhone.vue'
import ProductDetailPhone from '../../components/mobile/product/ProductDetailPhone.vue'
import MallIndex from '../../components/mobile/merchants/MallIndex.vue'

export default [{
  path: '/mobile/:corpNo/index',
  component: Home,
  children: [{
    path: '',
    name: 'IndexPhone',
    component: IndexPhone
  }, {
    path: 'classification',
    name: 'Classification',
    component: Classification
  }, {
    path: 'shopCart',
    name: 'ShopCart',
    component: ShopCart
  }, {
    path: 'order',
    name: 'Order',
    component: Order
  }, {
    path: 'myPage',
    name: 'MyPage',
    component: MyPage
  }, {
    path: 'search',
    name: 'SearchPhone',
    component: SearchPhone
  }, {
    path: 'productDetailPhone',
    name: 'ProductDetailPhone',
    component: ProductDetailPhone
  }]
}, {
  path: '/mobile',
  name: 'MallIndexPhone',
  component: MallIndex
}]
