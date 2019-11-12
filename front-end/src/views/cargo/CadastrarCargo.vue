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
          <v-card-title class="headline black white--text">Cadastrar Cargo</v-card-title>
          <v-container grid-list-md>
            <v-layout wrap>
              <v-flex xs12>
                <v-text-field
                  flat
                  v-model="titulacao"
                  label="Título do Cargo"
                  value
                  append-icon="title"
                ></v-text-field>
                <v-textarea v-model="missao" label="Missão" value append-icon="format_size"></v-textarea>
                <v-textarea
                  v-model="experienciaMinima"
                  label="Experiência Mínima"
                  value
                  append-icon="assignment"
                ></v-textarea>
                <v-text-field flat v-model="area" label="Área" value append-icon="school"></v-text-field>
                <v-text-field flat v-model="unidade" label="Unidade" value append-icon="group"></v-text-field>
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
          </v-container>
        </v-card-text>
        <v-card-actions class="justify-center">
          <v-btn class="ma-2" tile color="#F7685B" @click="addCargo = false, limpar()">
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
      addCargo: false,
      titulacao: "",
      missao: "",
      experienciaMinima: "",
      area: "",
      unidade: "",
      salarioBaseMinimo: 0,
      salarioBaseMaximo: 0,
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
            .post("/cargo", {
              titulacao: this.titulacao,
              missao: this.missao,
              experienciaMinima: this.experienciaMinima,
              area: this.area,
              unidade: this.unidade,
              salarioBaseMinimo: this.salarioBaseMinimo,
              salarioBaseMaximo: this.salarioBaseMaximo
            })
            .then(res => {
              this.$emit("cadastrou-cargo", res.data);
              this.limpar();
              this.addCargo = false;
              this.dSnackbar = true;
              this.dMensagem = "Cargo cadastrado com sucesso";
              this.dCor = "success";
            })
            .catch(() => {
              this.dMensagem = "Ocorreu um erro ao cadastrar o cargo.";
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
      this.titulacao = "";
      this.missao = "";
      this.experienciaMinima = "";
      this.area = "";
      this.unidade = "";
      this.salarioBaseMinimo = 0;
      this.salarioBaseMaximo = 0;
    }
  }
};
</script>

<style>
</style>
