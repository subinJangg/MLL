<template>
  <div class = "row">
    <header style="backgroundColor:#A6BB8D">
      <ul class="nav justify-content-end" style="backgroundColor:#EEEEEE">
        <!-- 로그인 화면 -->
        <li class="nav-item ">
          <router-link 
            class="nav-link active cur"
            :to="{ name : 'LoginMember'}" 
          >
            <font-awesome-icon :icon="['fas', 'key']" />
          </router-link>
        </li>

        <!-- 회원가입 화면 -->
        <li class="nav-item">
          <router-link 
            class="nav-link active cur"
            :to="{ name : 'JoinMember'}" 
          >
            <font-awesome-icon :icon="['fas', 'handshake']" />
          </router-link>
        </li>

        <!-- 쇼핑카트 -->
        <li class="nav-item">
          <router-link 
            class="nav-link active cur"
            :to="{ name : 'ShoppingCartList'}" 
          >
            <font-awesome-icon :icon="['fas', 'cart-shopping']" />
          </router-link>
        </li>

        <!-- 마이페이지 :: 본인확인 -->
        <li class="nav-item">
          <router-link
              class="nav-link active cur"
              :to="{ name : 'MyPagePassCheck'}"
          >
            <font-awesome-icon :icon="['fas', 'person-shelter']" />
          </router-link>
        </li>
      </ul>

      <!-- MLL 마켓 로고 -->
      <ul class="nav justify-content-md-center">
        <li class="nav-item" style="width:100%">
          <router-link
              :to="{ name : 'MainPageHome'}"
              style="text-decoration: none;"
          >
            <i class="logo" >
              MLL MARKET
            </i>
          </router-link>
        </li>
      </ul>

      <ul class="nav justify-content-center" style="backgroundColor:#EEEEEE">
        <!-- 홈화면 -->
        <li class="nav-item ">
          <router-link 
            class="nav-link active cur"
            :to="{ name :'MainPageHome'}" 
          > HOME </router-link>
        </li>
        
        <!-- 망링레 소개 -->
        <li class="nav-item cur">
          <router-link 
            class="nav-link active cur"
            :to="{ name : 'IntroMangLingLe'}"
          > ABOUT MANGLINGLE </router-link>
        </li>

        <!-- 쇼핑리스트 -->
        <li class="nav-item ">
          <router-link 
            class="nav-link active cur"
            :to="{ name : 'ShoppingAll'}" 
          > GOODS </router-link>
        </li> 
      </ul>
      <hr style="height:1%;color:#A6BB8D"/>
    </header>
  </div>
</template>
  
<script>
import MyPagePassCheck from "@/components/navbar/topnavbar/userpage/MyPagePassCheck.vue";

export default {
  name: 'MainPageHeader',
  computed: {
    MyPagePassCheck() {
      return MyPagePassCheck
    }
  },
  data() {
    return {



    };
  },

  methods: {

    /* 망링레마켓 로고 클릭시 메인페이지로 이동 */ 

  },
  // ...
}
</script>
  
<style scoped>

header {

}

.cur {
  text-decoration:none; 
  color: #FAAB78;
  cursor: pointer;
}


.cur:active {
  text-decoration: none;
  color: #d6c39c;
  background: transparent;
}

.cur:focus {
  text-decoration: none;
  color: #939B62;
  background: transparent;

}
/*background-color: #d6c39c;*/
.cur:hover {
  text-decoration: none;
  color: #EA906C;
  background-color: #d6c39c;
}

.logo {
  font-family:'Giants-Inline';
  color:#E9EDC9;
  font-size:70px
}

</style>
  