package br.edu.infnet.applanche.model.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Pedido {

	private String descricao;
	private boolean web;
	private LocalDateTime data;
	private Solicitante solicitante;
	private List<Produto> produtos;
	
	public Pedido() {
		data = LocalDateTime.now();
	}
	
	public void imprimir(){
		System.out.println("Pedido: " + this);
		System.out.println("Solicitante: " + solicitante);
		System.out.println("Qtde Produtos: " + produtos.size());
		System.out.println("Produtos:");
		for(Produto p : produtos) {
			System.out.println("- " + p.getNome());
		}
	}
	
	
	@Override
	public String toString() {
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		return  String.format("%s;%s;%s", 
				descricao, 
				web ? "web" : "loja",  
				data.format(formato)
			);
	}

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public boolean isWeb() {
		return web;
	}
	public void setWeb(boolean web) {
		this.web = web;
	}
	public Solicitante getSolicitante() {
		return solicitante;
	}
	public void setSolicitante(Solicitante solicitante) {
		this.solicitante = solicitante;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	public LocalDateTime getData() {
		return data;
	}
}