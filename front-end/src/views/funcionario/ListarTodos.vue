<template>
  <v-app id="telaInicial">
    <v-container grid-list-xl fluid>
      <v-layout row wrap>
        <v-flex xs12>
          <v-card>
            <v-container>
              <div>
                <v-toolbar flat color="white">

                  <CadastrarFuncionario @cadastrou-funcionario="atualizarTable"></CadastrarFuncionario>
                </v-toolbar>
                <v-data-table
                  :headers="headers"
                  :items="funcionarios"
                  :search="search"
                  hide-actions
                  :pagination.sync="pagination"
                  class="elevation-1"
                >
                  <template v-slot:items="props">
                    <td>
                      <v-checkbox :input-value="props.selected" primary hide-details></v-checkbox>
                    </td>
                    <td class="justify-center">{{ props.item.id }}</td>
                    <td class="justify-center">{{ props.item.nome }}</td>
                    <td class="justify-center">{{ props.item.cpf }}</td>
                    <td class="justify-center">{{ props.item.telefone   }}</td>
                    <td class="justify-center">{{ props.item.formacaoAcademica }}</td>
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
                      >
                        <v-icon small>edit</v-icon>
                      </v-btn>
                      <v-btn class="ma-2" tile depressed dark icon color="#F7685B" small>
                        <v-icon small>delete</v-icon>
                      </v-btn>
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
          <v-card-title class="headline">Excluir Funcionário</v-card-title>

          <v-card-text>Tem certeza que deseja excluir o funcionário?</v-card-text>

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
import CadastrarFuncionario from "../funcionario/CadastrarFuncionario";

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
  components: { CadastrarFuncionario },
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
          value: "selecionarFuncionario"
        },
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
          text: "CPF",
          sortable: false,
          value: "cpf"
        },
        {
          text: "Telefone",
          sortable: false,
          value: "telefone"
        },
        { text: "Formação Acadêmica", sortable: false, value: "formacaoAcademica" },
        { text: "Salário", sortable: false, value: "salario" },
        { text: "Opções", sortable: false, value: "opcoes" }
      ],
      funcionarios: [],
      dialog: false,
      funcionarioDelete: null,
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
      axios.get("funcionario/listar").then(res => {
        this.funcionarios = res.data;
      });
    },

    atualizarTable(funcionario) {
      this.funcionarios.push(funcionario);
    },
    excluirFuncionario() {
      axios
        .delete("/funcionario/excluir/" + this.funcionarioDelete.id)
        .then(() => {
          this.funcionarios.splice(
            this.funcionarios.indexOf(this.funcionarioDelete),
            1
          );
          this.funcionarioDelete = null;

          this.dSnackbar = true;
          this.dMensagem = "Funcionário excluído com sucesso";
          this.dCor = "success";
        })
        .catch(error => {
          this.dSnackbar = true;
          this.dMensagem = "Ocorreu um erro ao excluir o funcionário!";
          this.dCor = "error";
        });

      this.dialog = false;
    },

    abrirDialogExcluirFuncionario(funcionario) {
      this.funcionarioDelete = funcionario;
      this.dialog = true;
    }
  },
  computed: {}
};
</script>

<style lang="css" scoped>
</style>
