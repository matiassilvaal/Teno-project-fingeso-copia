<template>
  <div class="mt-3">
    <b-card-group deck class="mt-5">
      <b-card bg-variant="light" title="Información de la denuncia" title-tag="h1" border-variant="secondary" class="text-dark mx-auto text-center w-50">
         <b-card-body>
          <b-card-sub-title>ID denuncia: {{id}}</b-card-sub-title>
          <b-card-text align="left" class="pt-3"><strong>Correo institucional del denunciante: </strong>{{denunciante}}</b-card-text>
          <b-card-text align="left"><strong>Correo institucional del denunciado: </strong>{{denunciado}}</b-card-text>
          <b-card-text align="left"><strong>Correo institucional del fiscal asignado: </strong>{{fiscal}}</b-card-text>
          <b-card-text align="left" text-tag="h3"><strong>Descripción de la denuncia: </strong></b-card-text>
          <b-card-text align="justify">{{descripcion}}</b-card-text>
          <b-card-text align="left"><strong>Estado de la denuncia: </strong>
            <!-- Comprueba si fiscal (1) o usuario normal (0) -->
            <b-dropdown v-if="tipo == 1" aria-role="list" v-bind:text="(selectedState.name)">
              <b-dropdown-item
                v-for="(state, index) in estados"
                :key="index"
                aria-role="listitem"
                @click="setItem(state)"
              >{{ state.name }}</b-dropdown-item>
            </b-dropdown>
            <strong v-else>{{estado}} </strong>
          </b-card-text>
            <b-row>
              <!-- Comprueba si fiscal (1) o usuario normal (0) -->
              <b-col lg="1"><b-button size="lg" to="/denuncialist">Volver</b-button></b-col>
              <b-col lg="1" v-if="tipo == 1"><b-button @click="push" size="lg">Confirmar</b-button></b-col>
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
        descripcion: '',
        estado: '',
        denunciante: '',
        denunciado: '',
        fiscal: '',
        tipo: 0,
        estados:[{
          id: 1,
          name: "Ingresado",
        },
        {
          id: 2,
          name: "En curso",
        },
        {
          id: 3,
          name: "Finalizado",
        }],
        selectedState: {
          id: 0,
          name: this.$route.params.id.estado,
        },
      }
    },
    
    created () {
        this.tipo = localStorage.getItem('tipo');
        this.id = this.$route.params.id.id_denuncia;
        this.descripcion = this.$route.params.id.descripcion;
        this.estado = this.$route.params.id.estado;
        axios.get('http://localhost:8082/denounces/get-by-id?id='+this.id).
        then(response => {
            axios.get('http://localhost:8082/users/get-by-id?id='+response.data.iddenunciante).
              then(response => {
              this.denunciante = response.data.correo;
            })
            axios.get('http://localhost:8082/users/get-by-id?id='+response.data.iddenounced).
              then(response => {
              this.denunciado = response.data.correo;
            })
            if(response.data.idfiscal != -1){
              axios.get('http://localhost:8082/users/get-by-id?id='+response.data.idfiscal).
              then(response => {
              this.fiscal = response.data.correo;
            })
            }
            else{
              this.fiscal = 'No asignado';
            }
        })
    },
    methods: {
      push(){
      let put = {
        id: this.id,
        state: 'asignado',
      };
      console.log(this.selectedState.name);
      axios.put("http://localhost:8082/denounces/update-denounce", put).then((result) => {
        console.log(result);
      });
    },
    setItem: function(state) {
      this.selectedState = state;
    },
  } 
}
</script>
