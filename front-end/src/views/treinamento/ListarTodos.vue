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
                                <v-card-title>
                  <h3>
                    <b>Treinamento</b>
                  </h3>

                  <v-spacer></v-spacer>

                  <v-text-field
                    v-model="search"
                    append-icon="search"
                    label="Buscar Treinamento"
                    single-line
                    hide-details
                  ></v-text-field>
                </v-card-title>
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
                                @click="treinamentoEditar(props.item.id)"
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
                                    v-model="treinamento.titulo"
                                  ></v-text-field>
                                </v-flex>
                                <v-flex xs12>
                                  <v-textarea
                                    label="Informações"
                                    value
                                    append-icon="description"
                                    v-model="treinamento.informacoes"
                                  ></v-textarea>
                                </v-flex>
                                <v-flex xs4 d-flex>
                                  <v-select
                                    :items="classificacoes"
                                    item-text="text"
                                    item-value="value"
                                    label="Classificação do Treinamento"
                                    v-model="treinamento.classificacao"
                                  ></v-select>
                                </v-flex>
                                <v-flex xs8>
                                  <v-select
                                    v-model="cargoSelecionado"
                                    :items="cargos"
                                    label="Selecionar Cargos"
                                    multiple
                                  >
                                    <template v-slot:prepend-item>
                                      <v-list-tile ripple @click="toggle">
                                        <v-list-tile-action>
                                          <v-icon
                                            :color="cargoSelecionado.length > 0 ? 'indigo darken-4' : ''"
                                          >{{ icon }}</v-icon>
                                        </v-list-tile-action>
                                        <v-list-tile-content>
                                          <v-list-tile-title>Selecionar Tudo</v-list-tile-title>
                                        </v-list-tile-content>
                                      </v-list-tile>
                                      <v-divider class="mt-2"></v-divider>
                                    </template>
                                    <template v-slot:append-item></template>
                                  </v-select>
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
                      <v-tooltip bottom>
                        <template #activator="{ on: tooltip }">
                          <v-btn
                            class="ma-2"
                            tile
                            depressed
                            dark
                            icon
                            color="primary"
                            small
                            v-on="{ ...tooltip }"
                            :to="{name: 'DetalhesTreinamento'}"
                          >
                            <v-icon small>view_list</v-icon>
                          </v-btn>
                        </template>
                        <span>Ver mais</span>
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
      classificacoes: [
        { text: "Desejável", value: "DESEJAVEL" },
        { text: "Requerido", value: "REQUERIDO" }
      ],
      editarTreinamento: false,
      treinamentos: [],
      dialog: false,
      treinamentoDelete: null,
      dSnackbar: false,
      dMensagem: "",
      dCor: "",
      treinamento: {
        titulo: "",
        informacoes: "",
        classificacao: ""
      },
      y: "",
      cargos: [],
      cargoSelecionado: []
    };
  },
  created: function() {
    this.initialize();
    this.listarCargos();
  },
  computed: {
    likesAllFruit() {
      return this.cargoSelecionado.length === this.cargos.length;
    },
    likesSomeFruit() {
      return this.cargoSelecionado.length > 0 && !this.likesAllFruit;
    },
    icon() {
      if (this.likesAllFruit) return "mdi-close-box";
      if (this.likesSomeFruit) return "mdi-minus-box";
      return "mdi-checkbox-blank-outline";
    }
  },
  methods: {
    listarCargos() {
      axios.get("cargo/listar").then(res => {
        this.cargos = res.data;
      });
    },
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
    },

    treinamentoEditar(id) {
      axios.get("/treinamento/listar/" + id).then(res => {
        this.y = res.data;
        console.log(this.y.id);
        this.treinamento.titulo = this.y.titulo;
        this.treinamentos.informacoes = this.y.informacoes;
        this.treinamento.classificacao = this.y.classificacao;
      });
    },

    toggle() {
      this.$nextTick(() => {
        if (this.likesAllFruit) {
          this.cargoSelecionado = [];
        } else {
          this.cargoSelecionado = this.cargos.slice();
        }
      });
    }
  }
};
</script>

<style lang="css" scoped>
</style>
