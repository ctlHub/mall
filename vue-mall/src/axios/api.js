import service from './request'

// 获取商品
const getPersonInfo = params => {
  return service.axiosPost('/goods/listGoods', params)
}

// 获取商品大类
const getPersonClass = () => {
  return service.axiosGet('/api/index/class')
}

// 获取商品中类
const getPersonSubClass = className => {
  return service.axiosGet(`/api/index/subClass/${className}`)
}

// 获取首页轮播图
const getListCarousel = () => {
  return service.axiosGet('/api/index/listCarousel')
}

// 获取购物车数量
const getCountCart = () => {
  return service.axiosGet('/api/index/countCart')
}

// 获取我的收藏数量
const getCountCollect = () => {
  return service.axiosGet('/api/index/countCollect')
}

// 获取首页公告
const getListNotice = () => {
  return service.axiosGet('/api/index/listNotice')
}

// 获取当前帐套下的品牌信息
const getListBrand = () => {
  return service.axiosGet('/api/index/listBrand')
}

// 获取商家列表
const getListMerchant = () => {
  return service.axiosGet('/api/index/listMerchant')
}

// 获取商家信息
const getMerchantInfo = () => {
  return service.axiosGet('/api/index/getMerchant')
}

// 查询商品块
const getGoodsBlock = (saleStatus) => {
  return service.axiosGet('/api/index/getGoodsBlock?saleStatus=' + saleStatus)
}

// 查询商品
const searchGoods = (params, page, pageSize) => {
  const data = JSON.parse(JSON.stringify(params))
  if (data.salesStatus === -1) {
    delete data.salesStatus
  }
  return service.axiosPost(`/api/search?pn=${page}&ps=${pageSize}`, data, 'json', true)
}

// 商品详情界面获得商品描述图
const getDescription = (code) => {
  return service.axiosGet('/api/productDetail/listDescription?code=' + code)
}

// 商品详情界面获得电商绑定
const getEshop = (code) => {
  return service.axiosGet('/api/productDetail/listEshop?code=' + code)
}

// 商品详情界面获
const getGoodsDetail = (code) => {
  return service.axiosGet('/api/productDetail/getGoodsDetail?code=' + code)
}

// 获得新闻列表
const getNewsList = (page, pageSize) => {
  return service.axiosGet(`/api/search/listNotice?pn=${page}&ps=${pageSize}`)
}

// 获得新闻详情
const getNewsDetail = (uid) => {
  return service.axiosGet(`/api/notice/get?uid=${uid}`)
}

// 获得相关商品
const listBindGoods = (code) => {
  return service.axiosGet(`/api/productDetail/listBindGoods?code=${code}`)
}

// 获得商品属性
const listAttr = (code) => {
  return service.axiosGet(`/api/productDetail/listAttr?code=${code}`)
}

export default {
  getPersonInfo,
  getPersonClass,
  getPersonSubClass,
  getListCarousel,
  getCountCart,
  getCountCollect,
  getListNotice,
  getListBrand,
  getListMerchant,
  getMerchantInfo,
  getGoodsBlock,
  searchGoods,
  getDescription,
  getEshop,
  getGoodsDetail,
  getNewsList,
  getNewsDetail,
  listBindGoods,
  listAttr
}
