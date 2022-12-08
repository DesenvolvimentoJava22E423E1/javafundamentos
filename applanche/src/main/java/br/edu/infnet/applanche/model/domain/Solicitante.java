package br.edu.infnet.applanche.model.domain;

import br.edu.infnet.applanche.model.exceptions.SolicitanteInvalidoException;

public class Solicitante {

	private String nome;
	private String cpf;
	private String email;

	public Solicitante(String nome, String cpf, String email) throws SolicitanteInvalidoException {
		
		if(nome == null) {
			throw new SolicitanteInvalidoException("O nome do solicitante deve ser preenchido!");
		}
		
		if(cpf == null) {
			throw new SolicitanteInvalidoException("O CPF do solicitante deve ser preenchido!");
		}
		
		if(email == null) {
			throw new SolicitanteInvalidoException("O e-mail do solicitante deve ser preenchido!");
		}
		
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(nome);
		sb.append(";");
		sb.append(cpf);
		sb.append(";");
		sb.append(email);
		
		return sb.toString();
	}
	
	public String getNome() {
		return nome;
	}
	public String getCpf() {
		return cpf;
	}
	public String getEmail() {
		return email;
	}
}