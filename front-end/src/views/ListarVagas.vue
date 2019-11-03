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
        <div>
          <v-toolbar flat color="white">
            <v-toolbar-title>
              <v-container fluid>
                <v-layout row wrap align-center>
                  <v-flex xs6>
                    <v-subheader>Categorias:</v-subheader>
                  </v-flex>

                  <v-flex xs4>
                    <v-select
                      v-model="select"
                      :items="items"
                      item-text="state"
                      item-value="abbr"
                      single-line
                      return-object
                    ></v-select>
                  </v-flex>
                </v-layout>
              </v-container>
            </v-toolbar-title>
            <v-spacer></v-spacer>
            <v-btn class="ma-2" tile color="#2ED47A">
              <span class="white--text">
                <v-icon left>add</v-icon>Adicionar Novo Cargo
              </span>
            </v-btn>
          </v-toolbar>
          <v-data-table
            :headers="headers"
            :items="desserts"
            :search="search"
            hide-actions
            :pagination.sync="pagination"
            class="elevation-1"
          >
            <template v-slot:items="props">
              <td>
                <v-checkbox :input-value="props.selected" primary hide-details></v-checkbox>
              </td>
              <td class="justify-center">{{ props.item.vaga }}</td>
              <td class="justify-center">{{ props.item.tipo }}</td>
              <td class="justify-center">{{ props.item.salario }}</td>
              <td class="justify-center">{{ props.item.cargo }}</td>
            </template>
          </v-data-table>
          <div class="text-xs-center pt-2">
            <v-pagination v-model="pagination.page" :length="pages"></v-pagination>
          </div>
        </div>
      </v-container>
    </v-content>
  </v-app>
</template>


<script>
export default {
  data() {
    return {
      drawer: true,
      right: null,
      expand: false,
      search: "",
      pagination: {},
      selected: [],
      headers: [
        {
          text: "",
          align: "left",
          sortable: false,
          value: "selecionarVaga"
        },
        {
          text: "Vaga",
          align: "left",
          sortable: false,
          value: true
        },
        { text: "Tipo", value: "tipo" },
        { text: "Salário", value: "salário" },
        { text: "Cargo", value: "cargo" }
      ],
      desserts: [
        {
          selecionarVaga: "",
          vaga: "AAAAAAAAA",
          tipo: "AAAA",
          salario: "R$ 1500,00",
          cargo: "Diretor"
        },
        {
          selecionarVaga: "",
          vaga: "AAAAAAAAA",
          tipo: "AAAA",
          salario: "R$ 1500,00",
          cargo: "Diretor"
        },
        {
          selecionarVaga: "",
          vaga: "AAAAAAAAA",
          tipo: "AAAA",
          salario: "R$ 1500,00",
          cargo: "Diretor"
        },
        {
          selecionarVaga: "",
          vaga: "AAAAAAAAA",
          tipo: "AAAA",
          salario: "R$ 1500,00",
          cargo: "Diretor"
        },
        {
          selecionarVaga: "",
          vaga: "AAAAAAAAA",
          tipo: "AAAA",
          salario: "R$ 1500,00",
          cargo: "Diretor"
        }
      ],
      select: { state: "Florida", abbr: "FL" },
      items: [
        { state: "Florida", abbr: "FL" },
        { state: "Georgia", abbr: "GA" },
        { state: "Nebraska", abbr: "NE" },
        { state: "California", abbr: "CA" },
        { state: "New York", abbr: "NY" }
      ]
    };
  },
  methods: {
    logout() {
      this.$router.push("/logout");
    }
  },
  computed: {
    pages() {
      if (
        this.pagination.rowsPerPage == null ||
        this.pagination.totalItems == null
      )
        return 0;

      return Math.ceil(
        this.pagination.totalItems / this.pagination.rowsPerPage
      );
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
