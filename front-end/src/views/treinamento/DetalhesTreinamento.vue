<template>
  <v-app id="telaInicial">
    <v-container grid-list-xl fluid>
      <v-layout row wrap>
        <v-flex xs12>
          <v-card>
            <v-card-title class="headline black white--text">
              Dados do Treinamento
              <v-spacer></v-spacer>

              <v-btn icon color="white" outline @click="$router.push('/treinamento/listar')">
                <v-icon>arrow_back</v-icon>
              </v-btn>

              <h5>VOLTAR</h5>
            </v-card-title>

            <div>
              <v-flex xs10 offset-xs1>
                <template>
                  <v-flex xs12 class="text-xs-left">
                    <v-layout row wrap>
                      <v-flex xs8>
                        <h5>
                          <b>Título</b>
                        </h5>Administrador de Redes Sociais E-commerce
                      </v-flex>
                      <v-flex xs4>
                        <h5>
                          <b>Classificação</b>
                        </h5>Desejável
                      </v-flex>
                      <v-flex xs12>
                        <h5>
                          <b>Informações</b>
                        </h5>Somos uma nova concessionária de scooters e patinetes 100% elétricas, Estamos a procura de um profissional que possa desenvolver uma parceria duradoura para abrirmos o mercado e expandir para todo o território nacional. Nossa marca é a no.1 na China, por i (...)
                      </v-flex>
                      <v-flex xs12>
                        <h5>
                          <b>Cargos que Utilizam o Treinamento</b>
                        </h5>Somos uma nova concessionária de scooters e patinetes 100% elétricas, Estamos a procura de um profissional que possa desenvolver uma parceria duradoura para abrirmos o mercado e expandir para todo o território nacional. Nossa marca é a no.1 na China, por i (...)
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
