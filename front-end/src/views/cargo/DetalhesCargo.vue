<template>
  <v-app id="telaInicial">
    <v-container grid-list-xl fluid>
      <v-layout row wrap>
        <v-flex xs12>
          <v-card>
            <v-card-title class="headline black white--text">
              Dados do Cargo
              <v-spacer></v-spacer>

              <v-btn icon color="white" outline @click="$router.push('/cargo/listar')">
                <v-icon>arrow_back</v-icon>
              </v-btn>

              <h5>VOLTAR</h5>
            </v-card-title>

            <div>
              <v-flex xs10 offset-xs1>
                <template>
                  <v-flex xs12 class="text-xs-left">
                    <v-layout row wrap>
                      <v-flex xs12>
                        <h5>
                          <b>Título do Cargo</b>
                        </h5>Administrador de Redes Sociais E-commerce
                      </v-flex>
                      <v-flex xs12>
                        <h5>
                          <b>Missão</b>
                        </h5>Somos uma nova concessionária de scooters e patinetes 100% elétricas, Estamos a procura de um profissional que possa desenvolver uma parceria duradoura para abrirmos o mercado e expandir para todo o território nacional. Nossa marca é a no.1 na China, por i (...)
                      </v-flex>

                      <v-flex xs4>
                        <h5>
                          <b>Experiência Mínima</b>
                        </h5>30/05/1997
                      </v-flex>
                      <v-flex xs4>
                        <h5>
                          <b>Área</b>
                        </h5>Tecnologia da Informação
                      </v-flex>
                      <v-flex xs4>
                        <h5>
                          <b>Unidade</b>
                        </h5>Quixadá
                      </v-flex>
                      <v-flex xs4>
                        <h5>
                          <b>Salário Base Mínimo</b>
                        </h5>R$ 2.000,00
                      </v-flex>
                      <v-flex xs4>
                        <h5>
                          <b>Salário Base Máximo</b>
                        </h5>R$ 3.500,00
                      </v-flex>

                      <v-flex xs12>
                        <v-divider></v-divider>
                      </v-flex>
                      <v-flex xs12>
                        <h5>
                          <b>ATIVIDADES</b>
                        </h5>
                      </v-flex>
                      <v-flex xs12>
                        <h5>
                          <b>Título</b>
                        </h5>Administrador de Redes Sociais E-commerce
                      </v-flex>
                      <v-flex xs12>
                        <h5>
                          <b>Descrição</b>
                        </h5>Somos uma nova concessionária de scooters e patinetes 100% elétricas, Estamos a procura de um profissional que possa desenvolver uma parceria duradoura para abrirmos o mercado e expandir para todo o território nacional. Nossa marca é a no.1 na China, por i (...)
                      </v-flex>

                      <v-flex xs12>
                        <v-divider></v-divider>
                      </v-flex>
                      <v-flex xs12>
                        <h5>
                          <b>CONHECIMENTOS</b>
                        </h5>
                      </v-flex>
                      <v-flex xs8>
                        <h5>
                          <b>Título</b>
                        </h5>Administrador de Redes Sociais E-commerce
                      </v-flex>
                      <v-flex xs4>
                        <h5>
                          <b>Nível do Conhecimento</b>
                        </h5>Básico
                      </v-flex>

                      <v-flex xs12>
                        <v-divider></v-divider>
                      </v-flex>
                      <v-flex xs12>
                        <h5>
                          <b>TREINAMENTOS</b>
                        </h5>
                      </v-flex>

                      <v-flex xs8>
                        <h5>
                          <b>Título</b>
                        </h5>Administrador de Redes Sociais E-commerce
                      </v-flex>
                      <v-flex xs4>
                        <h5>
                          <b>Classificação do Treinamento</b>
                        </h5>Desejável
                      </v-flex>

                      <v-flex xs12>
                        <v-divider></v-divider>
                      </v-flex>

                      <v-flex xs12>
                        <h5>
                          <b>BENEFÍCIOS</b>
                        </h5>
                      </v-flex>
                      <v-flex xs8>
                        <h5>
                          <b>Título</b>
                        </h5>Administrador de Redes Sociais E-commerce
                      </v-flex>
                      <v-flex xs4>
                        <h5>
                          <b>Valor</b>
                        </h5>R$ 500,00
                      </v-flex>
                      <v-flex xs12>
                        <h5>
                          <b>Informações</b>
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
