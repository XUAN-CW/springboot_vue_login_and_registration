import axios from 'axios'
import Cookies from 'js-cookie'

// 创建axios实例
const service = axios.create({
  baseURL: "http://localhost:8080/", // api 的 base_url
  timeout: 5000 // 请求超时时间
})


// HTTP request拦截器
service.interceptors.request.use(
  config => {

    //判断cookie里面是否有名称是'guli_token'的值
    if( Cookies.get('token')){
      //把获取cookie值放到header里面
      
      config.headers['token'] = Cookies.get('token')
    }
    return config
  }
)

export default service
