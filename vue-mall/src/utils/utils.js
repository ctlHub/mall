export default {
  shopTitle: {
    98: {
      icon: require('@/assets/images/置顶标题.png'),
      jump: true,
      name: '置顶'
    },
    1: {
      icon: require('@/assets/images/新品标题.png'),
      jump: true,
      name: '新品'
    },
    2: {
      icon: require('@/assets/images/热销标题.png'),
      jump: false,
      name: '热销'
    },
    3: {
      icon: require('@/assets/images/特价标题.png'),
      jump: true,
      name: '特价'
    },
    4: {
      icon: require('@/assets/images/经典标题.png'),
      jump: true,
      name: '经典'
    },
    99: {
      icon: require('@/assets/images/促销标题.png'),
      jump: false,
      name: '促销'
    }
  },
  getToken: () => {
    return window.sessionStorage.getItem('token')
  },
  isLogin: () => {
    return window.sessionStorage.getItem('token') !== null
  }
}
