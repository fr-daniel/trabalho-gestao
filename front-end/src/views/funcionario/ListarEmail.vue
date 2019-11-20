<template>
  <v-app id="telaInicial">
    <v-container grid-list-xl fluid>
      <v-layout row wrap>
        <v-flex xs12>
          <v-card>
            <v-container>
              <div>
                <v-toolbar flat color="white">
                  <CadastrarFuncionario></CadastrarFuncionario>
                </v-toolbar>
                <v-data-table
                  :headers="headers"
                  :items="funcionarios"
                  :search="search"
                  class="elevation-1"
                >
                  <template v-slot:items="props">
                    <td class="justify-center">{{ props.item.id }}</td>
                    <td class="justify-center">{{ props.item.nome }}</td>
                    <td class="justify-center">{{ props.item.telefone }}</td>
                    <td class="justify-center">{{ props.item.email }}</td>
                    <td class="justify-center">
                      <v-tooltip bottom>
                        <template #activator="{ on: tooltip }">
                          <v-btn
                            class="ma-2"
                            tile
                            depressed
                            dark
                            icon
                            color="#2ED47A"
                            small
                            v-on="{ ...tooltip }"
                            @click="dialog = true"
                          >
                            <v-icon small>send</v-icon>
                          </v-btn>
                        </template>
                        <span>Enviar Email</span>
                      </v-tooltip>
                    </td>
                  </template>
                </v-data-table>
              </div>
            </v-container>
          </v-card>
        </v-flex>
      </v-layout>

      <v-snackbar :color="dCor" right top v-model="dSnackbar">{{ dMensagem }}</v-snackbar>

      <v-dialog max-width="290" v-model="dialog">
        <v-card>
          <v-card-title class="headline">Enviar Email</v-card-title>

          <v-card-text>Tem certeza que deseja enviar email para o funcionário?</v-card-text>

          <v-card-actions>
            <v-spacer></v-spacer>

            <v-btn @click="dialog = false" color="silver darken-1" flat="flat">Não</v-btn>

            <v-btn @click="excluirFuncionário()" color="red darken-1" flat="flat">Sim</v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
    </v-container>
  </v-app>
</template>


<script>
import axios from "axios";

export default {
  props: {
    cor: {
      type: String,
      default: ""
    },
    snackbar: {
      type: Boolean,
      default: false
    },
    mensagem: {
      type: String,
      default: ""
    }
  },
  data() {
    return {
      drawer: true,
      right: null,
      expand: false,
      search: "",
      selected: [],
      headers: [
        {
          text: "ID",
          align: "left",
          sortable: true,
          value: "id"
        },
        {
          text: "Nome",
          align: "left",
          sortable: false,
          value: "nome"
        },
        {
          text: "Telefone",
          align: "left",
          sortable: false,
          value: "telefone"
        },
        {
          text: "Email",
          sortable: false,
          value: "email"
        },
        { text: "Opções", sortable: false, value: "opcoes" }
      ],
      funcionarios: [],
      dialog: false,
      dSnackbar: false,
      dMensagem: "",
      dCor: ""
    };
  },
  created: function() {
    this.initialize();
  },
  methods: {
    initialize() {
      axios.get("funcionario/listar/emails").then(res => {
        this.funcionarios = res.data;
      });
    },

    abrirDialogExcluirFuncionario(funcionario) {
      this.dialog = true;
    }
  },
  computed: {}
};
</script>

<style lang="css" scoped>
</style>
