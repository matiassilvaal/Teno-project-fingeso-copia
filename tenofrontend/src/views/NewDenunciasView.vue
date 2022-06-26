<template>
    <div class="mt-5 formulario">
        <h1 class="text-dark">Ingresar una denuncia</h1>
        <h1 class="text-light">Ingresar una denuncia</h1>
        <form>
            <div class="mb-3">
                <label for="exampleInputEmail1"  class="form-label text-dark d-flex">Correo institucional del
                    denunciante</label>
                <input type="email" class="form-control" id="denunciante" aria-describedby="emailHelp" />
            </div>
            <div class="mb-3">
                <label for="exampleInputEmail1" class="form-label text-dark d-flex">Correo institucional del
                    denunciado</label>
                <input type="email" class="form-control" id="denunciado" aria-describedby="emailHelp" />
            </div>
            <div class="mb-3">
                <label for="floatingTextarea" class="text-dark d-flex">Detalles de la denuncia</label>
                <label for="floatingTextarea" class="text-light d-flex">Detalles de la denuncia</label>
                <textarea class="form-control" placeholder="Detalles de la denuncia" id="descripcion"></textarea>
            </div>
            <div class="mb-3">
                <label for="floatingTextarea" class="text-dark d-flex">Medidas de proteccion (opcional)</label>
                <textarea class="form-control" placeholder="Medidas de proteccion" id="floatingTextarea"></textarea>
            </div>
            <button @click='insert' type="" class="btn btn-primary d-flex">Enviar</button>
        </form>
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

export default {
    methods:{
        insert(){
            axios.post('http://localhost:8082/denounces/insert?description=' +document.getElementById('descripcion').value +'&denunciante="' + document.getElementById('denunciante').value+'"&denounced="'+document.getElementById('denunciado').value+'"').then(response => {console.log(response)})
        }
    }
}

</script>
