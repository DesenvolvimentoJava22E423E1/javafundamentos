package br.edu.infnet.app.exceptions;

public class ProfissionalInvalidoException extends Exception {

	private static final long serialVersionUID = 1L;

	public ProfissionalInvalidoException(String mensagem) {
		super(mensagem);
	}
}