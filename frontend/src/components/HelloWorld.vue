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
