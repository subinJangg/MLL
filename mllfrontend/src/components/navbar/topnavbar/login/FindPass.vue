<template>
  <div class="container">

    <div class="d-flex justify-content-center" style="margin-top:50px;">
      <h4>
        <font-awesome-icon :icon="['fas', 'paw']" />
        &nbsp; 비밀번호 찾기 &nbsp;
        <font-awesome-icon :icon="['fas', 'paw']" /> 
      </h4>
    </div>

    <div class="d-flex justify-content-center" style="margin-top:10px;">
      <h6>
        계속하려면 먼저 아이디를 인증하세요.
      </h6>
    </div>

    <div class="d-flex justify-content-center" style="margin-top:10px;">
      <input
          v-model="searchUserId"
          class="form-control box_size"
          type="text"
          maxlength="20"
          placeholder="아이디 입력"
          ref="searchUserId"
      />
    </div>

    <div class="d-flex justify-content-center" style="margin-top:10px; margin-bottom:10px">
      <span class="input-group-btn">
        <button
            type="button"
            class="btn box_size"
            style="background-color: #FFD89C"
            @click="searchPass()"
        >
          확인
        </button>
      </span>
    </div>

    <div class="d-flex justify-content-center" style="margin-top:50px;">
      <h6 style="margin-top:9px">
        비밀번호는 &nbsp;
      </h6>
      <input
          v-model="userPass"
          class="form-control"
          type="text"
          style="width:180px"
          maxlength="20"
          disabled
      />
      <h6 style="margin-top:9px">
        &nbsp; 입니다.
      </h6>
    </div>

    <div class="d-flex justify-content-center" style="margin-top:10px; margin-bottom:10px">
      <span class="input-group-btn">
        <button
            type="button"
            class="btn box_size"
            style="background-color: #FFD89C"
            @click="goToLogin()"
        >
          로그인하러가기 ฅ
        </button>
      </span>
    </div>
  </div>
</template>
  
<script>
import _ from 'lodash';

  export default{
    name : "FindPass",
    data() {
      return {
        searchUserList: [],
        userPass: this.userPass,
        searchUserId: '',
      };
    },

    mounted() {
      this.$refs.searchUserId.focus();
    },

    methods: {

      searchPass() {

        if(_.isEmpty(this.searchUserId)) {
          alert("아이디를 입력해주세요 :)");
          this.$refs.searchUserId.focus();
          return;
        }

        let value = {
          searchUserId: this.searchUserId,
        }

        this.searchUserList.splice(0);

        this.$axios.post('/api/test/gTest', value)
            .then(({ data }) => {

              // 아이디 유효성 체크
              if (_.isEmpty(data)) {
                console.log(data);
                alert("아이디를 다시 입력해주세요 :)");
                this.searchUserId = "";
                this.$refs.searchUserId.focus();
                return;
              }

              for (let i = 0; i < data.length; i++) {
                this.searchUserList.splice(i, 0, data[i]);
                this.userPass = data[i].userPass;
              }
            }).catch(({ message }) =>{
              alert(message);
              alert("처리중 오류가 발생하였습니다 고객센터에 문의해주세요 :)");
              return;
            });
      },

      goToLogin() {
        if(!_.isEmpty(this.userPass)) {
          this.$router.push({ name: 'LoginMember', param: { userId: this.searchUserId } });
          console.log(this.searchUserId);
        } else {
          alert("아이디 인증을 먼저 해주세요 :)");
          this.$refs.searchUserId.focus();
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

.cur {
  cursor: pointer;
}
</style>