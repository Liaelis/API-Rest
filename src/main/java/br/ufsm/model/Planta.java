package br.ufsm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Planta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String nome_popular;

    @NotBlank
    private String nome_cientifico;

    @NotBlank
    private Double valor;
    
    @ManyToOne
    @JoinColumn(name="idusuario")
    private Usuario usuario;
    
    
    public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome_popular() {
        return nome_popular;
    }

    public void setNome_popular(String nome_popular) {
        this.nome_popular = nome_popular;
    }

    public String getNome_cientifico() {
        return nome_cientifico;
    }

    public void setNome_cientifico(String nome_cientifico) {
        this.nome_cientifico = nome_cientifico;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
