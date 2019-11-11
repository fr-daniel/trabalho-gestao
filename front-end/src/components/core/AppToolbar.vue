<template>
  <v-app id="telaInicial">
    <v-toolbar color="white" fixed app>
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
          <v-list-tile @click>
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

    <v-navigation-drawer v-model="drawer" app>
      <div class="barra-lateral-1">
        <v-list class="pt-0" dense>
          <v-list-tile avatar></v-list-tile>
        </v-list>
      </div>

      <v-list class="pt-0" dense>
        <v-divider></v-divider>
        <v-list-tile class="mt-3" avatar>
          <v-list-tile-avatar>
            <img src="https://randomuser.me/api/portraits/men/85.jpg" />
          </v-list-tile-avatar>

          <v-list-tile-content>
            <v-list-tile-title>Profissional de RH</v-list-tile-title>
            <v-list-tile-sub-title>profissional@email.com</v-list-tile-sub-title>
          </v-list-tile-content>
        </v-list-tile>
      </v-list>

      <div class="barra-lateral-2">
        <v-list class="pt-0" dense>
          <v-list-tile :to="{name: 'Dashboard'}">
            <v-list-tile-action>
              <v-icon color="#C2CFE0">dashboard</v-icon>
            </v-list-tile-action>
            <v-list-tile-content>
              <v-list-tile-title>Dashboard</v-list-tile-title>
            </v-list-tile-content>
          </v-list-tile>

          <v-list-tile :to="{name: 'ListarTreinamentos'}">
            <v-list-tile-action>
              <v-icon color="#C2CFE0">assignment_turned_in</v-icon>
            </v-list-tile-action>
            <v-list-tile-content>
              <v-list-tile-title>Treinamentos</v-list-tile-title>
            </v-list-tile-content>
          </v-list-tile>

          <v-list-tile :to="{name: 'ListarBeneficios'}">
            <v-list-tile-action>
              <v-icon color="#C2CFE0">monetization_on</v-icon>
            </v-list-tile-action>
            <v-list-tile-content>
              <v-list-tile-title>Benefícios</v-list-tile-title>
            </v-list-tile-content>
          </v-list-tile>

          <v-list-tile :to="{name: 'ListarCargos'}">
            <v-list-tile-action>
              <v-icon color="#C2CFE0">work</v-icon>
            </v-list-tile-action>
            <v-list-tile-content>
              <v-list-tile-title>Todos os Cargos</v-list-tile-title>
            </v-list-tile-content>
          </v-list-tile>

          <v-list-tile>
            <v-list-tile-action>
              <v-icon color="#C2CFE0">assignment_ind</v-icon>
            </v-list-tile-action>
            <v-list-tile-content>
              <v-list-tile-title>Todos os Funcionários</v-list-tile-title>
            </v-list-tile-content>
          </v-list-tile>

          <v-list-tile>
            <v-list-tile-action>
              <v-icon color="#C2CFE0">mail</v-icon>
            </v-list-tile-action>
            <v-list-tile-content>
              <v-list-tile-title>Email dos Funcionários</v-list-tile-title>
            </v-list-tile-content>
          </v-list-tile>
        </v-list>
      </div>

      <div class="barra-lateral-3">
        <v-list class="pt-0" dense>
          <v-divider></v-divider>
          <v-list-tile>
            <v-list-tile-action>
              <v-icon color="#C2CFE0">more_horiz</v-icon>
            </v-list-tile-action>
            <v-list-tile-content>
              <v-list-tile-title>Configurações</v-list-tile-title>
            </v-list-tile-content>
          </v-list-tile>
        </v-list>
      </div>
    </v-navigation-drawer>
  </v-app>
</template>


<script>
export default {
  data() {
    return {
      search: "",
      drawer: true,
      right: null
    };
  },
  methods: {
    logout() {
      this.$router.push("/logout");
    }
  }
};
</script>

<style lang="css" scoped>
.barra-lateral-1 {
  margin-top: 13px;
}

.barra-lateral-2 {
  margin-top: 30px;
}

.barra-lateral-3 {
  margin-top: 100px;
}
</style>
