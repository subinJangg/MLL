<template>
  <div style="backgroundColor:#EEEEEE">
    <div class="navbar-brand header" style="min-height:250px;positon:sticky;" >
      <MainPageHeader/>
    </div>
    <div>
      <router-view/>
      <MainPageFooter/>
    </div>
<!--    <div style="height:155px;backgroundColor:#A6BB8D">-->


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

  /* margin-top: 60px; */
}
.header {
  position: sticky;
  top: 0px; /* 도달했을때 고정시킬 위치 */
  padding: 5px;
  z-index: 10;
  overflow: visible !important;
}

/* #nav {
  padding: 30px;
}

#test {
  padding: 100px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
} */
</style>
