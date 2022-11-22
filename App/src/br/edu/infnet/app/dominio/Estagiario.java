package br.edu.infnet.app.dominio;

public class Estagiario extends Funcionario {

	private String faculdade;
	private int periodo;
	
	public Estagiario() {
		this.setNome("Estag");
		this.setPeriodo(1);
	}
	
	public Estagiario(String nome, int idade, float salario) {
		super(nome, idade, salario);
	}
	
	public Estagiario(String nome, int idade, float salario, String faculdade) {
		super(nome, idade, salario);
		this.faculdade = faculdade;
	}

	@Override
	public float calcularSalarioLiquido() {
		return super.calcularSalarioLiquido() + periodo * 100;
	}
	
	@Override
	public String toString() {
		return super.toString() + ";" + faculdade + ";" + periodo;
	}
	
	public String getFaculdade() {
		return faculdade;
	}
	public void setFaculdade(String faculdade) {
		this.faculdade = faculdade;
	}
	public int getPeriodo() {
		return periodo;
	}
	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}
}
