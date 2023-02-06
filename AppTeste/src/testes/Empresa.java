package testes;

import java.util.List;

public class Empresa {

	private String nome;
	private List<Solicitante> solicitantes;

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Solicitante> getSolicitantes() {
		return solicitantes;
	}
	public void setSolicitantes(List<Solicitante> solicitantes) {
		this.solicitantes = solicitantes;
	}
}
