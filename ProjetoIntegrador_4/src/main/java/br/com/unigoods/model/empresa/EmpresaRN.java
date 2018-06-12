package br.com.unigoods.model.empresa;

import java.util.List;

public class EmpresaRN {
	
	private Empresa empresa = new Empresa();
	
	
	public void salvar(Empresa empresa) {
		if (empresa.getCod_empresa() == null) {
			new EmpresaDAO().insert(empresa);
		} else {
			new EmpresaDAO().update(empresa);
		}
	}
	
	public void apagar(Empresa empresa) {
		new EmpresaDAO().delete(empresa);
	}


	public List<Empresa> listarTodos(){
		return new EmpresaDAO().selectAll();
	}
	
	
	
	
	
	
	
	public Empresa getEmpresa() {
		return empresa;
	}


	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
}
