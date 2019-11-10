<template>
  <v-layout row justify-center>
    <v-spacer></v-spacer>
    <v-dialog v-model="addCargo" persistent max-width="1000">
      <template #activator="{ on: addCargo  }">
        <v-btn class="ma-2" tile color="#2ED47A" v-on="{ ...addCargo }">
          <span class="white--text">
            <v-icon left>add</v-icon>Adicionar Novo Cargo
          </span>
        </v-btn>
      </template>

      <v-card>
        <v-card-text>
          <v-card-title class="headline">Cadastrar Cargo</v-card-title>
          <v-container grid-list-md>
            <v-layout wrap>
              <v-flex xs12>
                <v-text-field
                  flat
                  v-model="titulo"
                  label="Título do Cargo"
                  value
                  append-icon="title"
                ></v-text-field>
                <v-textarea
                  auto-grow
                  rows="1"
                  v-model="missao"
                  label="Missão"
                  value
                  append-icon="format_size"
                ></v-textarea>
                <v-textarea
                  auto-grow
                  rows="1"
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
          </v-container>
        </v-card-text>
        <v-card-actions class="justify-center">
          <v-btn class="ma-2" tile color="#F7685B" @click="addCargo = false">
            <span class="white--text">Cancelar</span>
          </v-btn>

          <v-btn class="ma-2" tile color="#109CF1">
            <span class="white--text">Salvar</span>
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-layout>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      hidden: false,
      addCargo: false,
      titulo: "",
      missao: "",
      experienciaMinima: "",
      area: "",
      unidade: "",
      salarioBaseMinimo: 0,
      salarioBaseMaximo: 0
    };
  },

  computed: {},
  methods: {}
};
</script>

<style>
</style>
