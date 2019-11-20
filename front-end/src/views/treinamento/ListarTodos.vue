<template>
  <v-app id="telaInicial">
    <v-container grid-list-xl fluid>
      <v-layout row wrap>
        <v-flex xs12>
          <v-card>
            <v-container>
              <div>
                <v-toolbar flat color="white">
                  <CadastrarTreinamento @cadastrou-treinamento="atualizarTable"></CadastrarTreinamento>
                </v-toolbar>
                <v-data-table
                  :headers="headers"
                  :items="treinamentos"
                  :search="search"
                  class="elevation-1"
                >
                  <template v-slot:items="props">
                    <td class="justify-center">{{ props.item.id }}</td>
                    <td class="justify-center">{{ props.item.titulo }}</td>
                    <td
                      class="justify-center"
                    >{{ getLabelClassificaoTreinamento(props.item.classificacao) }}</td>
                    <td class="justify-center">
                      <v-dialog v-model="editarTreinamento" persistent max-width="800">
                        <template #activator="{ on: editarTreinamento  }">
                          <v-tooltip bottom>
                            <template #activator="{ on: tooltip }">
                              <v-btn
                                class="ma-2"
                                tile
                                depressed
                                dark
                                icon
                                color="#192A3E"
                                small
                                v-on="{ ...tooltip, ...editarTreinamento }"
                                @click="editarTreinamento=true"
                              >
                                <v-icon small>edit</v-icon>
                              </v-btn>
                            </template>
                            <span>Editar</span>
                          </v-tooltip>
                        </template>

                        <v-card>
                          <v-card-text>
                            <v-card-title class="headline black white--text">Editar Treinamento</v-card-title>
                            <v-container grid-list-md>
                              <v-layout wrap>
                                <v-flex xs12>
                                  <v-text-field
                                    flat
                                    label="Título"
                                    value
                                    append-icon="title"
                                  ></v-text-field>
                                  <v-flex xs12 sm6 d-flex>
                                    <v-select
                                      item-text="text"
                                      item-value="value"
                                      label="Classificação do Treinamento"
                                    ></v-select>
                                  </v-flex>
                                </v-flex>
                              </v-layout>
                            </v-container>
                          </v-card-text>
                          <v-card-actions class="justify-center">
                            <v-btn
                              class="ma-2"
                              tile
                              color="#F7685B"
                              @click="editarTreinamento = false"
                              v-on:click="limpar()"
                            >
                              <span class="white--text">Cancelar</span>
                            </v-btn>

                            <v-btn class="ma-2" tile color="#109CF1">
                              <span class="white--text">Salvar</span>
                            </v-btn>
                          </v-card-actions>
                        </v-card>
                      </v-dialog>

                      <v-tooltip bottom>
                        <template #activator="{ on: tooltip }">
                          <v-btn
                            @click="abrirDialogExcluirTreinamento(props.item)"
                            class="ma-2"
                            tile
                            depressed
                            dark
                            icon
                            color="#F7685B"
                            small
                            v-on="{ ...tooltip }"
                          >
                            <v-icon small>delete</v-icon>
                          </v-btn>
                        </template>
                        <span>Remover</span>
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
          <v-card-title class="headline">Excluir Treinamento</v-card-title>

          <v-card-text>Tem certeza que deseja excluir o treinamento?</v-card-text>

          <v-card-actions>
            <v-spacer></v-spacer>

            <v-btn @click="dialog = false" color="silver darken-1" flat="flat">Não</v-btn>

            <v-btn @click="excluirTreinamento()" color="red darken-1" flat="flat">Sim</v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
    </v-container>
  </v-app>
</template>


<script>
import axios from "axios";
import CadastrarTreinamento from "../treinamento/CadastrarTreinamento";
import store from "@/store";

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

  components: { CadastrarTreinamento },
  data() {
    return {
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
          text: "Título",
          align: "left",
          sortable: false,
          value: "titulo"
        },
        {
          text: "Classificação",
          align: "left",
          sortable: false,
          value: "classificacao"
        },
        { text: "Opções", sortable: false, value: "opcoes" }
      ],
      editarTreinamento: false,
      treinamentos: [],
      dialog: false,
      treinamentoDelete: null,
      dSnackbar: false,
      dMensagem: "",
      dCor: ""
    };
  },
  created: function() {
    this.initialize();
  },
  methods: {
    getLabelClassificaoTreinamento(fase) {
      return store.getters["enums/getLabelClassificacaoTreinamento"](fase);
    },

    initialize() {
      axios.get("treinamento/listar").then(res => {
        this.treinamentos = res.data;
      });
    },

    atualizarTable(treinamento) {
      this.treinamentos.push(treinamento);
    },
    excluirTreinamento() {
      axios
        .delete("/treinamento/excluir/" + this.treinamentoDelete.id)
        .then(() => {
          this.treinamentos.splice(
            this.treinamentos.indexOf(this.treinamentoDelete),
            1
          );
          this.treinamentoDelete = null;

          this.dSnackbar = true;
          this.dMensagem = "Treinamento excluído com sucesso";
          this.dCor = "success";
        })
        .catch(error => {
          this.dSnackbar = true;
          this.dMensagem = "Ocorreu um erro ao excluir o treinamento!";
          this.dCor = "error";
        });

      this.dialog = false;
    },

    abrirDialogExcluirTreinamento(treinamento) {
      this.treinamentoDelete = treinamento;
      this.dialog = true;
    }
  },
  computed: {}
};
</script>

<style lang="css" scoped>
</style>
