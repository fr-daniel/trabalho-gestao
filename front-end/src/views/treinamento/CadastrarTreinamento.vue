<template>
  <v-layout row justify-center>
    <v-spacer></v-spacer>
    <v-dialog v-model="addTreinamento" persistent max-width="800">
      <template #activator="{ on: addTreinamento  }">
        <v-btn class="ma-2" tile color="#109CF1" v-on="{ ...addTreinamento }">
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
              </v-flex>
              <v-flex xs12>
                <v-textarea
                  v-model="informacoes"
                  label="Informações"
                  value
                  append-icon="description"
                ></v-textarea>
              </v-flex>
              <v-flex xs4 d-flex>
                <v-select
                  :items="classificacoes"
                  v-model="classificacao"
                  item-text="text"
                  item-value="value"
                  label="Classificação do Treinamento"
                ></v-select>
              </v-flex>
              <v-flex xs8 sd-flex>
                <v-select
                  v-model="cargoSelecionado"
                  :items="cargos"
                  label="Selecionar Cargos"
                  multiple
                >
                  <template v-slot:prepend-item>
                    <v-list-tile ripple @click="toggle">
                      <v-list-tile-action>
                        <v-icon
                          :color="cargoSelecionado.length > 0 ? 'indigo darken-4' : ''"
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
          <v-btn
            class="ma-2"
            tile
            color="#F7685B"
            @click="addTreinamento = false"
            v-on:click="limpar()"
          >
            <span class="white--text">Cancelar</span>
          </v-btn>

          <v-btn class="ma-2" tile color="#2ED47A" @click="submit">
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
      dCor: "",
      cargos: [],
      cargoSelecionado: []
    };
  },
  mounted() {
    this.$validator.localize("pt", this.dictionary);
  },
  created: function() {
    this.initialize();
  },
  computed: {
    likesAllFruit() {
      return this.cargoSelecionado.length === this.cargos.length;
    },
    likesSomeFruit() {
      return this.cargoSelecionado.length > 0 && !this.likesAllFruit;
    },
    icon() {
      if (this.likesAllFruit) return "mdi-close-box";
      if (this.likesSomeFruit) return "mdi-minus-box";
      return "mdi-checkbox-blank-outline";
    }
  },
  methods: {
    initialize() {
      axios.get("cargo/listar").then(res => {
        this.cargos = res.data;
      });
    },

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
    },

    toggle() {
      this.$nextTick(() => {
        if (this.likesAllFruit) {
          this.cargoSelecionado = [];
        } else {
          this.cargoSelecionado = this.cargos.slice();
        }
      });
    }
  }
};
</script>

<style>
</style>
