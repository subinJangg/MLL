<template>
  <div class="container">

    <div class="d-flex justify-content-center" style="margin-top:50px;">
      <h4>
        <font-awesome-icon :icon="['fas', 'paw']" />
        &nbsp; LOGIN &nbsp;
        <font-awesome-icon :icon="['fas', 'paw']" /> 
      </h4>
    </div>

    <div class="d-flex justify-content-center" style="margin-top:10px;">
      <input
          v-model="userId"
          class="form-control box_size" 
          type="text"
          maxlegth="16"
          placeholder="ID"
          ref="userId"
          @keydown.enter="checkId()"
        />
    </div>
    <div class="d-flex justify-content-center" style="margin-top:10px;">
      <input
        v-model="userPass"
        ref="userPass"
        class="form-control box_size"
        type="text"
        maxlegth="20"
        placeholder="PASSWORD"
        @keydown.enter="checkPass()"
      />
<!--       oninput="javascript: this.value = this.value.replace(/[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/g, '');"-->
    </div>

    <div class="d-flex justify-content-center" style="margin-top:10px;">
      <span class="input-group-btn">
        <button
            class="btn btn_color box_size float-start"
            type="button"
            @click="loginBtn()"
        >
          로그인
        </button>
      </span>
    </div>

    <div class="d-flex justify-content-center" style="margin-top:10px;">
        <router-link 
            class="nav-link active"
            :to="{ name : 'FindId'}" 
          > 아이디 찾기  &nbsp; </router-link> | 
          <router-link 
            class="nav-link active"
            :to="{ name : 'FindPass'}" 
          > &nbsp; 비밀번호 찾기 &nbsp; </router-link> | 
          <router-link 
            class="nav-link active"
            :to="{ name : 'JoinMember'}" 
          > &nbsp; 회원가입 </router-link>
    </div>
  </div>
</template>
    
<script>
import _ from 'lodash';

export default {
  name: "LoginMember",

  data() {
    return {
      chkPass: false,
      userId: '',
      userPass: '',

    };
  },

  mounted() {
    this.$refs.userId.focus();   
  },

  methods: {

    // 아이디 특수문자 제어
    checkId() {

      const num = this.userId.search(/[0-9]/g);
      const eng = this.userId.search(/[a-z]/gi);

      if(eng < 0 && num < 0) {
        alert("영문, 숫자를 이용하여 아이디를 입력해주세요");
        this.$refs.userId.focus();
        return;
      } else if(this.userId.search(/\s/) != -1) {
        alert("아이디는 공백 없이 입력해주세요 :)");
        this.$refs.userId.focus();
        return;
      }
    },
    
    // 비밀번호 특수문자 제어
    checkPass() {

      const num = this.userPass.search(/[0-9]/g);
      const eng = this.userPass.search(/[a-z]/gi);
      const spe = this.userPass.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);

      if (num < 0 || eng < 0 || spe < 0) {
        alert("비밀번호는 영문, 숫자, 특수문자를 혼합하여 입력해주세요 :)");
        this.$refs.userPass.focus();
        return;
      }
    },

    // 로그인 버튼
    loginBtn() {
      if(_.isEmpty(this.userId)) {
        alert("아이디를 입력해주세요");
        this.$refs.userId.focus();
        return;
      } else if(_.isEmpty(this.userPass)) {
        alert("비밀번호를 입력해주세요");
        this.$refs.userPass.focus();
        return;
      }

    },



  },
}


</script>

<style scoped>
.box_size {
  width: 300px;
}

.btn_color {
  background-color: #FFD89C
}

.btn_color:active {

}

</style>