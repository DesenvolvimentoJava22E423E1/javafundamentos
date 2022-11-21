package br.edu.infnet.app.exceptions;

public class FaturamentoInvalidoException extends Exception {

	private static final long serialVersionUID = 1L;

	public FaturamentoInvalidoException(String mensagem) {
		super(mensagem);
	}
}
