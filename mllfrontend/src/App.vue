<template>
  <div style="backgroundColor:#EEEEEE">
    <div class="navbar-brand" style="min-height:300px;positon:sticky;" >
      <MainPageHeader/>
    </div>
    <div style="min-height:500px">
      <router-view/>
    </div>
<!--    <div style="height:155px;backgroundColor:#A6BB8D">-->
      <MainPageFooter/>

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
  overflow: hidden;
  /* margin-top: 60px; */
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
