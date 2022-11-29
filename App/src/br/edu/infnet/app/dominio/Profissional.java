package br.edu.infnet.app.dominio;

import br.edu.infnet.app.exceptions.JogadorInvalidoException;

public abstract class Profissional {

	private String nome;
	
	public abstract float calcularSalario() throws JogadorInvalidoException;
	
	@Override
	public String toString() {
		return String.format("%s", nome);
	}
	
	public void imprimir() throws JogadorInvalidoException {
		System.out.printf("Profissional: %s - %.2f\n", 
				toString(), 
				calcularSalario()
			);
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}