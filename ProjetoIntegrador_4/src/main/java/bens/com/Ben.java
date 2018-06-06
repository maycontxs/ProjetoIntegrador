package bens.com;

import java.io.Serializable;
import java.util.Date;

public class Ben implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;
	private int vidaUtil;
	private Date dataAquisicao;
	private Date dataVenda;
	private Double residual;
	private int periodoDepre;
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getVidaUtil() {
		return vidaUtil;
	}

	public void setVidaUtil(int vidaUtil) {
		this.vidaUtil = vidaUtil;
	}

	public Date getDataAquisicao() {
		return dataAquisicao;
	}

	public void setDataAquisicao(Date dataAquisicao) {
		this.dataAquisicao = dataAquisicao;
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public Double getResidual() {
		return residual;
	}

	public void setResidual(Double residual) {
		this.residual = residual;
	}

	public int getPeriodoDepre() {
		return periodoDepre;
	}

	public void setPeriodoDepre(int periodoDepre) {
		this.periodoDepre = periodoDepre;
	}

}
