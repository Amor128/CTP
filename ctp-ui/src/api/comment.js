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

export function adminListComments() {
  return request({
    url: '/comments/admin',
    method: 'get',
  })
}

export function removeComment(id) {
  return request({
    url: '/comments/' + id,
    method: 'delete',
  })
}