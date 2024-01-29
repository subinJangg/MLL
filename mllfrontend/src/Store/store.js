import { createStore } from "vuex";

export default createStore({

    state: {
        account: {
            id: 0
        }
    },

    mutations: {
        setAccount(state, payload) {
            state.account.id = payload;
        }
    },

    getters: {

    },

    actions: {

    },

});
