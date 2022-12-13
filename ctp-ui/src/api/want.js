import request from '@/utils/request'

export function insertWant(data) {
  return request({
    url: '/wants',
    method: 'post',
    data
  })
}

export function getWantPage(params) {
  return request({
    url: '/wants',
    method: 'get',
    params
  })
}

export function getMyWantList(params) {
  return request({
    url: '/wants/filter',
    method: 'get',
    params
  })
}

export function removeWant(wantID) {
  return request({
    url: '/wants/' + wantID,
    method: 'delete',
  })
}