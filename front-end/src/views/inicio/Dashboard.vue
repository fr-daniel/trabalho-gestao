<template>
  <v-app id="telaInicial">
    <v-toolbar color="white" fixed app>
      <v-text-field
        flat
        solo
        prepend-icon="search"
        placeholder="Realizar Uma Busca"
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
        <v-list-tile avatar>
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
          <v-list-tile>
            <v-list-tile-action>
              <v-icon color="#C2CFE0">dashboard</v-icon>
            </v-list-tile-action>
            <v-list-tile-content>
              <v-list-tile-title>Dashboard</v-list-tile-title>
            </v-list-tile-content>
          </v-list-tile>

          <v-list-tile>
            <v-list-tile-action>
              <v-icon color="#C2CFE0">work</v-icon>
            </v-list-tile-action>
            <v-list-tile-content>
              <v-list-tile-title>Todos os Cargos</v-list-tile-title>
            </v-list-tile-content>
          </v-list-tile>

          <v-list-tile>
            <v-list-tile-action>
              <v-icon color="#C2CFE0">monetization_on</v-icon>
            </v-list-tile-action>
            <v-list-tile-content>
              <v-list-tile-title>Todos os Salários</v-list-tile-title>
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

    <v-content>
      <v-container>
        <v-card>
          <v-container>
            <v-card-title primary-title>
              <div>
                <div class="headline">Vagas Cadastradas</div>
                <div class="grey--text">
                  Data da Última atualização:
                  <span class="black--text">December 23, 2018</span>
                </div>
                <div class="grey--text">
                  Último Cadastro:
                  <span class="black--text">Gerente de Recursos Humanos</span>
                </div>
              </div>
              <v-layout>
                <v-spacer></v-spacer>

                <v-btn class="ma-2" tile color="#2ED47A">
                  <span class="white--text">
                    <v-icon left>add</v-icon>Adicionar Novo Cargo
                  </span>
                </v-btn>
              </v-layout>
            </v-card-title>
          </v-container>

          <v-divider></v-divider>

          <v-container>
            <v-card-title primary-title>
              <div>
                <div class="headline">Cadastrar Funcionário</div>
                <div class="grey--text">
                  Última Atualização:
                  <span class="black--text">20 de outubro de 2019</span>
                </div>
                <div class="grey--text">
                  Quantidade de Funcionários:
                  <span class="black--text">5.000</span>
                </div>
              </div>
              <v-layout>
                <v-spacer></v-spacer>

                <v-btn class="ma-2" tile color="#F7685B">
                  <span class="white--text">
                    <v-icon left>add</v-icon>Adicionar Funcionário
                  </span>
                </v-btn>
              </v-layout>
            </v-card-title>
          </v-container>
        </v-card>
      </v-container>
    </v-content>
  </v-app>
</template>


<script>
export default {
  data() {
    return {
      drawer: true,
      right: null
    }
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
  margin-top: 12px;
}

.barra-lateral-2 {
  margin-top: 30px;
}

.barra-lateral-3 {
  margin-top: 100px;
}
</style>
