<template>
  <v-container grid-list-xl fluid>
    <v-layout row wrap>
      <v-flex xs12>
        <v-card>
          <v-container>
            <v-card-title primary-title>
              <div>
                <div class="headline">Cargos Cadastradas</div>
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
                  Última Atualização:
                  <span class="black--text">20 de outubro de 2019</span>
                </div>
                <div class="grey--text">
                  Quantidade de Funcionários:
                  <span class="black--text">5.000</span>
                </div>
              </div>
              <v-layout>
                <v-spacer></v-spacer>

                <v-btn class="ma-2" tile color="#F7685B">
                  <span class="white--text">
                    <v-icon left>add</v-icon>Adicionar Funcionário
                  </span>
                </v-btn>
              </v-layout>
            </v-card-title>
          </v-container>
        </v-card>
      </v-flex>
    </v-layout>
  </v-container>
</template>


<script>
import CadastrarCargo from "../CadastrarCargo";
export default {
  components: { CadastrarCargo },
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
.barra-lateral-1 {
  margin-top: 12px;
}

.barra-lateral-2 {
  margin-top: 30px;
}

.barra-lateral-3 {
  margin-top: 100px;
}
</style>
