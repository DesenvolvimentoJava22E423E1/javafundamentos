package br.edu.infnet.applanche.model.tests;

import br.edu.infnet.applanche.model.domain.Bebida;
import br.edu.infnet.applanche.model.exceptions.ValorZeradoException;

public class ProdutoTest {

	public static void main(String[] args) {
		
		try {
			Bebida b1 = new Bebida("b1caf5", "cafezin", 5, "Cooooffeeee");
			b1.setGelada(false);
			b1.setTamanho(500);
			System.out.println(b1);
		} catch (ValorZeradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Bebida b2 = new Bebida("b2cho10", "chopin", 10, "Brahhh");
			b2.setGelada(true);
			b2.setTamanho(300);
			System.out.println(b2);
		} catch (ValorZeradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Bebida b3 = new Bebida("b3suc8", "Suquin", 8, "Dafruta");
			b3.setGelada(true);
			b3.setTamanho(1000);
			System.out.println(b3);
		} catch (ValorZeradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
	}
}
