<template>
  <div class="mt-3">
    <b-card-group deck class="mt-5">
      <!-- poner un if para ver si es fiscal del caso -->
      <b-card bg-variant="light" title="Información de la denuncia" title-tag="h1" border-variant="secondary" class="text-dark mx-auto text-center w-50">
         <b-card-body>
          <b-card-sub-title>ID denuncia: {{id}}</b-card-sub-title>
          <b-card-text align="left" class="pt-3"><strong>Correo institucional del denunciante: </strong>matias.silva.al@usach.cl</b-card-text>
          <b-card-text align="left"><strong>Correo institucional del denunciado: </strong>catalina.olivares@usach.cl</b-card-text>
          <b-card-text align="left"><strong>Correo institucional del fiscal asignado: </strong>clemente.aguilar@usach.cl</b-card-text>
          <b-card-text align="left" text-tag="h3"><strong>Descripción de la denuncia: </strong></b-card-text>
          <b-card-text align="justify">{{descripcion}}</b-card-text>
          <b-card-text align="left"><strong>Estado de la denuncia: </strong>
            <!-- poner un if para ver si es fiscal del caso -->
            <b-dropdown id="dropdown-1" :text=estado class="m-md-2">
              <b-dropdown-item>Ingresado</b-dropdown-item>
              <b-dropdown-item>En curso</b-dropdown-item>
              <b-dropdown-item>Finalizado</b-dropdown-item>
            </b-dropdown>
          </b-card-text>
            <b-row>
              <!-- poner un if para ver si es fiscal del caso -->
              <b-col lg="1"><b-button size="lg">Volver</b-button></b-col>
              <b-col lg="1"><b-button size="lg">Confirmar</b-button></b-col>
            </b-row>        
        </b-card-body>
      </b-card>
    </b-card-group>
  </div>
</template>
<script>
import axios from 'axios'
export default {
    data () {
        return {
        id: '',
        }
    },
    created () {
        this.id = this.$route.params.id.id_denuncia;
        this.descripcion = this.$route.params.id.descripcion;
        this.estado = this.$route.params.id.estado;
    },
}
</script>
