import request from '@/utils/request'

export function listHomeGoods() {
  return request({
    url: '/goods/home',
    method: 'get',
  })
}

export function getGoodsPage(params) {
  return request({
    url: '/goods',
    method: 'get',
    params
  })
}

export function getGoodsDetail(id) {
  return request({
    url: '/goods/' + id,
    method: 'get',
  })
}

export function insertGoods(data) {
  return request({
    url: '/goods',
    method: 'post',
    data
  })
}

export function lsitMyGoods(params) {
  return request({
    url: '/goods/filter',
    method: 'get',
    params
  })
}

export function updateGoods(goodsID, data) {
  return request({
    url: '/goods/' + goodsID,
    method: 'put',
    data
  })
}
