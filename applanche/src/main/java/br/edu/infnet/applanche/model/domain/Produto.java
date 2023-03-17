package br.edu.infnet.applanche.model.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.edu.infnet.applanche.model.exceptions.TamanhoBebidaInvalidoException;
import br.edu.infnet.applanche.model.exceptions.ValorZeradoException;

@Entity
@Table(name = "TProduto")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String codigo;
	private String nome;
	private float valor;
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	@ManyToMany(mappedBy = "produtos")
	private List<Pedido> pedidos; 
	
	public Produto() {
		// TODO Auto-generated constructor stub
	}
	
	public Produto(String codigo, String nome, float valor) throws ValorZeradoException {
		
		if(valor == 0) {
			throw new ValorZeradoException("O valor do produto está zerado!");
		}
		
		if(valor < 0) {
			throw new ValorZeradoException("O valor do produto está negativo!");
		}

		this.codigo = codigo;
		this.nome = nome;
		this.valor = valor;
	}
	
	public abstract float calcularValorVenda() throws TamanhoBebidaInvalidoException;

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(codigo);
		sb.append(";");
		sb.append(nome);
		sb.append(";");
		sb.append(valor);

		return sb.toString();
	}

	public String getCodigo() {
		return codigo;
	}
	public String getNome() {
		return nome;
	}
	public float getValor() {
		return valor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}	
}