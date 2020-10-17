module.exports = {
  devServer: {
    proxy: {
      '/service': {
        // 此处的写法，目的是为了 将 /service 替换成 需要的api服务地址
        target: 'http://116.62.239.206',
        // 允许跨域
        changeOrigin: true,
        ws: true,
        pathRewrite: {
          '^/service': ''
        }
      }
    }
  }
}
