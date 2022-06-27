<template>
    <div>
        <b-table :items="Denouncements" :fields="fields" striped hover head-variant="dark"
        class="text-black bg-white">
        <template v-slot:cell(ver)="data">
            <router-link :to="
            {
            name: 'DenounceView', params: { id: data.item }
            }" tag="button" class="btn btn-succes">
            <b-icon icon="eye-fill" />
            </router-link>
        </template>
        </b-table>
    </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'ListDenouncements',
  props: {
    Denouncements: Array,
  },
  data() {
    return {
      fields: [
        { key: 'id_denuncia', label: 'ID' },
        { key: 'estado', label: 'Estado' },
        { key: 'descripcion', label: 'Descripción' },
        { key: 'ver', label: 'Ver' }
      ]
    }
  }
}

</script>