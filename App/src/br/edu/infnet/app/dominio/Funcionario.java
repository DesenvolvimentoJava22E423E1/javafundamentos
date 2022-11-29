package br.edu.infnet.app.dominio;

import br.edu.infnet.app.auxiliar.Constante;

public class Funcionario {

	private String nome;
	private int idade;
	private float salario;
	
	public Funcionario() {
		this.nome = Constante.NOME_PADRAO;
		this.idade = Constante.MAIOR_IDADE;
		this.salario = Constante.SALARIO_MINIMO;
	}
	
	public Funcionario(String nome, int idade) {
		this();
		this.nome = nome;
		this.idade = idade;
	}
	
	public Funcionario(String nome, int idade, float salario) {
		this(nome, idade);
		this.salario = salario;
	}

	@Override
	public String toString() {
		return nome + ";" + idade + ";" + salario;
	}
	
	public void imprimir(){		
		float salarioLiquido = calcularSalarioLiquido();
		
		System.out.println("Funcionário: " + this);
		System.out.println("Salário Líquido = R$" + salarioLiquido);
		System.out.println("Situação = " + obterSituacao(salarioLiquido));
	}

	public float calcularSalarioLiquido(){
		return salario;
	}
	
	public String obterSituacao(float salarioLiquido){		
		if(salarioLiquido >= Constante.SALARIO_LIQUIDO_MAXIMO) {
			return Constante.RICO;
		}		
		return Constante.POBRE;
	}
	
	public String obterStringSalarioPorFuncionario() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(this.getNome());
		sb.append(";");
		sb.append(this.calcularSalarioLiquido());
		sb.append("\r\n");

		return sb.toString();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}
}