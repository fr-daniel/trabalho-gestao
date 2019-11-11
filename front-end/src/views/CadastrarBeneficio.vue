<template>
  <v-layout row justify-center>
    <v-spacer></v-spacer>
    <v-dialog v-model="addBeneficio" persistent max-width="800">
      <template #activator="{ on: addBeneficio  }">
        <v-btn class="ma-2" tile color="#2ED47A" v-on="{ ...addBeneficio }">
          <span class="white--text">
            <v-icon left>add</v-icon>Adicionar Novo Benefício
          </span>
        </v-btn>
      </template>

      <v-card>
        <v-card-text>
          <v-card-title class="headline">Cadastrar Benefício</v-card-title>
          <v-container grid-list-md>
            <v-layout wrap>
              <v-flex xs12>
                <v-text-field flat v-model="titulo" label="Título" value append-icon="title"></v-text-field>
                <v-textarea
                  v-model="informacoes"
                  label="Informações"
                  value
                  append-icon="description"
                ></v-textarea>
                <v-flex xs12 sm4 d-flex>
                  <v-text-field
                    flat
                    v-model="valor"
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
          <v-btn
            class="ma-2"
            tile
            color="#F7685B"
            @click="addBeneficio = false"
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
  </v-layout>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      hidden: false,
      addBeneficio: false,
      titulo: "",
      iformacoes: "",
      valor: 0
    };
  },

  computed: {},
  methods: {
    limpar() {
      this.titulo = "", this.informacoes = "", this.valor = 0;
    }
  }
};
</script>

<style>
</style>
