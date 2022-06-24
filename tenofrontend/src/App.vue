<template>
  <div id="app">
    <nav class="navbar navbar-expand-lg" style="background-color: #004582">
      <div class="container-fluid">
        <router-link to="/" class="navbar-brand text-light"
          >TENO-DGDE</router-link
        >
        <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarNavAltMarkup"
          aria-controls="navbarNavAltMarkup"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
          <div class="navbar-nav">
            <router-link style="color: #ff8414" to="/" class="nav-link">Home</router-link>
            <router-link style="color: #ff8414" to="/about" class="nav-link">About</router-link>
            <b-dropdown id="dropdown-1" text="Denuncias" variant="text-light">
              <b-dropdown-item><router-link style="color: #ff8414" to="/newdenuncia" class="nav-link">Ingresar Denuncias</router-link></b-dropdown-item>
              <b-dropdown-item><router-link style="color: #ff8414" to="/denuncialist" class="nav-link">Ver Denuncias</router-link></b-dropdown-item>
            </b-dropdown>
          </div>
        </div>
      </div>
    </nav>
    <router-view />
    <div class="container-fluid position-absolute top-100 mt-5">
      <div class="row p-4 text-white" style="background-color: #24334a">
        <div class="col-xs-12 col-md-6 col-lg-4">
          <p class="h3">TENO-DGDE</p>
        </div>
        <div class="col-xs-12 col-md-6 col-lg-4">
          <p class="h5">Sitios de interes</p>
          <a class="text-white text-decoration-none" href="https://direcciondegenero.usach.cl">DGDE</a>
        </div>
        <div class="col-xs-12 col-md-6 col-lg-4">
          <p class="h5">Documentacion</p>
        </div>
        <div class="col-xs-12">
          <p class="text-white text-center">Todos los derechos resevados by @TENO</p>
        </div>
      </div>

    </div>
  </div>
</template>

<style scoped>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #478dd3;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>
