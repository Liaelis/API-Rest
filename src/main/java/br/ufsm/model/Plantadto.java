package br.ufsm.model;

import javax.validation.constraints.NotBlank;

public class Plantadto {
	 private String nomePopular;
	 private String nomeCientifico;
	 private String valor;
	 private int idUser;
	public String getNomePopular() {
		return nomePopular;
	}
	public void setNomePopular(String nomePopular) {
		this.nomePopular = nomePopular;
	}
	public String getNomeCientifico() {
		return nomeCientifico;
	}
	public void setNome_cientifico(String nomeCientifico) {
		this.nomeCientifico = nomeCientifico;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	 
	    
}
