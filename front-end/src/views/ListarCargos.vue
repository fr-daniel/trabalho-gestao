<template>
  <v-app id="telaInicial">
    <v-container grid-list-xl fluid>
      <v-layout row wrap>
        <v-flex xs12>
          <v-card>
            <v-container>
              <div>
                <v-toolbar flat color="white">
                  <!-- <v-toolbar-title>
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
                  </v-toolbar-title>-->

                  <CadastrarCargo></CadastrarCargo>
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
                    <td class="justify-center">{{ props.item.dataAtualizacao }}</td>
                    <td class="justify-center">{{ props.item.salario }}</td>
                    <td class="justify-center">
                      <v-btn
                        class="ma-2"
                        tile
                        depressed
                        dark
                        icon
                        color="#192A3E"
                        small
                        :to="{name: 'EditarCargo'}"
                      >
                        <v-icon small>edit</v-icon>
                      </v-btn>
                      <v-btn class="ma-2" tile depressed dark icon color="#F7685B" small>
                        <v-icon small>delete</v-icon>
                      </v-btn>
                    </td>
                  </template>
                </v-data-table>
                <div class="text-xs-center pt-2">
                  <v-pagination v-model="pagination.page" :length="pages"></v-pagination>
                </div>
              </div>
            </v-container>
          </v-card>
        </v-flex>
      </v-layout>
    </v-container>
  </v-app>
</template>


<script>
import CadastrarCargo from "./CadastrarCargo";

export default {
  components: { CadastrarCargo },
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
          sortable: true,
          value: true
        },
        {
          text: "Última Atualização",
          sortable: false,
          value: "dataAtualizacao"
        },
        { text: "Salário", sortable: false, value: "salario" },
        { text: "Opções", sortable: false, value: "opcoes" }
      ],
      desserts: [
        {
          selecionarVaga: "",
          vaga: "AAAAAAAAA",
          dataAtualizacao: "12/11/2019",
          salario: "R$ 1500,00"
        },
        {
          selecionarVaga: "",
          vaga: "AAAAAAAAA",
          dataAtualizacao: "12/11/2019",
          salario: "R$ 1500,00"
        },
        {
          selecionarVaga: "",
          vaga: "AAAAAAAAA",
          dataAtualizacao: "12/11/2019",
          salario: "R$ 1500,00"
        },
        {
          selecionarVaga: "",
          vaga: "AAAAAAAAA",
          dataAtualizacao: "12/11/2019",
          salario: "R$ 1500,00"
        },
        {
          selecionarVaga: "",
          vaga: "AAAAAAAAA",
          dataAtualizacao: "12/11/2019",
          salario: "R$ 1500,00"
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
</style>
