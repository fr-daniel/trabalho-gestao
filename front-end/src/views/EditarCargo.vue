<template>
  <v-app id="telaInicial">
    <AppToolbar></AppToolbar>

    <v-content>
      <v-container>
        <v-card>
          <v-card-text>
            <v-card-title class="headline">Editar Cargo</v-card-title>
            <v-container grid-list-md>
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
                    box
                    v-model="missaoCargo"
                    label="Missão"
                    value
                    append-icon="format_size"
                  ></v-textarea>
                  <v-textarea
                    box
                    v-model="experienciaMinima"
                    label="Experiência Mínima"
                    value
                    append-icon="assignment"
                  ></v-textarea>
                  <v-text-field flat v-model="area" label="Área" value append-icon="school"></v-text-field>
                  <v-text-field flat v-model="unidade" label="Unidade" value append-icon="group"></v-text-field>
                </v-flex>
                <v-layout row wrap>
                  <v-flex xs4>
                    <v-text-field
                      flat
                      v-model="salarioBaseMinimo"
                      label="Salário Base Mínimo"
                      value
                      append-icon="monetization_on"
                    ></v-text-field>
                  </v-flex>
                  <v-spacer></v-spacer>
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
              <v-divider class="mt-2 mb-2"></v-divider>

              <h5>
                <b>Atividades</b>
              </h5>

              <v-layout wrap>
                <v-flex xs12>
                  <v-text-field
                    flat
                    v-model="tituloAtividade"
                    label="Título"
                    value
                    append-icon="title"
                  ></v-text-field>
                  <v-textarea
                    box
                    v-model="descricaoAtividade"
                    label="Descrição"
                    value
                    append-icon="description"
                  ></v-textarea>
                </v-flex>
              </v-layout>

              <v-divider class="mt-2 mb-2"></v-divider>

              <h5>
                <b>Conhecimentos</b>
              </h5>

              <!-- auto-grow rows="1" -->

              <v-layout wrap>
                <v-flex xs12>
                  <v-text-field
                    flat
                    v-model="tituloAtividade"
                    label="Título"
                    value
                    append-icon="title"
                  ></v-text-field>
                  <v-textarea
                    box
                    v-model="descricaoConhecimento"
                    label="Descrição"
                    value
                    append-icon="description"
                  ></v-textarea>
                  <v-flex xs12 sm4 d-flex>
                    <v-select
                      :items="niveisConhecimento"
                      label="Nível do Conhecimento"
                      prepend-inner-icon="dehaze"
                    ></v-select>
                  </v-flex>
                </v-flex>
              </v-layout>

              <v-divider class="mt-2 mb-2"></v-divider>

              <h5>
                <b>Treinamentos</b>
              </h5>

              <v-layout wrap>
                <v-flex xs12 sm4 d-flex>
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

              <v-divider class="mt-2 mb-2"></v-divider>

              <h5>
                <b>Benefícios</b>
              </h5>

              <v-layout wrap>
                <v-flex xs12 sm4 d-flex>
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
          </v-card-text>
          <v-card-actions class="justify-center">
            <v-btn class="ma-2" tile color="#F7685B" :to="{name: 'ListarCargos'}">
              <span class="white--text">Cancelar</span>
            </v-btn>

            <v-btn class="ma-2" tile color="#109CF1">
              <span class="white--text">Salvar</span>
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-container>
    </v-content>
  </v-app>
</template>

<script>
import axios from "axios";
import AppToolbar from "../components/core/AppToolbar";

export default {
  components: { AppToolbar },
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
      descricaoConhecimento: "",
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
