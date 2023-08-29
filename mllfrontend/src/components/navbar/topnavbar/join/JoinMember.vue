<template xmlns:active="http://www.w3.org/1999/xhtml">
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

      </div>
      <div class="d-flex justify-content-center" style="color:red;">
        <i> {{ showMsg }} </i>
      </div>

      <div class="d-flex justify-content-center title_margin">
        <i class="title_line">비밀번호</i>
      </div>
      <div class="d-flex justify-content-center" >
        <input
          v-model="userPass"
          class="form-control "
          type="password"
          maxlength="20"
          placeholder="비밀번호 입력"
          ref="userPass"
          style="width:310px"
          @change="checkPass()"
        />
        <font-awesome-icon
            v-if="!showPass"
            @click="showPassword()"
            style="cursor:pointer; width:30px; margin-left:10px; margin-top:7px"
            :icon="['far', 'eye-slash']"
        />
        <font-awesome-icon
            v-if="showPass"
            @click="showPassword()"
            style="cursor:pointer; width:30px; margin-left:10px; margin-top:7px"
            :icon="['far', 'eye']"
        />
      </div>

      <div class="d-flex justify-content-center title_margin">
        <i class="title_line">비밀번호 확인</i>
      </div>
      <div class="d-flex justify-content-center">
        <input
          v-model="userPassChk"
          class="form-control "
          type="password"
          maxlength="20"
          placeholder="비밀번호  재입력"
          ref="userPassChk"
          style="width:310px"
          @keyup.enter="checkPassChk()"
        />
        <font-awesome-icon
            v-if="!showPassChk"
            @click="showPasswordChk()"
            style="cursor:pointer; width:30px; margin-left:10px; margin-top:7px"
            :icon="['far', 'eye-slash']"
        />
        <font-awesome-icon
            v-if="showPassChk"
            @click="showPasswordChk()"
            style="cursor:pointer; width:30px; margin-left:10px; margin-top:7px"
            :icon="['far', 'eye']"
        />
      </div>
      <div class="d-flex justify-content-center" style="color:red;">
        <i> {{ showPassMsg }} </i>
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
          @keyup.enter="checkName()"
        />
      </div>

      <div class="d-flex justify-content-center title_margin">
        <i class="title_line">전화번호</i>
      </div>

      <div class="d-flex justify-content-center">
        <input
          v-model="userHp1"
          class="form-control "
          type="text"
          maxlength="3"
          placeholder="010"
          style="width: 95px;"
          ref="userHp1"
          @keyup.enter="checkHp1()"
        />
        <i style="width:30px; margin-top:7px"> - </i>
        <input
          v-model="userHp2"
          class="form-control"
          type="text"
          maxlength="4"
          placeholder=""
          style="width: 95px;"
          ref="userHp2"
          @keyup.enter="checkHp2()"
        />
        <i style="width:30px; margin-top:7px"> - </i>
        <input
          v-model="userHp3"
          class="form-control "
          type="text"
          maxlength="4"
          placeholder=""
          style="width: 95px;"
          ref="userHp3"
          @keyup.enter="checkHp3()"
        />
      </div>
      <div class="d-flex justify-content-center title_margin">
        <i class="title_line">주소</i>
      </div>
      <div class="d-flex justify-content-center">
        <input
            v-model="userZc"
            class="form-control"
            type="text"
            maxlength="20"
            placeholder="우편번호"
            style="width: 250px;"
            ref="userZc"
            @keyup.enter="checkAdd()"
            readonly
        />
        <span class="input-group-btn">
          <button
              type="button"
              class="btn btn-light border"
              style="width: 100px;background-color: #FFD89C;"
              ref="openPostBtn"
              @click="openPostcode()"
          >
            검색
          </button>
        </span>
      </div>

      <div class="d-flex justify-content-center" style="margin-top:5px;">
        <input
            v-model="userAdd"
            class="form-control box_size"
            type="text"
            maxlength="20"
            placeholder="주소"
            readonly
        />
      </div>
      <div class="d-flex justify-content-center" style="margin-top:5px;">
        <input
            v-model="userAddDtl"
            class="form-control box_size"
            type="text"
            maxlength="20"
            placeholder="상세주소"
            ref="userAddDtl"
            @keyup.enter="checkAdd()"
        />
    </div>

    <div class="d-flex justify-content-center title_margin">
      <i class="title_line">이메일 주소</i>
    </div>
    <div class="d-flex justify-content-center">
        <input
            v-model="userEmailAdd"
            class="form-control"
            type="text"
            maxlength="20"
            placeholder="이메일 입력"
            ref="userEmailAdd"
            style="width:125px"
            @keyup.enter="checkEmailAdd()"

        />
      <i style="width:25px; margin-top:7px"> @ </i>
        <span v-if="searchEmDom == '직접입력'">
          <input
              v-model="searchEm"
              class="form-control"
              maxlength="20"
              placeholder=""
              ref="searchEm"
              style="width:100px"
              @keyup.enter="checkEmailDom()"
          />
        </span>
        <span v-else>
        <input
            v-model="searchEm"
            class="form-control"
            maxlength="20"
            placeholder=""
            ref="searchEm"
            style="width:100px"
            disabled
        />
          </span>
        <select
            v-model="searchEmDom"
            ref="searchEmDom"
            class="form-control"
            style="width:100px"
            @change="emailDomEv()"
        >
          <option
              v-for="option in searchEmDomOptions"
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
          <input
              v-model="userGenM"
              type="button"
              class="input-group-addon"
              :class="{ active: isMale }"
              maxlength="20"
              placeholder=""
              ref="userGenM"
              style="width:175px"
              @click="checkUserGenM()"
          />
        <input
            v-model="userGenF"
            class="input-group-addon"
            :class="{ active: isFeMale }"
            type="button"
            maxlength="20"
            placeholder=""
            ref="userGenF"
            style="width:175px"
            @click="checkUserGenF()"
        />
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
      userPassChk: "",
      userName: "",
      userHp1: "",
      userHp2: "",
      userHp3: "",
      userZc: "",
      userAdd: "",
      userAddDtl:"",
      userEmailAdd: "",
      searchEm: "",
      searchEmDom: "선택",
      searchEmDomOptions: [
        { value: '선택' },
        { value: 'naver.com' },
        { value: 'gmail.com' },
        { value: 'daum.net' },
        { value: 'nate.com' },
        { value: '직접입력' },
      ],
      userGenM: "남",
      userGenF: "여",
      isPanelOpen: false,
      termChk: false,
      priChk: false,
      allChk: false,
      showMsg: "",
      showPassMsg: "",
      showPass: false,
      showPassChk: false,
      chkId: false,
      chkPass: false,
      chkPassChk: false,
      chkName: false,
      chkHp1: false,
      chkHp2: false,
      chkHp3: false,
      chkAdd: false,
      chkEmailAdd: false,
      chkEmailDom: false,
      chkGen: false,
      isMale:false,
      isFeMale:false,

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
          this.userZc = data.zonecode;
          this.userAdd = data.roadAddress;
        },
      }).open();
    },

    // 아이디 체크 :: 한글 X, 6 ~ 15자
    checkId() {
      const userIdPattern = /^[a-z0-9]+$/;

      if (_.isEmpty(this.userId)) {
        alert("아이디를 입력해주세요 :)");
        this.showMsg="";
        this.$refs.userId.focus();
        //this.chkId = false;
        return false;
      } else if(this.userId.length < 6 || this.userId.length > 15 ) {
        alert("아이디는 6자리~15자리 이내로 입력해주세요 :)");
        this.showMsg="사용할 수 없는 아이디 입니다. :(";
        this.$refs.userId.focus();
        //this.chkId = false;
        return false;
      } else if( !userIdPattern.test(this.userId)) {
        alert("아이디는 소문자와 숫자만 이용하여 입력해주세요 :)");
        this.showMsg="사용할 수 없는 아이디 입니다. :(";
        this.$refs.userId.focus();
        //this.chkId = false;
        return false;
      } else if(this.userId.search(/\s/) != -1) {
        alert("아이디는 공백 없이 입력해주세요 :)");
        this.showMsg="사용할 수 없는 아이디 입니다. :(";
        this.$refs.userId.focus();
        this.chkId = false;
        return false;
      }

      let value = {
        userId: this.userId,
      }

      this.$axios.post('/api/test/gSearchId', value)
          .then(({ data }) => {
            //this.chkId = data.length;
            if(_.isEqual(data.length, 1)) {
              this.showMsg = "사용할 수 없는 아이디 입니다. :)";
              alert("아이디를 확인해주세요 :)");
              //this.chkId = false;
              this.$refs.userId.focus();
              return false;
            } else{
              this.showMsg = "사용 가능한 아이디 입니다. :)";
              this.chkId = true;
              this.$refs.userPass.focus();
              return;
            }

          });
    },

    // 비밀번호 보이기 :: 버튼
    showPassword() {
      this.showPass = !this.showPass;
      if (this.showPass) {
        this.$refs.userPass.type = 'text';
      } else {
        this.$refs.userPass.type = 'password';
      }
    },

    // 재입력 비밀번호 보이기 :: 버튼
    showPasswordChk() {
      this.showPassChk = !this.showPassChk;
      if (this.showPassChk) {
        this.$refs.userPassChk.type = 'text';
      } else {
        this.$refs.userPassChk.type = 'password';
      }
    },

    // 비밀번호 체크 :: 한글 X, 문자`숫자`특수문자 필수 포함, 8 ~ 20자
    checkPass() {
      const userPassPattern = /^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]+$/;

      if(this.chkId == false) {
        alert("아이디를 확인해주세요 :)");
        this.$refs.userId.focus();
        return;
      } else if (_.isEmpty(this.userPass)) {
        alert("비밀번호를 입력해주세요 :)");
        this.$refs.userPass.focus();
        return;
      } else if(this.userPass.length < 8 || this.userPass.length > 20) {
        alert("비밀번호는 8자리~20자리 이내로 입력해주세요 :)");
        this.$refs.userPass.focus();
        return;
      } else if (!userPassPattern.test(this.userPass)) {
        alert("비밀번호는 영문, 숫자, 특수문자를 혼합하여 입력해주세요 :)");
        this.$refs.userPass.focus();
        return;
      } else if(this.userPass.search(/\s/) != -1) {
        alert("비밀번호는 공백 없이 입력해주세요 :)");
        this.$refs.userPass.focus();
        return;
      } else {
        this.$refs.userPassChk.focus();
        this.chkPass = true;
        return;
      }
    },

    // 재입력 비밀번호 체크
    checkPassChk() {
      if (_.isEmpty(this.userPassChk)){
        alert("비밀번호를 재입력 해주세요 :)");
        this.$refs.userPassChk.focus();
        return false;
      } else if(!_.isEqual(this.userPass, this.userPassChk)) {
        this.showPassMsg="비밀번호가 일치하지 않습니다 :(";
        alert("재입력 비밀번호를 확인해주세요 :)");
        this.$refs.userPassChk.focus();
        return false;
      } else {
        this.showPassMsg="";
        this.chkPassChk = true;
        this.$refs.userName.focus();
        return;
      }
    },

    // 이름 체크
    checkName() {
      const userNamePattern = /^[가-힣]+$/;

      if(_.isEmpty(this.userName)) {
        alert("이름을 입력해주세요 :)");
        this.$refs.userName.focus();
        return false;
      } else if (!userNamePattern.test(this.userName)) {
        alert("이름은 한글만 입력 가능합니다 :)");
        this.$refs.userName.focus();
        return false;
      } else {
        this.$refs.userHp1.focus();
        this.chkName = true;
        return;
      }
    },

    // 핸드폰번호 1 체크
    checkHp1() {
      const hpPattern = /^[0-9]+$/;

      if(_.isEmpty(this.userHp1) || this.userHp1.length < 3) {
        alert("번호 앞자리를 입력해주세요 :)");
        this.$refs.userHp1.focus();
        return;
      } else if (!hpPattern.test(this.userHp1)) {
        alert("숫자만 입력해주세요 :)");
        this.$refs.userHp1.focus();
        return;
      } else {
        this.$refs.userHp2.focus();
        this.chkHp1 = true;
        return;
      }
    },

    // 핸드폰번호 2 체크
    checkHp2() {
      const hpPattern = /^[0-9]+$/;

      if(_.isEmpty(this.userHp2) || this.userHp2.length < 3) {
        alert("번호 중간자리를 입력해주세요 :)");
        this.$refs.userHp2.focus();
        return;
      } else if (!hpPattern.test(this.userHp2)) {
        alert("숫자만 입력해주세요 :)");
        this.$refs.userHp2.focus();
        return;
      } else {
        this.$refs.userHp3.focus();
        this.chkHp2 = true;
        return;
      }
    },

    // 핸드폰번호 3 체크
    checkHp3() {
      const hpPattern = /^[0-9]+$/;

      if(_.isEmpty(this.userHp3) || this.userHp3.length < 4) {
        alert("번호 끝자리를 입력해주세요 :)");
        this.$refs.userHp3.focus();
        return;
      } else if (!hpPattern.test(this.userHp3)) {
        alert("숫자만 입력해주세요 :)");
        this.$refs.userHp3.focus();
        return;
      } else {
        this.$refs.openPostBtn.focus();
        this.chkHp3 = true;
        return;
      }
    },

    // 주소 체크
    checkAdd() {
      if(_.isEmpty(this.userZc)) {
        alert("주소 검색을 해주세요 :)");
        this.$refs.openPostBtn.focus();
        return;
      } else {
        this.$refs.userEmailAdd.focus();
        this.chkAdd = true;
        return;
      }
    },

    // 이메일 주소 입력 체크
    checkEmailAdd() {
      const userEmailAddPattern = /^[a-z0-9]+$/;

      if(_.isEmpty(this.userEmailAdd)) {
        alert("이메일 주소를 입력해주세요 :)");
        this.$refs.userEmailAdd.focus();
        return;
      } else if (!userEmailAddPattern.test(this.userEmailAdd)) {
        alert("이메일 주소를 정확하게 입력해주세요 :)");
        this.$refs.userEmailAdd.focus();
        return;
      } else {
        // this.$refs.searchEmail.focus();
        this.chkEmailAdd = true;
        return;
      }
    },

    // 이메일 도메인 선택
    emailDomEv() {
      if(_.isEqual(this.searchEmDom, "선택")) {
        this.searchEm = "";
        return;
      } else if (_.isEqual(this.searchEmDom, "직접입력")) {
        this.searchEm = "";
        this.$refs.searchEm.focus();
        return;
      } else {
        this.searchEm = this.searchEmDom;
        return;
      }
    },

    // 이메일 :: 직접입력시 체크
    checkEmailDom() {
      const domainPattern = /^([a-z]+\.)+[a-z]{3,}$/;

      if(_.isEmpty(this.searchEm) && this.searchEmDom == "선택") {
        alert("이메일 도메인을 선택해주세요 :)");
        this.$refs.searchEm.focus();
        return;
      } else if ((this.searchEmDom == "직접입력") && _.isEmpty(this.searchEm)) {
        alert("이메일 도메인을 직접 입력해주세요 :)");
        this.$refs.searchEm.focus();
        return;
      } else if (!domainPattern.test(this.searchEm)) {
        alert("이메일 도메인을 정확하게 입력해주세요 :)");
        this.$refs.searchEm.focus();
        return;
      } else {
        this.$refs.userGenM.focus();
        this.chkEmailDom = true;
        return;
      }
    },

    // 성별 :: 남자 클릭
    checkUserGenM() {
      this.isMale = !this.isMale;
      this.isFeMale = false;
    },

    // 성별 :: 여자 클릭
    checkUserGenF() {
      this.isFeMale = !this.isFeMale;
      this.isMale = false;
    },

    // 이용약관 보이기
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
      if(this.chkId == false) {
        this.checkId();
        return;
      } else if (this.chkPass == false) {
        this.checkPass();
        return;
      } else if (this.chkPassChk == false) {
        this.checkPassChk();
        return;
      } else if (this.chkName == false) {
        this.checkName();
        return;
      } else if (this.chkHp1 == false) {
        this.checkHp1();
        return;
      } else if (this.chkHp2 == false) {
        this.checkHp2();
        return;
      } else if (this.chkHp3 == false) {
        this.checkHp3();
        return;
      } else if (this.chkAdd == false) {
        this.checkAdd();
        return;
      } else if (this.chkEmailAdd == false) {
        this.checkEmailAdd();
        return;
      } else if (this.chkEmailDom == false) {
        this.checkEmailDom();
        return;
      } else if (this.isMale == false && this.isFeMale == false) {
        alert("성별을 선택해주세요 :)");
        this.$refs.userGenM.focus();
        return;
      } else if (this.allChk === false) {
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

.active {
  background-color: #FFD89C;
}


</style>
    