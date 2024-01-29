import { createApp } from 'vue'
import App from './App.vue'

//생성한 뷰 라우터 받아오기
import { router } from './router/router.js'

//store import
import store from './Store/store.js'

//axios import
import axios from 'axios'

//폰트 css
import './assets/css/fonts.css'

//공동 css
import './assets/css/custom.css'

// import the fontawesome core
import { library } from '@fortawesome/fontawesome-svg-core'

//  import specific icons : 원하는 아이콘을 개별적으로 import
import { fas } from '@fortawesome/free-solid-svg-icons'
import { far } from '@fortawesome/free-regular-svg-icons'
import { fab } from '@fortawesome/free-brands-svg-icons'

//import font awesome 컴포넌트
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'

//위에서 import한 아이콘들을 Core library에 등록
library.add(fab, far, fas)

//부트스트랩 import :: npm install bootstrap@5.2.3 필수
import 'bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css'

const app = createApp(App)

//font awesome 컴포넌트를 전역으로 등록
app.component('font-awesome-icon', FontAwesomeIcon)


// axios / http 통신 ( 주석 부분 사용 가능 )
//app.config.globalProperties.axios = axios; app.config.globalProperties.foo = 'bar';
//app.provide('$axios', axios)
app.config.globalProperties.$axios = axios

// 라우터 사용
app.use(router)
app.use(store)

app.mount('#app')