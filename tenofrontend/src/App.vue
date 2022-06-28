<template>
  <div id="app">
    <nav class="navbar navbar-expand-lg" style="background-color: #EF7D00">
      <div class="container-fluid">
        <img src="https://i.imgur.com/JB4sZTQ.png" title="usach logo" width="46" height="60" />
        <router-link style="color: #ffffff;font-size: 30px;letter-spacing: 3px;" to="/" class="navbar-brand">TENO-DGDE
        </router-link>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
          aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
          <div class="navbar-nav">
            <router-link v-if="povCommonUser == 1" style="color: #000; font-size: 19px;" to="/denuncialist" class="nav-link">Denuncias</router-link>
            <router-link v-if="povDGDE == 1" style="color: #000; font-size: 19px;" to="/newdenuncia" class="nav-link">Ingresar Denuncias</router-link>
            <router-link v-if="povFiscal == 1" style="color: #000; font-size: 19px;" to="/denuncialistfiscal" class="nav-link">Denuncias Asignadas</router-link>
          </div>
        </div>
        <div class="form-inline my-2 my-lg-0">
          <b-button v-if="logged == 1" variant="primary" class="btn">
            <b-icon icon="power" aria-hidden="true"></b-icon> Logout
          </b-button>
        </div>
      </div>
    </nav>
    <div class="container-fluid">
      <router-view />
    </div>
    <footer>
      <div class="row p-1 text-white" style="background-color: #003B71">
        <div class="col-xs-12 col-md-6 col-lg-4 mt-3">
          <p class="h5">TENO-DGDE</p>
        </div>
        <div class="col-xs-12 col-md-6 col-lg-4 mt-2">
          <p class="h5">Sitios de interés</p>
          <a class="text-white text-decoration-none" href="https://direcciondegenero.usach.cl">DGDE</a>
        </div>
        <div class="col-xs-12 col-md-6 col-lg-4 mt-3">
          <p class="h5">Documentación</p>
        </div>
        <div class="col-xs-12">
          <p class="text-white text-center">Todos los derechos resevados by @TENO</p>
        </div>
      </div>
    </footer>
  </div>
</template>

<style scoped>
.gg-user-remove {
  /* This value will multiple the actual size  */
  --ggs: 1.4;
}

@import url('http://fonts.cdnfonts.com/css/coolvetica-2');

#footer {
  position: fixed;
  left: 0px;
  bottom: 0px;
  height: 20px;
  width: 100%;
}

#app {
  font-family: 'coolvetica';
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  letter-spacing: 1px;
}

nav {
  padding: 20px;
}

.navbar-dark .navbar-nav .nav-link {
  color: black !important
}
</style>

<script>
export default ({
  data() {
    return {
      povCommonUser: 1,
      povFiscal: 0,
      povDGDE: 0,
      logged: 1,
    }
  },
  created() {
    localStorage.setItem('tipo', 1) // 0: usuario comun 1: fiscal, cambiar despues cuando este mas avanzado, solo de debug
  }
})
</script>
