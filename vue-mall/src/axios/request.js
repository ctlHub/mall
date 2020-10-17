import axios from 'axios'
import app from '../main.js'

// 创建axios实例
const service = axios.create({
  baseURL: process.env.VUE_APP_BASE_URL, // api的base_url
  timeout: 30000 // 请求超时时间
})

// request拦截器==>对请求参数做处理
service.interceptors.request.use(config => {
  if (!config.data) {
    config.data = ''
  }
  if (config.url.indexOf('?') === -1) {
    config.url = config.url + '?corpNo=' + window.sessionStorage.getItem('corpNo')
  } else {
    config.url = config.url + '&corpNo=' + window.sessionStorage.getItem('corpNo')
  }
  return config
}, error => {
  // 请求错误处理
  app.$message.error(error)
  Promise.reject(error)
})

// respone拦截器==>对响应做处理
service.interceptors.response.use(
  response => {
    // 这里根据后端提供的数据进行对应的处理
    if (response.status === 200) {
      const message = getErrorMessage(response.data.code)
      if (message) {
        app.$message.error(message)
      }
      return response
    }
  },
  error => {
    // 响应错误处理

    if (error && error.response) {
      error.message = getErrorMessage(error.response.status)
    } else {
      error.message = '连接服务器失败!'
    }
    app.$message.error(error.message)
    return Promise.reject(error)
  }
)

const getErrorMessage = status => {
  let message = ''
  switch (status) {
    case 400:
      message = '请求错误(400)'
      break
    case 401:
      message = '未授权，请重新登录(401)'
      break
    case 403:
      message = '拒绝访问(403)'
      break
    case 404:
      message = '请求出错(404)'
      break
    case 408:
      message = '请求超时(408)'
      break
    case 500:
      message = '服务器错误(500)'
      break
    case 501:
      message = '服务未实现(501)'
      break
    case 502:
      message = '网络错误(502)'
      break
    case 503:
      message = '服务不可用(503)'
      break
    case 504:
      message = '网络超时(504)'
      break
    case 505:
      message = 'HTTP版本不受支持(505)'
      break
    default:
      message = ''
  }
  return message
}

// 获取头数据类型
const getHeadersType = (type, loading) => {
  let dataType = ''
  if (type === 'fromData') {
    dataType = 'application/multipart/form-data'
  } else if (type === 'text') {
    dataType = 'application/x-www-form-urlencoded'
  } else {
    dataType = 'application/json;charset=UTF-8'
  }
  return {
    headers: {
      'Content-type': dataType,
      'X-loading': 'true'
    }
  }
}

// post提交数据
const axiosPost = async (url, params, HeadersType, loading) => {
  var load
  if (loading) {
    load = app.$loading.service()
  }
  const {
    data: result
  } = await service.post(url, params, getHeadersType(HeadersType))
  if (load) {
    load.close()
  }
  return result
}

// post提交数据
const axiosGet = async (url, params, HeadersType, loading) => {
  var load
  if (loading) {
    load = app.$loading.service()
  }
  const {
    data: result
  } = await service.get(url, params, getHeadersType(HeadersType))
  if (load) {
    load.close()
  }
  return result
}

service.axiosPost = axiosPost
service.axiosGet = axiosGet

export default service
