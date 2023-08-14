<template>
  <div class="row">
    <footer style="height:155px;backgroundColor:#A6BB8D">
      <ul class="d-md-flex justify-content-md-around">
        <li class="p-2 psize">(주)망링레</li>
        <li class="p-2">개인정보</li>
        <li class="p-2">Q & A</li>
        <li class="p-2 cur">
          <font-awesome-icon
              :icon="['fab', 'instagram']"
              @click="instaLink('https://instagram.com/mango_lingo_lego?igshid=OGQ5ZDc2ODk2ZA==')"
          />
          instagram </li>
      </ul>

      <!-- 전화번호 및 상호명 -->
      <ul class="d-md-flex justify-content-md-around">
        <li class="p-2">전화번호</li>
        <li class="p-2">submit</li>
        <li class="p-2">자주묻는질문</li>
        <li class="p-2 cur">
          <font-awesome-icon
              :icon="['fab', 'youtube']"
              @click="youtubeLink('https://youtube.com/@mango_lingo_lego')"
          /> youtube </li>

      </ul>

      <ul class="d-md-flex justify-content-md-around">
        <li class="p-2">개인정보</li>
        <li class="p-2">submit</li>
      </ul>

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
