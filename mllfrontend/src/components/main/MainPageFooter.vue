<template>
  <div class="row">
    <footer style="height:130px;backgroundColor:#A6BB8D">
      <div class="col-md-12">
        <div class="row">
          <div class="col-md-3 font_size" style="margin-top:10px">상호 : (주)망링레</div>
          <div class="col-md-3 font_size" style="margin-top:10px">주소 : 서울 강남구 망링레컴퍼니</div>
          <div class="col-md-3 font_size" style="margin-top:10px">대표 : 장수빈 </div>
          <div class="col-md-3 font_size" style="margin-top:10px">사업자등록번호 : 17123944</div>
        </div>
      </div>

      <div class="col-md-12">
        <div class="row">
          <div class="col-md-3 font_size" style="margin-top:10px">대표번호 : 02-123-4567 </div>
          <div class="col-md-3 font_size" style="margin-top:10px">이메일 : manglingle@naver.com</div>
          <div class="col-md-3 font_size" style="margin-top:10px">통신판매업신고번호 : 17123944</div>
          <div class="col-md-3 font_size" style="margin-top:10px">호스팅제공자  : (주)망링레</div>
        </div>
      </div>

      <div class="col-md-12">
        <div class="row">
          <div class="col-md-3 font_size" style="margin-top:10px">사업자정보확인</div>
          <div class="col-md-3 font_size" style="margin-top:10px">이용약관 </div>
          <div class="col-md-3 font_size" style="margin-top:10px">개인정보처리방법</div>
          <div class="col-md-3 font_size" style="margin-top:10px"> </div>
        </div>
      </div>

      <div class="col-md-12">
        <div class="row">
        <div class="col-md-3 cur" style="margin-top:10px">
          <font-awesome-icon
            :icon="['fab', 'instagram']"
            @click="instaLink('https://instagram.com/mango_lingo_lego?igshid=OGQ5ZDc2ODk2ZA==')"
          /> instagram
        </div>
        <div class="col-md-3 cur" style="margin-top:10px">
          <font-awesome-icon
              :icon="['fab', 'youtube']"
              @click="youtubeLink('https://youtube.com/@mango_lingo_lego')"
          /> youtube
        </div>
        <div class="col-md-2" style="margin-top:10px"></div>
        <div class="col-md-2" style="margin-top:10px"></div>
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
.font_size {
  font-size: xx-small;
}

.psize {

}

</style>
