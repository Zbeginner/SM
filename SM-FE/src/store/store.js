import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export const store = new Vuex.Store({
    state: {
        user: {}
    },
    getters: {
        verify: (state) => (roles) => {
            return roles.some(name => {
                return state.user.roles.some(val => name == val.roleName)
            })
        }
    },
    mutations: {
        SET_USER: (state, user) => {
            state.user = user
        }
    },
    actions: {
        LoginAction({commit}, user) {
            commit('SET_USER', user)
        },
        LogoutAction({commit}) {
            sessionStorage.removeItem('$token')
            commit('SET_USER', {})
        }
    }
})