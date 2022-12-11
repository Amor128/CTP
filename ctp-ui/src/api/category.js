import request from '@/utils/request'

export function listCategories() {
  return request({
    url: '/categories',
    method: 'get',
  })
}

