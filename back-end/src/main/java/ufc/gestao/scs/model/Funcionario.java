package ufc.gestao.scs.model;

import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.fasterxml.jackson.annotation.JsonFormat;

import ufc.gestao.scs.model.enums.EstadoCivil;
import ufc.gestao.scs.model.enums.Sexo;

public class Funcionario {

	  	@JsonFormat(pattern = "yyyy-MM-dd")
	    private LocalDate dataNascimento;

	    @Enumerated(EnumType.STRING)
	    private EstadoCivil estadoCivil;

	    @Enumerated(EnumType.STRING)
	    private Sexo sexo;
	    
	    public LocalDate getDataNascimento() {
	        return dataNascimento;
	    }

	    public void setDataNascimento(LocalDate dataNascimento) {
	        this.dataNascimento = dataNascimento;
	    }

	    public EstadoCivil getEstadoCivil() {
	        return estadoCivil;
	    }

	    public void setEstadoCivil(EstadoCivil estadoCivil) {
	        this.estadoCivil = estadoCivil;
	    }

	    public Sexo getSexo() {
	        return sexo;
	    }

	    public void setSexo(Sexo sexo) {
	        this.sexo = sexo;
	    }
	   
}
