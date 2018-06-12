package br.com.unigoods.web;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

import br.com.unigoods.model.empresa.Empresa;
import br.com.unigoods.model.empresa.EmpresaDAO;
import br.com.unigoods.model.empresa.EmpresaRN;

@ManagedBean(name = "unigoodsCompany")
public class EmpresaBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Empresa empresa = new Empresa();

	//testar este modo de verificação de login
	public String actionLogin() {
		String verificar = "login_erro";
		Empresa consulta = new EmpresaDAO().selectPorUsuarioSenha(empresa);
		if (consulta != null) {
			//falta colocar em baixo do comentario um if para comparação de senha com o banco de dados
			verificar = "index";
			} else {
				verificar = "login_erro";
			}
		return verificar;
	}

	public String actionCancel() {

		new EmpresaRN().apagar(empresa);
		return "login?faces-redirect=true";
	}
	
	public String actionNovo() {
		this.empresa = new Empresa();
		return "login";
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
}
