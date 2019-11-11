<template>
  <v-app id="telaInicial">
    <v-container grid-list-xl fluid>
      <v-layout row wrap justify-center>
        <v-flex xs12>
          <div id="app">
            <v-app id="inspire">
              <v-card>
                <v-card-title class="headline">Editar Cargo</v-card-title>
                <v-tabs centered icons-and-text :grow="true">
                  <v-tabs-slider color="blue"></v-tabs-slider>

                  <v-tab href="#tab-1">
                    CARGOS
                    <v-icon>pie_chart</v-icon>
                  </v-tab>

                  <v-tab href="#tab-2">
                    ATIVIDADES
                    <v-icon>show_chart</v-icon>
                  </v-tab>

                  <v-tab href="#tab-3">
                    CONHECIMENTOS
                    <v-icon>dns</v-icon>
                  </v-tab>

                  <v-tab href="#tab-4">
                    TREINAMENTOS
                    <v-icon>category</v-icon>
                  </v-tab>

                  <v-tab href="#tab-5">
                    BENEFÍCIOS
                    <v-icon>gavel</v-icon>
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
                      </v-container>
                    </div>
                  </v-tab-item>
                </v-tabs>

                <v-card-actions class="justify-center">
                  <v-btn class="ma-2" tile color="#F7685B" :to="{name: 'ListarCargos'}">
                    <span class="white--text">Cancelar</span>
                  </v-btn>

                  <v-btn class="ma-2" tile color="#109CF1">
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
      niveisConhecimento: ["BÁSICO", "MÉDIO", "AVANÇADO"],
      fruits: [
        "Apples",
        "Apricots",
        "Avocado",
        "Bananas",
        "Blueberries",
        "Blackberries"
      ],
      selectedFruits: []
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
