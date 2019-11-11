<template>
  <v-navigation-drawer :clipped="clipped" v-model="drawer" enable-resize-watcher app flat>
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
          <v-list-tile-title>{{user.nome}}</v-list-tile-title>
          <v-list-tile-sub-title>{{user.email}}</v-list-tile-sub-title>
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
</template>


<script>
import { mapGetters } from "vuex";

export default {
  name: "app-menu",
  data() {
    return {
      search: "",
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
  margin-top: 30px;
}

.barra-lateral-3 {
  margin-top: 100px;
}
</style>
