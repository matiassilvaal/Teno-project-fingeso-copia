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
              <d1 class="text-center" style="font-family:coolvetica;font-size:40px;">Denuncias activas</d1>
            </b-col>
          </b-row>
          <div class="row">
            <div class="col-6">
              <d1 style="font-family:coolvetica;font-size:30px;">Denuncias realizadas</d1>
              <template>
                <div>
                  <b-table :items="itemsReal" :fields="fields" striped hover head-variant="dark"
                    class="text-black bg-white">
                    <template v-slot:cell(ver)="data">
                      <router-link :to="
                      {
                        name: 'DenounceView', params: { id: data.itemsReal }
                      }" tag="button" class="btn btn-succes">
                        <b-icon icon="eye-fill" />
                      </router-link>
                    </template>
                  </b-table>
                </div>
              </template>
            </div>
            <div class="col-6">
              <d1 style="font-family:coolvetica;font-size:30px;">Denuncias Recibidas</d1>
              <template>
                <div>
                  <b-table :items="itemsRecib" :fields="fields" striped hover head-variant="dark"
                    class="text-black bg-white">
                    <template v-slot:cell(ver)="data">
                      <router-link :to="
                      {
                        name: 'DenounceView', params: { id: data.itemsRecib }
                      }" tag="button" class="btn btn-succes">
                        <b-icon icon="eye-fill" />
                      </router-link>
                    </template>
                  </b-table>
                </div>
              </template>
            </div>
          </div>
        </b-container>
      </div>
    </template>
  </div>
</template>

<script>
import axios from 'axios'
export default {
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
    console.log(localStorage.getItem('iduser'))
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
