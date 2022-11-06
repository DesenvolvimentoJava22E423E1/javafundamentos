package br.edu.infnet.app.dominio;

import br.edu.infnet.app.auxiliar.Constante;

public class Funcionario {

	public String nome;
	public int idade;
	public float salario;
	public float bonus;
	public float desconto;
	
	public Funcionario() {
		this.nome = Constante.NOME_PADRAO;
	}
	
	public Funcionario(String nome, int idade) {
		this();
		this.nome = nome;
		this.idade = idade;
	}
	
	public Funcionario(String nome, int idade, float salario, float bonus, float desconto) {
		this(nome, idade);
		this.salario = salario;
		this.bonus = bonus;
		this.desconto = desconto;		
	}

	@Override
	public String toString() {
		return nome + ";" + idade + ";" + salario + ";" + bonus + ";" + desconto;
	}
	
	public void imprimir(){
		
		float salarioLiquido = calcularSalarioLiquido();
		
		System.out.println("Funcionário: " + this);
		System.out.println("Salário Líquido = R$" + salarioLiquido);
		System.out.println("Situação = " + obterSituacao(salarioLiquido));
	}

	private float calcularSalarioLiquido(){
		return salario + bonus - desconto;
	}
	
	private String obterSituacao(float salarioLiquido){		
		if(salarioLiquido >= Constante.SALARIO_LIQUIDO_PADRAO) {
			return Constante.RICO;
		}		
		return Constante.POBRE;
	}
}