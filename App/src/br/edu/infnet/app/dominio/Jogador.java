package br.edu.infnet.app.dominio;

import br.edu.infnet.app.exceptions.JogadorInvalidoException;

public class Jogador extends Profissional {

	private int anoNascimento;
	private int qtdeTituloNacional;
	private int qtdeTituloInternacional;

	@Override
	public float calcularSalario() throws JogadorInvalidoException {

		if(qtdeTituloNacional <= 0) {
			throw new JogadorInvalidoException("É necessário ter a quantidade de títulos nacionais superior à zero");
		}
		
		if(qtdeTituloNacional > 10) {
			throw new JogadorInvalidoException("É necessário ter a quantidade de títulos nacionais inferior à dez");
		}

		if(qtdeTituloInternacional < 0 || qtdeTituloInternacional > 5) {
			throw new JogadorInvalidoException("É necessário ter a quantidade de títulos internacionais superior à zero e inferior à cinco");			
		}
		
		return qtdeTituloNacional * 1000 + qtdeTituloInternacional * 5000;
	}

	public int getAnoNascimento() {
		return anoNascimento;
	}
	public void setAnoNascimento(int anoNascimento) {
		this.anoNascimento = anoNascimento;
	}
	public int getQtdeTituloNacional() {
		return qtdeTituloNacional;
	}
	public void setQtdeTituloNacional(int qtdeTituloNacional) {
		this.qtdeTituloNacional = qtdeTituloNacional;
	}
	public int getQtdeTituloInternacional() {
		return qtdeTituloInternacional;
	}
	public void setQtdeTituloInternacional(int qtdeTituloInternacional) {
		this.qtdeTituloInternacional = qtdeTituloInternacional;
	}
	
	@Override
	public String toString() {
		return String.format("%s - %d - %d - %d",
				super.toString(),
				anoNascimento, 
				qtdeTituloNacional, 
				qtdeTituloInternacional
				);
	}

	public void imprimir() throws JogadorInvalidoException {
		super.imprimir();
		System.out.println("Jogador: " + toString()); 
	}
}