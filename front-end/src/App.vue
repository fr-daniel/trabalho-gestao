<template>
  <div id="appRoot">
    <template v-if="!$route.meta.public">
      <v-app>
        <app-menu></app-menu>

        <v-content class="mt-5">
          <div class="layout column align-center">
            <img
              id="logo"
              src="/static/logo-01.png"
              alt="Logo Sistema de Sistema Inteno de Cargos e Salários"
            />
          </div>
          <v-container fluid>
            <div class="page-wrapper">
              <router-view></router-view>
            </div>
          </v-container>
        </v-content>
        <!-- App Footer -->
        <v-footer height="auto" class="white pa-3 app--footer">
          <span class="caption">Gestão de Projetos &copy; {{ new Date().getFullYear() }}</span>
          <v-spacer></v-spacer>
          <span class="caption">v1.0.0</span>
        </v-footer>
      </v-app>
    </template>
    <template v-else>
      <transition>
        <keep-alive>
          <router-view :key="$route.fullpath"></router-view>
        </keep-alive>
      </transition>
    </template>
  </div>
</template>

<script>
import AppToolbar from "./components/core/AppToolbar";
import AppMenu from "./components/core/AppMenu";
// import axios from "axios";

export default {
  name: "App",
  components: {
    AppToolbar,
    AppMenu
  }
};
</script>

<style lang="stylus" scoped>
.page-wrapper {
  min-height: calc(100vh - 64px - 50px - 81px);
}

.v-breadcrumbs {
  padding: 24px !important;
}

.v-content {
  padding-top: 0 !important;
}

#logo {
  max-width: 350px;
}
</style>
