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
            </b-dropdown>
          </div>
        </div>
      </div>
    </nav>
    <router-view />
  </div>
</template>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
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
