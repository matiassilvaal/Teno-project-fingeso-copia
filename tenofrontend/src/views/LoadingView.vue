<template>
    <h1 class="loading">{{msg}}</h1>
</template>

<style scoped>
.loading{
    margin-top: 10%;
    font-size: 8rem;
}

</style>

<script>
export default {
  data () {
    return {
        msg: 'Loading',
        i: 0
    }
  },
  methods : {
    loading () {
        if (this.i  == 0){
            setTimeout(() => {
                this.msg="Loading."
                this.i ++
                this.loading()
            },400)
        }
        else if (this.i  == 1){
            setTimeout(() => {
                this.msg="Loading.."
                this.i ++
                this.loading()
            },400)
        }
        else if (this.i  == 2){
            setTimeout(() => {
                this.msg="Loading..."
                this.i ++
                this.loading()
            },400)
        }else if(this.i == 3){
            setTimeout(() => {
                this.msg="Loading"
                this.i = 0
                this.loading()
            },400)
        }
    }
  },
  created() {
    this.loading()
    setTimeout(() => {
        var typeuser = localStorage.getItem('typeuser')
        if(!typeuser){
            window.location.href = "/#/"
        }
        else if(typeuser == 'denunciador'){
            window.location.href = '/#/denuncialist'
        }
        else if(typeuser == 'fiscal'){
            window.location.href = '/#/denuncialistfiscal'
        }
        else if(typeuser == 'dgde'){
            window.location.href = '/#/newdenuncia'
        }
        
    }, 700);
  }
}

</script>
