package br.com.unigoods.web;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;

import br.com.unigoods.model.patrimonio.BemRN;
import br.com.unigoods.model.patrimonio.Bem;

@ManagedBean(name = "uniGoodsBens")
@SessionScoped

public class BeanBem implements Serializable {

	private static final long serialVersionUID = 1L;
	Bem bem = new Bem();
	private Date d = new Date();

	public List<Bem> getListagem() {
		return new BemRN().listarTodos();
	}

	// listarAtivos
	public List<Bem> getList() {
		return new BemRN().listarAtivos();
	}

	public String actionNovo() {
		this.bem = new Bem();
		return "teste";
	}

	public String actionVoltarMenu() {
		return "menu?faces-redirect=true";
	}

	public String actionGravar() {
		new BemRN().salvar(bem);
		return "manutencao_dos_bens?faces-redirect=true";
	}

	public String actionCalcularDep() {
		bem = new BemRN().calcular(bem);
		return "";
	}

	public String actionBaixar() {
		new BemRN().inserirBaixa_bem(bem);
		return "";
	}

	public String actionCalcularEbaixar() {
		bem = new BemRN().calcular(bem);
		return "";
	}

	public String actionIrParaBaixa() {
		bem = new BemRN().calcular(bem);
		return "";
	}

	public Bem getbem() {
		return bem;
	}

	public void setbem(Bem bem) {
		this.bem = bem;
	}

	public Date getD() {
		return d;
	}

	public void setD(Date d) {
		this.d = d;
	}
}
