import { createStore } from 'vuex'

export default createStore({
  state: {
    message: ""
  },
  mutations: {
    setMessage(state, payload) {
      state.message = payload;
    }
  },
  actions: {
    setMessage({ commit }, payload) {
      commit("setMessage", payload);
    }
  },
  modules: {},
  getters: {
    getMessage(state) {
      return state.message;
    }
  }
});
