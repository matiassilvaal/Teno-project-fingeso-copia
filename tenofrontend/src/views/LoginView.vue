<template>
    <div class="mt-5" v-on:keyup.enter="push">
        <button id="alert" v-on:click="alertHidden" hidden class="button-alert">
          <div class="myalert">
            <p>
              Hubo un poblema con el correo ingresado
            </p>
          </div>
        </button>
        <h1 class="primary">T e n o</h1>
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

.myalert{
  background-color: rgb(226, 65, 25);
  color: white;
  border-radius: 5px;
  height: 100%;
  font-size: 1.2rem;
  padding-top: 0.7rem;
  margin: 0 auto;
  cursor: pointer;
}

.button-alert{
  height: 3rem;
  border-style: none;
  width: 50rem;
  padding: 0px;
  margin: 1rem;
  transition: box-shadow 0.3s ease;
  transition: height 0.3s ease;
  transition: width 0.1s ease;
}

.myalert:hover{
  padding-top: 1rem;
}

.button-alert:hover{
  box-shadow:  0 0.1rem 0.4rem rgba(0,0,0,0.3);
  margin: 0.6rem;
  height: 4rem;
  width: 51rem;
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
    alertHidden(){
      document.getElementById('alert').hidden = true
    },
    push () {
      axios.get('http://localhost:8082/users/get-id-by-correo?correo="' + (document.getElementById('correo').value)+'"')
        .then(response => {
          if (response.data > -1) {
            this.controller(response.data)
          } else {
            document.getElementById('alert').hidden = false
          }
        })
    },
    controller (id) {
      localStorage.setItem('iduser', id)
      localStorage.setItem('correo', document.getElementById('correo').value)
      localStorage.setItem('typeuser', this.selected)
      console.log("entranding")
      window.location.href = '/#/home'
    }
  }
}
</script>
