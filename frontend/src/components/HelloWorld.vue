<template>
  <div>
    <div>
      <input type="text" v-model="username" placeholder="用户名"/>
      <input type="text" v-model="password" placeholder="密码"/>
      <button @click="login">登录</button>
      <p>登录后获取的 token 如下</p>
      <textarea cols="30" rows="10" v-model="token"></textarea>
    </div>
    <div v-show="token">
      <button @click="getUserInformation">获取用户信息</button>
      <p>获取的用户信息如下</p>
      <textarea cols="30" rows="10" v-model="userInformation.id">
      </textarea>
    </div>
  </div>
</template>

<script>
import * as loginApi from '@/api/login'
import Cookies from 'js-cookie'

export default {
  data() {
    return {
      username: '123',
      password:'456',
      token: null,
      userInformation: []
    }
  },

  methods: {
    login(){
      loginApi.login(this.username,this.password)
        .then(response =>{
          console.log(response)
          this.token = response.data.data
          Cookies.set('token', response.data.data, { expires: 7 })
        }).catch(error =>{
          console.log(error)
      });
    },

    getUserInformation(){
      loginApi.getUserInformation()
        .then(response => {
          console.log(response)
           this.userInformation = response.data.data
        }).catch(error =>{
          console.log(error)
      });
    }
  }
}
</script>
