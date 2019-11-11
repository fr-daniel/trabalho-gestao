<template>
  <v-app id="telaInicial">
    <AppToolbar></AppToolbar>

    <v-content>
      <v-container>
        <div>
          <v-toolbar flat color="white">
            <CadastrarTreinamento></CadastrarTreinamento>
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
              <td class="justify-center">{{ props.item.descricao }}</td>
              <td class="justify-center">{{ props.item.treinamento }}</td>
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
    </v-content>
  </v-app>
</template>


<script>
import CadastrarTreinamento from "./CadastrarTreinamento";
import AppToolbar from "../components/core/AppToolbar";
export default {
  components: { CadastrarTreinamento, AppToolbar },
  data() {
    return {
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
          value: "selecionarTreinamento"
        },
        {
          text: "Título",
          align: "left",
          sortable: true,
          value: "titulo"
        },
        {
          text: "Descrição",
          align: "left",
          sortable: false,
          value: "descricao"
        },
        {
          text: "Treinamento",
          align: "left",
          sortable: false,
          value: "treinamento"
        },
        { text: "Opções", sortable: false, value: "opcoes" }
      ],
      desserts: [
        {
          selecionarTreinamento: "",
          titulo: "BBBBBBB",
          descricao: "AAAAAAAAA",
          treinamento: "12/11/2019"
        },
        {
          selecionarTreinamento: "",
          titulo: "BBBBBBB",
          descricao: "AAAAAAAAA",
          treinamento: "12/11/2019"
        },
        {
          selecionarTreinamento: "",
          titulo: "BBBBBBB",
          descricao: "AAAAAAAAA",
          treinamento: "12/11/2019"
        },
        {
          selecionarTreinamento: "",
          titulo: "BBBBBBB",
          descricao: "AAAAAAAAA",
          treinamento: "12/11/2019"
        },
        {
          selecionarTreinamento: "",
          titulo: "BBBBBBB",
          descricao: "AAAAAAAAA",
          treinamento: "12/11/2019"
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
