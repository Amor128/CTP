import { login, getInfo } from '@/api/user'
import { getToken, setToken, removeToken, getUserID, setUserID, removeUserID } from '@/utils/auth'

const getDefaultState = () => {
    return {
        token: getToken(),
        userID: getUserID(),
    }
}
const mutations = {
    RESET_STATE: (state) => {
        Object.assign(state, getDefaultState())
    },
    SET_TOKEN: (state, token) => {
        state.token = token
    },
    SET_NAME: (state, name) => {
        state.name = name
    },
    SET_AVATAR: (state, avatar) => {
        state.avatar = avatar
    },
    SET_USERID: (state, userID) => {
        state.userID = userID
    }
}

const actions = {
    // user login
    Login({ commit }, userInfo) {
        const { phone, password } = userInfo
        return new Promise((resolve, reject) => {
            login({ phone: phone.trim(), password: password }).then(response => {
                const { data } = response
                commit('SET_TOKEN', data.token)
                commit('SET_USERID', Number(data.id))
                setToken(data.token)
                setUserID(data.id)
                resolve()
            }).catch(error => {
                reject(error)
            })
        })
    },

    // get user info
    getInfo({ commit, state }) {
        return new Promise((resolve, reject) => {
            getInfo(state.token).then(response => {
                const { data } = response

                if (!data) {
                    return reject('Verification failed, please Login again.')
                }

                const { name, avatar } = data

                commit('SET_NAME', name)
                commit('SET_AVATAR', avatar)
                resolve(data)
            }).catch(error => {
                reject(error)
            })
        })
    },

    // user logout
    logout({ commit }) {
        removeToken() // must remove  token  first
        removeUserID()
        commit('RESET_STATE')

    },

    // remove token
    resetToken({ commit }) {
        return new Promise(resolve => {
            removeToken() // must remove  token  first
            commit('RESET_STATE')
            resolve()
        })
    }
}

const user = {
    namespaced: true,
    state: getDefaultState(),
    actions,
    mutations
}

export default user

