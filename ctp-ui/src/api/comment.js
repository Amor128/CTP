import request from '@/utils/request'

export function postComment(data) {
  return request({
    url: '/comments',
    method: 'post',
    data
  })
}

export function listComments(params) {
    return request({
      url: '/comments',
      method: 'get',
      params
    })
  }