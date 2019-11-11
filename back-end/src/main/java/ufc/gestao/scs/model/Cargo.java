package ufc.gestao.scs.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cargo")
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String titulacao;
    private String missao;
    private String experienciaMinima;
    private String area;
    private String unidade;

    private Double salarioBaseMinimo;
    private Double salarioBaseMaximo;

    @ManyToMany
    @JoinTable(name = "cargo_has_beneficio", joinColumns = @JoinColumn(referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(referencedColumnName = "id"))
    private List<Beneficio> beneficios;

    @ManyToMany
    @JoinTable(name = "cargo_has_treinamento", joinColumns = @JoinColumn(referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(referencedColumnName = "id"))
    private List<Treinamento> treinamentos;

    @OneToMany
    @JoinTable(name = "cargo_has_conhecimento", joinColumns = @JoinColumn(referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(referencedColumnName = "id"))
    private List<Conhecimento> conhecimentos;

    @OneToMany
    @JoinTable(name = "cargo_has_atividade", joinColumns = @JoinColumn(referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(referencedColumnName = "id"))
    private List<Atividade> atividades;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public String getMissao() {
        return missao;
    }

    public void setMissao(String missao) {
        this.missao = missao;
    }

    public String getExperienciaMinima() {
        return experienciaMinima;
    }

    public void setExperienciaMinima(String experienciaMinima) {
        this.experienciaMinima = experienciaMinima;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public Double getSalarioBaseMinimo() {
        return salarioBaseMinimo;
    }

    public void setSalarioBaseMinimo(Double salarioBaseMinimo) {
        this.salarioBaseMinimo = salarioBaseMinimo;
    }

    public Double getSalarioBaseMaximo() {
        return salarioBaseMaximo;
    }

    public void setSalarioBaseMaximo(Double salarioBaseMaximo) {
        this.salarioBaseMaximo = salarioBaseMaximo;
    }

    public List<Beneficio> getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(List<Beneficio> beneficios) {
        this.beneficios = beneficios;
    }

    public List<Treinamento> getTreinamentos() {
        return treinamentos;
    }

    public void setTreinamentos(List<Treinamento> treinamentos) {
        this.treinamentos = treinamentos;
    }

    public List<Conhecimento> getConhecimentos() {
        return conhecimentos;
    }

    public void setConhecimentos(List<Conhecimento> conhecimentos) {
        this.conhecimentos = conhecimentos;
    }

    public List<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(List<Atividade> atividades) {
        this.atividades = atividades;
    }
}