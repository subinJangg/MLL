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
          ref="userPass"
      />
    </div>

    <div class="d-flex justify-content-center" style="margin-top:10px; margin-bottom:10px">
      <span class="input-group-btn">
        <button
            type="button"
            class="btn box_size"
            style="background-color: #FFD89C"
            @click="test()"
        >
          확인
        </button>
      </span>
    </div>
    <div class="d-flex justify-content-center" style="margin-top:10px;">
      {{ testList.userPass }}
    </div>
  </div>
</template>
  
<script>
  export default{
    name : "FindPass",
    data() {
      return {
        userId: "",
        userPass: "",
        testList: [],
        searchUserId: '',
      };
    },

    mounted() {
      this.$refs.userPass.focus();
    },

    methods: {

      test() {
        let value = {
          searchUserId: this.searchUserId,

        }

        this.testList.splice(0);
        console.log(value);
        this.$axios.post('/api/test/gTest', value)
            .then(({ data }) => {
              console.log(data);
              for(let i=0; i < data.length; i++) {
                this.testList.splice(i, 0, data[i]);

                console.log(this.testList.userPass);

              }



            });
      },



      },



    
  }
</script>
  
<style scoped>

.box_size {
  width: 300px;
}
</style>