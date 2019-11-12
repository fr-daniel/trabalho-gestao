<template>
  <v-app id="telaInicial">
    <div class="organizarLogo">
      <router-link to="/">Sistema de Cargos e Salários (SCS)</router-link>
    </div>
    <v-content>
      <v-container fill-height fluid>
        <v-layout align-center justify-center>
          <v-flex md4 sm8 xs12>
            <v-card>
              <v-tabs v-model="tab" grow centered>
                <v-tab-item key="0">
                  <app-login></app-login>
                </v-tab-item>
              </v-tabs>
            </v-card>
          </v-flex>
        </v-layout>

        <v-snackbar right top :color="cor" v-model="snackbar">{{ mensagem }}</v-snackbar>
      </v-container>
    </v-content>
  </v-app>
</template>


<script>
import Login from "../../components/inicio/AppLogin";

export default {
  components: {
    "app-login": Login
  },
  data() {
    return {
      tab: 0,

      snackbar: false,
      mensagem: "",
      cor: ""
    };
  },
  methods: {
    toLogin() {
      this.tab = 0;
    },
    notificar(notificacao) {
      this.mensagem = notificacao.mensagem;
      this.cor = notificacao.cor;
      this.snackbar = true;
    }
  }
};
</script>
<style lang="css" scoped>
#logo {
  background: #1c6eb7;
}

@media all and (max-width: 319px) {
  #telaInicial {
    background: #efefef;
    background-size: 160px 102px;
  }
}

@media all and (max-width: 639px) and (min-width: 320px) {
  #telaInicial {
    background: #efefef;
    background-size: 320px 205px;
  }
}

#telaInicial {
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-position: center;
}

p {
  margin-top: 24px;
  margin-left: 24px;
}

.organizarLogo {
  margin-top: 24px;
  margin-left: 24px;
  text-align: center;
}

.organizarLogo a {
  font-size: 1.6em;
  text-decoration: none;
}
</style>
