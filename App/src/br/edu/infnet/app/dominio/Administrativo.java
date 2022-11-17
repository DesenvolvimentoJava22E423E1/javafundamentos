package br.edu.infnet.app.dominio;

public class Administrativo extends Funcionario {

	private float bonus;
	private float desconto;

	public Administrativo() {
	}
	
	public Administrativo(String nome, int idade) {
		super(nome, idade);
	}
	
	public Administrativo(String nome, int idade, float salario, float bonus, float desconto) {
		super(nome, idade, salario);
		this.bonus = bonus;
		this.desconto = desconto;
	}

	@Override
	public String toString() {
		return super.toString() + ";" + bonus + ";" + desconto;
	}

	public float getBonus() {
		return bonus;
	}
	public void setBonus(float bonus) {
		this.bonus = bonus;
	}
	public float getDesconto() {
		return desconto;
	}
	public void setDesconto(float desconto) {
		this.desconto = desconto;
	}
}