<template>
  <v-app id="telaInicial">
    <v-container grid-list-xl fluid>
      <v-layout row wrap>
        <v-flex xs12>
          <v-card>
            <v-container>
              <div>
                <v-toolbar flat color="white">
                  <CadastrarFuncionario @cadastrou-funcionario="atualizarTable"></CadastrarFuncionario>
                </v-toolbar>
                <v-data-table
                  :headers="headers"
                  :items="funcionarios"
                  :search="search"
                  class="elevation-1"
                >
                  <template v-slot:items="props">
                    <td>
                      <v-tooltip bottom>
                        <template #activator="{ on: tooltip }">
                          <v-btn
                            class="ma-2"
                            tile
                            depressed
                            dark
                            icon
                            color="primary"
                            small
                            v-on="{ ...tooltip }"
                            :to="{name: 'DetalhesFuncionario'}"
                          >
                            <v-icon small>view_list</v-icon>
                          </v-btn>
                        </template>
                        <span>Ver mais</span>
                      </v-tooltip>
                    </td>
                    <td class="justify-center">{{ props.item.id }}</td>
                    <td class="justify-center">{{ props.item.nome }}</td>
                    <td class="justify-center">{{ props.item.cpf }}</td>
                    <td class="justify-center">{{ props.item.formacaoAcademica }}</td>
                    <td class="justify-center">R$ {{ props.item.salarioBase }}, 00</td>

                    <v-dialog v-model="editarFuncionario" persistent max-width="800">
                      <template #activator="{ on: editarFuncionario  }">
                        <v-tooltip bottom>
                          <template #activator="{ on: tooltip }">
                            <v-btn
                              class="ma-2"
                              tile
                              depressed
                              dark
                              icon
                              color="#192A3E"
                              small
                              v-on="{ ...tooltip, ...editarFuncionario }"
                              @click="funcionarioEditar(props.item.id)"
                            >
                              <v-icon small>edit</v-icon>
                            </v-btn>
                          </template>
                          <span>Editar</span>
                        </v-tooltip>
                      </template>

                      <v-card>
                        <v-card-text>
                          <v-card-title class="headline black white--text">Editar Funcionário</v-card-title>
                          <v-container grid-list-md>
                            <v-layout wrap>
                              <v-flex xs8>
                                <v-text-field
                                  flat   
                                  label="Nome"
                                  value
                                  append-icon="person"
                                  v-model="funcionario.nome"
                                ></v-text-field>
                              </v-flex>
                              <v-flex xs4>
                                <v-text-field
                                  flat
                                  label="Formação Acadêmica"
                                  value
                                  append-icon="school"
                                  v-model="funcionario.formacaoAcademica"
                                ></v-text-field>
                              </v-flex>
                              <v-layout row wrap>
                                <v-flex xs4>
                                  <v-text-field
                                    flat
                                    label="Data de Nascimento"
                                    value
                                    append-icon="event"
                                    v-model="funcionario.dataNascimento"
                                  ></v-text-field>
                                </v-flex>
                                <v-flex xs4>
                                  <v-select
                                    :items="estadosCivis"
                                    item-text="text"
                                    item-value="value"
                                    label="Estado Civil"
                                    v-model="funcionario.estadoCivil"
                                  ></v-select>
                                </v-flex>
                                <v-flex xs4>
                                  <v-select
                                    :items="sexos"
                                    item-text="text"
                                    item-value="value"
                                    label="Sexo"
                                    v-model="funcionario.sexo"
                                  ></v-select>
                                </v-flex>
                              </v-layout>
                              <v-layout row wrap>
                                <v-flex xs4>
                                  <v-text-field
                                    flat
                                    label="CPF"
                                    value
                                    append-icon="assignment_ind"
                                    v-model="funcionario.cpf"
                                  ></v-text-field>
                                </v-flex>
                                <v-flex xs4>
                                  <v-text-field
                                    flat
                                    label="RG"
                                    value
                                    append-icon="assignment_ind"
                                    v-model="funcionario.rg"
                                  ></v-text-field>
                                </v-flex>
                                <v-flex xs4>
                                  <v-text-field
                                    flat
                                    label="NIS"
                                    value
                                    append-icon="assignment_ind"
                                    v-model="funcionario.nis"
                                  ></v-text-field>
                                </v-flex>
                              </v-layout>
                              <v-layout row wrap>
                                <v-flex xs8>
                                  <v-text-field
                                    flat
                                    label="Email"
                                    value
                                    append-icon="mail"
                                    v-model="funcionario.email"
                                  ></v-text-field>
                                </v-flex>
                                <v-flex xs4>
                                  <v-text-field
                                    flat
                                    label="Telefone"
                                    value
                                    append-icon="phone"
                                    v-model="funcionario.telefone"
                                  ></v-text-field>
                                </v-flex>
                              </v-layout>
                              <v-layout row wrap justify-center>
                                <v-flex xs4>
                                  <v-text-field
                                    flat
                                    label="Salário Base"
                                    append-icon="attach_money"
                                    v-model="funcionario.salarioBase"
                                  ></v-text-field>
                                </v-flex>
                                <v-flex xs4>
                                  <v-text-field
                                    flat
                                    label="Carga Horária"
                                    append-icon="access_time"
                                    v-model="funcionario.cargaHoraria"
                                  ></v-text-field>
                                </v-flex>
                              </v-layout>
                            </v-layout>
                          </v-container>
                        </v-card-text>
                        <v-card-actions class="justify-center">
                          <v-btn
                            class="ma-2"
                            tile
                            color="#F7685B"
                            @click="editarFuncionario = false"
                          >
                            <span class="white--text">Cancelar</span>
                          </v-btn>

                          <v-btn class="ma-2" tile color="#109CF1">
                            <span class="white--text">Salvar</span>
                          </v-btn>
                        </v-card-actions>
                      </v-card>
                    </v-dialog>

                    <v-tooltip bottom>
                      <template #activator="{ on: tooltip }">
                        <v-btn
                          @click="abrirDialogExcluirFuncionario(props.item)"
                          class="ma-2"
                          tile
                          depressed
                          dark
                          icon
                          color="#F7685B"
                          small
                          v-on="{ ...tooltip }"
                        >
                          <v-icon small>delete</v-icon>
                        </v-btn>
                      </template>
                      <span>Remover</span>
                    </v-tooltip>
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
          <v-card-title class="headline">Excluir Funcionário</v-card-title>

          <v-card-text>Tem certeza que deseja excluir o funcionário?</v-card-text>

          <v-card-actions>
            <v-spacer></v-spacer>

            <v-btn @click="dialog = false" color="silver darken-1" flat="flat">Não</v-btn>

            <v-btn @click="excluirFuncionario()" color="red darken-1" flat="flat">Sim</v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
    </v-container>
  </v-app>
</template>


<script>
import axios from "axios";
import CadastrarFuncionario from "../funcionario/CadastrarFuncionario";

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
  components: { CadastrarFuncionario },
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
          value: "selecionarFuncionario"
        },
        {
          text: "ID",
          align: "left",
          sortable: true,
          value: "id"
        },
        {
          text: "Nome",
          align: "left",
          sortable: false,
          value: "nome"
        },
        {
          text: "CPF",
          sortable: false,
          value: "cpf"
        },
        {
          text: "Formação Acadêmica",
          sortable: false,
          value: "formacaoAcademica"
        },
        { text: "Salário Base", sortable: false, value: "salarioBase" },
        { text: "Opções", sortable: false, value: "opcoes" }
      ],
      funcionarios: [],
      dialog: false,
      editarFuncionario: false,
      funcionarioDelete: null,
      dSnackbar: false,
      dMensagem: "",
      dCor: "",
      estadosCivis: [
        { text: "Solteiro", value: "SOLTEIRO" },
        { text: "Casado", value: "CASADO" },
        { text: "Divorciado", value: "DIVORCIADO" },
        { text: "Viúvo", value: "VIUVO" }
      ],
      sexos: [
        { text: "Masculino", value: "MASCULINO" },
        { text: "Feminino", value: "FEMININO" }
      ],
      funcionario: {
        nome: "",
        formacaoAcademica: "",
        dataNascimento: "",
        estadoCivil: "",
        sexo: "",
        cpf: "",
        rg: "",
        nis: "",
        email: "",
        telefone: "",
        salarioBase: "",
        cargaHoraria: ""
      },
      y: ""
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
    },

    atualizarTable(funcionario) {
      this.funcionarios.push(funcionario);
    },
    excluirFuncionario() {
      axios
        .delete("/funcionario/excluir/" + this.funcionarioDelete.id)
        .then(() => {
          this.funcionarios.splice(
            this.funcionarios.indexOf(this.funcionarioDelete),
            1
          );
          this.funcionarioDelete = null;

          this.dSnackbar = true;
          this.dMensagem = "Funcionário excluído com sucesso";
          this.dCor = "success";
        })
        .catch(error => {
          this.dSnackbar = true;
          this.dMensagem = "Ocorreu um erro ao excluir o funcionário!";
          this.dCor = "error";
        });

      this.dialog = false;
    },

    abrirDialogExcluirFuncionario(funcionario) {
      this.funcionarioDelete = funcionario;
      this.dialog = true;
    },

    funcionarioEditar(id) {
      axios.get("/funcionario/listar/" + id).then(res => {
        this.y = res.data;
        console.log(this.y);
        this.funcionario.nome = this.y.nome;
        this.funcionario.formacaoAcademica = this.y.formacaoAcademica;
        this.funcionario.dataNascimento = this.y.dataNascimento;    
        this.funcionario.estadoCivil = this.y.estadoCivil;
        this.funcionario.sexo = this.y.sexo;
        this.funcionario.cpf = this.y.cpf;
        this.funcionario.rg = this.y.rg;    
        this.funcionario.nis = this.y.nis;
        this.funcionario.email = this.y.email;
        this.funcionario.telefone = this.y.telefone;
        this.funcionario.salarioBase = this.y.salarioBase;
        this.funcionario.cargaHoraria = this.y.cargaHoraria;
      });
    },

  },
  computed: {}
};
</script>

<style lang="css" scoped>
</style>
