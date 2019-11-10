package ufc.gestao.scs.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import ufc.gestao.scs.model.enums.NivelConhecimento;

@Entity
@Table(name = "conhecimento")
public class Conhecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String descricao;

    @Enumerated(EnumType.STRING)
    private NivelConhecimento nivel;

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

    public NivelConhecimento getNivel() {
        return nivel;
    }

    public void setNivel(NivelConhecimento nivel) {
        this.nivel = nivel;
    }

}