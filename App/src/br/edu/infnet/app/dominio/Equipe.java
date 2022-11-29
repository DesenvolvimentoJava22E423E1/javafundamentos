package br.edu.infnet.app.dominio;

import java.util.List;

import br.edu.infnet.app.exceptions.ContatoInvalidoException;
import br.edu.infnet.app.exceptions.ProfissionalInvalidoException;

public class Equipe {

	private String nome;
	private int anoFundacao;
	private Contato contato;
	private List<Profissional> profissionais;

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getAnoFundacao() {
		return anoFundacao;
	}
	public void setAnoFundacao(int anoFundacao) {
		this.anoFundacao = anoFundacao;
	}
	public Contato getContato() {
		return contato;
	}
	public void setContato(Contato contato) {
		this.contato = contato;
	}
	public List<Profissional> getProfissionais() {
		return profissionais;
	}
	public void setProfissionais(List<Profissional> profissionais) {
		this.profissionais = profissionais;
	}
	
	@Override
	public String toString() {
		return String.format("%s - %d", nome, anoFundacao);
	}
	
	public void imprimir() throws ContatoInvalidoException, ProfissionalInvalidoException {
		
		if(contato == null) {
			throw new ContatoInvalidoException("O contato precisa ser preenchido!");
		}

		if(profissionais == null){
			throw new ProfissionalInvalidoException("Nenhuma listagem de profissionais foi associada à equipe!");
		}
		
		if(profissionais.size() == 0) {
			throw new ProfissionalInvalidoException("A listagem não possui profissionais!");
		}

		System.out.printf("Equipe: %s - %s - %d\n", 
				toString(),	
				contato, 
				profissionais.size()
			);
		
		System.out.println("Profissionais:");
		for(Profissional profissional : this.getProfissionais()) {
			System.out.println(profissional);
		}
	}
}