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
                    REMUNERAÇÃO
                    <v-icon>monetization_on</v-icon>
                  </v-tab>

                  <v-tab-item v-for="i in 4" :key="i" :value="'tab-' + i">
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
                            </v-layout>
                          </v-card-text>
                        </v-layout>
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
                            <v-btn class="ma-2" tile color="primary">
                              <span class="white--text">Adicionar</span>
                            </v-btn>
                          </v-card-actions>
                        </v-layout>
                        <v-card-title>
                          <h3>
                            <b>Atividades</b>
                          </h3>

                          <v-spacer></v-spacer>

                          <v-text-field
                            v-model="search"
                            append-icon="search"
                            label="Buscar Atividade"
                            single-line
                            hide-details
                          ></v-text-field>
                        </v-card-title>
                        <v-data-table
                          :headers="headersAtividades"
                          :items="desserts1"
                          :search="search"
                          hide-actions
                          class="elevation-1"
                        >
                          <template v-slot:items="props">
                            <td class="justify-center">{{ props.item.id }}</td>
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
                            <v-select :items="niveisConhecimento" label="Nível do Conhecimento"></v-select>
                          </v-flex>
                        </v-layout>
                        <v-layout>
                          <v-spacer></v-spacer>
                          <v-card-actions>
                            <v-btn class="ma-2" tile color="primary">
                              <span class="white--text">Adicionar</span>
                            </v-btn>
                          </v-card-actions>
                        </v-layout>
                        <v-card-title>
                          <h3>
                            <b>Conhecimentos</b>
                          </h3>

                          <v-spacer></v-spacer>

                          <v-text-field
                            v-model="search"
                            append-icon="search"
                            label="Buscar Conhecimento"
                            single-line
                            hide-details
                          ></v-text-field>
                        </v-card-title>
                        <v-data-table
                          :headers="headersConhecimentos"
                          :items="desserts2"
                          :search="search"
                          hide-actions
                          class="elevation-1"
                        >
                          <template v-slot:items="props">
                            <td class="justify-center">{{ props.item.id }}</td>
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

                    <div v-if="i === 4">
                      <v-container grid-list-xl fluid>
                        <v-layout row wrap>
                          <v-flex xs12>
                            <h5>
                              <b>Valor dos Benefícios</b>
                            </h5>R$ 500,00
                          </v-flex>
                          <v-layout row wrap justify-center>
                            <v-flex xs4>
                              <v-text-field
                                flat
                                v-model="salarioBaseMinimo"
                                label="Salário Base Mínimo"
                                value
                                append-icon="attach_money"
                              ></v-text-field>
                            </v-flex>

                            <v-flex xs4>
                              <v-text-field
                                flat
                                v-model="salarioBaseMaximo"
                                label="Salário Base Máximo"
                                value
                                append-icon="attach_money"
                              ></v-text-field>
                            </v-flex>
                          </v-layout>
                        </v-layout>
                      </v-container>
                    </div>
                  </v-tab-item>
                </v-tabs>
                <v-card-actions class="justify-center">
                  <v-btn class="ma-2" tile color="#F7685B" :to="{name: 'ListarCargos'}">
                    <span class="white--text">Cancelar</span>
                  </v-btn>

                  <v-btn class="ma-2" tile color="#2ED47A">
                    <span class="white--text">Salvar</span>
                  </v-btn>
                </v-card-actions>
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
      salarioBaseMinimo: "",
      salarioBaseMaximo: "",
      tituloAtividade: "",
      descricaoAtividade: "",
      tituloConhecimento: "",
      niveisConhecimento: [
        { text: "Básico", value: "BÁSICO" },
        { text: "Médio", value: "MÉDIO" },
        { text: "Avançado", value: "AVANÇADO" }
      ],
      headersAtividades: [
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
          id: "1",
          titulo: "AAAAAAAAA",
          descricao: "12/11/2019"
        }
      ],
      headersConhecimentos: [
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
          id: "1",
          titulo: "AAAAAAAAA",
          nivel: "Básico"
        }
      ]
    };
  },

  computed: {},
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
    }
  }
};
</script>

<style>
</style>
