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

export function getUserInformation() {
  return request({
    url: '/backend/user/getUserInformation',
    method: 'get'
  })
}