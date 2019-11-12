package ufc.gestao.scs.model;

import javax.persistence.*;

import ufc.gestao.scs.model.enums.ClassificacaoTreinamento;

@Entity
@Table(name = "treinamento")
public class Treinamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="descricao", columnDefinition="TEXT")
    private String descricao;

    @Enumerated(EnumType.STRING)
    private ClassificacaoTreinamento classificacao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ClassificacaoTreinamento getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(ClassificacaoTreinamento classificacao) {
        this.classificacao = classificacao;
    }

}