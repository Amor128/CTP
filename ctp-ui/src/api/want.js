import request from '@/utils/request'

export function insertWant(data) {
  return request({
    url: '/wants',
    method: 'post',
    data
  })
}