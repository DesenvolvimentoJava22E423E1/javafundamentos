package br.edu.infnet.applanche.model.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.edu.infnet.applanche.model.exceptions.PedidoSemProdutoException;
import br.edu.infnet.applanche.model.exceptions.PedidoSemSolicitanteException;

@Entity
@Table(name = "TPedido")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	private boolean web;
	private LocalDateTime data;
	@OneToOne(cascade = CascadeType.DETACH) 
	@JoinColumn(name = "idSolicitante")
	private Solicitante solicitante;
	@ManyToMany(cascade = CascadeType.DETACH)
	private List<Produto> produtos;
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	
	public Pedido() {
		// TODO Auto-generated constructor stub
	}
	
	public Pedido(Solicitante solicitante, List<Produto> produtos) throws PedidoSemSolicitanteException, PedidoSemProdutoException {
		this();
		
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}