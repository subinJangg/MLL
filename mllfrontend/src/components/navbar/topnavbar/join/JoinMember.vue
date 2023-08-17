<template>
    <div class="row">
    <div class="d-flex justify-content-center">
        <h4>
          <font-awesome-icon :icon="['fas', 'paw']" />
              JOIN US
          <font-awesome-icon :icon="['fas', 'paw']" />
        </h4>
    </div>
        <div class="d-flex justify-content-center" style="margin-top:10px;">
          아이디
        </div>

        <div class="d-flex justify-content-center" style="margin-top:10px;">
          <input
              v-model="userId"
              class="form-control"
              type="text"
              maxlength="20"
              placeholder="아이디 입력(6~15자)"
              style="width:300px;"
              ref="userId"
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
        placeholder="비밀번호 입력(문자, 숫자, 특수문자 포함 8~20자)"
        ref="userPass"
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
        maxlength="3"
        placeholder=""
        style="width: 85px; margin-top:-7px"
        ref="userPhone2"
      /> &nbsp; - &nbsp;
      <input
        v-model="userPhone3"
        class="form-control " 
        type="text"
        maxlength="3"
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
              style="width: 70px;"
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
    <div class="d-flex justify-content-center" style="margin-top:10px; margin-bottom:10px">
      <span class="input-group-btn">
        <button
            type="button"
            class="btn box_size"
            style="coler:#EEEEEE"
            @click="saveUserInfo()"
        >
          가입하기
        </button>
      </span>
    </div>
  </div>
</template>

<!--<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>-->

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
    