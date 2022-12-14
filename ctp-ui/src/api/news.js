import request from '@/utils/request'

export function listNews() {
    return request({
        url: '/news',
        method: 'get',
    })
}

export function insertNews(data) {
    return request({
        url: '/news',
        method: 'post',
        data
    })
}

export function removeNews(id) {
    return request({
        url: '/news/' + id,
        method: 'delete',
    })
}

export function updateNews(data) {
    return request({
        url: '/news',
        method: 'put',
        data
    })
}