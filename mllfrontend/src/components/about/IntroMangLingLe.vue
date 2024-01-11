<template>
 <div>
   <!-- 망고 소개 -->
   <div class="d-md-flex flex-md-column mb-3" style="margin-top:50px;">
     <div class="p-2">
       <img
           src="../../assets/image/mango.png"
           class="logo-img"
           style="height: 3%; width: 3%;"
       />
     </div>
     <div class="p-2">
       <font-awesome-icon :icon="['fas', 'shield-cat']" /> 망고
     </div>
   </div>

   <!-- 링고 소개 -->
   <div class="d-md-flex flex-md-column mb-3" style="margin-top:50px;">
     <div class="p-2">
       <img
           src="../../assets/image/lingo.png"
           class="logo-img"
           style="height: 3%; width: 3%;"
       />
     </div>
     <div class="p-2">
       <font-awesome-icon :icon="['fas', 'shield-cat']" /> 링고
     </div>
   </div>

   <!-- 레고 소개 -->
   <div class="d-md-flex flex-md-column mb-3" style="margin-top:50px;">
     <div class="p-2">
       <img
           src="../../assets/image/lego.png"
           class="logo-img"
           style="height: 3%; width: 3%;"
       />
     </div>
     <div class="p-2">
       <font-awesome-icon :icon="['fas', 'shield-cat']" /> 레고
     </div>
   </div>
 </div>
</template>

<script>
export default{
   name : "IntroMangLingLe",
 //   components: [],
 // data() {
 //   return {
 //     connectData: "",
 //   };
 // },
 // methods: {
 //   get() {
 //     this.axios.get("/connectTest").then((response) => {
 //       this.connectData = response.data;
 //     });
 //   },
 // },
 // mounted() {
 //   this.get();
 // },
}
</script>

<style scoped>


</style>