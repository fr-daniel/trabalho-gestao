<template>
  <v-layout row justify-center>
    <v-spacer></v-spacer>
    <v-dialog v-model="addFuncionario" persistent max-width="800">
      <template #activator="{ on: addFuncionario  }">
        <v-btn class="botao" tile color="#109CF1" v-on="{ ...addFuncionario }">
          <span class="white--text">
            <v-icon left>add</v-icon>Adicionar Funcionário
          </span>
        </v-btn>
      </template>

      <v-card>
        <v-card-text>
          <v-card-title class="headline black white--text">Cadastrar Funcionário</v-card-title>
          <v-container grid-list-md>
            <v-layout wrap>
              <v-flex xs8>
                <v-text-field flat v-model="nome" label="Nome" value append-icon="person"></v-text-field>
              </v-flex>
              <v-flex xs4>
                <v-text-field
                  flat
                  v-model="formacaoAcademica"
                  label="Formação Acadêmica"
                  value
                  append-icon="school"
                ></v-text-field>
              </v-flex>
              <v-layout row wrap>
                <v-flex xs4>
                  <v-text-field
                    flat
                    v-model="dataNascimento"
                    label="Data de Nascimento"
                    value
                    append-icon="event"
                  ></v-text-field>
                </v-flex>
                <v-flex xs4>
                  <v-select
                    :items="estadosCivis"
                    v-model="estadoCivil"
                    item-text="text"
                    item-value="value"
                    label="Estado Civil"
                  ></v-select>
                </v-flex>
                <v-flex xs4>
                  <v-select
                    :items="sexos"
                    v-model="sexo"
                    item-text="text"
                    item-value="value"
                    label="Sexo"
                  ></v-select>
                </v-flex>
                <v-flex xs4>
                  <v-text-field flat v-model="cpf" label="CPF" value append-icon="assignment_ind"></v-text-field>
                </v-flex>
                <v-flex xs4>
                  <v-text-field flat v-model="rg" label="RG" value append-icon="assignment_ind"></v-text-field>
                </v-flex>
                <v-flex xs4>
                  <v-text-field flat v-model="nis" label="NIS" value append-icon="assignment_ind"></v-text-field>
                </v-flex>
                <v-flex xs8>
                  <v-text-field flat v-model="email" label="Email" value append-icon="mail"></v-text-field>
                </v-flex>
                <v-flex xs4>
                  <v-text-field flat v-model="telefone" label="Telefone" value append-icon="phone"></v-text-field>
                </v-flex>
                <v-flex xs4 d-flex>
                  <v-select
                    :items="cargos"
                    v-model="cargoSelecionado"
                    item-text="cargos.titulacao"
                    item-value="cargos.titulacao"
                    label="Cargo"
                    return-object
                  ></v-select>
                </v-flex>
                <v-flex xs4>
                  <v-text-field
                    flat
                    v-model="salario.salarioBase"
                    label="Salário Base"
                    append-icon="attach_money"
                  ></v-text-field>
                </v-flex>
                <v-flex xs4>
                  <v-text-field
                    flat
                    v-model="salario.cargaHoraria"
                    label="Carga Horária"
                    append-icon="access_time"
                  ></v-text-field>
                </v-flex>
              </v-layout>
            </v-layout>
          </v-container>
        </v-card-text>
        <v-card-actions class="justify-center">
          <v-btn class="ma-2" tile color="#F7685B" @click="addFuncionario = false, limpar()">
            <span class="white--text">Cancelar</span>
          </v-btn>

          <v-btn class="ma-2" tile color="#2ED47A" @click="submit">
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
import download from "downloadjs";

Vue.use(VeeValidate);

export default {
  data() {
    return {
      hidden: false,
      addFuncionario: false,
      nome: "",
      email: "",
      telefone: "",
      dataNascimento: "",
      estadoCivil: "",
      sexo: "",
      cpf: "",
      rg: "",
      nis: "",
      formacaoAcademica: "",
      salario: {
        salarioBase: "",
        cargaHoraria: ""
      },
      estadosCivis: [
        { text: "Solteiro", value: "SOLTEIRO" },
        { text: "Casado", value: "CASADO" },
        { text: "Divorciado", value: "DIVORCIADO" },
        { text: "Viúvo", value: "VIUVO" }
      ],
      sexos: [
        { text: "Masculino", value: "MASCULINO" },
        { text: "Feminino", value: "FEMININO" }
      ],
      dictionary: {},
      snackbar: false,
      cor: "",
      mensagem: "",
      cargos: [],
      cargoSelecionado: []
    };
  },
  mounted() {
    this.$validator.localize("pt", this.dictionary);
    this.listarCargos();
  },
  methods: {
    listarCargos() {
      axios
        .get("cargo/listar", {})
        .then(response => {
          this.cargos = response.data;
        })
        .catch(error => console.log(error));
    },
    submit() {
      this.$validator.validateAll().then(result => {
        if (result) {
          axios
            .post("/funcionario", {
              nome: this.nome,
              email: this.email,
              telefone: this.telefone,
              //dataNascimento: this.dataNascimento,
              estadoCivil: this.estadoCivil,
              sexo: this.sexo,
              cpf: this.cpf,
              rg: this.rg,
              nis: this.nis,
              formacaoAcademica: this.formacaoAcademica,
              salario: {
                salarioBase: this.salario.salarioBase,
                cargaHoraria: this.salario.cargaHoraria
              }
            })
            .then(res => {
              this.$emit("cadastrou-funcionario", res.data);
              this.limpar();
              this.addFuncionario = false;
            })
            .catch(() => {
              this.mensagem = "Ocorreu um erro ao cadastrar o funcionário.";
              this.cor = "error";
              this.snackbar = true;
            });
        } else {
          this.mensagem = "O formulário contém erros!";
          this.cor = "error";
          this.snackbar = true;
        }
      });
      // this.limpar();
    },

    limpar() {
      (this.nome = ""),
        (this.email = ""),
        (this.telefone = ""),
        (this.dataNascimento = ""),
        (this.estadoCivil = ""),
        (this.sexo = ""),
        (this.cpf = ""),
        (this.rg = ""),
        (this.nis = ""),
        (this.formacaoAcademica = ""),
        (this.salarioBase = ""),
        (this.cargaHoraria = ""),
        (this.cargoSelecionado = "");
    }
  }
};
</script>

<style>
.botao {
  max-width: 250px;
}
</style>
