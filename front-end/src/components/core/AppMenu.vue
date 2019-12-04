<template>
  <v-navigation-drawer
    :clipped="clipped"
    v-model="drawer"
    enable-resize-watcher
    app
    flat
    class="blue"
  >
    <v-list class="pt-0" dense color="#109CF1">
      <v-list-tile class="mt-3" avatar>
        <v-list-tile-avatar>
          <v-menu offset-y origin="center center" :nudge-bottom="10" transition="scale-transition">
            <v-btn icon large flat slot="activator">
              <img src="https://randomuser.me/api/portraits/men/85.jpg" />
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
        </v-list-tile-avatar>

        <v-list-tile-content>
          <v-list-tile-title class="white--text">{{user.nome}}</v-list-tile-title>
          <v-list-tile-sub-title class="white--text">{{user.email}}</v-list-tile-sub-title>
        </v-list-tile-content>
      </v-list-tile>
    </v-list>

    <div class="barra-lateral-2">
      <v-divider light="true"></v-divider>
      <v-list class="pt-0" dense light="true">
        <v-list-tile :to="{name: 'Dashboard'}">
          <v-list-tile-action>
            <v-icon color="#C2CFE0">dashboard</v-icon>
          </v-list-tile-action>
          <v-list-tile-content>
            <v-list-tile-title class="white--text">Dashboard</v-list-tile-title>
          </v-list-tile-content>
        </v-list-tile>

        <v-list-tile :to="{name: 'ListarBeneficios'}">
          <v-list-tile-action>
            <v-icon color="#C2CFE0">monetization_on</v-icon>
          </v-list-tile-action>
          <v-list-tile-content>
            <v-list-tile-title class="white--text">Benefícios</v-list-tile-title>
          </v-list-tile-content>
        </v-list-tile>

        <v-list-tile :to="{name: 'ListarTreinamentos'}">
          <v-list-tile-action>
            <v-icon color="#C2CFE0">assignment_turned_in</v-icon>
          </v-list-tile-action>
          <v-list-tile-content>
            <v-list-tile-title class="white--text">Treinamentos</v-list-tile-title>
          </v-list-tile-content>
        </v-list-tile>

        <v-list-tile :to="{name: 'ListarCargos'}">
          <v-list-tile-action>
            <v-icon color="#C2CFE0">work</v-icon>
          </v-list-tile-action>
          <v-list-tile-content>
            <v-list-tile-title class="white--text">Todos os Cargos</v-list-tile-title>
          </v-list-tile-content>
        </v-list-tile>

        <v-list-tile :to="{name: 'ListarFuncionarios'}">
          <v-list-tile-action>
            <v-icon color="#C2CFE0">account_box</v-icon>
          </v-list-tile-action>
          <v-list-tile-content>
            <v-list-tile-title class="white--text">Todos os Funcionários</v-list-tile-title>
          </v-list-tile-content>
        </v-list-tile>
      </v-list>
    </div>
    <div class="barra-lateral-3">
      <v-list class="pt-0" dense>
        <v-divider class="white--text"></v-divider>
        <v-list-tile>
          <v-list-tile-action>
            <v-icon color="#C2CFE0">more_horiz</v-icon>
          </v-list-tile-action>
          <v-list-tile-content>
            <v-list-tile-title class="white--text">Configurações</v-list-tile-title>
          </v-list-tile-content>
        </v-list-tile>
      </v-list>
    </div>
  </v-navigation-drawer>
</template>


<script>
import { mapGetters } from "vuex";

export default {
  name: "app-menu",
  data() {
    return {
      drawer: true,
      right: null
    };
  },
  computed: {
    ...mapGetters({
      user: "auth/user"
    })
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
  margin-top: 50px;
}

.barra-lateral-3 {
  margin-top: 180px;
}

.hover-title:hover {
  color: black !important;
  background-color: blueviolet !important;
}
</style>
