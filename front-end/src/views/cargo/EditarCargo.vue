<template>
  <v-app id="telaInicial">
    <v-container grid-list-xl fluid>
      <v-layout row wrap justify-center>
        <v-flex xs12>
          <v-card-title class="headline black white--text">Editar Cargo</v-card-title>
          <div id="app">
            <v-app id="inspire">
              <v-card>
                <v-tabs centered icons-and-text :grow="true">
                  <v-tabs-slider color="blue"></v-tabs-slider>

                  <v-tab href="#tab-1">
                    CARGO
                    <v-icon>work</v-icon>
                  </v-tab>

                  <v-tab href="#tab-2">
                    ATIVIDADES
                    <v-icon>border_color</v-icon>
                  </v-tab>

                  <v-tab href="#tab-3">
                    CONHECIMENTOS
                    <v-icon>local_library</v-icon>
                  </v-tab>

                  <v-tab href="#tab-4">
                    TREINAMENTOS
                    <v-icon>assignment_turned_in</v-icon>
                  </v-tab>

                  <v-tab href="#tab-5">
                    BENEFÍCIOS
                    <v-icon>monetization_on</v-icon>
                  </v-tab>

                  <v-tab-item v-for="i in 5" :key="i" :value="'tab-' + i">
                    <div v-if="i == 1">
                      <v-container grid-list-md>
                        <v-layout row wrap>
                          <v-card-text>
                            <v-layout wrap>
                              <v-flex xs12>
                                <v-text-field
                                  flat
                                  v-model="tituloCargo"
                                  label="Título do Cargo"
                                  value
                                  append-icon="title"
                                ></v-text-field>
                                <v-textarea
                                  v-model="missaoCargo"
                                  label="Missão"
                                  value
                                  append-icon="format_size"
                                ></v-textarea>
                                <v-textarea
                                  v-model="experienciaMinima"
                                  label="Experiência Mínima"
                                  value
                                  append-icon="assignment"
                                ></v-textarea>
                                <v-text-field
                                  flat
                                  v-model="area"
                                  label="Área"
                                  value
                                  append-icon="school"
                                ></v-text-field>
                                <v-text-field
                                  flat
                                  v-model="unidade"
                                  label="Unidade"
                                  value
                                  append-icon="group"
                                ></v-text-field>
                              </v-flex>
                              <v-layout row wrap justify-center>
                                <v-flex xs4>
                                  <v-text-field
                                    flat
                                    v-model="salarioBaseMinimo"
                                    label="Salário Base Mínimo"
                                    value
                                    append-icon="monetization_on"
                                  ></v-text-field>
                                </v-flex>

                                <v-flex xs4>
                                  <v-text-field
                                    flat
                                    v-model="salarioBaseMaximo"
                                    label="Salário Base Máximo"
                                    value
                                    append-icon="monetization_on"
                                  ></v-text-field>
                                </v-flex>
                              </v-layout>
                            </v-layout>
                          </v-card-text>
                        </v-layout>
                        <v-card-actions class="justify-center">
                          <v-btn class="ma-2" tile color="#F7685B" :to="{name: 'ListarCargos'}">
                            <span class="white--text">Cancelar</span>
                          </v-btn>

                          <v-btn class="ma-2" tile color="#109CF1">
                            <span class="white--text">Salvar</span>
                          </v-btn>
                        </v-card-actions>
                      </v-container>
                    </div>

                    <div v-if="i == 2">
                      <v-container grid-list-xl fluid>
                        <v-layout row wrap>
                          <v-flex xs12>
                            <v-text-field
                              flat
                              v-model="tituloAtividade"
                              label="Título"
                              value
                              append-icon="title"
                            ></v-text-field>
                            <v-textarea
                              v-model="descricaoAtividade"
                              label="Descrição"
                              value
                              append-icon="description"
                            ></v-textarea>
                          </v-flex>
                        </v-layout>
                        <v-layout>
                          <v-spacer></v-spacer>
                          <v-card-actions>
                            <v-btn class="ma-2" tile color="#109CF1">
                              <span class="white--text">Salvar</span>
                            </v-btn>
                          </v-card-actions>
                        </v-layout>

                        <v-data-table
                          :headers="headersAtividades"
                          :items="desserts1"
                          :search="search"
                          hide-actions
                          class="elevation-1"
                        >
                          <template v-slot:items="props">
                            <td>
                              <v-checkbox :input-value="props.selected" primary hide-details></v-checkbox>
                            </td>
                            <td class="justify-center">{{ props.item.titulo }}</td>
                            <td class="justify-center">{{ props.item.descricao }}</td>
                            <td class="justify-center">
                              <v-btn class="ma-2" tile depressed dark icon color="#F7685B" small>
                                <v-icon small>delete</v-icon>
                              </v-btn>
                            </td>
                          </template>
                        </v-data-table>
                      </v-container>
                    </div>

                    <div v-if="i == 3">
                      <v-container grid-list-xl fluid>
                        <v-layout row wrap>
                          <v-flex xs12>
                            <v-text-field
                              flat
                              v-model="tituloConhecimento"
                              label="Título"
                              value
                              append-icon="title"
                            ></v-text-field>
                          </v-flex>
                          <v-flex xs12 sm4 d-flex>
                            <v-select
                              :items="niveisConhecimento"
                              label="Nível do Conhecimento"
                              prepend-inner-icon="dehaze"
                            ></v-select>
                          </v-flex>
                        </v-layout>
                        <v-layout>
                          <v-spacer></v-spacer>
                          <v-card-actions>
                            <v-btn class="ma-2" tile color="#109CF1">
                              <span class="white--text">Salvar</span>
                            </v-btn>
                          </v-card-actions>
                        </v-layout>

                        <v-data-table
                          :headers="headersConhecimentos"
                          :items="desserts2"
                          :search="search"
                          hide-actions
                          class="elevation-1"
                        >
                          <template v-slot:items="props">
                            <td>
                              <v-checkbox :input-value="props.selected" primary hide-details></v-checkbox>
                            </td>
                            <td class="justify-center">{{ props.item.titulo }}</td>
                            <td class="justify-center">{{ props.item.nivel }}</td>
                            <td class="justify-center">
                              <v-btn class="ma-2" tile depressed dark icon color="#F7685B" small>
                                <v-icon small>delete</v-icon>
                              </v-btn>
                            </td>
                          </template>
                        </v-data-table>
                      </v-container>
                    </div>

                    <div v-if="i == 4">
                      <v-container grid-list-xl fluid>
                        <v-layout row wrap>
                          <v-flex xs12 sm12 d-flex>
                            <v-select
                              v-model="selectedFruits"
                              :items="fruits"
                              label="Selecionar Treinamentos"
                              multiple
                            >
                              <template v-slot:prepend-item>
                                <v-list-tile ripple @click="toggle">
                                  <v-list-tile-action>
                                    <v-icon
                                      :color="selectedFruits.length > 0 ? 'indigo darken-4' : ''"
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
                        <v-layout>
                          <v-spacer></v-spacer>
                          <v-card-actions>
                            <v-btn class="ma-2" tile color="#109CF1">
                              <span class="white--text">Salvar</span>
                            </v-btn>
                          </v-card-actions>
                        </v-layout>
                      </v-container>
                    </div>

                    <div v-if="i === 5">
                      <v-container grid-list-xl fluid>
                        <v-layout row wrap>
                          <v-flex xs12 sm12 d-flex>
                            <v-select
                              v-model="selectedFruits"
                              :items="fruits"
                              label="Selecionar Benefícios"
                              multiple
                            >
                              <template v-slot:prepend-item>
                                <v-list-tile ripple @click="toggle">
                                  <v-list-tile-action>
                                    <v-icon
                                      :color="selectedFruits.length > 0 ? 'indigo darken-4' : ''"
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
                        <v-layout>
                          <v-spacer></v-spacer>
                          <v-card-actions>
                            <v-btn class="ma-2" tile color="#109CF1">
                              <span class="white--text">Salvar</span>
                            </v-btn>
                          </v-card-actions>
                        </v-layout>
                      </v-container>
                    </div>
                  </v-tab-item>
                </v-tabs>
              </v-card>
            </v-app>
          </div>
        </v-flex>
      </v-layout>
    </v-container>
  </v-app>
</template>

<script>
import axios from "axios";

export default {
  props: ["id"],
  data() {
    return {
      drawer: true,
      right: null,
      search: "",
      hidden: false,
      tituloCargo: "",
      missaoCargo: "",
      experienciaMinima: "",
      area: "",
      unidade: "",
      salarioBaseMinimo: 0,
      salarioBaseMaximo: 0,
      tituloAtividade: "",
      descricaoAtividade: "",
      tituloConhecimento: "",
      niveisConhecimento: [
        { text: "Básico", value: "BÁSICO" },
        { text: "Médio", value: "MÉDIO" },
        { text: "Avançado", value: "AVANÇADO" }
      ],
      fruits: [
        "Apples",
        "Apricots",
        "Avocado",
        "Bananas",
        "Blueberries",
        "Blackberries"
      ],
      selectedFruits: [],
      headersAtividades: [
        {
          text: "",
          align: "left",
          sortable: false,
          value: "selecionarAtividade"
        },
        {
          text: "Título",
          align: "left",
          sortable: true,
          value: true
        },
        {
          text: "Descrição",
          sortable: false,
          value: "descricao"
        },
        { text: "Opções", sortable: false, value: "opcoes" }
      ],
      desserts1: [
        {
          selecionarAtividade: "",
          titulo: "AAAAAAAAA",
          descricao: "12/11/2019"
        }
      ],
      headersConhecimentos: [
        {
          text: "",
          align: "left",
          sortable: false,
          value: "selecionarConhecimento"
        },
        {
          text: "Título",
          align: "left",
          sortable: true,
          value: true
        },
        {
          text: "Nível",
          sortable: false,
          value: "nivel"
        },
        { text: "Opções", sortable: false, value: "opcoes" }
      ],
      desserts2: [
        {
          selecionarConhecimento: "",
          titulo: "AAAAAAAAA",
          nivel: "Básico"
        }
      ]
    };
  },

  computed: {
    likesAllFruit() {
      return this.selectedFruits.length === this.fruits.length;
    },
    likesSomeFruit() {
      return this.selectedFruits.length > 0 && !this.likesAllFruit;
    },
    icon() {
      if (this.likesAllFruit) return "mdi-close-box";
      if (this.likesSomeFruit) return "mdi-minus-box";
      return "mdi-checkbox-blank-outline";
    }
  },
  methods: {
    initialize() {
      axios.get("/cargo/" + this.id).then(res => {
        this.titulo = res.data.titulo;
        this.localProva = res.data.localProva;
        this.numeroVagas = res.data.numeroVagas;
        this.descricao = res.data.descricao;
        this.inicioInscricoes = res.data.inicioInscricoes;
        this.terminoInscricoes = res.data.terminoInscricoes;
        this.dataHoraProva = res.data.dataHoraProva;
        this.dataResultado = res.data.dataResultado;
        this.inicioReavaliacao = res.data.inicioReavaliacao;
        this.terminoReavaliacao = res.data.terminoReavaliacao;
      });
    },
    toggle() {
      this.$nextTick(() => {
        if (this.likesAllFruit) {
          this.selectedFruits = [];
        } else {
          this.selectedFruits = this.fruits.slice();
        }
      });
    }
  }
};
</script>

<style>
</style>
