<template>
  <div>
    <b-card>
      <blockquote class="blockquote mb-0">
        <p>{{shorter(description)}}</p>
        <footer class="blockquote-footer">
          {{state}}
        </footer>
      </blockquote>
    </b-card>
  </div>
</template>

<script>
export default {
  name: 'OneDenounce',
  props: {
    description: Array,
    state: String
  },
  methods: {
    shorter (text) {
      if (text.length > 30) {
        return text.substr(0, 29)
      }
      return text
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
div{
  background-color: azure;
  width: 20rem;
  height: 5rem;
  border-radius: 4px;
}

div p{
  position: relative;
  bottom: 0.5rem;
  background-color: rgb(244, 231, 215);
  border-radius: 5px;
  padding: 5px;
  font-size: 13px;
  height: 2.5rem;
}

div footer{
  position: relative;
  bottom: 0.3rem;
  border-radius: 5px;
  background-color: rgb(244, 231, 215);
  font-size: 15px;
}
</style>
