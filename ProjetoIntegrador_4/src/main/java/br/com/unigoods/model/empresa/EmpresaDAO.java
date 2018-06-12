package br.com.unigoods.model.empresa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.unigoods.util.ConnectionFactory;

public class EmpresaDAO extends ConnectionFactory {
	
	//Objeto da classe privada +-+
	private Empresa empresa;

	// todos os metodos tem que fechar a conexao FALTANDO TODAS
	// FALTA CRIAR METODO DE FECHAR CONEXAO
	public void insert(Empresa empresa) {

		Connection con = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO empresas(nome, cnpj, senha) VALUES(?, ?, ?)";

		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, empresa.getNome());
			ps.setDouble(2, empresa.getCnpj());
			ps.setString(3, empresa.getSenha());
			ps.executeUpdate();
		} catch (Exception e) {
			System.err.println("Erro ao cadastrar Empresa no banco de dados");
		} finally {
			// aqui tem que fechar a conexao (falta no connectionFactory)
		}
	}

	public Empresa selectPorUsuarioSenha(Empresa empresa) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "SELECT cod_empresa, nome, cnpj FROM empresas WHERE nome = ? AND senha = ?";
		Empresa user = null;
		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, empresa.getNome());
			ps.setString(2, empresa.getSenha());
			rs = ps.executeQuery();

			if (rs.next()) {
				user = new Empresa();
				user.setId(rs.getLong("cod_empresa"));
				user.setNome(rs.getString("nome"));
			}
		} catch (Exception e) {
			System.err.println("Erro: ");
			e.printStackTrace();
		} finally {
			// criar o metodo para
			// fechar a conexao
		}
		return user;
	}

	
	//FALTANDO ESSES DOIS METODOS (cançasso bateu na mente, foda-se)
	public void update(Empresa empresa) {
		String sql = "UPDATE usuario SET  nome = ?, login =?, senha = ?, tipo = ? "
				+ "WHERE codUsuario = ?";	
		try {
			Connection con;
			PreparedStatement ps;
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, empresa.getNome());
			ps.setDouble(2, empresa.getCnpj());
			ps.setString(3, empresa.getSenha());
			ps.setLong(5, empresa.getCod_empresa());
			ps.executeUpdate();
		} catch (Exception e){
			System.err.println("---------------------");
			System.err.println("Erro: " + e.getMessage());
			e.printStackTrace();
			System.err.println("---------------------");
		} finally {
			// criar o metodo para
			// fechar a conexao
		}

	}
	
	public void delete(Empresa empresa) {
		String sql = "DELETE FROM empresas WHERE cod_empresa = ?";
		try {
			Connection con;
			PreparedStatement ps;
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setLong(1, empresa.getCod_empresa());
			ps.executeUpdate();
		} catch (Exception e){
			System.err.println("***************************************");
			System.err.println("Erro: " + e.getMessage());
			e.printStackTrace();
			System.err.println("***************************************");
		} finally {
			//CRIAR O METODO DE FECHAR CONEXAO
		}
		
	}

	
	public List<Empresa> selectAll() {
		List<Empresa> listagem = null;
		String sql = "SELECT cod_empresa, nome, cnpj FROM empresas order by nome";
		try {
			Connection con;
			PreparedStatement ps;
			ResultSet rs;
			con = getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			listagem = new ArrayList<Empresa>();

			// laço onde busca todas as empresas criadas
			while (rs.next()) {
				Empresa empresa = new Empresa();
				empresa.setId(rs.getLong("cod_empresa"));
				empresa.setNome(rs.getString("nome"));
				empresa.setCnpj(rs.getDouble("cnpj"));
				listagem.add(empresa);
			}
		} catch (Exception e) {
			System.err.println("**************************************************");
			System.err.println("Erro: " + e.getMessage());
			e.printStackTrace();
			System.err.println("**************************************************");
		} finally {
			// faltando metodo para fechar conexao
		}
		return listagem;
	}

	
	
	
	
	//get e set para desbugar o programa, INSERIR A EMPRESA CERTA HAHAHAA
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}
