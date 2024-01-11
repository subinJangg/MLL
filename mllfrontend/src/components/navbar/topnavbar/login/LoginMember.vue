<template>
  <div class="container">

    <div class="d-flex justify-content-center" >
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

      const spe = this.userId.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
      const kor = this.userId.search(/[가-힣ㄱ-ㅎㅏ-ㅣ]/g);
      const wht = this.userId.search(/\s/);

      if(_.isEmpty(this.userId)) {
        alert("아이디를 입력해주세요");
        this.$refs.userId.focus();
        return;
      } else if(spe != -1 || kor != -1) {
        alert("영문, 숫자를 이용하여 아이디를 입력해주세요");
        this.$refs.userId.focus();
        return;
      } else if(wht != -1) {
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

      if(_.isEmpty(this.userPass)) {
        alert("비밀번호를 입력해주세요");
        this.$refs.userPass.focus();
        return;
      } else if (num < 0 || eng < 0 || spe < 0) {
        alert("비밀번호는 영문, 숫자, 특수문자를 혼합하여 입력해주세요 :)");
        this.$refs.userPass.focus();
        return;
      }
    },

    // 로그인 버튼
    loginBtn() {

      if(_.isEmpty(this.userId)) {
        this.$refs.userId.focus();
        alert("아이디를 입력해주세요");
        return;
      } else if(_.isEmpty(this.userPass)) {
        alert("비밀번호를 입력해주세요");
        this.$refs.userPass.focus();
        return;
      }

      const value = {
        userId: this.userId,
        userPass: this.userPass,
      }
      console.log(value);
      this.$axios.post('/api/test/gLoginUs', value)
          .then(({ data }) =>{
      console.log(data)
            if(_.isEmpty(data)) {
              alert("아이디나 비밀번호가 일치하지 않습니다.\n 다시 로그인해주세요 :)");
              this.userId = "";
              this.userPass = "";
              this.$refs.userId.focus();
              return;
            } else {
              alert("로그인 성공 :)");
              return;
            }

          }).catch(({ message }) => {
            alert(message);
            alert("처리중 오류가 발생하였습니다.\n 고객센터에 문의해주세요 :)");
            return;
      })






    },
  },
}


</script>

<style scoped>
.box_size {
  width: 300px;
}


.btn {
  border-radius: 3px
}

.btn_color {
  background: #FFD89C;
  border: 1px solid #ecc387;
}

button.btn_color:hover,
button.btn_color:focus,
button.btn_color:active {
  background: #f8cf94;
  border: 1px solid #ecc387;
}
</style>