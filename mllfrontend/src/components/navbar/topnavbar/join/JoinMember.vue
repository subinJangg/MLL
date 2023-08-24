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
            class="form-control "
            type="text"
            maxlength="16"
            placeholder="아이디 입력"
            ref="userId"
            style="width:350px"
            @change="checkId()"
        />
<!--        <span class="input-group-btn">-->
<!--          <button-->
<!--              type="button"-->
<!--              class="btn btn-light border"-->
<!--              style="width: 100px;background-color: #FFD89C;"-->
<!--              ref="chkId"-->

<!--          >-->
<!--            중복확인-->
<!--          </button>-->
<!--        </span>-->
      </div>
      <div class="d-flex justify-content-center" style="color:red;">
        <i> {{ showMes }} </i>
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

        />
      <i style="width:25px; margin-top:7px"> @ </i>
        <span v-if="searchEmail == '직접입력'">
          <input
              v-model="searchEm"
              class="form-control"
              maxlength="20"
              placeholder=""
              ref="searchEm"
              style="width:100px"
          />
        </span>
        <span v-else>
        <input
            v-model="searchEm"
            class="form-control"
            maxlength="20"
            placeholder=""
            ref="searchEmail"
            style="width:100px"
            disabled
        />
          </span>
        <select
            v-model="searchEmail"
            ref="searchEmail"
            class="form-control"
            style="width:100px"
            @change="EamilDomEv()"
        >
          <option
              v-for="option in searchEmailOptions"
              :key="option.value"
              :value="option.value"
          >
            {{ option.value }}
          </option>
        </select>
    </div>
    <div class="d-flex justify-content-center title_margin">
      <i class="title_line">성별</i>
    </div>

    <div class="d-flex justify-content-center title_margin">
      <i class="title_line cur" style="color:red" @click="openPanel()">
        약관 동의 (필수 *)
      </i>
      <i class="panel_clk cur" @click="openPanel()">
        <font-awesome-icon :icon="['far', 'square-caret-down']" />
      </i>
    </div>
    <div class="d-flex justify-content-center" style="margin-bottom:30px">
      <div v-show="isPanelOpen">
        <i class="term_title">ฅ 이용약관</i>
        <input
               class="form-control panel_size"
               placeholder="이용약관"
               disabled
        />
        <i class="term_chk cur" style="margin-bottom: 10px" @click="chkTerm()">
          위의 이용약관에 동의합니다. &nbsp;
          <input
            v-model="termChk"
            type="checkbox"
          >
        </i>
        <i class="term_title">ฅ 개인정보 수집 및 이용에 대한 안내 &nbsp;</i>
        <input
           class="form-control panel_size"
           placeholder="개인정보 수집 동의사항"
           disabled
        />
        <i class="term_chk cur" @click="chkPri()">
          위의 개인정보 수집 및 이용에 대한 안내에 동의합니다. &nbsp;
          <input
              v-model="priChk"
              type="checkbox"
          >
        </i>
        <i class="term_chk cur" @click="chkAll()">
          위의 이용약관 및 개인정보 수집 및 이용에 대한 안내에 동의합니다. &nbsp;
          <input
              v-model="allChk"
              type="checkbox"
          >
        </i>
      </div>
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
      searchEm: "",
      searchEmail: "선택",
      searchEmailOptions: [
        { value: '선택' },
        { value: 'naver.com' },
        { value: 'gmail.com' },
        { value: 'daum.net' },
        { value: 'nate.com' },
        { value: '직접입력' },
      ],
      isPanelOpen: false,
      termChk: false,
      priChk: false,
      allChk: false,
      searchId: [],
      chkId: null,
      showMes: "",
      test22: false,
      isTest:false,
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

      //const num = this.userId.search(/[0-9]/g);
      //const eng = this.userId.search(/[a-z]/gi);
      const kor = this.userId.search(/[ㄱ-ㅎㅏ-ㅣ가-힣]/g);
      const spe = this.userPass.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);

      if (_.isEmpty(this.userId)) {
        alert("먼저 아이디를 입력해주세요 :)");
        this.showMes="";
        this.$refs.userId.focus();
        return;
      } else if(this.userId.length < 6 || this.userId.length > 15 ) {
        alert("아이디는 6자리~15자리 이내로 입력해주세요 :)");
        this.showMes="";
        this.$refs.userId.focus();
        return;
      } else if( kor > -1 || spe > -1) {
        alert("아이디는 영문과 숫자만 이용하여 입력해주세요 :)");
        this.showMes="";
        this.$refs.userId.focus();
        return;
      } else if(this.userId.search(/\s/) != -1) {
        alert("아이디는 공백 없이 입력해주세요 :)");
        this.showMes="";
        this.$refs.userId.focus();
      }

      let value = {
        userId: this.userId,
      }

      this.$axios.post('/api/test/gSearchId', value)
          .then(({ data }) => {
            this.chkId = data.length;

            if(_.isEqual(data.length, 1)) {
              this.showMes = "사용할 수 없는 아이디 입니다. :)";
              this.$refs.userId.focus();
              return;
            } else{
              this.showMes = "사용 가능한 아이디 입니다. :)";
              this.$refs.userPass.focus();
              return;
            }

          });
    },

    // 이메일 도메인 선택
    EamilDomEv() {
      if (_.isEqual(this.searchEmail, "선택")) {
        this.searchEm = "";
        return;
      } else if (_.isEqual(this.searchEmail, "직접입력")) {
        this.searchEm = "";
        this.$refs.searchEm.focus();
        return;
      } else {
        this.searchEm = this.searchEmail;
        return;
      }
    },

    // 비밀번호 체크 :: 한글 X, 문자`숫자`특수문자 필수 포함, 8 ~ 20자
    checkPass() {

      const num = this.userPass.search(/[0-9]/g);
      const eng = this.userPass.search(/[a-z]/gi);
      const spe = this.userPass.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);

      // if(_.isEqual(this.chkId, 1) || _.isEmpty(this.userId)) {
      //   alert("아이디를 체크해주세요 :)");
      //   console.log(this.chkId);
      //   this.$refs.userId.focus();
      //   return;

      if (_.isEmpty(this.userPass)) {
        alert("비밀번호를 입력해주세요 :)");
        this.$refs.userPass.focus();
        return;
      } else if(this.userPass.length < 8 || this.userPass.length > 20) {
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
        alert("비밀번호가 일치하지 않습니다 :(");
        this.$refs.userPass2.focus();
        return;
      }
    },

    openPanel() {
      this.isPanelOpen = !this.isPanelOpen;
    },

    // 이용약관 체크
    chkTerm() {
      this.termChk = !this.termChk;
    },

    // 개인정보 수집 약관 체크
    chkPri() {
      this.priChk = !this.priChk;
    },

    // 필수 이용 약관 전체 체크
    chkAll() {
      this.termChk = !this.allChk;
      this.priChk = !this.allChk;
      this.allChk = !this.allChk;
    },

    // 회원가입 버튼 연동
    saveUserInfo() {
      // this.checkId();
      // this.checkPass();
      // this.checkPass2();
      if (_.isEmpty(this.userId)) {
        alert("아이디를 입력해주세요 :)");
        this.$refs.userId.focus();
        return;
      } else if (_.isEmpty(this.userPass)) {
        alert("비밀번호를 입력해주세요 :)");
        this.$refs.userPass.focus();
        return;
      } else if (_.isEmpty(this.userPass2)) {
        alert("비밀번호를 재입력해주세요 :)");
        this.$refs.userPass2.focus();
        return;
      } else if (_.isEmpty(this.userName)) {
        alert("이름을 입력해주세요 :)");
        this.$refs.userName.focus();
        return;
      } else if (_.isEmpty(this.userPhone1)) {
        alert("전화번호를 입력해주세요 :)");
        this.$refs.userPhone1.focus();
        return;
      } else if (_.isEmpty(this.userPhone2)) {
        alert("전화번호를 입력해주세요 :)");
        this.$refs.userPhone2.focus();
        return;
      } else if (_.isEmpty(this.userPhone3)) {
        alert("전화번호를 입력해주세요 :)");
        this.$refs.userPhone3.focus();
        return;
      } else if (_.isEmpty(this.zonecode)) {
        alert("주소를 입력해주세요 :)");
        this.$refs.zonecode.focus();
        return;
      } else if (this.termChk === false) {
        alert("약관동의를 모두 체크해주세요 :)");
        this.isPanelOpen = true;
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

.cur {
  cursor: pointer;
}

.panel_size {
  width: 350px;
  height: 100px;
  overflow: auto;
  font-size: xx-small;
}
.panel_clk {
  justify-content: flex-end;
  margin-left:-15px;
}

.term_title {
  width:350px;
  display: flex;
  justify-content: center;
  font-size: small;
}
.term_chk {
  width:350px;
  display: flex;
  justify-content: flex-start;
  font-size: small;
}


</style>
    