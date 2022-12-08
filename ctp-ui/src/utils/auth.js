import Cookies from 'js-cookie'

const TokenKey = 'vue_admin_template_token'
const UserIDKey = 'vue_admin_template_user_id'

export function getToken() {
  return Cookies.get(TokenKey)
}

export function setToken(token) {
  return Cookies.set(TokenKey, token)
}

export function removeToken() {
  return Cookies.remove(TokenKey)
}

export function getUserID() {
  return Cookies.get(UserIDKey)
}

export function setUserID(userID) {
  return Cookies.set(UserIDKey, userID)
}

export function removeUserID() {
  return Cookies.remove(UserIDKey)
}
