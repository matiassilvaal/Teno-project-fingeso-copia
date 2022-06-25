<template>
  <div class="mt-4">
    <h1 class="text-light">Denuncias Activas</h1>
    <div class="row">
      <div class="col-6">
        <template>
          <div>
            <b-table
              :items="items"
              :fields="fields"
              striped hover head-variant="dark"
              class="text-black bg-white"
              >
              <template v-slot:cell(ver)="data">
                <router-link :to="
                { name: 'DenounceView', params: { id: data.item.id_denuncia }
                }"
                  tag="button"
                  class="btn btn-succes"><b-icon icon="eye-fill" />
                </router-link>
              </template>
            </b-table>
          </div>
        </template>
      </div>
      <div class="col-6" style="border: 1px solid">
        <h1 class="text-light">Denuncias realizadas</h1>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  data () {
    return {
      fields: [
        { key: 'id_denuncia', label: 'ID' },
        { key: 'estado', label: 'Estado' },
        { key: 'descripcion', label: 'Descripción' },
        { key: 'ver', label: 'Ver' }
      ],
      items: [
      ]
    }
  },
  created () {
    axios.get('http://localhost:8082/denounces/get-all')
      .then(response => {
        response.data.forEach(element => {
          this.items.push({
            id_denuncia: element.id,
            estado: element.state,
            descripcion: element.description
          })
        })
      })
  }
}
</script>
