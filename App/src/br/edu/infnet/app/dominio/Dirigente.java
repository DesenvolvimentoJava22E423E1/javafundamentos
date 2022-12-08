package br.edu.infnet.app.dominio;

public class Dirigente extends Profissional {

	private int anoInicio;
	private boolean ehPresidente;
	private Contato contato;

	@Override
	public float calcularSalario() {

		int qtdeAno = 2022 - anoInicio;
		
		return qtdeAno * 500 + (ehPresidente ? 7500 : 0);
	}

	public int getAnoInicio() {
		return anoInicio;
	}
	public void setAnoInicio(int anoInicio) {
		this.anoInicio = anoInicio;
	}
	public boolean isEhPresidente() {
		return ehPresidente;
	}
	public void setEhPresidente(boolean ehPresidente) {
		this.ehPresidente = ehPresidente;
	}
	public Contato getContato() {
		return contato;
	}
	public void setContato(Contato contato) {
		this.contato = contato;
	}

	@Override
	public String toString() {

		return String.format("%s - %d - %s - %s",
				super.toString(),
				anoInicio, 
				ehPresidente ? "presidente=S" : "presidente=N", 
				contato				
				);
	}

	public void imprimir() {
		System.out.println("Dirigente: " + toString()); 
	}
}