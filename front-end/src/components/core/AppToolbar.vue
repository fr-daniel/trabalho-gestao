<template>
  <v-toolbar color="white" fixed app class="mb-3">
    <v-text-field
      flat
      solo
      prepend-icon="search"
      placeholder="Realizar uma Busca por Cargo ou Funcionário"
      v-model="search"
      hide-details
      class="hidden-sm-and-down"
    ></v-text-field>

    <v-spacer></v-spacer>

    <v-menu offset-y origin="center center" :nudge-bottom="10" transition="scale-transition">
      <v-btn icon large flat slot="activator">
        <v-avatar size="30px">
          <v-icon>account_circle</v-icon>
        </v-avatar>
      </v-btn>
      <v-list class="pa-0">
        <v-list-tile>
          <v-list-tile-action>
            <v-icon>face</v-icon>
          </v-list-tile-action>
          <v-list-tile-content>
            <v-list-tile-title>Perfil</v-list-tile-title>
          </v-list-tile-content>
        </v-list-tile>
        <v-list-tile @click="logout">
          <v-list-tile-action>
            <v-icon>power_settings_new</v-icon>
          </v-list-tile-action>
          <v-list-tile-content>
            <v-list-tile-title>Sair</v-list-tile-title>
          </v-list-tile-content>
        </v-list-tile>
      </v-list>
    </v-menu>
  </v-toolbar>
</template>

<script>
export default {
  name: "app-toolbar",
  data() {
    return {};
  }
};
</script>
