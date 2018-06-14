package br.com.unigoods.model.patrimonio;

import java.io.Serializable;
import java.util.Date;

public class Bem implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private Date data_aquisicao;
	//private Date data_atual;
	private Integer periodo;
	//private String categoria;
	private Float vida_util;
	//private String bem_usado;
	private Float tempo_de_uso;
	private Float turnos;
	private Float valor_residual;
	private Float restante_vida_util;
	private Float metade_vida_util;
	//private Float vida_admissivel;
	private Float taxa;
	private Float valor_aquisicao;
	//private Float valor_residual;
	
	private Date data_baixa;
	private Float da;
	private Float vc;
	private Float gp;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getData_aquisicao() {
		return data_aquisicao;
	}
	public void setData_aquisicao(Date data_aquisicao) {
		this.data_aquisicao = data_aquisicao;
	}
	public Integer getPeriodo() {
		return periodo;
	}
	public void setPeriodo(Integer periodo) {
		this.periodo = periodo;
	}
	public Float getVida_util() {
		return vida_util;
	}
	public void setVida_util(Float vida_util) {
		this.vida_util = vida_util;
	}
	public Float getTempo_de_uso() {
		return tempo_de_uso;
	}
	public void setTempo_de_uso(Float tempo_de_uso) {
		this.tempo_de_uso = tempo_de_uso;
	}
	public Float getTurnos() {
		return turnos;
	}
	public void setTurnos(Float turnos) {
		this.turnos = turnos;
	}
	public Float getValor_residual() {
		return valor_residual;
	}
	public void setValor_residual(Float valor_residual) {
		this.valor_residual = valor_residual;
	}
	public Float getRestante_vida_util() {
		return restante_vida_util;
	}
	public void setRestante_vida_util(Float restante_vida_util) {
		this.restante_vida_util = restante_vida_util;
	}
	public Float getMetade_vida_util() {
		return metade_vida_util;
	}
	public void setMetade_vida_util(Float metade_vida_util) {
		this.metade_vida_util = metade_vida_util;
	}
	public Float getTaxa() {
		return taxa;
	}
	public void setTaxa(Float taxa) {
		this.taxa = taxa;
	}
	public Float getValor_aquisicao() {
		return valor_aquisicao;
	}
	public void setValor_aquisicao(Float valor_aquisicao) {
		this.valor_aquisicao = valor_aquisicao;
	}
	public Date getData_baixa() {
		return data_baixa;
	}
	public void setData_baixa(Date data_baixa) {
		this.data_baixa = data_baixa;
	}
	public Float getDa() {
		return da;
	}
	public void setDa(Float da) {
		this.da = da;
	}
	public Float getVc() {
		return vc;
	}
	public void setVc(Float vc) {
		this.vc = vc;
	}
	public Float getGp() {
		return gp;
	}
	public void setGp(Float gp) {
		this.gp = gp;
	}
	
	
	
	
	

	
}
