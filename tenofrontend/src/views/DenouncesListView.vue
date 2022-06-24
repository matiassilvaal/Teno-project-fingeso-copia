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
                { name: 'DenounceView', params: { id: data.item.id }
                }"
                  tag="button"
                  class="btn btn-succes"><b-icon icon="eye-fill" />
                </router-link>
              </template>
            </b-table>
          </div>
        </template>
        <!--grillo chupame el pico embarao y la conchetumare pollo culiao hijo de la gran perra-->
        <!--perro culiao-->
      </div>
      <div class="col-6" style="border: 1px solid">
        <h1 class="text-light">Denuncias realizadas</h1>
      </div>
    </div>
  </div>
</template>

<script>
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
        { id_denuncia: 40, estado: 'Dickerson', descripcion: 'Macdonald' },
        { id_denuncia: 21, estado: 'Larsen', descripcion: 'Shaw' },
        { id_denuncia: 89, estado: 'Geneva', descripcion: 'Wilson' }
      ]
    }
  }
}
</script>
