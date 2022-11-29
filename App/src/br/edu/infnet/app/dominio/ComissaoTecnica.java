package br.edu.infnet.app.dominio;

public class ComissaoTecnica extends Profissional {

	private boolean ehTreinador;
	private int qtdeTitulo;

	@Override
	public float calcularSalario() {
		return qtdeTitulo * 2000 + (ehTreinador ? 10000 : 0);
	}

	public boolean isEhTreinador() {
		return ehTreinador;
	}
	public void setEhTreinador(boolean ehTreinador) {
		this.ehTreinador = ehTreinador;
	}
	public int getQtdeTitulo() {
		return qtdeTitulo;
	}
	public void setQtdeTitulo(int qtdeTitulo) {
		this.qtdeTitulo = qtdeTitulo;
	}
	
	@Override
	public String toString() {

		return String.format("%s - %d - %s",
					ehTreinador ? "treinador=S" : "treinador=N",
					qtdeTitulo,
					super.toString()
				);
	}

	public void imprimir() {
		System.out.println("Comissão Técnica: " + toString()); 
	}
}