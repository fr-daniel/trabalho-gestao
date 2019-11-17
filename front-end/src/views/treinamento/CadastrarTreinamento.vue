<template>
  <v-layout row justify-center>
    <v-spacer></v-spacer>
    <v-dialog v-model="addTreinamento" persistent max-width="800">
      <template #activator="{ on: addTreinamento  }">
        <v-btn class="ma-2" tile color="#2ED47A" v-on="{ ...addTreinamento }">
          <span class="white--text">
            <v-icon left>add</v-icon>Adicionar Treinamento
          </span>
        </v-btn>
      </template>

      <v-card>
        <v-card-text>
          <v-card-title class="headline black white--text">Cadastrar Treinamento</v-card-title>
          <v-container grid-list-md>
            <v-layout wrap>
              <v-flex xs12>
                <v-text-field flat v-model="titulo" label="Título" value append-icon="title"></v-text-field>
                <v-flex xs12 sm6 d-flex>
                  <v-select
                    :items="classificacoes"
                    v-model="classificacao"
                    item-text="text"
                    item-value="value"
                    label="Classificação do Treinamento"
                  ></v-select>
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
            @click="addTreinamento = false"
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
    <v-snackbar :color="dCor" right top v-model="dSnackbar">{{ dMensagem }}</v-snackbar>
  </v-layout>
</template>

<script>
import Vue from "vue";
import axios from "axios";
import VeeValidate from "vee-validate";

Vue.use(VeeValidate);

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
  data() {
    return {
      hidden: false,
      addTreinamento: false,
      titulo: "",
      classificacao: "",
      classificacoes: [
        { text: "Desejável", value: "DESEJAVEL" },
        { text: "Requerido", value: "REQUERIDO" }
      ],
      dictionary: {},
      dSnackbar: false,
      dMensagem: "",
      dCor: ""
    };
  },
  mounted() {
    this.$validator.localize("pt", this.dictionary);
  },
  methods: {
    submit() {
      this.$validator.validateAll().then(result => {
        if (result) {
          axios
            .post("/treinamento", {
              titulo: this.titulo,
              classificacao: this.classificacao
            })
            .then(res => {
              this.$emit("cadastrou-treinamento", res.data);
              this.limpar();
              this.addTreinamento = false;
              this.dSnackbar = true;
              this.dMensagem = "Treinamento cadastrado com sucesso";
              this.dCor = "success";
            })
            .catch(() => {
              this.dMensagem = "Ocorreu um erro ao cadastrar o treinamento.";
              this.dCor = "error";
              this.dSnackbar = true;
            });
        } else {
          this.dMensagem = "O formulário contém erros!";
          this.dCor = "error";
          this.dSnackbar = true;
        }
      });
      // this.limpar();
    },

    limpar() {
      this.titulo = "";
      this.classificacao = "";
    }
  }
};
</script>

<style>
</style>
