package ufc.gestao.scs.model;

import javax.persistence.*;

import ufc.gestao.scs.model.enums.ClassificacaoTreinamento;

@Entity
@Table(name = "treinamento")
public class Treinamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;

    @Column(name = "informacoes", columnDefinition = "TEXT")
    private String informacoes;

    @Enumerated(EnumType.STRING)
    private ClassificacaoTreinamento classificacao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ClassificacaoTreinamento getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(ClassificacaoTreinamento classificacao) {
        this.classificacao = classificacao;
    }

}