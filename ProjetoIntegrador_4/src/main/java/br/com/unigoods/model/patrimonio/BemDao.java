package br.com.unigoods.model.patrimonio;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.unigoods.util.ConnectionFactory;

public class BemDao extends ConnectionFactory{

	private static final long serialVersionUID = 1L;
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	public List<Bem> selecionarBaixados(){
		List<Bem> listaBaixados = null;
		String sql = "select * from Bem_Patrimonial inner join baixa_de_Bem on Bem_Patrimonial.cod_Bem = "
				+ "baixa_de_bem.cod_Bem order by nome";
		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			listaBaixados = new ArrayList<Bem>();
			while (rs.next()){
				Bem pt = new Bem();
				pt.setId(rs.getLong("cod_Bem"));
				pt.setNome(rs.getString("nome"));
				pt.setData_aquisicao(rs.getDate("data_aquisicao"));
				pt.setCategoria(rs.getString("categoria"));
				pt.setVida_util(rs.getFloat("vida_util"));
				pt.setBem_usado(rs.getString("bem_usado"));
				pt.setValor_aquisicao(rs.getFloat("valor_aquisicao"));
				pt.setTempo_de_uso(rs.getFloat("tempo_de_uso"));
				pt.setTaxa_residual(rs.getFloat("taxa_residual"));
				pt.setTurnos(rs.getFloat("turnos_trabalhados"));
				pt.setData_de_baixa(rs.getDate("data_de_baixa"));
				pt.setValor_de_baixa(rs.getFloat("valor"));
				listaBaixados.add(pt);
			}
		}catch (Exception e){
			System.err.println("Erro: " + e.getMessage());
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}
		return listaBaixados;
	}
	public List<Bem> lista(){
		List<Bem> listaAtivos = null;
		String sql = "select * from Bem_Patrimonial where cod_Bem not in "
				+ "(select cod_Bem from baixa_de_bem) "
				+ "order by cod_Bem";
		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			listaAtivos = new ArrayList<Bem>();
			while (rs.next()){
				Bem Bem = new Bem();
				Bem.setId(rs.getLong("cod_bem"));
				Bem.setNome(rs.getString("nome"));
				Bem.setData_aquisicao(rs.getDate("data_aquisicao"));
				Bem.setCategoria(rs.getString("categoria"));
				Bem.setVida_util(rs.getFloat("vida_util"));
				Bem.setBem_usado(rs.getString("bem_usado"));
				Bem.setValor_aquisicao(rs.getFloat("valor_aquisicao"));
				Bem.setTempo_de_uso(rs.getFloat("tempo_de_uso"));
				Bem.setTaxa_residual(rs.getFloat("taxa_residual"));
				Bem.setTurnos(rs.getFloat("turnos_trabalhados"));
				listaAtivos.add(Bem);
			}
		}catch (Exception e){
			System.err.println("Erro: " + e.getMessage());
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}
		return listaAtivos;
	}
	public Bem insert(Bem Bem){
		
		String sql = "INSERT INTO Bem_Patrimonial (nome, data_aquisicao, categoria, vida_util, "
				+ "bem_usado, valor_aquisicao, taxa_residual, turnos_trabalhados, tempo_de_uso) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			Connection con;
			PreparedStatement ps;
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, Bem.getNome());
			ps.setDate(2, new Date(Bem.getData_aquisicao()
					.getTime()));
			System.out.println("dt: "+Bem.getData_aquisicao()
					.getTime());
			ps.setString(3, Bem.getCategoria());
			ps.setFloat(4, Bem.getVida_util());
			ps.setString(5, Bem.getBem_usado());
			ps.setFloat(6, Bem.getValor_aquisicao());
			ps.setFloat(7, Bem.getTaxa_residual());
			ps.setFloat(8, Bem.getTurnos());
			ps.setFloat(9, Bem.getTempo_de_uso());
			ps.executeUpdate();
			System.out.println("feito insert");
		} catch (Exception e){
			System.err.println("Erro: " + e.getMessage());
			e.printStackTrace();
		} finally {
			close(con, ps);
		}
		return Bem;
	}
	
	public Bem inserirBaixa(Bem Bem){
		String sql = "INSERT INTO baixa_de_bem (data_de_baixa, valor, cod_bem) "
				+ " VALUES (?, ?, ?)";
		try {
			Connection con;
			PreparedStatement ps;
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setDate(1, new Date(Bem.getData_de_baixa().getTime()));
			ps.setFloat(2, Bem.getValor_de_baixa());
			ps.setLong(3, Bem.getId());
			ps.executeUpdate();
		} catch (Exception e){
			System.err.println("Erro: " + e.getMessage());
			e.printStackTrace();
		} finally {
			close(con, ps);
		}
		return Bem;
	}

	public Bem atualizarBD(Bem pt){
		String sql = "UPDATE Bem_Patrimonial SET  bem_usado = ?, tempo_de_uso =?, nome = ?, "
				+ "data_aquisicao = ?, categoria = ?, vida_util = ?, "
				+ "valor_aquisicao = ?, taxa_residual = ?, turnos_trabalhados = ? WHERE cod_bem = ?";
		
		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, pt.getBem_usado());
			ps.setFloat(2, pt.getTempo_de_uso());
			ps.setString(3, pt.getNome());
			System.out.println(pt.getNome());
			ps.setDate(4, new Date(pt.getData_aquisicao()
					.getTime()));
			ps.setString(5, pt.getCategoria());
			ps.setFloat(6, pt.getVida_util());
			ps.setFloat(7, pt.getValor_aquisicao());
			ps.setFloat(8, pt.getTaxa_residual());
			ps.setFloat(9, pt.getTurnos());
			ps.setLong(10, pt.getId());
			ps.executeUpdate();
		} catch (Exception e){
			System.err.println("Erro: " + e.getMessage());
			e.printStackTrace();
		} finally {
			close(con, ps);
		}
		return pt;
	}
	 
	public Bem buscarPorCodigo(Bem p){
	     String sql = "SELECT * from Bem_Patrimonial WHERE cod_bem = ? ;";
	     Bem ptO = null;
	     try {
	    	con = getConnection();
	        ps = con.prepareStatement(sql);
	        ps.setLong(1, p.getId());
	        rs = ps.executeQuery();
	        while (rs.next()){
	        	ptO = new Bem();
	        	ptO.setId(rs.getLong("cod_bem"));
	        	ptO.setNome(rs.getString("nome"));
	        	ptO.setData_aquisicao(rs.getDate("data_aquisicao"));
	        	ptO.setVida_util(rs.getFloat("vida_util"));
	        	ptO.setValor_aquisicao(rs.getFloat("valor_aquisicao"));
	        	ptO.setTaxa_residual(rs.getFloat("taxa_residual"));
				ptO.setTurnos(rs.getFloat("turnos_trabalhados"));
				ptO.setTempo_de_uso(rs.getFloat("tempo_de_uso"));
				ptO.setBem_usado(rs.getString("bem_usado"));
	        }
	    } catch (Exception e){
			System.err.println("Erro: " + e.getMessage());
			e.printStackTrace();
		} finally {
			close(con, ps);
		}
	     return ptO;
	}


}
