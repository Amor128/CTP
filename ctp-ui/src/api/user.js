import request from '@/utils/request'

export function login(data) {
  return request({
    url: '/users/sessions',
    method: 'post',
    data
  })
}

export function register(data) {
  return request({
    url: '/users',
    method: 'post',
    data
  })
}

export function getInfo(userID) {
  return request({
    url: '/users/' + userID,
    method: 'get',
  })
}

export function updateInfo(userID, data) {
  return request({
    url: '/users/' + userID,
    method: 'put',
    data
  })
}

export function logout() {
  return request({
    url: '/vue-admin-template/user/logout',
    method: 'post'
  })
}
