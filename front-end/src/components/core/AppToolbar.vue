<template>
  <v-toolbar color="white" fixed app class="mb-3">

    <v-spacer></v-spacer>

  </v-toolbar>
</template>

<script>
export default {
  name: "app-toolbar",
  data() {
    return {
      search: ""
    };
  },
  methods:{
    logout() {
      this.$router.push("/logout");
    }
  }
};
</script>

<style scoped>

</style>
