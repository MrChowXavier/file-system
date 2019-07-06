import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const store = new Vuex.Store({
  state: {
    token: '',
    username: 'xue',
    filelist: []
  },
  // getters: {
  //   getName (state) {
  //     return state.username
  //   }
  // },
  mutations: {
    setToken (state, token) {
      state.token = token
    },
    setUserName (state, username) {
      state.username = username
    },
    setFileList (state, payload) {
      state.filelist = payload
    }
  }
  // // 异步操作
  // actions: {
  //
  // }
})
export default store
