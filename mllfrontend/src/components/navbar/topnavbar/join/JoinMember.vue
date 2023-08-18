<template>
    <div class="row">
    <div class="d-flex justify-content-center">
        <h4>
          <font-awesome-icon :icon="['fas', 'paw']" />
            &nbsp; JOIN US &nbsp;
          <font-awesome-icon :icon="['fas', 'paw']" />
        </h4>
    </div>
        <div class="d-flex justify-content-center" style="margin-top:10px;">
          아이디
        </div>

        <div class="d-flex justify-content-center" style="margin-top:10px;">
          <input
              v-model="userId"
              class="form-control box_size"
              type="text"
              maxlength="16"
              placeholder="아이디 입력"
              ref="userId"
              @change="checkId()"
            />
        </div>

    <div class="d-flex justify-content-center" style="margin-top:10px;">
      비밀번호
    </div>
    <div class="d-flex justify-content-center" style="margin-top:10px;">
      <input
        v-model="userPass"
        class="form-control box_size" 
        type="text"
        maxlength="20"
        placeholder="비밀번호 입력"
        ref="userPass"
        @change="checkPass()"
      />
    </div>

    <div class="d-flex justify-content-center " style="margin-top:10px;">
      비밀번호 확인
    </div>
    <div class="d-flex justify-content-center" style="margin-top:10px;">
      <input
        v-model="userPass2"
        class="form-control box_size"
        type="text"
        maxlength="20"
        placeholder="비밀번호 재입력"
        ref="userPass2"
        @change="checkPass2()"
      />
    </div>

    <div class="d-flex justify-content-center " style="margin-top:10px;">
      이름
    </div>
    <div class="d-flex justify-content-center" style="margin-top:10px;">
      <input
        v-model="userName"
        class="form-control box_size" 
        type="text"
        maxlength="20"
        placeholder="이름을 입력해주세요"
        ref="userName"
      />
    </div>

    <div class="d-flex justify-content-center" style="margin-top:10px;">
      <div class="text-left" style="width:300px">
        전화번호
      </div>
    </div>

    <div class="d-flex justify-content-center" style="margin-top:15px;">
      <input
        v-model="userPhone1"
        class="form-control " 
        type="text"
        maxlength="3"
        placeholder="010"
        style="width: 85px; margin-top:-7px"
        ref="userPhone1"
      /> &nbsp; - &nbsp; 
      <input
        v-model="userPhone2"
        class="form-control " 
        type="text"
        maxlength="4"
        placeholder=""
        style="width: 85px; margin-top:-7px"
        ref="userPhone2"
      /> &nbsp; - &nbsp;
      <input
        v-model="userPhone3"
        class="form-control " 
        type="text"
        maxlength="4"
        placeholder=""
        style="width: 85px; margin-top:-7px"
        ref="userPhone3"
      />
    </div>
      <div class="d-flex justify-content-center" style="margin-top:10px;">
        주소
      </div>
      <div class="d-flex justify-content-center" style="margin-top:10px;">
        <input
            v-model="zonecode"
            class="form-control"
            type="text"
            maxlength="20"
            placeholder="우편번호"
            style="width: 230px;"
            ref="zonecode"
            readonly
        />
        <span class="input-group-btn">
          <button
              type="button"
              class="btn btn-light border"
              style="width: 70px;background-color: #FFD89C;"
              @click="openPostcode()"
          >
            검색
          </button>
        </span>
      </div>

      <div class="d-flex justify-content-center" style="margin-top:10px;">
        <input
            v-model="roadAddress"
            class="form-control box_size"
            type="text"
            maxlength="20"
            placeholder="주소"
            readonly
        />
      </div>
      <div class="d-flex justify-content-center" style="margin-top:10px;">
        <input
            v-model="datailAddress"
            class="form-control box_size"
            type="text"
            maxlength="20"
            placeholder="상세주소"
            ref="datailAddress"
        />
    </div>
    <div class="d-flex justify-content-center" style="margin-top:10px; margin-bottom:30px">
      <span class="input-group-btn">
        <button
            type="button"
            class="btn box_size"
            style="background-color: #FFD89C"
            @click="saveUserInfo()"
        >
          가입하기
        </button>
      </span>
    </div>
  </div>
</template>

<script>
import _ from 'lodash';

export default{
  name : "JoinMember",
  data() {
    return {
      show1: false,
      userId: "",
      userPass: "",
      userPass2: "",
      userName: "",
      userPhone1: "",
      userPhone2: "",
      userPhone3: "",
      zonecode: "",
      roadAddress: "",
      datailAddress:"",
    };
  },

  mounted() {
    this.$refs.userId.focus();
  },

  methods: {

    //다음 주소 연동
    openPostcode() {
      new window.daum.Postcode({
        oncomplete: (data) => {
          this.zonecode = data.zonecode;
          this.roadAddress = data.roadAddress;
        },
      }).open();
    },

    // 아이디 체크 :: 한글 X, 6 ~ 15자
    checkId() {

      const num = this.userId.search(/[0-9]/g);
      const eng = this.userId.search(/[a-z]/gi);

      console.log("총 길이 :: " + this.userId.length);

      if(this.userId.length < 6 || this.userId.length > 15 ) {
        alert("아이디는 6자리~15자리 이내로 입력해주세요 :)");
        this.$refs.userId.focus();
        return;
      } else if(eng < 0 && num < 0) {
        alert("아이디는 영문, 숫자를 혼합하여 입력해주세요 :)");
        this.$refs.userId.focus();
        return;
      } else if(this.userId.search(/\s/) != -1) {
        alert("아이디는 공백 없이 입력해주세요 :)");
        this.$refs.userId.focus();
      }
    },

    // 비밀번호 체크 :: 한글 X, 문자`숫자`특수문자 필수 포함, 8 ~ 20자
    checkPass() {

      const num = this.userPass.search(/[0-9]/g);
      const eng = this.userPass.search(/[a-z]/gi);
      const spe = this.userPass.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);

      console.log("총 길이 :: " + this.userPass.length);

      if(this.userPass.length < 8 || this.userPass.length > 20) {
        alert("비밀번호는 8자리~20자리 이내로 입력해주세요 :)");
        this.$refs.userPass.focus();
        return;
      } else if (num < 0 || eng < 0 || spe < 0) {
        alert("비밀번호는 영문, 숫자, 특수문자를 혼합하여 입력해주세요 :)");
        this.$refs.userPass.focus();
        return;
      } else if(this.userPass.search(/\s/) != -1) {
        alert("비밀번호는 공백 없이 입력해주세요 :)");
        this.$refs.userPass.focus();
      }
    },

    // 재입력 비밀번호 체크
    checkPass2() {
      if(!_.isEqual(this.userPass, this.userPass2)) {
        alert("비밀번호가 일치하지 않습니다.");
        this.$refs.userPass2.focus();
        return;
      }
    },

    // 회원가입 버튼 연동
    saveUserInfo() {
      if (_.isEmpty(this.userId)) {
        alert("아이디를 입력해주세요");
        this.$refs.userId.focus();
        return;
      } else if (_.isEmpty(this.userPass)) {
        alert("비밀번호를 입력해주세요");
        this.$refs.userPass.focus();
        return;
      } else if (_.isEmpty(this.userPass2)) {
        alert("비밀번호를 재입력해주세요");
        this.$refs.userPass2.focus();
        return;
      } else if (_.isEmpty(this.userName)) {
        alert("이름을 입력해주세요");
        this.$refs.userName.focus();
        return;
      } else if (_.isEmpty(this.userPhone1)) {
        alert("전화번호를 입력해주세요");
        this.$refs.userPhone1.focus();
        return;
      } else if (_.isEmpty(this.userPhone2)) {
        alert("전화번호를 입력해주세요");
        this.$refs.userPhone2.focus();
        return;
      } else if (_.isEmpty(this.userPhone3)) {
        alert("전화번호를 입력해주세요");
        this.$refs.userPhone3.focus();
        return;
      } else if (_.isEmpty(this.zonecode)) {
        alert("주소를 입력해주세요");
        this.$refs.zonecode.focus();
        return;
      } else if (_.isEmpty(this.datailAddress)) {
        alert("상세주소를 입력해주세요");
        this.$refs.datailAddress.focus();
        return;
      }
    },
  }
}
</script>

<style scoped>
.box_size {
  width: 300px;
}

</style>
    