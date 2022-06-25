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
          <b-card-text align="justify">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer maximus interdum tellus. Nullam dignissim finibus tortor congue varius. Proin lacus turpis, gravida ac nibh a, tempor congue sem. Curabitur mi turpis, maximus eu bibendum a, iaculis quis erat. Aenean nisi ipsum, eleifend ut rutrum non, pellentesque commodo turpis. Integer porta, mi nec mattis tincidunt, purus nulla pharetra ante, sit amet suscipit risus lectus sed sem. Nam pellentesque, justo ac bibendum ultricies, nibh velit mattis tortor, ac dictum ipsum metus eget tellus. Duis mollis, dui non tempus luctus, sem metus condimentum arcu, sit amet vestibulum dui orci in erat. Nam ac luctus odio, in consequat quam. Nunc non gravida tortor. Phasellus faucibus convallis fermentum. Maecenas tincidunt egestas libero sed commodo. Sed auctor quam nec mollis vulputate.</b-card-text>
          <b-card-text align="left"><strong>Estado de la denuncia: </strong>
            <!-- poner un if para ver si es fiscal del caso -->
            <b-dropdown id="dropdown-1" text="Estado actual" class="m-md-2">
              <b-dropdown-item>Estado 1</b-dropdown-item>
              <b-dropdown-item>Estado 2</b-dropdown-item>
              <b-dropdown-item>Estado 3</b-dropdown-item>
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
export default {
    data () {
        return {
        id: ''
        }
    },
    created () {
        this.id = this.$route.params.id;
    },
}
</script>
