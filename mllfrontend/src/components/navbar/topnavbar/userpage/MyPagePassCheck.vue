<template>
  <div class="row">
    <div class="d-flex justify-content-center">
      <h4>
        <font-awesome-icon :icon="['fas', 'paw']" />
          &nbsp; MY PAGE &nbsp;
        <font-awesome-icon :icon="['fas', 'paw']" />
      </h4>
    </div>
    <div class="d-flex justify-content-center" style="margin-top:10px;">
        <h6>
          계속하려면 먼저 본인임을 인증하세요.
        </h6>
    </div>
    <div class="d-flex justify-content-center" style="margin-top:10px;">
      <h5>
        <font-awesome-icon :icon="['far', 'circle-user']" />
        {{ userId }}
      </h5>
    </div>
    <div class="d-flex justify-content-center" style="margin-top:10px;">
      <input
          v-model="userPass"
          class="form-control box_size"
          type="text"
          maxlength="20"
          placeholder="비밀번호 입력"
          ref="userPass"
      />
    </div>
    <div class="d-flex justify-content-center" style="margin-top:10px; margin-bottom:10px">
      <span class="input-group-btn">
        <button
            type="button"
            class="btn box_size"
            style="background-color: #FFD89C"
            @click="intoMypage()"
        >
          확인
        </button>
      </span>
    </div>
  </div>
</template>

<script>
import _ from 'lodash';

export default {

  name : "MyPagePassCheck",
  data() {
    return{
      userId: "",
      userPass: "",
    };
  },

  mounted() {
    this.$refs.userPass.focus();
  },

  methods: {

    // 비밀번호 확인
    checkPass() {

    },

    // 확인버튼
    intoMypage() {
      if(_.isEmpty(this.userPass)) {
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

</style>
