import router from './router/index.js';

const loginMember = {
    state: {
        userId: '',
        username:'',
        token:'',
    },
    mutations: {
        login: function (state, payload) {
            state.userId = payload.userId
            state.userPass = payload.userPass
            state.token = payload.token
        },
        loginCheck: function (state) {
            if(!state.token) {
                router.push({
                    name: 'LoginMember'
                }).catch(error =>{
                    console.log(error)
                })
            }
        }
    }
}

export default loginMember

