<template>
    <nav class="navbar navbar-expand-lg" style="background-color: #EF7D00">
      <div class="container-fluid">
        <img src="https://i.imgur.com/JB4sZTQ.png" title="usach logo" width="46" height="60" />
        <router-link style="color: #ffffff;font-size: 30px;letter-spacing: 3px;" to="/home" class="navbar-brand">TENO-DGDE
        </router-link>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
          aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
          <div class="navbar-nav">
            <router-link v-if="povCommonUser == 1 && logged == 1" style="color: #000; font-size: 19px;" to="/denuncialist" class="nav-link">Denuncias</router-link>
            <router-link v-if="povDGDE == 1 && logged == 1" style="color: #000; font-size: 19px;" to="/newdenuncia" class="nav-link">Ingresar Denuncias</router-link>
            <router-link v-if="povFiscal == 1 && logged == 1" style="color: #000; font-size: 19px;" to="/denuncialistfiscal" class="nav-link">Denuncias Asignadas</router-link>
          </div>
        </div>
        <div class="form-inline my-2 my-lg-0">
          <b-button @click="logout" v-if="logged == 1" variant="primary" class="btn">
            <b-icon icon="power" aria-hidden="true"></b-icon> Logout
          </b-button>
        </div>
      </div>
    </nav>
</template>
<style scoped>
nav {
  padding: 20px;
}

.navbar-dark .navbar-nav .nav-link {
  color: black !important
}
</style>

<script>
export default {
  name : "Navbar",
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
  mounted () {
    this.$forceUpdate()
    let typeuser = localStorage.getItem('typeuser')
    if(typeuser){
      this.logged = 1
      if (typeuser == 'denunciador'){
        this.povCommonUser = 1
        this.povFiscal = 0
        this.povDGDE = 0
      }else if (typeuser == 'fiscal'){
        this.povCommonUser = 0
        this.povFiscal = 1
        this.povDGDE = 0
      }else if (typeuser == 'dgde'){
        this.povCommonUser = 0
        this.povFiscal = 0
        this.povDGDE = 1
      }
    }else{
      this.logged = 0
      this.povCommonUser = 0
      this.povFiscal = 0
      this.povDGDE = 0
      window.location.href = "/#/"
    }
  }
}
</script>
