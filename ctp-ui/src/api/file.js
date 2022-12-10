import request from '@/utils/request'

export function upload(data) {
  return request({
    url: '/files',
    method: 'post',
    params: {
        file: data
    }
  })
}
