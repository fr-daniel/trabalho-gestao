import store from "../store";
import axios from "axios";

import HomePage from "../components/Home";

import NotFoundPage from "../views/utils/NotFoundPage";
import AccessDeniedPage from "../views/utils/AccessDeniedPage";
import ServerErrorPage from "../views/utils/ServerErrorPage";

import RecuperarSenhaPage from "../views/inicio/RecuperarSenha";
import MsgEnvioEmailPage from "../views/inicio/MsgEnvioEmail";
import NovaSenhaPage from "../views/inicio/NovaSenha";
import MsgAlteracaoSenhaPage from "../views/inicio/MsgAlteracaoSenha";
import TelaInicialPage from "../views/inicio/TelaInicial";
import DashboardPage from "../views/inicio/Dashboard";
import ListarCargosPage from "../views/cargo/ListarTodos";
import EditarCargoPage from "../views/cargo/EditarCargo";
import ListarTreinamentosPage from "../views/treinamento/ListarTodos";
import ListarBeneficiosPage from "../views/beneficio/ListarTodos";
import ListarFuncionariosPage from "../views/funcionario/ListarTodos";

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
      requiresAuth: true,
      permissions: [
        {
          role: "ADMINISTRADOR",
          access: true
        }
      ]
    },
    props: true,
    name: "Dashboard",
    component: DashboardPage
  },
  {
    path: "/cargo",
    component: HomePage,
    redirect: { name: "NotFound" },
    meta: { requiresAuth: true },
    children: [
      {
        path: "listar",
        name: "ListarCargos",
        component: ListarCargosPage,
        meta: { permissions: [{ role: "ADMINISTRADOR", access: true }] }
      }
    ]
    
  },
  {
    path: "/cargo",
    component: HomePage,
    redirect: { name: "NotFound" },
    meta: { requiresAuth: true },
    children: [
      {
        path: "editar",
        name: "EditarCargo",
        component: EditarCargoPage,
        meta: { permissions: [{ role: "ADMINISTRADOR", access: true }] }
      }
    ]
    
  },
  {
    path: "/treinamento",
    component: HomePage,
    redirect: { name: "NotFound" },
    meta: { requiresAuth: true },
    children: [
      {
        path: "listar",
        name: "ListarTreinamentos",
        component: ListarTreinamentosPage,
        meta: { permissions: [{ role: "ADMINISTRADOR", access: true }] }
      }
    ]
  },
  {
    path: "/beneficio",
    component: HomePage,
    redirect: { name: "NotFound" },
    meta: { requiresAuth: true },
    children: [
      {
        path: "listar",
        name: "ListarBeneficios",
        component: ListarBeneficiosPage,
        meta: { permissions: [{ role: "ADMINISTRADOR", access: true }] }
      }
    ]
  },
  {
    path: "/funcionario",
    component: HomePage,
    redirect: { name: "NotFound" },
    meta: { requiresAuth: true },
    children: [
      {
        path: "listar",
        name: "ListarFuncionarios",
        component: ListarFuncionariosPage,
        meta: { permissions: [{ role: "ADMINISTRADOR", access: true }] }
      }
    ]
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
    redirect: {
      name: "Dashboard"
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
