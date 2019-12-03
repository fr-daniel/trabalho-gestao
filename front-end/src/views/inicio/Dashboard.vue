<template>
  <v-container grid-list-xl fluid>
    <v-layout row wrap>
      <v-flex xs12>
        <v-card>
          <v-container>
            <v-card-title primary-title>
              <div>
                <div class="headline">Cargos Cadastrados</div>
                <div class="grey--text">
                  Data da Última atualização:
                  <span class="black--text">December 23, 2018</span>
                </div>
                <div class="grey--text">
                  Último Cadastro:
                  <span class="black--text">Gerente de Recursos Humanos</span>
                </div>
              </div>
              <CadastrarCargo></CadastrarCargo>
            </v-card-title>
          </v-container>

          <v-divider></v-divider>

          <v-container>
            <v-card-title primary-title>
              <div>
                <div class="headline">Cadastrar Funcionário</div>
                <div class="grey--text">
                  Data da última atualização:
                  <span class="black--text">20 de outubro de 2019</span>
                </div>
                <div class="grey--text">
                  Quantidade de Funcionários:
                  <span class="black--text">5.000</span>
                </div>
              </div>
              <v-layout>
                <v-spacer></v-spacer>
              </v-layout>
              <CadastrarFuncionario></CadastrarFuncionario>
            </v-card-title>
          </v-container>
        </v-card>
      </v-flex>
    </v-layout>
  </v-container>
</template>


<script>
import CadastrarCargo from "../cargo/CadastrarCargo";
import CadastrarFuncionario from "../funcionario/CadastrarFuncionario";
export default {
  components: { CadastrarCargo, CadastrarFuncionario },
  data() {
    return {
      drawer: true,
      right: null,
      search: ""
    };
  },
  methods: {
    logout() {
      this.$router.push("/logout");
    }
  }
};
</script>

<style lang="css" scoped>
.botao {
  max-width: 250px;
}
</style>
