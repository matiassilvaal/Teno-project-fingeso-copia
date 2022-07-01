<template>
<div>
    <Navbar/>
    <div class="mt-5 mb-5 formulario" style="padding-bottom: 3rem;">
        <h1 class="text-dark">Ingresar una denuncia</h1>
        <form id="form-denuncia" class="p-5">
            <div class="alert alert-danger alert-dismissible fade show" id="alertdenciante" hidden role="alert">
                <div class="myalert">
                    Hubo un poblema con el correo ingresado del denunciante
                    <button type="button" v-on:click="alertHiddendenunciante" class="btn-close" data-bs-dismiss="alert"
                        aria-label="Close"></button>
                </div>
            </div>
            <div class="alert alert-success alert-dismissible fade show" id="alertsucces" hidden role="alert">
                <div class="myalert">
                    denuncia ingresada con exito
                    <button type="button" v-on:click="alertHiddensucces" class="btn-close" data-bs-dismiss="alert"
                        aria-label="Close"></button>
                </div>
            </div>
            <div class="mb-3">
                <label for="exampleInputEmail1" class="form-label text-dark d-flex">Correo institucional del
                    denunciante</label>
                <input type="email" class="form-control" id="denunciante" aria-describedby="emailHelp" />
            </div>
            <div class="alert alert-danger alert-dismissible fade show" id="alertdenunciado" hidden role="alert">
                <div class="myalert">
                    Hubo un poblema con el correo ingresado del denuncido
                    <button type="button" v-on:click="alertHiddendenunciado" class="btn-close" data-bs-dismiss="alert"
                        aria-label="Close"></button>
                </div>
            </div>
            <div class="mb-3">
                <label for="exampleInputEmail1" class="form-label text-dark d-flex">Correo institucional del
                    denunciado</label>
                <input type="email" class="form-control" id="denunciado" aria-describedby="emailHelp" />
            </div>
            <div class="alert alert-danger alert-dismissible fade show" id="alertdescription" hidden role="alert">
                <div class="myalert">
                    la descripcion no puede estar vacia
                    <button type="button" v-on:click="alertHiddendescription" class="btn-close" data-bs-dismiss="alert"
                        aria-label="Close"></button>
                </div>
            </div>
            <div class="mb-3">
                <label for="floatingTextarea" class="text-dark d-flex">Detalles de la denuncia</label>
                <textarea class="form-control" placeholder="Detalles de la denuncia" id="descripcion"></textarea>
            </div>
            <div class="mb-3">
                <label for="floatingTextarea" class="text-dark d-flex">Medidas de proteccion (opcional)</label>
                <textarea class="form-control" placeholder="Medidas de proteccion" id="floatingTextarea"></textarea>
            </div>
            <button @click='insert' type="" class="btn btn-primary d-flex">Enviar</button>
        </form>
    </div>
    <Footer/>
</div>
</template>

<style>
.formulario {
    margin-bottom: 4rem;
    margin-left: 3rem;
    margin-right: 3rem;
}
</style>

<script>
import axios from 'axios'
import Navbar from '../components/Navbar'
import Footer from '../components/Footer'

export default {
    components: {
      Navbar,
      Footer
    },
    methods: {
        alertHiddendenunciante() {
            document.getElementById('alertdenciante').hidden = true
        },
        alertHiddendenunciado() {
            document.getElementById('alertdenunciado').hidden = true
        },
        alertHiddensucces() {
            document.getElementById('alertsucces').hidden = true
        },
        alertHiddendescription() {
            document.getElementById('alertdescription').hidden = true
        },
        insert() {
            axios.post('http://localhost:8082/denounces/insert?description=' + document.getElementById('descripcion').value + '&denunciante="' + document.getElementById('denunciante').value + '"&denounced="' + document.getElementById('denunciado').value + '"')
                .then(response => {
                    if (response.data == 0) {
                        document.getElementById('alertsucces').hidden = false
                        document.getElementById('alertdenciante').hidden = true
                        document.getElementById('alertdenunciado').hidden = true
                        document.getElementById('alertdescription').hidden = true
                        document.getElementById('form-denuncia').reset()
                    } else if (response.data == 1) {
                        document.getElementById('alertdenciante').hidden = false
                        document.getElementById('alertdenunciado').hidden = true
                    } else if (response.data == 2) {
                        document.getElementById('alertdenunciado').hidden = false
                        document.getElementById('alertdenciante').hidden = true
                    }else if (response.data == 4){
                        document.getElementById('alertdescription').hidden = false
                        document.getElementById('alertdenunciado').hidden = true
                    }else{
                        document.getElementById('alertdescription').hidden = false
                        document.getElementById('alertdenunciado').hidden = false
                        document.getElementById('alertdenciante').hidden = false
                        document.getElementById('alertsucces').hidden = true
                    }
                })
        }
    },
    beforeCreate(){
        if(!(localStorage.getItem('typeuser') == "dgde")){
            window.location.href = "/#/home"
        }
    }
}

</script>
