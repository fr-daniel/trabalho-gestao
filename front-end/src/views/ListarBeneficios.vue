<template>
  <v-app id="telaInicial">
    <v-container grid-list-xl fluid>
      <v-layout row wrap>
        <v-flex xs12>
          <v-card>
            <v-container>
              <v-toolbar flat color="white">
                <CadastrarBeneficio></CadastrarBeneficio>
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
                  <td class="justify-center">{{ props.item.titulo }}</td>
                  <td class="justify-center">{{ props.item.valor }}</td>
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
            </v-container>
          </v-card>
        </v-flex>
      </v-layout>
    </v-container>
  </v-app>
</template>


<script>
import CadastrarBeneficio from "./CadastrarBeneficio";

export default {
  components: { CadastrarBeneficio },
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
          value: "selecionarBeneficio"
        },
        {
          text: "Título",
          align: "left",
          sortable: true,
          value: "titulo"
        },
        {
          text: "Valor",
          align: "left",
          sortable: false,
          value: "valor"
        },
        { text: "Opções", sortable: false, value: "opcoes" }
      ],
      desserts: [
        {
          selecionarBeneficio: "",
          titulo: "BBBBBBBBB",
          valor: "12/11/2019"
        },
        {
          selecionarBeneficio: "",
          titulo: "BBBBBBBBB",
          valor: "12/11/2019"
        },
        {
          selecionarBeneficio: "",
          titulo: "BBBBBBBBB",
          valor: "12/11/2019"
        },
        {
          selecionarBeneficio: "",
          titulo: "BBBBBBBBB",
          valor: "12/11/2019"
        },
        {
          selecionarBeneficio: "",
          titulo: "BBBBBBBBB",
          valor: "12/11/2019"
        }
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
