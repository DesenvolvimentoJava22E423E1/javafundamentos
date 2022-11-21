package br.edu.infnet.app.exceptions;

public class NomeIncompletoException extends Exception {

	private static final long serialVersionUID = 1L;

	public NomeIncompletoException(String mensagem) {
		super(mensagem);
	}
}