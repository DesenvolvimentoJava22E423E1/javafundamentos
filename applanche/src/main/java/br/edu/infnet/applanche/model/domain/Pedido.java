package br.edu.infnet.applanche.model.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import br.edu.infnet.applanche.model.exceptions.PedidoSemProdutoException;
import br.edu.infnet.applanche.model.exceptions.PedidoSemSolicitanteException;

public class Pedido {

	private String descricao;
	private boolean web;
	private LocalDateTime data;
	private Solicitante solicitante;
	private List<Produto> produtos;
	
	public Pedido(Solicitante solicitante, List<Produto> produtos) throws PedidoSemSolicitanteException, PedidoSemProdutoException {
		
		if(solicitante == null) {
			throw new PedidoSemSolicitanteException("Não existe nenhum solicitante associado ao pedido!");
		}
		
		if(produtos == null) {
			throw new PedidoSemProdutoException("Não existe nenhum produto associado ao pedido!");
		}

		this.solicitante = solicitante;
		this.produtos = produtos;
		
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
	
	public String obterLinha() {	
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("MM/yyyy");
		
		return this.getData().format(formato)+";"+
			   this.getDescricao()+";"+
			   this.getSolicitante()+";"+
			   this.getProdutos().size()+"\r\n";
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
	public List<Produto> getProdutos() {
		return produtos;
	}
	public LocalDateTime getData() {
		return data;
	}
}