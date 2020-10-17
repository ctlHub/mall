import Vue from 'vue'
import {
  Button,
  Form,
  FormItem,
  Input,
  Breadcrumb,
  BreadcrumbItem,
  Link,
  Popover,
  Carousel,
  CarouselItem,
  Card,
  Badge,
  Collapse,
  CollapseItem,
  Row,
  Col,
  Image,
  InputNumber,
  Notification,
  Loading,
  Message,
  Cascader,
  Tag,
  Dialog,
  Pagination,
  InfiniteScroll,
  Tabs,
  TabPane
} from 'element-ui'

Vue.use(Tabs)
Vue.use(TabPane)
Vue.use(Button)
Vue.use(Form)
Vue.use(FormItem)
Vue.use(Input)
Vue.use(Breadcrumb)
Vue.use(BreadcrumbItem)
Vue.use(Link)
Vue.use(Popover)
Vue.use(Carousel)
Vue.use(CarouselItem)
Vue.use(Card)
Vue.use(Badge)
Vue.use(Collapse)
Vue.use(CollapseItem)
Vue.use(Row)
Vue.use(Col)
Vue.use(Image)
Vue.use(InputNumber)
Vue.use(Loading)
Vue.use(Cascader)
Vue.use(Tag)
Vue.use(Dialog)
Vue.use(Pagination)
Vue.use(InfiniteScroll)
// 解决引入是会执行一次，导致每个页面都会有弹窗
Vue.component(Message.name, Message)
Vue.prototype.$notify = Notification
Vue.prototype.$loading = Loading
Vue.prototype.$message = Message
