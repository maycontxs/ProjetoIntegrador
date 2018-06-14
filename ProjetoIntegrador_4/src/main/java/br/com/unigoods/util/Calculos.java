package br.com.unigoods.util;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import br.com.unigoods.model.patrimonio.Bem;

public class Calculos implements Serializable {

	private static final long serialVersionUID = 1L;
	

	private Bem bem = new Bem();

	public int calcularPeriodo(Bem p) {
		int depreciacaoPeriodo;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date(p.getData_aquisicao().getTime()));
		Calendar calendarAtual = Calendar.getInstance();
		calendarAtual.setTime(new Date());
		int diaAquisicao = calendar.get(Calendar.DAY_OF_MONTH);
		int mesAquisicao = calendar.get(Calendar.MONTH) + 1;
		int anoAquisicao = calendar.get(Calendar.YEAR);
		int diaAtual = calendarAtual.get(Calendar.DAY_OF_MONTH);
		int mesAtual = calendarAtual.get(Calendar.MONTH) + 1;
		int anoAtual = calendarAtual.get(Calendar.YEAR);
		
		depreciacaoPeriodo = (anoAtual - anoAquisicao) * 12;
		
		if (depreciacaoPeriodo > 0) {
			mesAquisicao = 12 - mesAquisicao;

			if (diaAquisicao <= 15) {
				mesAquisicao += 1;
			}
		}

		if (diaAtual < 15) {
			mesAtual -= 1;
		}
		if (depreciacaoPeriodo < 12) {
			depreciacaoPeriodo = mesAquisicao - mesAtual;
			if (depreciacaoPeriodo < 0) {
				depreciacaoPeriodo *= -1;
			}
		} else {
			if (depreciacaoPeriodo == 12) {
				depreciacaoPeriodo = mesAquisicao + mesAtual;
			} else {
				depreciacaoPeriodo += (mesAquisicao + mesAtual) - 12;
			}
		}
		if (depreciacaoPeriodo > p.getVida_util() * 12) {
			depreciacaoPeriodo = (int) (p.getVida_util() * 12);
		}

		return depreciacaoPeriodo;
	}
/*	
	public Bem calculoDepreciacao(Bem p){
		float calcularTurnoDeUso; 
		int periodo = this.calcularPeriodo(p);
		p.setPeriodo(periodo);
		
		p.setValor_residual((p.getValor_aquisicao() * p.getTaxa_residual()) / 100);
		

		if (p.getBem_usado() == "não"){
			p.setVida_admissivel(p.getVida_util());
		}else{
			p.setMetade_vida_util(p.getVida_util() / 2);
			p.setRestante_vida_util(p.getVida_util() - p.getTempo_de_uso());

			if(p.getVida_util() < p.getTempo_de_uso() || p.getMetade_vida_util() > p.getRestante_vida_util()){
				p.setVida_admissivel(p.getMetade_vida_util());
			}else{
				p.setVida_admissivel(p.getRestante_vida_util());
			}
		}	
		
		if(p.getVida_admissivel() <= 1 || p.getValor_aquisicao() <= 326.61){
			p.setValor_depreciado((float) 0);
		}else{

			if(p.getTurnos() == 1){
				calcularTurnoDeUso = 1;
			}else{
				if(p.getTurnos() == 2){
					calcularTurnoDeUso = (float) 1.5;
				}else{
					calcularTurnoDeUso = 2;
				}
			}
			p.setTaxa_depreciacao((100 / p.getVida_admissivel()) * calcularTurnoDeUso);

			
			p.setValor_depreciado(((p.getValor_aquisicao() - p.getValor_residual()) * 
					(p.getTaxa_depreciacao() / 100) / 12) * periodo); 			}
		
		p.setValor_contabil(p.getValor_aquisicao() - p.getValor_depreciado());
				
				
		if(p.getValor_depreciado() >= (p.getValor_aquisicao() - p.getValor_residual())){
			p.setValor_contabil(p.getValor_residual());
			p.setValor_depreciado(p.getValor_aquisicao());
		}
		
		return p;
	}
*/
	public Bem getP() {
		return bem;
	}

	public void setP(Bem p) {
		this.bem = p;
	}		
	
}
