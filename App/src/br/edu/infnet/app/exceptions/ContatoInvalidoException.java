package br.edu.infnet.app.exceptions;

public class ContatoInvalidoException extends Exception {

	private static final long serialVersionUID = 1L;

	public ContatoInvalidoException(String mensagem) {
		super(mensagem);
	}
}