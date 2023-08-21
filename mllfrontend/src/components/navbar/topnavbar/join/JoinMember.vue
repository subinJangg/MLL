<template>
    <div class="row">
      <div class="d-flex justify-content-center">
        <h4>
          <font-awesome-icon :icon="['fas', 'paw']" />
            &nbsp; JOIN US &nbsp;
          <font-awesome-icon :icon="['fas', 'paw']" />
        </h4>
      </div>

      <div class="d-flex justify-content-center title_margin">
        <i class="title_line">아이디</i>
      </div>

      <div class="d-flex justify-content-center">
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

      <div class="d-flex justify-content-center title_margin">
        <i class="title_line">비밀번호</i>
      </div>
      <div class="d-flex justify-content-center" >
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

      <div class="d-flex justify-content-center title_margin">
        <i class="title_line">비밀번호 확인</i>
      </div>
      <div class="d-flex justify-content-center">
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

      <div class="d-flex justify-content-center" style="margin-top:15px;">
        <i class="title_line">이름</i>
      </div>
      <div class="d-flex justify-content-center">
        <input
          v-model="userName"
          class="form-control box_size"
          type="text"
          maxlength="20"
          placeholder="이름을 입력해주세요"
          ref="userName"
        />
      </div>

      <div class="d-flex justify-content-center title_margin">
        <i class="title_line">전화번호</i>
      </div>

      <div class="d-flex justify-content-center">
        <input
          v-model="userPhone1"
          class="form-control "
          type="text"
          maxlength="3"
          placeholder="010"
          style="width: 95px;"
          ref="userPhone1"
        />
        <i style="width:30px; margin-top:7px"> - </i>
        <input
          v-model="userPhone2"
          class="form-control "
          type="text"
          maxlength="4"
          placeholder=""
          style="width: 95px;"
          ref="userPhone2"
        />
        <i style="width:30px; margin-top:7px"> - </i>
        <input
          v-model="userPhone3"
          class="form-control "
          type="text"
          maxlength="4"
          placeholder=""
          style="width: 95px;"
          ref="userPhone3"
        />
      </div>
      <div class="d-flex justify-content-center title_margin">
        <i class="title_line">주소</i>
      </div>
      <div class="d-flex justify-content-center ">
        <input
            v-model="zonecode"
            class="form-control"
            type="text"
            maxlength="20"
            placeholder="우편번호"
            style="width: 250px;"
            ref="zonecode"
            readonly
        />
        <span class="input-group-btn">
          <button
              type="button"
              class="btn btn-light border"
              style="width: 100px;background-color: #FFD89C;"
              @click="openPostcode()"
          >
            검색
          </button>
        </span>
      </div>

      <div class="d-flex justify-content-center" style="margin-top:5px;">
        <input
            v-model="roadAddress"
            class="form-control box_size"
            type="text"
            maxlength="20"
            placeholder="주소"
            readonly
        />
      </div>
      <div class="d-flex justify-content-center" style="margin-top:5px;">
        <input
            v-model="datailAddress"
            class="form-control box_size"
            type="text"
            maxlength="20"
            placeholder="상세주소"
            ref="datailAddress"
        />
    </div>

    <div class="d-flex justify-content-center title_margin">
      <i class="title_line">이메일 주소</i>
    </div>
    <div class="d-flex justify-content-center">
      <input
          v-model="emailAdd"
          class="form-control"
          type="text"
          maxlength="20"
          placeholder="이메일 입력"
          ref="emailAdd"
          style="width:125px"
          @change="emailAdd()"
      />
      <i style="width:25px; margin-top:7px"> @ </i>
      <span v-if="searchEmail !== '1' || searchEmail !== '6'">
        <input
            v-model="searchEmail"
            class="form-control"
            maxlength="20"
            placeholder=""
            ref="searchEmail"
            style="width:100px"
            disabled
        />
      </span>
      <span v-if="searchEmail === '6'">

      </span>
        <select
            v-model="searchEmail"
            ref="searchEmail"
            class="form-control"
            style="width:100px"
            @change="styleChg()"
        >
          <option
              v-for="option in searchEmailOptions"
              :key="option.value"
              :value="option.value"
          >
            {{ option.text }}
          </option>
        </select>
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
      emailAdd: "",
      searchEmail: "1",
      searchEmailOptions: [
        { text: '선택', value: '1' },
        { text: 'naver.com', value: '2' },
        { text: 'gmail.com', value: '3' },
        { text: 'daum.net', value: '4' },
        { text: 'nate.com', value: '5' },
        { text: '직접입력', value: '6' },
      ],
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

    styleChg() {
   //   test = this.searchEmail.value;
      console.log(this.searchEmailOptions.text);
      console.log(this.searchEmail);
      console.log(this.searchEmailOptions.text);
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
  width: 350px;
}

.title_margin {
  margin-top:15px;
}

.title_line {
  width:350px;
  display: flex;
  justify-content: flex-start;
}

</style>
    