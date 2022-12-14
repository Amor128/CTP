import request from '@/utils/request'

export function listCategories() {
  return request({
    url: '/categories',
    method: 'get',
  })
}


export function adminListCategories() {
  return request({
    url: '/categories/admin',
    method: 'get',
  })
}


export function listParentCategories() {
  return request({
    url: '/categories/parent',
    method: 'get',
  })
}


export function updateCategory(data) {
  return request({
    url: '/categories',
    method: 'put',
    data
  })
}


export function insertCategory(data) {
  return request({
    url: '/categories',
    method: 'post',
    data
  })
}


