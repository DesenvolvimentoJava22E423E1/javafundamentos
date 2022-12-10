package br.edu.infnet.applanche.model.tests;

import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.applanche.model.domain.Bebida;
import br.edu.infnet.applanche.model.domain.Pedido;
import br.edu.infnet.applanche.model.domain.Produto;
import br.edu.infnet.applanche.model.domain.Solicitante;
import br.edu.infnet.applanche.model.exceptions.PedidoSemProdutoException;
import br.edu.infnet.applanche.model.exceptions.PedidoSemSolicitanteException;
import br.edu.infnet.applanche.model.exceptions.SolicitanteInvalidoException;
import br.edu.infnet.applanche.model.exceptions.ValorZeradoException;

public class PedidoTest {

	public static void main(String[] args) {
		List<Produto> produtosP1 = new ArrayList<Produto>();
		List<Produto> produtosP2 = new ArrayList<Produto>();
		List<Produto> produtosP3 = new ArrayList<Produto>();
		List<Produto> produtosP4 = new ArrayList<Produto>();

		try {
			Bebida b1 = new Bebida("b1caf5", "cafezin", 5, "Cooooffeeee");
			b1.setGelada(false);
			b1.setTamanho(500);

			produtosP1.add(b1);
			produtosP2.add(b1);
			produtosP4.add(b1);
		} catch (ValorZeradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Bebida b2 = new Bebida("b2cho10", "chopin", 10, "Brahhh");
			b2.setGelada(true);
			b2.setTamanho(300);

			produtosP2.add(b2);
			produtosP3.add(b2);
			produtosP4.add(b2);
		} catch (ValorZeradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Bebida b3 = new Bebida("b3suc8", "Suquin", 8, "Dafruta");
			b3.setGelada(true);
			b3.setTamanho(1000);

			produtosP3.add(b3);
			produtosP4.add(b3);
		} catch (ValorZeradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Pedido p1 = new Pedido(new Solicitante("huguinho", "12312312312", "hugo@hugo.com"), produtosP1);
			p1.setDescricao("Primeiro pedido");
			p1.setWeb(false);
			p1.imprimir();
		} catch (SolicitanteInvalidoException | PedidoSemSolicitanteException | PedidoSemProdutoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Pedido p2 = new Pedido(new Solicitante("zezinho", "12312312312", "ze@ze.com"), produtosP2);
			p2.setDescricao("Segundo pedido");
			p2.setWeb(true);
			p2.imprimir();
		} catch (SolicitanteInvalidoException | PedidoSemSolicitanteException | PedidoSemProdutoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Pedido p3 = new Pedido(new Solicitante("luizinho", "12312312312", "luiz@luiz.com"), produtosP3);
			p3.setDescricao("Terceiro pedido");
			p3.setWeb(true);
			p3.imprimir();
		} catch (SolicitanteInvalidoException | PedidoSemSolicitanteException | PedidoSemProdutoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Pedido p4 = new Pedido(new Solicitante("mariazinha", "12312312312", "maria@maria.com"), produtosP4);
			p4.setDescricao("Quarto pedido");
			p4.setWeb(true);
			p4.imprimir();
		} catch (SolicitanteInvalidoException | PedidoSemSolicitanteException | PedidoSemProdutoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Pedido p5 = new Pedido(null, produtosP4);
			p5.setDescricao("Quinto pedido");
			p5.setWeb(true);
			p5.imprimir();
		} catch (PedidoSemSolicitanteException | PedidoSemProdutoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Solicitante s6 = new Solicitante("mariazinha", "12312312312", "maria@maria.com");
		
			Pedido p6 = new Pedido(s6, null);
			p6.setDescricao("Sexto pedido");
			p6.setWeb(true);
			p6.imprimir();
		} catch (SolicitanteInvalidoException | PedidoSemSolicitanteException | PedidoSemProdutoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
	}
}