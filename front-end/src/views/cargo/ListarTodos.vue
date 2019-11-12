<template>
  <v-app id="telaInicial">
    <v-container grid-list-xl fluid>
      <v-layout row wrap>
        <v-flex xs12>
          <v-card>
            <v-container>
              <div>
                <v-toolbar flat color="white">

                  <CadastrarCargo @cadastrou-cargo="atualizarTable"></CadastrarCargo>
                </v-toolbar>
                <v-data-table
                  :headers="headers"
                  :items="cargos"
                  :search="search"
                  hide-actions
                  class="elevation-1"
                >
                  <template v-slot:items="props">
                    <td>
                      <v-checkbox :input-value="props.selected" primary hide-details></v-checkbox>
                    </td>
                    <td class="justify-center">{{ props.item.id }}</td>
                    <td class="justify-center">{{ props.item.titulacao }}</td>
                    <td class="justify-center">{{ props.item.area }}</td>
                    <td class="justify-center">{{ props.item.unidade   }}</td>
                    <td class="justify-center">{{ props.item.salarioBaseMinimo }}</td>
                    <td class="justify-center">{{ props.item.salarioBaseMaximo }}</td>
                    <td class="justify-center">
                      <v-btn
                        class="ma-2"
                        tile
                        depressed
                        dark
                        icon
                        color="#192A3E"
                        small
                        :to="{name: 'EditarCargo'}"
                      >
                        <v-icon small>edit</v-icon>
                      </v-btn>
                      <v-btn class="ma-2" tile depressed dark icon color="#F7685B" small>
                        <v-icon small>delete</v-icon>
                      </v-btn>
                    </td>
                  </template>
                </v-data-table>
              </div>
            </v-container>
          </v-card>
        </v-flex>
      </v-layout>

       <v-snackbar :color="dCor" right top v-model="dSnackbar">{{ dMensagem }}</v-snackbar>

      <v-dialog max-width="290" v-model="dialog">
        <v-card>
          <v-card-title class="headline">Excluir Cargo</v-card-title>

          <v-card-text>Tem certeza que deseja excluir o cargo?</v-card-text>

          <v-card-actions>
            <v-spacer></v-spacer>

            <v-btn @click="dialog = false" color="silver darken-1" flat="flat">Não</v-btn>

            <v-btn @click="excluirCargo()" color="red darken-1" flat="flat">Sim</v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>

    </v-container>
  </v-app>
</template>


<script>
import axios from "axios";
import CadastrarCargo from "../cargo/CadastrarCargo";

export default {
  props: {
    cor: {
      type: String,
      default: ""
    },
    snackbar: {
      type: Boolean,
      default: false
    },
    mensagem: {
      type: String,
      default: ""
    }
  },
  components: { CadastrarCargo },
  data() {
    return {
      drawer: true,
      right: null,
      expand: false,
      search: "",
      selected: [],
      headers: [
        {
          text: "",
          align: "left",
          sortable: false,
          value: "selecionarCargo"
        },
        {
          text: "ID",
          align: "left",
          sortable: true,
          value: "id"
        },
        {
          text: "Titulação",
          align: "left",
          sortable: false,
          value: "titulacao"
        },
        {
          text: "Área",
          sortable: false,
          value: "area"
        },
        {
          text: "Unidade",
          sortable: false,
          value: "unidade"
        },
        { text: "Salário Base Mínimo", sortable: false, value: "salarioBMin" },
        { text: "Salário Base Máximo", sortable: false, value: "salarioBMax" },
        { text: "Opções", sortable: false, value: "opcoes" }
      ],
      cargos: [],
      dialog: false,
      cargoDelete: null,
      dSnackbar: false,
      dMensagem: "",
      dCor: ""
    };
  },
  created: function() {
    this.initialize();
  },
  methods: {
    initialize() {
      axios.get("cargo/listar").then(res => {
        this.cargos = res.data;
      });
    },

    atualizarTable(cargo) {
      this.cargos.push(cargo);
    },
    excluirCargo() {
      axios
        .delete("/cargo/excluir/" + this.cargoDelete.id)
        .then(() => {
          this.cargos.splice(
            this.cargos.indexOf(this.cargoDelete),
            1
          );
          this.cargoDelete = null;

          this.dSnackbar = true;
          this.dMensagem = "Cargo excluído com sucesso";
          this.dCor = "success";
        })
        .catch(error => {
          this.dSnackbar = true;
          this.dMensagem = "Ocorreu um erro ao excluir o cargo!";
          this.dCor = "error";
        });

      this.dialog = false;
    },

    abrirDialogExcluirCargo(cargo) {
      this.cargoDelete = cargo;
      this.dialog = true;
    }
  },
  computed: {}
};
</script>

<style lang="css" scoped>
</style>
