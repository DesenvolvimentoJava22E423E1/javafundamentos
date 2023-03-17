package br.edu.infnet.applanche.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.edu.infnet.applanche.model.exceptions.TamanhoBebidaInvalidoException;
import br.edu.infnet.applanche.model.exceptions.ValorZeradoException;

@Entity
@Table(name = "TBebida")
public class Bebida extends Produto {

	private boolean gelada;
	private int tamanho;
	private String marca;
	
	public Bebida() {
		// TODO Auto-generated constructor stub
	}

	public Bebida(String codigo, String nome, float valor, String marca) throws ValorZeradoException {
		super(codigo, nome, valor);
		this.marca = marca;
	}

	@Override
	public float calcularValorVenda() throws TamanhoBebidaInvalidoException {
		
		if(tamanho < 300) {
			throw new TamanhoBebidaInvalidoException("O tamanho da bebida está inválido!");
		}
		
		return this.getValor() + (gelada ? 3 : 0) + tamanho * 0.05f;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(gelada ? "gelada=S" : "gelada=N");
		sb.append(";");
		sb.append(tamanho);
		sb.append(";");
		sb.append(marca);

		return sb.toString();
	}
	
	public boolean isGelada() {
		return gelada;
	}
	public void setGelada(boolean gelada) {
		this.gelada = gelada;
	}
	public int getTamanho() {
		return tamanho;
	}
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
}