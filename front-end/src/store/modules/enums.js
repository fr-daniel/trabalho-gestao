const state = {
  estados: [
    {
      value: "SOLTEIRO",
      label: "Solteiro(a)"
    },
    {
      value: "CASADO",
      label: "Casado(a)"
    },
    {
      value: "DIVORCIADO",
      label: "Divorciado(a)"
    },
    {
      value: "VIUVO",
      label: "Viúvo(a)"
    }
  ],
  necessidades: [
    {
      value: "FISICA",
      label: "Física"
    },
    {
      value: "AUDITIVA",
      label: "Auditiva"
    },
    {
      value: "VISUAL",
      label: "Visual"
    },
    {
      value: "MENTAL",
      label: "Mental"
    },
    {
      value: "MULTIPLA",
      label: "Múltipla"
    }
  ],
  sexos: [
    {
      value: "MASCULINO",
      label: "Masculino"
    },
    {
      value: "FEMININO",
      label: "Feminino"
    }
  ],
  papeis: [
    {
      value: "COORDENADOR",
      label: "Coordenador"
    },
    {
      value: "CANDIDATO",
      label: "Candidato"
    }
  ]
};

const getters = {
  estados(state) {
    return state.estados;
  },

  getLabelEstadoCivil(state) {
    return value => {
      const estado = state.estados.find(estado => estado.value == value);
      return estado != undefined ? estado.label : value;
    };
  },

  papeis(state) {
    return state.papeis;
  },

  getLabelPapel(state) {
    return value => {
      const papel = state.papeis.find(papel => papel.value == value);
      return papel != undefined ? papel.label : value;
    };
  },

  necessidades(state) {
    return state.necessidades;
  },

  getLabelNecessidade(state) {
    return value => {
      const necessidade = state.necessidades.find(
        necessidade => necessidade.value == value
      );
      return necessidade != undefined ? necessidade.label : value;
    };
  },

  sexos(state) {
    return state.sexos;
  },

  getLabelSexo(state) {
    return value => {
      const sexo = state.sexos.find(sexo => sexo.value == value);
      return sexo != undefined ? sexo.label : value;
    };
  }
};

export default {
  namespaced: true,
  state,
  getters
};
