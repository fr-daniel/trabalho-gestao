import store from "../store";
import axios from "axios";

// import HomePage from "../components/Home";

import NotFoundPage from "../views/utils/NotFoundPage";
import AccessDeniedPage from "../views/utils/AccessDeniedPage";
import ServerErrorPage from "../views/utils/ServerErrorPage";

import RecuperarSenhaPage from "../views/inicio/RecuperarSenha";
import MsgEnvioEmailPage from "../views/inicio/MsgEnvioEmail";
import NovaSenhaPage from "../views/inicio/NovaSenha";
import MsgAlteracaoSenhaPage from "../views/inicio/MsgAlteracaoSenha";
import TelaInicialPage from "../views/inicio/TelaInicial";
import DashboardPage from "../views/inicio/Dashboard";
import ListarVagasPage from "../views/ListarVagas";

export default [
  {
    path: "*",
    meta: {
      public: true
    },
    redirect: {
      path: "/404"
    }
  },
  {
    path: "/404",
    meta: {
      public: true
    },
    name: "NotFound",
    component: NotFoundPage
  },
  {
    path: "/403",
    meta: {
      public: true
    },
    name: "AccessDenied",
    component: AccessDeniedPage
  },
  {
    path: "/500",
    meta: {
      public: true
    },
    name: "ServerError",
    component: ServerErrorPage
  },
  {
    path: "/telaInicial",
    meta: {
      public: true
    },
    props: true,
    name: "TelaInicial",
    component: TelaInicialPage
  },
  {
    path: "/dashboard",
    meta: {
      public: true
    },
    props: true,
    name: "Dashboard",
    component: DashboardPage
  },
  {
    path: "/listarVagas",
    meta: {
      public: true
    },
    props: true,
    name: "ListarVagas",
    component: ListarVagasPage
  },
  {
    path: "/recuperacao",
    meta: {
      public: true
    },
    name: "RecuperarSenha",
    component: RecuperarSenhaPage
  },
  {
    path: "/msgEnvioEmail",
    meta: {
      public: true
    },
    props: true,
    name: "MsgEnvioEmail",
    component: MsgEnvioEmailPage
  },
  {
    path: "/novaSenha",
    meta: {
      public: true
    },
    name: "NovaSenha",
    component: NovaSenhaPage,
    beforeEnter: (to, from, next) => {
      axios
        .get(`public/usuario/validar-token?token=${to.query.hash}`)
        .then(function(data) {
          if (data && data.status == 200) {
            return next();
          } else {
            return next("/tokenInvalido");
          }
        });
    }
  },
  {
    path: "/msgAlteracaoSenha",
    meta: {
      public: true
    },
    props: true,
    name: "MsgAlteracaoSenha",
    component: MsgAlteracaoSenhaPage
  },

  {
    path: "/",
    name: "Root",
    meta: {
      requiresAuth: true,
      permissions: [
        {
          role: "ADMINISTRADOR",
          access: false,
          redirect: "CoordenadorExames"
        },
        {
          role: "CANDIDATO",
          access: false,
          redirect: "CandidatoInscricoes"
        }
      ]
    }
  },

  {
    path: "/logout",
    name: "Logout",
    beforeEnter() {
      store.dispatch("auth/logout");
    }
  }
];
