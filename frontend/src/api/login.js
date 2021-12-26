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
