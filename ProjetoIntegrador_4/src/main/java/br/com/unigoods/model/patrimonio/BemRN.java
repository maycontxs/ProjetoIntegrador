package br.com.unigoods.model.patrimonio;


import java.util.List;

import br.com.unigoods.util.Calculos;


public class BemRN {
	
	private Bem p = new Bem();
	private Calculos calcular = new Calculos();

	public List<Bem> listarTodos() {
		return new BemDao().selecionarBaixados();
	}
	public List<Bem> listarAtivos() {
		return new BemDao().lista();
	}
	public void inserir(Bem Bem){
		new BemDao().insert(Bem);
	}
	public void salvar(Bem Bem) {
		new BemDao().insert(Bem);
		
		//if (Bem.getId() == null) {
			
		//} else {
			//new BemDao().atualizarBD(Bem);
		//}
	}
	public void inserirBaixa_bem(Bem Bem){
		//new BemDao().inserirBaixa(Bem);
		
	}
	
	public Bem buscar(Bem p) {
		return new BemDao().buscarPorCodigo(p);
	}
	public Bem calcular(Bem p) {
		Bem desgraca = new BemDao().buscarPorCodigo(p);
		//Bem capeta = new Calculos().calculoDepreciacao(desgraca);
		//desgraca.setValor_contabil(capeta.getValor_contabil());
		//desgraca.setValor_residual(capeta.getValor_residual());
		//desgraca.setPeriodo(capeta.getPeriodo());
		return desgraca;
	}

	public Bem getP() {
		return p;
	}

	public void setP(Bem p) {
		this.p = p;
	}

	public Calculos getCalculos() {
		return calcular;
	}

	public void setCalculos(Calculos calcular) {
		this.calcular = calcular;
	}


	
}
