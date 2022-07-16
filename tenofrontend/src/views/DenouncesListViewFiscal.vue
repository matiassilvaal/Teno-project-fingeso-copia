<style>
@import url('http://fonts.cdnfonts.com/css/coolvetica-2');
</style>

<template>
<div>
<Navbar/>
  <div class="mt-4" style="padding-bottom: 3rem;">
    <template>
      <div class="mt-4 mb-4" >
        <b-container fluid>
          <b-row>
            <b-col class="mb-4">
              <h1 class="text-center" style="font-family:coolvetica;font-size:30px;">Denuncias asignadas</h1>
            </b-col>
          </b-row>
            <div class="row">
                <div class="col-6 centered">
                    <ListDenouncements :Denouncements="itemsRecib" />
                </div>
          </div>
        </b-container>
      </div>
    </template>
  </div>
<Footer/>
</div>
</template>

<style>
.centered{
    margin: 0 auto;
}

</style>
<script>
import ListDenouncements from '../components/ListDenouncements'
import Navbar from '../components/Navbar'
import Footer from '../components/Footer'
import axios from 'axios'
export default {
  components: {
    ListDenouncements,
    Navbar,
    Footer
  },
  data() {
    return {
      fields: [
        { key: 'id_denuncia', label: 'ID' },
        { key: 'estado', label: 'Estado' },
        { key: 'descripcion', label: 'Descripción' },
        { key: 'ver', label: 'Ver' }
      ],
      itemsRecib: [
      ]
    }
  },
  created() {
    axios.get('http://localhost:8082/denounces/get-by-idrol?id='+localStorage.getItem('iduser')+'&type=fiscal')
      .then(response => {
        response.data.forEach(element => {
          this.itemsRecib.push({
            id_denuncia: element.id,
            estado: element.state,
            descripcion: element.description
          })
        })
      })
  },
    beforeCreate(){
        if(!(localStorage.getItem('typeuser') == "fiscal")){
            window.location.href = "/#/home"
        }
    }
}
</script>