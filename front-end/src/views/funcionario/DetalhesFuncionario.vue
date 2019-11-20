<template>
  <v-app id="telaInicial">
    <v-container grid-list-xl fluid>
      <v-layout row wrap>
        <v-flex xs12>
          <v-card>
            <v-card-title class="headline black white--text">
              Dados do Funcionário
              <v-spacer></v-spacer>

              <v-btn icon color="white" outline @click="$router.push('/funcionario/listar')">
                <v-icon>arrow_back</v-icon>
              </v-btn>

              <h5>VOLTAR</h5>
            </v-card-title>

            <div>
              <v-flex xs10 offset-xs1>
                <template>
                  <v-flex xs12 class="text-xs-left">
                    <v-layout row wrap>
                      <v-flex xs4>
                        <h5>
                          <b>Nome</b>
                        </h5>Sabrina Cunha de Sousa
                      </v-flex>
                      <v-flex xs4>
                        <h5>
                          <b>Formação Acadêmica</b>
                        </h5>Sistemas de Informação
                      </v-flex>

                      <v-flex xs4>
                        <h5>
                          <b>Data de Nascimento</b>
                        </h5>30/05/1997
                      </v-flex>
                      <v-flex xs4>
                        <h5>
                          <b>Estado Civil</b>
                        </h5>Solteira
                      </v-flex>
                      <v-flex xs4>
                        <h5>
                          <b>Sexo</b>
                        </h5>Feminino
                      </v-flex>
                      <v-flex xs12>
                        <v-divider></v-divider>
                      </v-flex>

                      <v-flex xs12>
                        <h5>
                          <b>DOCUMENTOS</b>
                        </h5>
                      </v-flex>
                      <v-flex xs4>
                        <h5>
                          <b>CPF</b>
                        </h5>026.039.143-32
                      </v-flex>
                      <v-flex xs4>
                        <h5>
                          <b>RG</b>
                        </h5>026.039.143-32
                      </v-flex>
                      <v-flex xs4>
                        <h5>
                          <b>NIS</b>
                        </h5>026.039.143-32
                      </v-flex>

                      <v-flex xs12>
                        <v-divider></v-divider>
                      </v-flex>

                      <v-flex xs12>
                        <h5>
                          <b>CONTATOS</b>
                        </h5>
                      </v-flex>
                      <v-flex xs4>
                        <h5>
                          <b>Email</b>
                        </h5>sacunha73@gmail.com
                      </v-flex>
                      <v-flex xs4>
                        <h5>
                          <b>Telefone</b>
                        </h5>(88)99866-7009
                      </v-flex>

                      <v-flex xs12>
                        <v-divider></v-divider>
                      </v-flex>

                      <v-flex xs12>
                        <h5>
                          <b>DADOS COMPLEMENTARES</b>
                        </h5>
                      </v-flex>

                      <v-flex xs4>
                        <h5>
                          <b>Salário Base</b>
                        </h5>R$ 2.500,00
                      </v-flex>
                      <v-flex xs4>
                        <h5>
                          <b>Carga Horária</b>
                        </h5>40 horas semanais
                      </v-flex>
                    </v-layout>
                  </v-flex>
                  <br />
                </template>
              </v-flex>
            </div>
          </v-card>
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
      expand: false,
      search: "",
      funcionarios: []
    };
  },
  created: function() {
    this.initialize();
  },
  methods: {
    initialize() {
      axios.get("funcionario/listar").then(res => {
        this.funcionarios = res.data;
        console.log(this.funcionarios);
      });
    }
  },
  computed: {}
};
</script>

<style lang="css" scoped>
</style>
