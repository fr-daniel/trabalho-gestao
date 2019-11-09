package ufc.gestao.scs.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import ufc.gestao.scs.model.enums.Papel;

@Entity
public class Usuario implements UserDetails {


	private static final long serialVersionUID = 5429387806362006604L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String cpf;

    private String email;

    private String senha;

    @ElementCollection(targetClass = Papel.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "papel")
    @Column(name = "papel")
    private List<Papel> papeis;

    @OneToMany(mappedBy = "usuario")
    private List<Token> token;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Papel> getPapeis() {
        return papeis;
    }

    public void setPapeis(List<Papel> papeis) {
        this.papeis = papeis;
    }

    public boolean PapelUsuario(Papel papelUsuario) {
        return this.papeis.contains(papelUsuario);
    }

    public void addPapel(Papel papel) {
        if (this.papeis == null) this.papeis = new ArrayList<>();
        this.papeis.add(papel);
    }

    public List<Token> getToken() {
        return token;
    }

    public void setToken(List<Token> token) {
        this.token = token;
    }  

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.papeis;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    public void setPassword(String password) {
        this.senha = password;
    }

    @Override
    public String getUsername() {
        return this.cpf;
    }

    public void setUsername(String username) {
        this.cpf = username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
