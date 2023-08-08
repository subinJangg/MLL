<template>
  <div class = "row">
    <header style="backgroundColor:#A6BB8D">
      <ul class="nav justify-content-end bg-light">
        <!-- 로그인 화면 -->
        <li class="nav-item cur">
          <router-link 
            class="nav-link active"
            :to="{ name : 'LoginMember'}" 
          > LOGIN </router-link>
        </li>

        <!-- 회원가입 화면 -->
        <li class="nav-item cur">
          <router-link 
            class="nav-link active"
            :to="{ name : 'JoinMember'}" 
          > JOIN </router-link>
        </li>

        <!-- 쇼핑카트 -->
        <li class="nav-item cur">
          <router-link 
            class="nav-link active"
            :to="{ name : 'ShoppingCartList'}" 
          > CART </router-link>
        </li>
      </ul>

      <ul class="nav justify-content-md-center">
        <li class="nav-item" style="width:100%">
          <router-link
              :to="{ name : 'MainPageHome'}"
              style="text-decoration: none;"
          >
            <i style="font-family:'Giants-Inline'; color:#E9EDC9; font-size:60px" >
              MLL MARKET
            </i>

          </router-link>

        </li>
      </ul>

      <ul class="nav justify-content-center bg-light">
        <!-- 홈화면 -->
        <li class="nav-item cur">
          <router-link 
            class="nav-link active"
            :to="{ name :'MainPageHome'}" 
          > HOME </router-link> 
          
        </li>
        
        <!-- 망링레 소개 -->
        <li class="nav-item cur">
          <router-link 
            class="nav-link active"
            :to="{ name : 'IntroMangLingLe'}"
          > ABOUT MANGLINGLE </router-link>
        </li>

        <!-- 쇼핑리스트 -->
        <li class="nav-item cur">
          <router-link 
            class="nav-link active"
            :to="{ name : 'ShoppingAll'}" 
          > GOODS </router-link>
        </li> 
      </ul>
      <hr style="height:1%;color:#A6BB8D"/>
    </header>
  </div>
</template>
  
<script>
export default {
  name: 'MainPageHeader',
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

.cur {
  text-decoration:none; 
  color: #EA906C;
  cursor: pointer;
} 

.cur:focus {
  text-decoration: none;
  color: #EA906C;
  background: transparent;
  background-color: #d6c39c;
}

/* a:hover {
  text-decoration: none;
  color: #EA906C;
  background-color: #d6c39c;
}*/

</style>
  