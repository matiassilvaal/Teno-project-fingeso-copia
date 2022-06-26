<style>
@import url('http://fonts.cdnfonts.com/css/coolvetica-2');
</style>

<template>
  <div class="mt-4">
    <template>
      <div class="mt-4 mb-4">
        <b-container fluid>
          <b-row>
            <b-col class="mb-4">
              <d1 class="text-center">Denuncias activas</d1>
            </b-col>
          </b-row>
          <div class="row">
            <div class="col-6">
              <d2>Denuncias realizadas</d2>
                <ListDenouncements :denouncements="itemsReal" />
            </div>
            <div class="col-6">
              <d2>Denuncias Recibidas</d2>
              <ListDenouncements :denouncements="itemsReal" />
            </div>
          </div>
        </b-container>
      </div>
    </template>
  </div>
</template>

<script>
import ListDenouncements from '../components/ListDenouncements'
import axios from 'axios'
export default {
  components: {
    ListDenouncements
  },
  data() {
    return {
      fields: [
        { key: 'id_denuncia', label: 'ID' },
        { key: 'estado', label: 'Estado' },
        { key: 'descripcion', label: 'Descripción' },
        { key: 'ver', label: 'Ver' }
      ],
      itemsReal: [
      ],
      itemsRecib: [
      ]
    }
  },
  created() {
    axios.get('http://localhost:8082/denounces/get-by-idrol?id='+localStorage.getItem('iduser')+'&type=denunciante')
      .then(response => {
        response.data.forEach(element => {
          this.itemsReal.push({
            id_denuncia: element.id,
            estado: element.state,
            descripcion: element.description
          })
        })
      })
    axios.get('http://localhost:8082/denounces/get-by-idrol?id='+localStorage.getItem('iduser')+'&type=denunciado')
      .then(response => {
        response.data.forEach(element => {
          this.itemsRecib.push({
            id_denuncia: element.id,
            estado: element.state,
            descripcion: element.description
          })
        })
      })
  }
}
</script>
