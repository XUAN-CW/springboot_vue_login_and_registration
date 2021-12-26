---
title: frontend
date: 2021-12-26 19:47:47
tags: 
categories: 
id: 1640519267643323100

---

# 概述

# 环境

- node-v16.13.0-x64.msi 

----

# 创建项目

```
vue create frontend
```

# 安装 axios

```
npm install --save axios
```

# axios 全局配置

[request.js](src/http/request.js) 

```js
import axios from 'axios'

// 创建axios实例
const service = axios.create({
  baseURL: "http://localhost:8080/", // api 的 base_url
  timeout: 5000 // 请求超时时间
})

export default service

```

# 编写 api

[login.js](src/api/login.js) 

```js
import request from '@/http/request'

export function login(username, password) {
  return request({
    url: '/backend/user/loginByPassword',
    method: 'post',
    data: {
      username,
      password
    }
  })
}

```

# 引用

[HelloWorld.vue](src/components/HelloWorld.vue) 

```vue
<template>
  <div>
    <input type="text" v-model="username" placeholder="用户名"/>
    <input type="text" v-model="password" placeholder="密码"/>
    <button @click="login">登录</button>
    <p>登录后获取的 token 如下</p>
    <textarea cols="30" rows="10" v-model="token"></textarea>
  </div>
</template>

<script>
import * as loginApi from '@/api/login'

export default {
  data() {
    return {
      username: '123',
      password:'456',
      token:''
    }
  },

  methods: {
    login(){
      loginApi.login(this.username,this.password)
        .then(response =>{
          console.log(response)
          this.token = response.data.data
        }).catch(error =>{
          console.log(error)
        });
    }
  }
}
</script>

```

# 启动

```
npm run serve
```

---

# 参考



