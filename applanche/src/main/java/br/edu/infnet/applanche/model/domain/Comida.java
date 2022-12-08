package br.edu.infnet.applanche.model.domain;

import br.edu.infnet.applanche.model.exceptions.ValorZeradoException;

public class Comida extends Produto {

	public Comida(String codigo, String nome, float valor) throws ValorZeradoException {
		super(codigo, nome, valor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public float calcularValorVenda() {
		// TODO Auto-generated method stub
		return 0;
	}

}
