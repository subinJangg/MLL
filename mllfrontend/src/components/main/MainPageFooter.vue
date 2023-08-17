<template>

    <div class="row">
  <footer style="height:155px;backgroundColor:#A6BB8D">
    <div class="row">
      <div class="col-md-12">
        <div class="row">
        <div class="col-md-2"/>
        <div class="col-md-2" style="margin-top:10px">상호 : (주)망링레</div>
        <div class="col-md-2" style="margin-top:10px">주소 : </div>
        <div class="col-md-2" style="margin-top:10px">대표 : </div>
        <div class="col-md-2" style="margin-top:10px">사업자등록번호 : </div>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-md-12">
        <div class="col-md-3" style="margin-top:10px">대표번호 : </div>
        <div class="col-md-3" style="margin-top:10px">이메일 : </div>
        <div class="col-md-3" style="margin-top:10px">통신판매업신고번호 : </div>
        <div class="col-md-3" style="margin-top:10px">호스팅제공자  : </div>
      </div>
    </div>
    <div class="row">
      <div class="col-md-12">
        <div class="col-md-3" style="margin-top:10px">사업자정보확인</div>
        <div class="col-md-3" style="margin-top:10px">이용약관 </div>
        <div class="col-md-3" style="margin-top:10px">개인정보처리방법</div>
        <div class="col-md-3" style="margin-top:10px"> </div>
      </div>
    </div>
    <div class="row">
      <div class="col-md-12">
        <div class="col-md-3 cur" style="margin-top:10px">
          <font-awesome-icon
            :icon="['fab', 'instagram']"
            @click="instaLink('https://instagram.com/mango_lingo_lego?igshid=OGQ5ZDc2ODk2ZA==')"
          /> instagram
        </div>
        <div class="col-md-3" style="margin-top:10px">
          <font-awesome-icon
              :icon="['fab', 'youtube']"
              @click="youtubeLink('https://youtube.com/@mango_lingo_lego')"
          /> youtube
        </div>
        <div class="col-md-3" style="margin-top:10px"></div>
        <div class="col-md-3" style="margin-top:10px"></div>
      </div>
    </div>
  </footer>
    </div>
</template>
  
<script>
  export default{
    name : "MainPageFooter",

  data() {
    return {



    };
  },

  methods: {

    /* youtube 이동 */ 
    youtubeLink(url) {
      window.location.href = url;
    },

    /* instagram  이동 */
    instaLink(url) {
      window.location.href = url;
    },


    


  },
  // ...
}
</script>
  
<style scoped>

.cur {
  cursor: pointer;
}

.psize {

}

</style>
