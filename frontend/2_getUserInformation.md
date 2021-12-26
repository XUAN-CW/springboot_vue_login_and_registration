---
title: getUserInformation
date: 2021-12-26 22:44:34
tags: 
categories: 
id: 1640529874607182200
---
# 概述



# 安装 js-cookie

```
npm i js-cookie
```

# 获取 token 后保存

[HelloWorld.vue](src/components/HelloWorld.vue) 

```
import Cookies from 'js-cookie'
```

```
Cookies.set('token', response.data.data, { expires: 7 })
```

# 请求时带上 token 

```
import Cookies from 'js-cookie'
```

```
// HTTP request拦截器
service.interceptors.request.use(
  config => {

    //判断cookie里面是否有名称是'guli_token'的值
    if( Cookies.get('token')){
      //把获取cookie值放到header里面
      
      config.headers['token'] = cookie.get('token')
    }
    return config
  }
)
```









# 参考



https://github.com/js-cookie/js-cookie

https://www.npmjs.com/package/js-cookie
