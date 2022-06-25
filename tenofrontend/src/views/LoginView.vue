<template>
    <div class="mt-5" v-on:keyup.enter="push">
        <h1 class="primary">Login</h1>
        <p class="black">Ingrese su correo</p>
        <input type="email" id="correo" placeholder="tucorreo@usach.cl" class="input">
        <b-form-group label="Selecciona tu tipo de usuario" v-slot="{ ariaDescribedby }">
        <b-form-radio-group
            button-variant="outline-primary"
            id="btn-radios-1"
            v-model="selected"
            :options="options"
            :aria-describedby="ariaDescribedby"
            name="radios-btn-default"
            buttons>
        </b-form-radio-group>
    </b-form-group>
    <b-button @click="push"  variant="primary" size="lg" class="btn">Ingresar</b-button>
    </div>
</template>

<style scoped>

.title{
    color:black;
}

.btn{
    margin-top: 1rem;
}
input{
    border-radius: 5px;
    border-width: 1px;
    padding: 0.3rem;
    width: 15rem;
    margin-bottom: 0.5rem;
}

.campo{
    color: black;

}

input {
    margin-bottom: 0.5rem;

}

label{
    margin: 0px;
    color: white;
}
</style>

<script>
import axios from 'axios'

export default {
  data () {
    return {
      selected: 'denunciador',
      options: [
        { text: '  Denunciador', value: 'denunciador' },
        { text: '  Fiscal', value: 'fiscal' },
        { text: '  Funcionario DGDE', value: 'dgde' }
      ]
    }
  },
  methods: {
    push () {
      axios.get('http://localhost:8082/users/getidbycorreo?correo=' + (document.getElementById('correo').value))
        .then(response => {
          if (response.data > -1) {
            this.controller(response.data)
          } else {
            window.location.href = '/login'
          }
        })
    },
    controller (id) {
      localStorage.setItem('iduser', id)
      localStorage.setItem('typeuser', document.getElementById('correo').value)
      window.location.href = '/'
    }
  }
}
</script>
