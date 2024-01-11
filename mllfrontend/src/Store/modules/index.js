import { createStore } from "vuex";

export default createStore({

    state: {
        count: 1
    },

    mutations: {
        doubleCount(state) {
            state.count = state.count *2
        },

        multiCountAndNumber(state, payload) {
            state.count = state.count * payload
        }
    },

    getters: {

    },

    actions: {

    },

});
