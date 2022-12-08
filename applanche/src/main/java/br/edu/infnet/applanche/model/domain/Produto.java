package br.edu.infnet.applanche.model.domain;

import br.edu.infnet.applanche.model.exceptions.TamanhoBebidaInvalidoException;
import br.edu.infnet.applanche.model.exceptions.ValorZeradoException;

public abstract class Produto {

	private String codigo;
	private String nome;
	private float valor;
	
	public Produto(String codigo, String nome, float valor) throws ValorZeradoException {
		
		if(valor == 0) {
			throw new ValorZeradoException("O valor do produto está zerado!");
		}
		
		if(valor < 0) {
			throw new ValorZeradoException("O valor do produto está negativo!");
		}

		this.codigo = codigo;
		this.nome = nome;
		this.valor = valor;
	}
	
	public abstract float calcularValorVenda() throws TamanhoBebidaInvalidoException;

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(codigo);
		sb.append(";");
		sb.append(nome);
		sb.append(";");
		sb.append(valor);

		return sb.toString();
	}

	public String getCodigo() {
		return codigo;
	}
	public String getNome() {
		return nome;
	}
	public float getValor() {
		return valor;
	}	
}