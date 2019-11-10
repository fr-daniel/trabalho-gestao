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
                    auto-grow
                    rows="1"
                    box
                    v-model="missaoCargo"
                    label="Missão"
                    value
                    append-icon="format_size"
                  ></v-textarea>
                  <v-textarea
                    auto-grow
                    rows="1"
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

              <h5>
                <b>Atividade</b>
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
                    auto-grow
                    rows="1"
                    box
                    v-model="descricaoAtividade"
                    label="Descrição"
                    value
                    append-icon="description"
                  ></v-textarea>
                </v-flex>
              </v-layout>

              <h5>
                <b>Conhecimento</b>
              </h5>

              <v-layout wrap>
                <v-flex xs12>
                  <v-textarea
                    auto-grow
                    rows="1"
                    box
                    v-model="descricaoConhecimento"
                    label="Descrição"
                    value
                    append-icon="description"
                  ></v-textarea>
                  <v-flex xs12 sm4 d-flex>
                    <v-select
                      :items="niveisConhecimento"
                      box
                      label="Nível do Conhecimento"
                      prepend-inner-icon="dehaze"
                    ></v-select>
                  </v-flex>
                </v-flex>
              </v-layout>

              <h5>
                <b>Treinamento</b>
              </h5>

              <v-layout wrap>
                <v-flex xs12>
                  <v-textarea
                    auto-grow
                    rows="1"
                    box
                    v-model="descricaoTreinamento"
                    label="Descrição"
                    value
                    append-icon="description"
                  ></v-textarea>
                  <v-flex xs12 sm4 d-flex>
                    <v-select
                      :items="classificacoesTreinamento"
                      box
                      label="Classificação do Treinamento"
                      prepend-inner-icon="dehaze"
                    ></v-select>
                  </v-flex>
                </v-flex>
              </v-layout>

              <h5>
                <b>Benefício</b>
              </h5>

              <v-layout wrap>
                <v-flex xs12>
                  <v-text-field
                    flat
                    v-model="tituloBeneficio"
                    label="Título"
                    value
                    append-icon="title"
                  ></v-text-field>
                  <v-textarea
                    auto-grow
                    rows="1"
                    box
                    v-model="descricaoBeneficio"
                    label="Descrição"
                    value
                    append-icon="description"
                  ></v-textarea>
                  <v-flex xs4>
                    <v-text-field
                      flat
                      v-model="valorBeneficio"
                      label="Valor"
                      value
                      append-icon="monetization_on"
                    ></v-text-field>
                  </v-flex>
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
      descricaoConhecimento: "",
      niveisConhecimento: ["BÁSICO", "MÉDIO", "AVANÇADO"],
      descricaoTreinamento: "",
      classificacoesTreinamento: ["DESEJÁVEL", "REQUERIDO"],
      tituloBeneficio: "",
      descricaoBeneficio: "",
      valorBeneficio: 0
    };
  },

  computed: {},
  methods: {
    logout() {
      this.$router.push("/logout");
    }
  }
};
</script>

<style>
</style>
