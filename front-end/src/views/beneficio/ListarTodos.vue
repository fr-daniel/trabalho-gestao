<template>
  <v-app id="telaInicial">
    <v-container grid-list-xl fluid>
      <v-layout row wrap>
        <v-flex xs12>
          <v-card>
            <v-container>
              <v-toolbar flat color="white">
                <CadastrarBeneficio @cadastrou-beneficio="atualizarTable"></CadastrarBeneficio>
              </v-toolbar>
              <v-card-title>
                <h3>
                  <b>Benefícios</b>
                </h3>

                <v-spacer></v-spacer>

                <v-text-field
                  v-model="search"
                  append-icon="search"
                  label="Buscar Benefício"
                  single-line
                  hide-details
                ></v-text-field>
              </v-card-title>
              <v-data-table
                :headers="headers"
                :items="beneficios"
                :search="search"
                class="elevation-1"
              >
                <template v-slot:items="props">
                  <td class="justify-center">{{ props.item.id }}</td>
                  <td class="justify-center">{{ props.item.titulo }}</td>
                  <td class="justify-center">R$ {{ props.item.valor }}, 00</td>
                  <td class="justify-center">
                    <v-dialog v-model="editarBeneficio" persistent max-width="800">
                      <template #activator="{ on: editarBeneficio  }">
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
                              v-on="{ ...tooltip, ...editarBeneficio }"
                              @click="beneficioEditar(props.item.id)"
                            >
                              <v-icon small>edit</v-icon>
                            </v-btn>
                          </template>
                          <span>Editar</span>
                        </v-tooltip>
                      </template>

                      <v-card>
                        <v-card-text>
                          <v-card-title class="headline black white--text">Editar Benefício</v-card-title>
                          <v-container grid-list-md>
                            <v-layout wrap>
                              <v-flex xs12>
                                <v-text-field
                                  flat
                                  label="Título"
                                  value
                                  append-icon="title"
                                  v-model="beneficio.titulo"
                                ></v-text-field>
                              </v-flex>
                              <v-flex xs12>
                                <v-textarea
                                  label="Informações"
                                  value
                                  append-icon="description"
                                  v-model="beneficio.informacoes"
                                ></v-textarea>
                              </v-flex>
                              <v-flex xs4 d-flex>
                                <v-text-field
                                  flat
                                  label="Valor"
                                  value
                                  append-icon="attach_money"
                                  v-model="beneficio.valor"
                                ></v-text-field>
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
                          <v-btn class="ma-2" tile color="#F7685B" @click="editarBeneficio = false">
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
                          @click="abrirDialogExcluirBeneficio(props.item)"
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
                          :to="{name: 'DetalhesBeneficio'}"
                        >
                          <v-icon small>view_list</v-icon>
                        </v-btn>
                      </template>
                      <span>Ver mais</span>
                    </v-tooltip>
                  </td>
                </template>
              </v-data-table>
            </v-container>
          </v-card>
        </v-flex>
      </v-layout>

      <v-snackbar :color="dCor" right top v-model="dSnackbar">{{ dMensagem }}</v-snackbar>

      <v-dialog max-width="290" v-model="dialog">
        <v-card>
          <v-card-title class="headline">Excluir Benefício</v-card-title>

          <v-card-text>Tem certeza que deseja excluir o benefício?</v-card-text>

          <v-card-actions>
            <v-spacer></v-spacer>

            <v-btn @click="dialog = false" color="silver darken-1" flat="flat">Não</v-btn>

            <v-btn @click="excluirBeneficio()" color="red darken-1" flat="flat">Sim</v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
    </v-container>
  </v-app>
</template>


<script>
import axios from "axios";
import CadastrarBeneficio from "../beneficio/CadastrarBeneficio";

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

  components: { CadastrarBeneficio },
  data() {
    return {
      dialog: false,
      right: null,
      expand: false,
      search: "",
      pagination: {},
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
          text: "Valor",
          align: "left",
          sortable: false,
          value: "valor"
        },
        { text: "Opções", sortable: false, value: "opcoes" }
      ],
      beneficios: [],
      beneficioDelete: null,
      editarBeneficio: false,
      dSnackbar: false,
      dMensagem: "",
      dCor: "",
      beneficio: {
        titulo: "",
        informacoes: "",
        valor: ""
      },
      dados: "",
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
    initialize() {
      axios.get("beneficio/listar").then(res => {
        this.beneficios = res.data;
      });
    },

    atualizarTable(beneficio) {
      this.beneficios.push(beneficio);
    },

    excluirBeneficio() {
      axios
        .delete("/beneficio/excluir/" + this.beneficioDelete.id)
        .then(() => {
          this.beneficios.splice(
            this.beneficios.indexOf(this.beneficioDelete),
            1
          );
          this.beneficioDelete = null;

          this.dSnackbar = true;
          this.dMensagem = "Benefício excluído com sucesso";
          this.dCor = "success";
        })
        .catch(error => {
          this.dSnackbar = true;
          this.dMensagem = "Ocorreu um erro ao excluir o benefício!";
          this.dCor = "error";
        });

      this.dialog = false;
    },

    abrirDialogExcluirBeneficio(beneficio) {
      this.beneficioDelete = beneficio;
      this.dialog = true;
    },

    beneficioEditar(id) {
      axios.get("/beneficio/listar/" + id).then(res => {
        this.dados = res.data;
        console.log(this.dados.id);
        this.beneficio.titulo = this.dados.titulo;
        this.beneficio.informacoes = this.dados.informacoes;
        this.beneficio.valor = this.dados.valor;
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
