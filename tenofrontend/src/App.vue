<template>
  <div id="app">
    <nav class="navbar navbar-expand-lg" style="background-color: #EF7D00">
      <div class="container-fluid">
        <router-link to="/" class="navbar-brand">TENO-DGDE</router-link>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
          aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
          <div class="navbar-nav">
            <router-link v-if="selected == 0" to="/" class="nav-link">Home</router-link>
            <router-link v-if="selected == 0" to="/about" class="nav-link">About</router-link>
            <b-nav-item-dropdown text="Denuncias" right>
              <b-dropdown-item>
                <router-link style="color: #ff8414" to="/newdenuncia" class="nav-link">Ingresar Denuncias</router-link>
              </b-dropdown-item>
              <b-dropdown-item>
                <router-link style="color: #ff8414" to="/denuncialist" class="nav-link">Ver Denuncias</router-link>
              </b-dropdown-item>
            </b-nav-item-dropdown>
          </div>
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
          <p class="h5">Documentacion</p>
        </div>
        <div class="col-xs-12">
          <p class="text-white text-center">Todos los derechos resevados by @TENO</p>
        </div>
      </div>

    </footer>
  </div>
</template>

<style scoped>
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
}

nav {
  padding: 20px;
}
</style>

<script>
export default ({
  data () {
    return {
      selected: 0
    }
  }
})
</script>
