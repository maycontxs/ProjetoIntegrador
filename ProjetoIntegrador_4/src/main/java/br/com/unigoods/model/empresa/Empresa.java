package br.com.unigoods.model.empresa;

import java.io.Serializable;

public class Empresa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long cod_empresa;
	private String nome;
	private Double cnpj;
	private String senha;
	public Long getCod_empresa() {
		return cod_empresa;
	}
	public void setId(Long cod_empresa) {
		this.cod_empresa = cod_empresa;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getCnpj() {
		return cnpj;
	}
	public void setCnpj(Double cnpj) {
		this.cnpj = cnpj;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
