package br.edu.infnet.app.dominio;

import br.edu.infnet.app.auxiliar.Constante;

public class Programador extends Funcionario {

	private String linguagem;
	private boolean devFull;
	
	public Programador(String nome, int idade) {
		super(nome, idade);
	}
	
	public Programador(String nome, int idade, float salario, String linguagem, boolean devFull) {
		super(nome, idade, salario);
		this.linguagem = linguagem;
		this.devFull = devFull;
	}

	@Override
	public String toString() {
		return super.toString() + ";" + linguagem + ";" + devFull;
	}
	
	@Override
	public float calcularSalarioLiquido() {
		return super.calcularSalarioLiquido() + calcularSalarioLiquidoDevFull() + calcularSalarioLiquidoLinguagem();
	}

	private float calcularSalarioLiquidoDevFull() {
		return devFull ? 1500 : 500;
	}
	
	private float calcularSalarioLiquidoLinguagem() {
		return "java".equalsIgnoreCase(linguagem) ? 2000 : 750;
	}
	
	@Override
	public String obterSituacao(float salarioLiquido) {
		if(salarioLiquido <= Constante.SALARIO_LIQUIDO_MINIMO) {
			return Constante.POBRE;
			
		}else if (salarioLiquido >= Constante.SALARIO_LIQUIDO_MAXIMO) {
			return Constante.RICO;
			
		}else {
			return Constante.CLASSE_MEDIA;
		}
	}

	public String getLinguagem() {
		return linguagem;
	}

	public void setLinguagem(String linguagem) {
		this.linguagem = linguagem;
	}

	public boolean isDevFull() {
		return devFull;
	}

	public void setDevFull(boolean devFull) {
		this.devFull = devFull;
	}
}