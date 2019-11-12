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
          <v-card-title class="headline black white--text">Cadastrar Benefício</v-card-title>
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

          <v-btn class="ma-2" tile color="#109CF1" @click="submit">
            <span class="white--text">Salvar</span>
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-layout>
</template>

<script>
import Vue from "vue";
import axios from "axios";
import VeeValidate from "vee-validate";

Vue.use(VeeValidate);

export default {
  data() {
    return {
      hidden: false,
      addBeneficio: false,
      titulo: "",
      informacoes: "",
      valor: 0,
      dictionary: {},
      snackbar: false,
      cor: "",
      mensagem: ""
    };
  },
  mounted() {
    this.$validator.localize("pt", this.dictionary);
  },
  computed: {},
  methods: {
    submit() {
      this.$validator.validateAll().then(result => {
        if (result) {
          axios
            .post("/beneficio", {
              titulo: this.titulo,
              informacoes: this.informacoes,
              valor: this.valor
            })
            .then(res => {
              this.$emit("cadastrou-beneficio", res.data);
              this.limpar();
              this.addBeneficio = false;
            })
            .catch(() => {
              this.mensagem = "Ocorreu um erro ao cadastrar o benefício.";
              this.cor = "error";
              this.snackbar = true;
            });
        } else {
          this.mensagem = "O formulário contém erros!";
          this.cor = "error";
          this.snackbar = true;
        }
      });
    },
    limpar() {
      this.titulo = "", this.informacoes = "", this.valor = 0;
    }
  }
};
</script>

<style>
</style>
