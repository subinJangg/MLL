<template>
  <div class="container-fluid">
    <div class="header">
      <MainPageHeader/>
    </div>
    <div class="body">
      <router-view/>
    </div>
      <MainPageFooter/>
  <!--  </div>-->
  </div>
</template>
<script>
import MainPageHeader from '@/components/main/MainPageHeader';
import MainPageFooter from '@/components/main/MainPageFooter';

export default{
    name : 'App',
    components : {
      MainPageHeader,
      MainPageFooter,
    }
  }
</script>

<style>
@import "./assets/css/fonts.css";

#app {
  font-family: 'SDSamliphopangche_Basic';
  /*font-family: Avenir, Helvetica, Arial, sans-serif;*/
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  width:100%;
  overflow-x: hidden;
}

.header {
  height: 250px;
  backgroundColor:#A6BB8D;
  text-align: center;
  padding: 10px;
  position: fixed;
  top: -10px;
  left: 0;
  width: 100%;
  z-index: 999; /* 헤더가 다른 요소 위에 오도록 설정 */
}

.body {
  margin-top: 230px; /* 헤더 높이와 동일하게 설정하여 헤더가 바디를 가리지 않도록 조절 */
  padding: 20px;
  /* 바디 내용의 높이가 뷰포트를 넘어갈 경우 스크롤이 생기도록 설정 */
  overflow-y: auto;
  height: calc(10nv - 50px); /* 뷰포트 높이에서 헤더 높이를 빼줍니다 */
  box-sizing: border-box;
  min-height: 595px;
}


</style>
