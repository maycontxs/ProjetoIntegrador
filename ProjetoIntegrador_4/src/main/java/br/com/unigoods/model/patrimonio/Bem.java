package br.com.unigoods.model.patrimonio;

import java.io.Serializable;
import java.util.Date;

public class Bem implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private Date data_aquisicao;
	private Date data_atual;
	private Integer periodo;
	private String categoria;
	private Float vida_util;
	private String bem_usado;
	private Float tempo_de_uso;
	private Float turnos;
	private Float taxa_residual;
	private Float restante_vida_util;
	private Float metade_vida_util;
	private Float vida_admissivel;
	private Float taxa_depreciacao;
	private Float valor_aquisicao;
	private Float valor_residual;
	private Float valor_depreciado;
	private Float valor_contabil;
	private Date data_de_baixa;
	private Float valor_de_baixa;
	private Long id_baixa;
	
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
	public Date getData_atual() {
		return data_atual;
	}
	public void setData_atual(Date data_atual) {
		this.data_atual = data_atual;
	}
	public Integer getPeriodo() {
		return periodo;
	}
	public void setPeriodo(Integer periodo) {
		this.periodo = periodo;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Float getVida_util() {
		return vida_util;
	}
	public void setVida_util(Float vida_util) {
		this.vida_util = vida_util;
	}
	public String getBem_usado() {
		return bem_usado;
	}
	public void setBem_usado(String bem_usado) {
		this.bem_usado = bem_usado;
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
	public Float getTaxa_residual() {
		return taxa_residual;
	}
	public void setTaxa_residual(Float taxa_residual) {
		this.taxa_residual = taxa_residual;
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
	public Float getVida_admissivel() {
		return vida_admissivel;
	}
	public void setVida_admissivel(Float vida_admissivel) {
		this.vida_admissivel = vida_admissivel;
	}
	public Float getTaxa_depreciacao() {
		return taxa_depreciacao;
	}
	public void setTaxa_depreciacao(Float taxa_depreciacao) {
		this.taxa_depreciacao = taxa_depreciacao;
	}
	public Float getValor_aquisicao() {
		return valor_aquisicao;
	}
	public void setValor_aquisicao(Float valor_aquisicao) {
		this.valor_aquisicao = valor_aquisicao;
	}
	public Float getValor_residual() {
		return valor_residual;
	}
	public void setValor_residual(Float valor_residual) {
		this.valor_residual = valor_residual;
	}
	public Float getValor_depreciado() {
		return valor_depreciado;
	}
	public void setValor_depreciado(Float valor_depreciado) {
		this.valor_depreciado = valor_depreciado;
	}
	public Float getValor_contabil() {
		return valor_contabil;
	}
	public void setValor_contabil(Float valor_contabil) {
		this.valor_contabil = valor_contabil;
	}
	public Date getData_de_baixa() {
		return data_de_baixa;
	}
	public void setData_de_baixa(Date data_de_baixa) {
		this.data_de_baixa = data_de_baixa;
	}
	public Float getValor_de_baixa() {
		return valor_de_baixa;
	}
	public void setValor_de_baixa(Float valor_de_baixa) {
		this.valor_de_baixa = valor_de_baixa;
	}
	public Long getId_baixa() {
		return id_baixa;
	}
	public void setId_baixa(Long id_baixa) {
		this.id_baixa = id_baixa;
	}
}
