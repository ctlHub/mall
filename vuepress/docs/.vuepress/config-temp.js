module.exports = {
  base: '/mall/',
  title: 'Mall Documents',
  description: '开发文档笔记',
  themeConfig: {
    nav:[ // 导航栏配置
      { text: '首页', link: '/' },
      { text: '前端', link: '/frontend/' },
      { text: '后端', link: '/backend/' },
      { text: '指南', link: '/guide/' },
      // {text: '微博', link: 'https://baidu.com'}      
    ],
    sidebarDepth: 2, // 侧边栏显示2级
    lastUpdated: 'Last Updated',
  },
}