<template>
  <div id="app">
    <div class="container-fluid" style="padding-left: 0px;padding-right: 0px;">
      <router-view />
    </div>
  </div>
</template>

<style scoped>
.gg-user-remove {
  /* This value will multiple the actual size  */
  --ggs: 1.4;
}

@import url('http://fonts.cdnfonts.com/css/coolvetica-2');

#app {
  padding-left: 0px;
  font-family: 'coolvetica';
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  letter-spacing: 1px;
  padding: 0 0 0 0;
}
</style>

<script>
export default ({
  name : "App",
  data() {
    return {
      povCommonUser: 0,
      povFiscal: 0,
      povDGDE: 0,
      logged: 0,
    }
  },
  methods: {
    logout () {
      this.logged = 0
      this.povCommonUser = 0
      this.povFiscal = 0
      this.povDGDE = 0
      localStorage.clear()
      window.location.href = "/#/"
    }
  },

})
</script>
